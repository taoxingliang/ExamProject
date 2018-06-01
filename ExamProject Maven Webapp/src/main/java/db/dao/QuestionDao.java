package db.dao;

import java.util.List;

import db.entity.Question;

public interface QuestionDao {
	void insertQuestionInDb(Question Question);
	List<Question> queryExam(int questionType, int questionNum);
	Question queryQuestion(String questionid);
}
