package pl.coderslab.app;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookDao bookDao;
	
	@RequestMapping("/read/{id}")
	@ResponseBody
	public String read(@PathVariable("id") Long id) {
		Book book = bookDao.findById(id);
		return book.toString();
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String save() {
		Book book = new Book();
		book.setAuthor("author");
		book.setDescription("description");
		book.setPublisher("publisher");
		book.setRating(new BigDecimal(8.5));
		book.setTitle("title");
		bookDao.saveBook(book);
		return "Added book id: " + book.getId();
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable("id") long id) {
		Book book = bookDao.findById(id);
		bookDao.delete(book);
	}
	
	@RequestMapping("/update/{id}")
	@ResponseBody
	public String update(@PathVariable("id") Long id) {
		Book book = bookDao.findById(id);
		book.setTitle("new title");
		bookDao.update(book);
		return "Book updated";
	}
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello, it fucking works!";
	}
}
