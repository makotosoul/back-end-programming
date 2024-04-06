package backend.thiennguyen.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import backend.thiennguyen.bookmark.domain.Project;
import backend.thiennguyen.bookmark.domain.ProjectRepository;
import backend.thiennguyen.bookmark.domain.Website;
import backend.thiennguyen.bookmark.domain.WebsiteRepository;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class WebsiteController {


    @Autowired
    private WebsiteRepository repository;
    @Autowired
    private ProjectRepository Prepository;
    //@Autowired
    //private CategoryRepository Crepository;


    @GetMapping("/websitelist/{id}")
    public String websitelist(@PathVariable("id") Long projectId,Model model) {
        Project project =Prepository.findById(projectId).orElseThrow(() -> new EntityNotFoundException("project not found"));
        List<Website> websites = project.getWebsites();
        model.addAttribute("projectName", project.getName().toUpperCase());
        model.addAttribute("websites", websites);
        return "websitelist";
    }

    @GetMapping("/projectlist")
    public String projectlist(Model model) {
        model.addAttribute("projects", Prepository.findAll());
        return "projectlist";
    }
    

    @GetMapping("/websiteadd")
    public String websiteadd(Model model) {
        model.addAttribute("website", new Website());
        //model.addAttribute("categories", Crepository.findAll());
        return "websiteadd";
    }

    @PostMapping("/save")
    public String websitesave(Website website) {
        repository.save(website);
        return "redirect:websitelist";
    }
    
    


    
}
