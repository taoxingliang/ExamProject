package web.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.ibatis.session.SqlSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import db.dao.UserDao;
import db.entity.User;
import db.util.SqlSessionFactoryUtil;


@SpringBootApplication // Spring Boot项目的核心注解，主要目的是开启自动配置
@Controller // 标明这是一个SpringMVC的Controller控制器
@ComponentScan(basePackages = "web.application")
public class Application extends SpringBootServletInitializer {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() throws Exception {
    	SqlSession sqlSession=SqlSessionFactoryUtil.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class); 
        User user1 = new User("fff", "eseses");
        userDao.insertUserInDb(user1);
        sqlSession.commit();
        String id = "fff";  
        User curUser = userDao.findUserById(id);  
        if(curUser!=null){  
            System.out.println("HelloWorld:"+curUser.getId());  
        }
//    	String userName = "root";  
//        String password = "TxL7516..";  
//        String jdbcurl = "jdbc:mysql://localhost:3306/userdb";
//        Class.forName("com.mysql.jdbc.Driver").newInstance();  
//        Connection conn = (Connection) DriverManager.getConnection(jdbcurl, userName, password);  
//        String sql = "select * from user";  
//        PreparedStatement pstmt = conn.prepareStatement(sql);
        return "hello world : curUser.getId() = " + curUser.getPassword();
    }
    
    
    @GetMapping("/add")
    public String  add() {
    	return "aaa";
    }
    
    @RequestMapping("/ccc")
    @ResponseBody
    public String index(){
      return "aaaaaa";
    }


    // 在main方法中启动一个应用，即：这个应用的入口
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }


}

