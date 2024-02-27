package trainning.project.book_store.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import trainning.project.book_store.domain.Book;
import trainning.project.book_store.domain.BookRepository;
import trainning.project.book_store.domain.CategoryRepository;
import org.springframework.web.bind.annotation.PostMapping;









@Controller
public class BookController {
   
   
    @Autowired
    private BookRepository repository;
    @Autowired
    private CategoryRepository Crepository;

    //showing booklist
    @GetMapping("/booklist")
    public String bookList(Model model) {
        System.out.println(Crepository.findAll());
        model.addAttribute("books",repository.findAll());
        return "booklist";
    }
    
    //add page
    @GetMapping("/add")
    public String bookadd(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", Crepository.findAll());
        return "bookadd";
    }
    //updating the db
    @PostMapping("/save")
    public String save(Book book) {
        repository.save(book); 
        return "redirect:booklist";
    }
    
    //edit
    @GetMapping("/edit/{id}")
    public String bookEdit(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", repository.findById(bookId));
        model.addAttribute("categories", Crepository.findAll());
        
        return "bookedit";
    }
    

    //delete book
    @GetMapping("/delete/{id}")
    public String bookDelete(@PathVariable("id") Long bookId, Model model) {
        repository.deleteById(bookId);;
        return "redirect:../booklist";
    }
    
    
        
}
