public class Book {
    private String title;
    private String authorName;
    private int year;
    private String publisher;
    private String genre;
    private int pageCount;

    public Book() {
        // Конструктор по умолчанию
    }

    public Book(String title, String authorName, int year, String publisher, String genre, int pageCount) {
        this.title = title;
        this.authorName = authorName;
        this.year = year;
        this.publisher = publisher;
        this.genre = genre;
        this.pageCount = pageCount;
    }

    public void setData(String title, String authorName, int year, String publisher, String genre, int pageCount) {
        this.title = title;
        this.authorName = authorName;
        this.year = year;
        this.publisher = publisher;
        this.genre = genre;
        this.pageCount = pageCount;
    }

    public void setData(String title, String authorName, int year) {
        this.title = title;
        this.authorName = authorName;
        this.year = year;
    }

    public void displayData() {
        System.out.println("Название книги: " + title);
        System.out.println("Автор: " + authorName);
        System.out.println("Год выпуска: " + year);
        System.out.println("Издательство: " + publisher);
        System.out.println("Жанр: " + genre);
        System.out.println("Количество страниц: " + pageCount);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getGenre() {
        return genre;
    }

    public int getPageCount() {
        return pageCount;
    }

    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setData("Название1", "Автор1", 2021, "Издательство1", "Жанр1", 200);
        book1.displayData();

        System.out.println();

        Book book2 = new Book();
        book2.setData("Название2", "Автор2", 2022);
        book2.displayData();
    }
}