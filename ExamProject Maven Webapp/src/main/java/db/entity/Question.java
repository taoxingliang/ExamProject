package db.entity;

import java.io.Serializable;
@SuppressWarnings("serial")  
public class Question  implements Serializable {
	
	private long questionId;
	private int region;
	private int questionEditor;
	private int questionLevel;
	private int questionTypeOne;
	private int questionTypeTwo;
	private String question;
	private String selectA;
	private String selectB;
	private String selectC;
	private String selectD;
	private String selectOther;
	private String analysis;
	private int answer;
	private long ansSum;
	private long rightSum;
	private long selectASum;
	private long selectBSum;
	private long selectCSum;
	private String selectOtherSum;
	private String other;
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	public int getRegion() {
		return region;
	}
	public void setRegion(int region) {
		this.region = region;
	}
	public int getQuestionEditor() {
		return questionEditor;
	}
	public void setQuestionEditor(int questionEditor) {
		this.questionEditor = questionEditor;
	}
	public int getQuestionLevel() {
		return questionLevel;
	}
	public void setQuestionLevel(int questionLevel) {
		this.questionLevel = questionLevel;
	}
	public int getQuestionTypeOne() {
		return questionTypeOne;
	}
	public void setQuestionTypeOne(int questionTypeOne) {
		this.questionTypeOne = questionTypeOne;
	}
	public int getQuestionTypeTwo() {
		return questionTypeTwo;
	}
	public void setQuestionTypeTwo(int questionTypeTwo) {
		this.questionTypeTwo = questionTypeTwo;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getSelectA() {
		return selectA;
	}
	public void setSelectA(String selectA) {
		this.selectA = selectA;
	}
	public String getSelectB() {
		return selectB;
	}
	public void setSelectB(String selectB) {
		this.selectB = selectB;
	}
	public String getSelectC() {
		return selectC;
	}
	public void setSelectC(String selectC) {
		this.selectC = selectC;
	}
	public String getSelectD() {
		return selectD;
	}
	public void setSelectD(String selectD) {
		this.selectD = selectD;
	}
	public String getSelectOther() {
		return selectOther;
	}
	public void setSelectOther(String selectOther) {
		this.selectOther = selectOther;
	}
	public String getAnalysis() {
		return analysis;
	}
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public long getAnsSum() {
		return ansSum;
	}
	public void setAnsSum(long ansSum) {
		this.ansSum = ansSum;
	}
	public long getRightSum() {
		return rightSum;
	}
	public void setRightSum(long rightSum) {
		this.rightSum = rightSum;
	}
	public long getSelectASum() {
		return selectASum;
	}
	public void setSelectASum(long selectASum) {
		this.selectASum = selectASum;
	}
	public long getSelectBSum() {
		return selectBSum;
	}
	public void setSelectBSum(long selectBSum) {
		this.selectBSum = selectBSum;
	}
	public long getSelectCSum() {
		return selectCSum;
	}
	public void setSelectCSum(long selectCSum) {
		this.selectCSum = selectCSum;
	}
	public String getSelectOtherSum() {
		return selectOtherSum;
	}
	public void setSelectOtherSum(String selectOtherSum) {
		this.selectOtherSum = selectOtherSum;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	

}
