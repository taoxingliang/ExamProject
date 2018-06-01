package db.dao;

import db.entity.Exam;

public interface ExamDao {
	 Exam findExamById(String id);
	 void insertExamInDb(Exam exam);
	 void updateExamInDb(Exam exam);
}
