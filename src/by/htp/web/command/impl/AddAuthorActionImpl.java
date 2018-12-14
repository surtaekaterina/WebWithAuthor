package by.htp.web.command.impl;

import java.io.IOException;
import static by.htp.web.util.WebConstant.*;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.library.entity.Book;
import by.htp.library.service.CatalogService;
import by.htp.library.service.impl.CatalogServiceImpl;
import by.htp.web.command.BasicAction;

public class AddAuthorActionImpl implements BasicAction{
	
	private CatalogService service = new CatalogServiceImpl();

	@Override
	public void performAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		
		String author_name = req.getParameter(REO_PARAM_AUTHOR_NAME);
		
		//add validation
		if(author_name != null) {
		service.addAuthorToCatalog(author_name);
		}
		System.out.println(author_name);
		
	}

}
