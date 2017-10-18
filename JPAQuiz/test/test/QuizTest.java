package test;

import static org.junit.Assert.*;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Answer;
import entities.Question;
import entities.Quiz;

public class QuizTest {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	@Before 
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("Quiz");
		em = emf.createEntityManager();
		}
	@After
	public void tearDown() {
		em.close();
		emf.close();
	}
	
	@Test
	public void smokeTest() {
		assertEquals(true, true);
	}
	@Test
	public void test_quiz_field_mappings() {
		Quiz quiz = em.find(Quiz.class, 1);
		assertEquals(quiz.getName(), "test name here");
		assertEquals(quiz.getId(), 1);
	}
	@Test
	public void test_quiz_has_many_questions() {
		Quiz quiz = em.find(Quiz.class, 10);
		assertNotNull(quiz.getQuestions());
	}

}