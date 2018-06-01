package web.application;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import db.dao.ExamDao;
import db.dao.QuestionDao;
import db.dao.UserDao;
import db.entity.Exam;
import db.entity.Question;
import db.entity.User;
import db.util.SqlSessionFactoryUtil;


@Controller
public class ActionController {
  
  @RequestMapping("/adad")
  @ResponseBody
  public String index(){
    return "aaaaaa";
  }
  
  @GetMapping("/addQuestion")
  public String addQuestion(){ 
      return "addQuestion";
  }
  @RequestMapping("/insertQuestion")
  public String insertQuestion(HttpServletRequest request) {
	  SqlSession sqlSession=SqlSessionFactoryUtil.openSession();
      QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class); 
      Question question = new Question();
      question.setQuestionId(System.currentTimeMillis());
      question.setQuestionTypeOne(1);
	  Map<String,String[]> map= request.getParameterMap();  
      //参数名称  
      Set<String> key=map.keySet();  
      //参数迭代器  
      Iterator<String> iterator = key.iterator(); 
      StringBuilder result = new StringBuilder();
      while(iterator.hasNext()){  
          String k=iterator.next();
          if ("questionType".equals(k)) {
        	  question.setQuestionTypeTwo(Integer.parseInt(map.get(k)[0]));
          } else if ("questionLevel".equals(k)) {
        	  question.setQuestionLevel(Integer.parseInt(map.get(k)[0]));
          } else if ("question".equals(k)) {
        	  question.setQuestion(map.get(k)[0]);
          } else if ("selectA".equals(k)) {
        	  question.setSelectA(map.get(k)[0]);
          } else if ("selectB".equals(k)) {
        	  question.setSelectB(map.get(k)[0]);
          } else if ("selectC".equals(k)) {
        	  question.setSelectC(map.get(k)[0]);
          } else if ("selectD".equals(k)) {
        	  question.setSelectD(map.get(k)[0]);
          } else if ("analysis".equals(k)) {
        	  question.setAnalysis(map.get(k)[0]);
          } else if ("questionAnswer".equals(k)) {
        	  question.setAnswer(Integer.parseInt(map.get(k)[0]));
          }
          System.out.println(k + ": " + "-" + map.get(k)[0] + "-\n");
      }
      questionDao.insertQuestionInDb(question);
      sqlSession.commit();
      return "addSuccess";
  }
  /**
   * 获取试卷  questionType 试卷类型， questionNum 题目数目
   * 客户端数据格式
   * {
		"Head":{
		},
		"Body":{
			"questionType":"1",
			"questionNum":"3"
		}
   * }
   * @param jsonParam
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/GetExam", method = RequestMethod.POST)
  public String getExam(@RequestBody JSONObject jsonParam){
	// 直接将json信息打印出来
	    System.out.println(jsonParam.toJSONString());
	    JSONObject error;
	    int type=0;
	    int num=0;
	    try {
		    HashMap body = (HashMap) jsonParam.get("Body");
		    if (body != null) {
		    	type = Integer.parseInt(body.get("questionType").toString());
			    num = Integer.parseInt(body.get("questionNum").toString());
		    }
	    } catch (Exception e) {
	    	error = new JSONObject();
	    	error.put("err", e.getLocalizedMessage());
	    	return error.toJSONString();
	    }
	    if (num == 0 || type == 0) {
	    	error = new JSONObject();
	    	error.put("err", "questionType and questionNum can not be 0");
	    	return error.toJSONString();
	    }
	    
	    SqlSession sqlSession=SqlSessionFactoryUtil.openSession();
	    QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
	    List<Question> questionList = questionDao.queryExam(type, num);
	    // 将获取的json数据封装一层，然后在给返回
	    JSONObject result = new JSONObject();
	    result.put("msg", "ok");
	    result.put("method", "json");
	    Exam exam = new Exam();
	    exam.setExamId(System.currentTimeMillis());
	    exam.setQuestionType(type);
	    exam.setQuestionNum(num);
	    StringBuilder questioninfo = new StringBuilder();
	    int i = 0;
	    for (Question q : questionList) {
	    	i++;
	    	questioninfo.append(q.getQuestionId());
	    	if (i != questionList.size()) {
	    		questioninfo.append("#");
	    	}
	    	JSONObject ques = new JSONObject();
	    	ques.put("questionId", q.getQuestionId());
	    	ques.put("questionTypeTwo", q.getQuestionTypeTwo());
	    	ques.put("question", q.getQuestion());
	    	ques.put("selectA", q.getSelectA());
	    	ques.put("selectB", q.getSelectB());
	    	ques.put("selectC", q.getSelectC());
	    	ques.put("selectD", q.getSelectD());
	    	result.put("question" + i, ques);
	    }
	    result.put("examId", exam.getExamId());
	    exam.setQuestionInfo(questioninfo.toString());
	    ExamDao examDao = sqlSession.getMapper(ExamDao.class);
	    examDao.insertExamInDb(exam);
	    sqlSession.commit();
	    result.put("questionSize", questionList.size());
	    

	    return result.toJSONString();
  }
  
  @ResponseBody
  @RequestMapping(value = "/GetScore", method = RequestMethod.POST)
  public String getScore(@RequestBody JSONObject jsonParam){
	// 直接将json信息打印出来
	    System.out.println(jsonParam.toJSONString());
	    JSONObject error;
	    JSONObject result = new JSONObject();
	    int num=0;
	    long examId=0;
	    try {
		    HashMap body = (HashMap) jsonParam.get("Body");
		    
		    if (body != null) {
			    num = Integer.parseInt(body.get("questionNum").toString());
			    examId = Long.parseLong(body.get("examId").toString());
			    HashMap questions = (HashMap)body.get("question");
			    if (num == 0 || examId <= 0) {
			    	error = new JSONObject();
			    	error.put("err", "examId and questionNum can not be 0");
			    	return error.toJSONString();
			    }
			    SqlSession sqlSession=SqlSessionFactoryUtil.openSession();
			    QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
			    StringBuilder errorquestioninfo = new StringBuilder();
			    int score = 0;
			    for (int i = 0; i < num; i++) {
			    	JSONObject ques = new JSONObject();
			    	HashMap question = (HashMap)questions.get("question" + (i + 1));
			    	System.out.println("query question in db:" + question.get("questionId").toString());
			    	Question qu = questionDao.queryQuestion(question.get("questionId").toString());
			    	if (qu.getAnswer() == Integer.parseInt(question.get("answer").toString())) {
			    		score++;
			    		ques.put("isRight", 1);
			    		System.out.println("right");
			    	} else {
			    		errorquestioninfo.append(qu.getQuestionId() + "#");
			    		ques.put("isRight", 0);
			    		System.out.println("error");
			    	}
			    	
			    	ques.put("questionId", qu.getQuestionId());
			    	ques.put("analysis", qu.getAnalysis());
			    	result.put("question" + i, ques);
			    }
			    ExamDao examDao = sqlSession.getMapper(ExamDao.class);
			    Exam exam = examDao.findExamById(body.get("examId").toString());
			    exam.setErrorQuestion(errorquestioninfo.toString());
			    result.put("questionNum",num);
			    result.put("rightNum",score);
			    exam.setScore(score);
			    examDao.updateExamInDb(exam);
			    sqlSession.commit();
		    } else {
		    	error = new JSONObject();
		    	error.put("err", "body is null");
		    	return error.toJSONString();
		    }
	    } catch (Exception e) {
	    	error = new JSONObject();
	    	error.put("err", e.getLocalizedMessage());
	    	return error.toJSONString();
	    }
	    return result.toJSONString();
  }
 
}
