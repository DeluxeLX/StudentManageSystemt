package com.itlzh.mapper;

import com.itlzh.pojo.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserDAO {

    /*
    *   查询一个集合时，property表示pojo类中的参数名
    *                column表示传进嵌套查询里的参数(这里为ID)
    *                javaType表示这个result返回的是一种什么类型(比如List)
    *                many用于返回通过查询返回一个语句
    * */

    // 通过传来的用户名在数据库中进行匹配
    @Select("select * from users where username = #{username};")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id",
                    javaType = java.util.List.class,
                    many = @Many(select = "com.itlzh.mapper.RoleDAO.findRoleByUserId"))
    })
    UserInfo findByUsername(String username);

}
