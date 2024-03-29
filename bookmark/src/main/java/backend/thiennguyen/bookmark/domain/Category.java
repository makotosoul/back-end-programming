package backend.thiennguyen.bookmark.domain;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryid;
    private String name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Website> websites;
    
    public Category() {}
    public Category(String name){
        super();
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryid;
    }
    public void setCategoryId(Long categoryid){
        this.categoryid = categoryid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Website> getWebsites() {
        return websites;
    }

    public void setWebsite(List<Website> websites){
        this.websites = websites;
    }

    @Override
    public String toString(){
        return "Category [categoryid= "+getCategoryId()+", name ="+getName();//+", website ="+getWebsites()+" ]";//just in case the websites is needed
    }
}
