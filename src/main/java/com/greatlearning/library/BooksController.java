package com.greatlearning.library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.library.model.Book;
import com.greatlearning.library.service.LibraryService;

@Controller
@RequestMapping("/books")
public class BooksController {
	
	@Autowired
	LibraryService libraryService;
	
	@RequestMapping("/list")
	public String getAllBooks(Model theModel) {
		List<Book> res = libraryService.getAllBooks();
		theModel.addAttribute("bookModel", res);
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
		Book book = libraryService.getBookById(id);
		theModel.addAttribute("book", book);
		return "savebook";
	}
	
	@RequestMapping("/delete")
	public String deleteBook(@RequestParam("id") int id) {
		Book book = libraryService.delete(id);
		System.out.println("Deleted Book Id"+ book.getId());
		return "redirect:/books/list";
	}
	
	@PostMapping("/save")
	public String saveBook(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("category") String category, @RequestParam("author") String author) {
		Book book;
		if(id != 0) {
			book = libraryService.getBookById(id);
		}else {
			book = new Book();
		}
		book.setName(name);
		book.setCategory(category);
		book.setAuthor(author);
		libraryService.save(book);
		return "redirect:/books/list";
	}
}
