package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String questionText;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE} )
	private Set<Answer> answers;
	
	@JsonIgnore
	@ManyToOne
	  @JoinColumn(name="quiz_id")
	  private Quiz quiz;

	public Question(int id, String questionText) {
		super();
		this.id = id;
		this.questionText = questionText;
	}

	public Question() {
		super();
	}
	

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}


	public int getId() {
		return id;
	}


	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", questionText=" + questionText + "]";
	}
	
	
}