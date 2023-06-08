import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExpressionsExample {
    public static void main(String[] args) {
        // Проверка является ли год високосным
        BiFunction<Integer, Predicate<Integer>, Boolean> leapYearCheck = (year, predicate) -> predicate.test(year);
        int year = 2020;
        System.out.println(year + " год является високосным? " + leapYearCheck.apply(year, isLeapYear()));

        // Подсчет количества дней между двумя датами
        BiFunction<LocalDate, LocalDate, Long> daysBetween = (d1, d2) -> ChronoUnit.DAYS.between(d1, d2);
        LocalDate date1 = LocalDate.of(2023, 1, 1);
        LocalDate date2 = LocalDate.of(2023, 6, 1);
        System.out.println("Количество дней между " + date1 + " и " + date2 + ": " + daysBetween.apply(date1, date2));

        // Подсчет количества полных недель между двумя датами
        BiFunction<LocalDate, LocalDate, Long> weeksBetween = (d1, d2) -> ChronoUnit.WEEKS.between(d1, d2);
        System.out.println("Количество полных недель между " + date1 + " и " + date2 + ": " + weeksBetween.apply(date1, date2));

        // Подсчет дня недели по полученной дате
        Function<LocalDate, String> dayOfWeek = d -> d.getDayOfWeek().toString();
        LocalDate date = LocalDate.of(1969, 7, 20);
        System.out.println(date + " - " + dayOfWeek.apply(date));
    }

    private static Predicate<Integer> isLeapYear() {
        return year -> (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
