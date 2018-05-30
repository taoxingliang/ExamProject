package web.application;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ActionController {
  
  @RequestMapping("/adad")
  @ResponseBody
  public String index(){
    return "aaaaaa";
  }
  
  @GetMapping("/addQuestion")
  public String test(){ 
      return "aaa";
  }
  @RequestMapping("/insertQuestion")
  @ResponseBody
  public String insertQuestion(HttpServletRequest request) {
	  Map<String,String[]> map= request.getParameterMap();  
      //参数名称  
      Set<String> key=map.keySet();  
      //参数迭代器  
      Iterator<String> iterator = key.iterator(); 
      StringBuilder result = new StringBuilder();
      while(iterator.hasNext()){  
          String k=iterator.next();
          result.append(k + ": " + "\n" + map.get(k)[0] + "\n");
      }
      return result.toString();
	  
  }
 
}
