package by.htp.library.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.htp.library.dao.AuthorDao;
import by.htp.library.dao.BookDao;
import by.htp.library.dao.impl.AuthorDaoSqlImpl;
import by.htp.library.dao.impl.BookDaoSqlImpl;
import by.htp.library.entity.Author;
import by.htp.library.entity.Book;
import by.htp.library.service.CatalogService;

public class CatalogServiceImpl implements CatalogService {

	
	private BookDao bookDao = new BookDaoSqlImpl();
	private AuthorDao authorDao = new AuthorDaoSqlImpl();
	
	
	@Override
	public List<Book> getCatalogBooks() {
		
		/*List<Book> books = new ArrayList<>();
		books.add(new Book(1,"Book1"));
		books.add(new Book(2,"Book2"));
		books.add(new Book(3,"Book3"));*/
	
		return bookDao.readAll();
	}
	@Override
	public void addAuthorToCatalog(String author_name) {
		
		Author author = new Author(author_name);
		authorDao.addAuthor(author);
		System.out.println("3");
		
	}

}
