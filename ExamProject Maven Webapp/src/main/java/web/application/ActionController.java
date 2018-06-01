package web.application;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import db.dao.QuestionDao;
import db.dao.UserDao;
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
  public String test(){ 
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
 
}
