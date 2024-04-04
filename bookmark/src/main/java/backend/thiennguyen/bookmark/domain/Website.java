package backend.thiennguyen.bookmark.domain;
import jakarta.persistence.*;

@Entity
public class Website {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String URL;
    private String note;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    @ManyToOne
    @JoinColumn(name ="projectId")
    private Project project;

    public Website () {}

    public Website(String name, String URL, String note, Category category,Project project){
        super();
        this.name = name;
        this.URL = URL;
        this.note = note;
        this.category = category;
        this.project = project;
    }

    //getter
    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getURL(){
        return URL;
    }

    public String getNote(){
        return note;
    }
    public Category getCategory() {
        return category;
    }
    public Project getProject(){
        return project;
    }
    //setter
    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setURL(String URL){
        this.URL = URL;
    }
    public void setNote(String note){
        this.note = note;
    }
    public void setCategory(Category category){
        this.category = category;
    }
    public void setProject(Project project){
        this.project = project;
    }
    @Override
    public String toString(){
        if(this.category != null&& this.project !=null){
            return "Website [ id ="+ getId()+", name ="+getName()+", url ="+getURL()+", note ="+getNote()+"category ="+getCategory()+"project ="+getProject()+" ]";
        }
        else if(this.category != null){
            return "Website [ id ="+ getId()+", name ="+getName()+", url ="+getURL()+", note ="+getNote()+"category ="+getCategory()+" ]";
        }
        else if(this.project != null){
            return "Website [ id ="+ getId()+", name ="+getName()+", url ="+getURL()+", note ="+getNote()+"project ="+getProject()+" ]";
        }
        else{
            return "Website [ id ="+ getId()+", name ="+getName()+", url ="+getURL()+", note ="+getNote()+" ]";
        }
        
    }
}
