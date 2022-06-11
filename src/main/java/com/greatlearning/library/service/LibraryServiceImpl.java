package com.greatlearning.library.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.library.model.Book;

@Service
public class LibraryServiceImpl implements LibraryService{
	
	SessionFactory sessionFactory;
	Session session;
	
	@Autowired
	public LibraryServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			this.session = sessionFactory.getCurrentSession();
		}catch(HibernateException he) {
			this.session = sessionFactory.openSession();
		}
	}

	@Override
	@Transactional
	public List<Book> getAllBooks() {
		@SuppressWarnings("unchecked")
		List<Book> list = (List<Book>)session.createQuery("from Book").list();
		return list;
	}

	@Override
	public void save(Book book) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(book);
		tx.commit();
	}

	@Override
	@Transactional
	public Book delete(int id) {
		Book book = session.get(Book.class, id);
		session.delete(book);
		return book;
	}

	@Override
	public Book getBookById(int id) {
		return session.get(Book.class, id);
	}

}
