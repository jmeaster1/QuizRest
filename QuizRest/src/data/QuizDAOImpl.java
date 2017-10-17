package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.Quiz;

@Transactional
public class QuizDAOImpl implements QuizDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Quiz> index() {
		String query = "SELECT q FROM Quiz q";
		return em.createQuery(query, Quiz.class).getResultList();
	}

	@Override
	public Quiz show(int id) {
		String query = "SELECT q FROM Quiz q WHERE q.id = :id";
		return em.createQuery(query, Quiz.class).setParameter("id", id).getResultList().get(0);
	}

	@Override
	public Quiz create(Quiz quiz) {
			  em.persist(quiz);
			  em.flush();
			  return em.find(Quiz.class, quiz.getId());
	}

	@Override
	public Quiz update(int id, Quiz quiz) {
		Quiz managed = em.find(Quiz.class, id);
		managed.setName(quiz.getName());
		return managed;
	}

	@Override
	public boolean destroy(int id) {
		Quiz managed = em.find(Quiz.class, id);
		em.remove(managed);
		return true;
	}
}