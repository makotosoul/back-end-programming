package chapter2.assignment3.friend_list.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import chapter2.assignment3.friend_list.domain.Student;





@Controller
public class friendListController {
List<Student> students = new ArrayList<>();

@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String greetingForm(Model model, Student friend) {
		model.addAttribute("students", students);
        model.addAttribute("newStudent", new Student());
        if(friend.getName() !=null && !friend.getName().isEmpty()){
            students.add(friend);
        }
		return "index";
	}
    
}
