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
	
	@RequestMapping(path = "quizzes", method = RequestMethod.GET)
	public Quiz show(@PathVariable int id) {
		
		//STUB
		return dao.show(id);
	}
	
	@RequestMapping(path = "quizzes", method = RequestMethod.GET)
	public Quiz create(@PathVariable Quiz quiz) {
		
		///STUB
		return dao.create(quiz);
	}
	
	@RequestMapping(path = "quizzes", method = RequestMethod.GET)
	public Quiz update(@PathVariable int id) {
		
		//STUB
		return dao.show(id);
	}
}