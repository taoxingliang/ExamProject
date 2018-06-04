package db.dao;

import db.entity.Exam;

public interface ExamDao {
	 Exam findExamById(long id);
	 void insertExamInDb(Exam exam);
	 void updateExamInDb(Exam exam);
}
