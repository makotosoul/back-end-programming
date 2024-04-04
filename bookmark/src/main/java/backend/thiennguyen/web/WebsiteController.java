package backend.thiennguyen.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import backend.thiennguyen.bookmark.domain.CategoryRepository;
import backend.thiennguyen.bookmark.domain.ProjectRepository;
import backend.thiennguyen.bookmark.domain.Website;
import backend.thiennguyen.bookmark.domain.WebsiteRepository;
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
    private CategoryRepository Crepository;
    @Autowired
    private ProjectRepository Prepository;


    @GetMapping("/websitelist")
    public String websitelist(@PathVariable("id") Long projectId,Model model) {
        model.addAttribute("websites", repository.findAllById(Prepository.findById(projectId)));
        return "websitelist";
    }

    @GetMapping("/projectlist")
    public String projectlist(Model model) {
        model.addAttribute("projects", Prepository.findAll());
        return "projectlist";
    }
    

    @GetMapping("/add")
    public String websiteadd(Model model) {
        model.addAttribute("website", new Website());
        model.addAttribute("categories", Crepository.findAll());
        return "websiteadd";
    }

    @PostMapping("/save")
    public String websitesave(Website website) {
        repository.save(website);
        return "redirect:websitelist";
    }
    
    


    
}
