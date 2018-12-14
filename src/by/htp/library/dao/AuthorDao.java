package by.htp.library.dao;

import java.util.List;

import by.htp.library.entity.Author;
import by.htp.library.entity.Book;

public interface AuthorDao {
	
	List<Author> readAll();

	void addAuthor(Author author);

}
