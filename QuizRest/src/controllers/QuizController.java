package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.QuizDAO;
import entities.Quiz;



@RestController
public class QuizController {

	@Autowired
	QuizDAO dao;
	
	@RequestMapping(path="ping", method=RequestMethod.GET)
	public String ping(){
	  return "pong";
	}
	
	@RequestMapping(path = "quizzes", method = RequestMethod.GET)
	public List<Quiz> index() {
		return dao.index();
	}
	
	@RequestMapping(path = "quizzes/{id}", method = RequestMethod.GET)
	public Quiz show(@PathVariable int id) {
		return dao.show(id);
	}
	
	@RequestMapping(path = "quizzes", method = RequestMethod.POST)
	public Quiz create(@RequestBody String jsonAddress) {
		ObjectMapper mapper = new ObjectMapper();
		Quiz quiz = null;
		try {
			  quiz = mapper.readValue(jsonAddress, Quiz.class);
			} catch (Exception e) {
			  e.printStackTrace();
			}
			return dao.create(quiz);
	}
	@RequestMapping(path = "quizzes", method = RequestMethod.PUT)
	public Quiz update(@RequestBody String jsonAddress, @PathVariable int id) {
		ObjectMapper mapper = new ObjectMapper();
		Quiz quiz = null;
		try {
			  quiz = mapper.readValue(jsonAddress, Quiz.class);
			} catch (Exception e) {
			  e.printStackTrace();
			}
			return dao.update(id, quiz);
	}
	
	@RequestMapping(path = "quizzes/{id}", method = RequestMethod.DELETE)
	public boolean destroy(@PathVariable int id) {
		return dao.destroy(id);
	}

	
}