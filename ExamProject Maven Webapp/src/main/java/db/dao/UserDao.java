package db.dao;

import db.entity.User;

/** 
*@author 作者 E-mail：ingo 
*@version 创建时间：2016年4月17日下午6:26:40 
*类说明 
*/  
public interface UserDao {  
    User findUserById(String id);
    void insertUserInDb(User user);
}
