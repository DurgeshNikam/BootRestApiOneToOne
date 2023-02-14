package com.api.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.api.book.Repositary.BookRepositary;
import com.api.book.entities.Book;
@Component
@Service
public class BookService {
	
	 
	@Autowired
	private BookRepositary bookRepositary;
	 
		
		public List<Book> getAllBooks()
		{
					List<Book>list = (List<Book>) this.bookRepositary.findAll();
			return list;
		}
	 

		
		public Book getBookById(int id)
		{
			Book book=null;
			try {
			
				book =this.bookRepositary.findById(id);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return book;
		}
		
		
		public Book addBook(Book b)
		{
			Book result=bookRepositary.save(b);
			return result;
		}
		
		public void deleteBook(int bid)
		{
			bookRepositary.deleteById(bid);
			
		}

		public void updatebook(Book book, int bookId) {

			book.setId(bookId);
			bookRepositary.save(book);
			
		}
		
}




