package com.rabbit.lungvision.user.mapper;

import com.rabbit.lungvision.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> queryByUserNameAndPassword(@Param("username") String username, @Param("password") String password);
}
