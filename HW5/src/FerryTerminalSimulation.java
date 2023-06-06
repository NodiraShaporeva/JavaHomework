import java.util.Random;

class FerryTerminalSimulation {
    private double[] passengerArrivalRates; // Среднее время между появлениями пассажиров на причале в разное время суток
    private double[] ferryArrivalRates; // Среднее время между появлениями катеров на причале в разное время суток
    private boolean[] ferryStopTypes; // Тип остановки катера (конечная или нет)
    private int maxCapacity; // Максимальная вместимость катера
    private int maxPassengersAtTerminal; // Максимальное количество пассажиров на остановке

    private Random random;
    private int passengersAtTerminal;
    private int totalPassengers;
    private int totalFerries;
    private double totalPassengerTime;

    public FerryTerminalSimulation(double[] passengerArrivalRates, double[] ferryArrivalRates, boolean[] ferryStopTypes,
                                   int maxCapacity, int maxPassengersAtTerminal) {
        this.passengerArrivalRates = passengerArrivalRates;
        this.ferryArrivalRates = ferryArrivalRates;
        this.ferryStopTypes = ferryStopTypes;
        this.maxCapacity = maxCapacity;
        this.maxPassengersAtTerminal = maxPassengersAtTerminal;

        random = new Random();
        passengersAtTerminal = 0;
        totalPassengers = 0;
        totalFerries = 0;
        totalPassengerTime = 0.0;
    }

    public void runSimulation(int numIterations) {
        for (int i = 0; i < numIterations; i++) {
            // Генерация пассажиров
            double passengerArrivalRate = passengerArrivalRates[getTimeOfDay()];
            int newPassengers = getPoissonRandom(passengerArrivalRate);
            passengersAtTerminal += newPassengers;
            totalPassengers += newPassengers;

            // Погрузка пассажиров в катеры
            int passengersLoaded = 0;
            while (passengersLoaded < passengersAtTerminal && passengersLoaded < maxCapacity) {
                int passengersToLoad = Math.min(maxCapacity - passengersLoaded, passengersAtTerminal);
                passengersLoaded += passengersToLoad;
                passengersAtTerminal -= passengersToLoad;
            }

            // Генерация катеров
            double ferryArrivalRate = ferryArrivalRates[getTimeOfDay()];
            double nextFerryArrival = getExponentialRandom(ferryArrivalRate);
            boolean isFinalStop = ferryStopTypes[getTimeOfDay()];
            totalFerries++;

            // Расчет времени пребывания пассажиров на остановке
            totalPassengerTime += passengersLoaded * nextFerryArrival;

            // Вывод информации о прибытии катера
            System.out.println("Ferry arrival - Time: " + nextFerryArrival +
                    ", Passengers: " + passengersLoaded +
                    ", Final Stop: " + isFinalStop);

            // Обновление пассажиров на остановке
            if (!isFinalStop) {
                passengersAtTerminal = 0;
            }

            // Задержка перед следующей итерацией
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Вывод статистики
        double avgPassengerTime = totalPassengerTime / totalPassengers;
        System.out.println("\nSimulation Statistics:");
        System.out.println("Total Passengers: " + totalPassengers);
        System.out.println("Total Ferries: " + totalFerries);
        System.out.println("Average Passenger Time: " + avgPassengerTime);
    }

    private int getTimeOfDay() {
        // Здесь можно реализовать логику определения времени суток
        // В данном примере используется случайное значение
        return random.nextInt(passengerArrivalRates.length);
    }

    private int getPoissonRandom(double lambda) {
        // Генерация случайного числа по распределению Пуассона
        double L = Math.exp(-lambda);
        double p = 1.0;
        int k = 0;

        do {
            k++;
            p *= random.nextDouble();
        } while (p > L);

        return k - 1;
    }

    private double getExponentialRandom(double lambda) {
        // Генерация случайного числа по экспоненциальному распределению
        return -Math.log(1 - random.nextDouble()) / lambda;
    }

    public static void main(String[] args) {
        // Параметры модели
        double[] passengerArrivalRates = {0.5, 1.0, 0.8, 0.3}; // Среднее время между появлениями пассажиров в разное время суток
        double[] ferryArrivalRates = {0.2, 0.5, 0.3, 0.6}; // Среднее время между появлениями катеров в разное время суток
        boolean[] ferryStopTypes = {false, true, true, false}; // Тип остановки катера (конечная или нет)
        int maxCapacity = 50; // Максимальная вместимость катера
        int maxPassengersAtTerminal = 100; // Максимальное количество пассажиров на остановке

        // Создание и запуск имитационной модели
        FerryTerminalSimulation simulation = new FerryTerminalSimulation(passengerArrivalRates, ferryArrivalRates,
                ferryStopTypes, maxCapacity, maxPassengersAtTerminal);
        simulation.runSimulation(10); // Запуск модели на 10 итераций
    }
}