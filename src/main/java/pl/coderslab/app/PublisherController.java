package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

	@Autowired
	private PublisherDao publisherDao;

	@RequestMapping("/read/{id}")
	@ResponseBody
	public String read(@PathVariable("id") Long id) {
		Publisher publisher = publisherDao.findById(id);
		return publisher.toString();
	}

	@RequestMapping("/save")
	@ResponseBody
	public String save() {
		Publisher publisher = new Publisher();
		publisher.setName("name");
		publisherDao.save(publisher);
		return "Added publisher id: " + publisher.getId();
	}

	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable("id") long id) {
		Publisher publisher = publisherDao.findById(id);
		publisherDao.delete(publisher);
	}

	@RequestMapping("/update/{id}")
	@ResponseBody
	public String update(@PathVariable("id") Long id) {
		Publisher publisher = publisherDao.findById(id);
		publisher.setName("new name");
		publisherDao.update(publisher);
		return "Publisher updated";
	}

}