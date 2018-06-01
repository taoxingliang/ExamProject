package db.entity;

public class Exam {
	private long examId;
	private int region;
	private int questionType;
	private int questionNum;
	private String questionInfo;
	private String errorQuestion;
	private int score;
	
	public long getExamId() {
		return examId;
	}
	public void setExamId(long examId) {
		this.examId = examId;
	}
	public int getRegion() {
		return region;
	}
	public void setRegion(int region) {
		this.region = region;
	}
	public int getQuestionType() {
		return questionType;
	}
	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}
	public int getQuestionNum() {
		return questionNum;
	}
	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}
	public String getQuestionInfo() {
		return questionInfo;
	}
	public void setQuestionInfo(String questionInfo) {
		this.questionInfo = questionInfo;
	}
	public String getErrorQuestion() {
		return errorQuestion;
	}
	public void setErrorQuestion(String errorQuestion) {
		this.errorQuestion = errorQuestion;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

}
