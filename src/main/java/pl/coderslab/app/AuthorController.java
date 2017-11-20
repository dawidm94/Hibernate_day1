package pl.coderslab.app;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	private AuthorDao authorDao;

	@RequestMapping("/read/{id}")
	@ResponseBody
	public String read(@PathVariable("id") Long id) {
		Author author = authorDao.findById(id);
		return author.toString();
	}

	@RequestMapping("/save")
	@ResponseBody
	public String save() {
		Author author = new Author();
		author.setFirstName("firstName");
		author.setLastName("lastName");
		authorDao.save(author);
		return "Added author id: " + author.getId();
	}

	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable("id") long id) {
		Author author = authorDao.findById(id);
		authorDao.delete(author);
	}

	@RequestMapping("/update/{id}")
	@ResponseBody
	public String update(@PathVariable("id") Long id) {
		Author author = authorDao.findById(id);
		author.setLastName("new lastName");
		authorDao.update(author);
		return "Author updated";
	}

}