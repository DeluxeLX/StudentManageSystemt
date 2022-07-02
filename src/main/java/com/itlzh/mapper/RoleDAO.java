package com.itlzh.mapper;

import com.itlzh.pojo.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleDAO {
    // 根据用户ID查询出所用用户的角色
    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    List<Role> findRoleByUserId(String userId) throws Exception;
}
