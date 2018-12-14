package by.htp.library.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.mysql.cj.jdbc.PreparedStatement;

import static by.htp.library.dao.util.DaoConstant.*;
import by.htp.library.dao.AuthorDao;
import by.htp.library.entity.Author;
import by.htp.library.entity.Book;

public class AuthorDaoSqlImpl implements AuthorDao {

	private static final String SQL_INSERT_AUTHOR = "INSERT INTO author (author_name) VALUES (?)";

	@Override
	public void addAuthor(Author author) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {

				// защищен от скл-тнъекции
				
System.out.println("1");
				
				
				PreparedStatement ps = (PreparedStatement) conn.prepareStatement(SQL_INSERT_AUTHOR,
						Statement.RETURN_GENERATED_KEYS);

				ps.setString(1, author.getName());
				ps.executeUpdate();

				ResultSet rs = ps.getGeneratedKeys();

				long key = 0;

				if (rs.next()) {
					key = rs.getLong(1);

				}

				System.out.println(key);
				System.out.println("2");

				// Statement st = conn.createStatement();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Author> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
