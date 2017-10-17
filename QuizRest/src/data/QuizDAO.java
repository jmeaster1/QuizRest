package data;

import java.util.List;

import entities.Quiz;

public interface QuizDAO {
	public List<Quiz> index();
	public Quiz show(int id);
	public Quiz create(Quiz quiz);
	public Quiz update(int id, Quiz quiz);

}
