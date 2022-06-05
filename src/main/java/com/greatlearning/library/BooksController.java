package com.greatlearning.library;

import java.util.Collections;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.library.model.Book;

@Controller
@RequestMapping("/books")
public class BooksController {
	
	@RequestMapping("/list")
	public String getAllBooks(Model theModel) {
		Book book = new Book();
		book.setName("Test Book");
		book.setAuthor("Tester");
		book.setCategory("Test");
		theModel.addAttribute("bookModel", Collections.singletonList(book));
		return "booklist";
	}
	
	@RequestMapping("/add")
	public String addBook(Model theModel) {
		Book book = new Book();
		theModel.addAttribute("book", book);
		return "savebook";
	}
	
	@RequestMapping("/update")
	public String updateBook(@RequestParam("id") int id,Model theModel) {
		Book book = new Book();
		book.setName("Test Book");
		book.setAuthor("Tester");
		book.setCategory("Test");
		theModel.addAttribute("book", book);
		return "savebook";
	}
	
	@RequestMapping("/delete")
	public String deleteBook(@RequestParam("id") int id) {
		System.out.println(id);
		return "redirect:/books/list";
	}
	
	@RequestMapping("/save")
	public String saveBook(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("category") int category, @RequestParam("author") int author) {
		
		System.out.println(id+" "+name+" "+category+" "+author);
		return "redirect:/books/list";
	}
}
