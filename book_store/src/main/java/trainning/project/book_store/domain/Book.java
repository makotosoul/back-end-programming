package trainning.project.book_store.domain;


public class Book {
    private String title; 
    private String author;
    private int year;
    private String isbn;
    private double price;

    public Book(String title, String author, int year, String isbn, double price){
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.price = price;
    }

    //getter
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getISBN(){
        return isbn;
    }
    public Integer getYear(){
        return year;
    }
    public Double getPrice(){
        return price;
    }

    //setter
    public void setTitle(String title){
        this.title =title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setISBN(String isbn){
        this.isbn = isbn;
    }
    public void setYear(int year){
        this.year = year;
    }
    public void setPrice(double price){
        this.price = price;
    }
    
    @Override
    public String toString(){
        return "title = " + getTitle() + "author = "+getAuthor() +"year = "+getYear()+"ISBN = "+getISBN()+"price = "+getPrice();
    }


}
