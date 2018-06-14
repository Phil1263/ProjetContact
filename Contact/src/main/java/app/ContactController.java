package app;

import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import app.ContactRepository;

@Controller
@SessionAttributes("/index")
public class ContactController {
	private static final Logger log = LoggerFactory.getLogger(ContactApplication.class);
	@Autowired
	ContactRepository repository;
	
	@GetMapping("/index")
	public String ContactController() {
		return "main";
	}
	
	@ModelAttribute("list")
	public Iterable<Contact> getAll(){
		Iterable<Contact> it = repository.findAll();
	    return it;
	 }
	
	@GetMapping(value="/delete/{id}")
	public String deleteContact(@PathVariable("id") Long id) {
		repository.delete(id);
		return "redirect:/index";
	}
	
	@GetMapping(value="/form/{id}")
	public String modifyContact(@PathVariable("id") Long id, Model model) {
		Contact c=repository.findById(id).get();
		model.addAttribute("contactForm", c);
		return "form";
	}

}