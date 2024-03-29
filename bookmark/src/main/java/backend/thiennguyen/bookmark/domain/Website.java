package backend.thiennguyen.bookmark.domain;
import jakarta.persistence.*;

@Entity
public class Website {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String url;
    private String note;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    public Website () {}

    public Website(String name, String url, String note, Category category){
        super();
        this.name = name;
        this.url = url;
        this.note = note;
        this.category = category;
    }

    //getter
    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getURL(){
        return url;
    }

    public String getNote(){
        return note;
    }
    public Category getCategory() {
        return category;
    }
    //setter
    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setURL(String url){
        this.url = url;
    }
    public void setNote(String note){
        this.note = note;
    }
    public void setCategory(Category category){
        this.category = category;
    }
    @Override
    public String toString(){
        if(this.category != null){
            return "Website [ id ="+ getId()+", name ="+getName()+", url ="+getURL()+", note ="+getNote()+"category ="+getCategory()+" ]";
        }
        else{
            return "Website [ id ="+ getId()+", name ="+getName()+", url ="+getURL()+", note ="+getNote()+" ]";
        }
        
    }
}
