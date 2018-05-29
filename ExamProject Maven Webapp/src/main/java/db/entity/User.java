package db.entity;

import java.io.Serializable;  

/** 
*@author 作者 E-mail：ingo 
*@version 创建时间：2016年4月17日下午6:25:27 
*类说明 
*/  
@SuppressWarnings("serial")  
public class User implements Serializable{  
      
    private String id;  
    private String password;  
    public String getId() {  
        return id;  
    }  
    public void setId(String id) {  
        this.id = id;  
    }  
    public String getPassword() {  
        return password;  
    }  
    public void setPassword(String password) {  
        this.password = password;  
    }  
    public User(String id, String password) {  
        super();  
        this.id = id;  
        this.password = password;  
    }  
    public User() {  
        super();  
        // TODO Auto-generated constructor stub  
    }  
}  

