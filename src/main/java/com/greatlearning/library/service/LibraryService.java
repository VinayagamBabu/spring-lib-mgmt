package com.greatlearning.library.service;

import java.util.List;

import com.greatlearning.library.model.Book;

public interface LibraryService {
	
	public List<Book> getAllBooks();
	public void save(Book book);
	public Book delete(int id);
	public Book getBookById(int id);

}
