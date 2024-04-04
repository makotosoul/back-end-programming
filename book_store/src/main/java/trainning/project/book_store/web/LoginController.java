package trainning.project.book_store.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import trainning.project.book_store.domain.AppUser;
import trainning.project.book_store.domain.AppUserRepository;
import trainning.project.book_store.domain.SignupForm;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;








@Controller
public class LoginController {
@Autowired 
private AppUserRepository repository;

@GetMapping("signup")
public String addUser(Model model) {
    model.addAttribute("signupform",new SignupForm());
    return "signup";
} 

@GetMapping("login")
public String login() {
    return "login";
}





@PostMapping("saveuser")
public String save(@Valid @ModelAttribute("signupform") SignupForm signupForm, BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
        return "signup";
    }
    else {

        if(signupForm.getPassword().equals(signupForm.getPasswordCheck())){
            String pwd = signupForm.getPassword();
            BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
            String hashPwd = bc.encode(pwd);

            AppUser newUser = new AppUser();
            newUser.setPasswordHash(hashPwd);
            newUser.setUsername(signupForm.getUsername());
            newUser.setRole("USER");
            if(repository.findByUsername(signupForm.getUsername()) == null ){
                repository.save(newUser);
            }
            else {
                bindingResult.rejectValue("username", "err.username", "Username already exists");
            }
        }
    
        else {
            bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");
            return "signup";
        }
        
    }
    return "redirect:/login";
}
 

}
