package pl.coderslab.app;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
@Transactional
public class AuthorDao {
	@PersistenceContext
	EntityManager entityManager;

	public void save(Author entity) {
		entityManager.persist(entity);
	}

	public void update(Author entity) {
		entityManager.merge(entity);
	}

	public void delete(Author entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}

	public Author findById(Long id) {
		return entityManager.find(Author.class, id);
	}
}
