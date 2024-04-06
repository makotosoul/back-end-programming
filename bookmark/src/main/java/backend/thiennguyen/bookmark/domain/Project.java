package backend.thiennguyen.bookmark.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectId;
    private String name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<Website> websites;

    public Project() {}
    public Project(String name){
        super();
        this.name = name;
    }
    
    //getter 
    public Long getId(){
        return projectId;
    }

    public String getName(){
        return name;
    }
    public List<Website> getWebsites(){
        return websites;
    }

    //setter
    public void setId(Long projectId){
        this.projectId = projectId;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setWebsites(List<Website> websites) {
        this.websites = websites;
    }
    @Override
    public String toString() {
        return "Project [id = "+getId()+", name = "+getName()+"]";
    }
}
