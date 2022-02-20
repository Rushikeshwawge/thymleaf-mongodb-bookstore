package io.starterprojectBookStore.Book;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@RequestMapping("/books")
	public String getAllBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "index";
	}
	
	@GetMapping("/addbooks")
	public String getAddBook() {
		return "addbook";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addbooks")
	public String addBook(@RequestParam String name, @RequestParam int rating,
			@RequestParam String author, Model model) {
		Book book = new Book();
		book.setName(name);
		book.setRating(rating);
		book.setAuthor(author);
		bookRepository.save(book);
		
		return "redirect:/books/"+ book.getName();
	}
	
	@RequestMapping("/books/{id}")
	public String getBook(@PathVariable String id, Model model) {
//		System.out.println(id);
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Book name:" + id));
		model.addAttribute("book", book);
		return "book";
	}
	
	@RequestMapping("/updatebook/{id}")
	public String updateBook(@PathVariable String id, Model model) {
		model.addAttribute("id", id);
		return "updatebook";
	}
	
	@RequestMapping("/deletebook/{id}")
	public String deleteBook(@PathVariable String id) {
		bookRepository.deleteById(id);
		return "redirect:/books";
	}

}
