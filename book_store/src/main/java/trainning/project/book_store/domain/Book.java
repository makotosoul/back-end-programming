package trainning.project.book_store.domain;
import jakarta.persistence.*;



@Entity
public class Book {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title; 
    private String author;
    private int year_;
    private String isbn;
    private double price;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    public Book(){}


    public Book(String title, String author, int year_, String isbn, double price, Category category){
        super();
        this.title = title;
        this.author = author;
        this.year_ = year_;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
    }

    //getter
    public Long getId() {
        return id;
    }

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
        return year_;
    }
    public Double getPrice(){
        return price;
    }
    public Category getCategory() {
        return category;
    }

    //setter
    public void setId(Long id){
        this.id = id;
    }
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
        this.year_ = year;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setCategory(Category category){
        this.category = category;
    }
    
    @Override
    public String toString(){
        if(this.category != null){
            return "Book [id = " + getId()+ "title = " + getTitle() + "author = "+getAuthor() +"year = "+getYear()+"ISBN = "+getISBN()+"price = "+getPrice()+"category = "+getCategory()+"]";
        }
        else{
            return "Book [id = " + getId()+ "title = " + getTitle() + "author = "+getAuthor() +"year = "+getYear()+"ISBN = "+getISBN()+"price = "+getPrice()+"]";
        }
    }


}
