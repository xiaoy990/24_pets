package com.nenu.ossas.mapper.usermapper;

import com.nenu.ossas.entity.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List getAllUsers();
    User findByName(@Param("name") String name);
    User findById(@Param("id") int id);
    void addUser(@Param("user") User user);
    void delUser(@Param("user") User user);
}
