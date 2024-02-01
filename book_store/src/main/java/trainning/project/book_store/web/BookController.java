package trainning.project.book_store.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import trainning.project.book_store.domain.BookRepository;


@Controller
public class BookController {
   
    @Autowired
    private BookRepository repository;
        @GetMapping({"/","booklist"})
        public String bookList(Model model) {
            model.addAttribute("books",repository.findAll());
            return "booklist";
        }
    
    @GetMapping("/index")
    public String BookControl() {
        return "index";
    }
    
}
