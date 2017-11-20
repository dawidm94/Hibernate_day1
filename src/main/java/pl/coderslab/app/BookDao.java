package pl.coderslab.app;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
@Transactional
public class BookDao {

	@PersistenceContext
	EntityManager entityManager;
	public void saveBook(Book entity) {
		entityManager.persist(entity);
	}
	
	public void update(Book entity) {
		entityManager.merge(entity);
	}
	
	public void delete(Book entity) {
		entityManager.remove(entityManager.contains(entity) ? 
		entity : entityManager.merge(entity));
	}
	
	public Book findById(Long id) {
		return entityManager.find(Book.class, id);
	}
}
