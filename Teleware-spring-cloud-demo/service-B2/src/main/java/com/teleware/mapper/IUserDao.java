package com.teleware.mapper;

import com.teleware.entity.userModel;
import org.apache.ibatis.annotations.Param;

public interface IUserDao {

    userModel getUserById(@Param("id") String id);

    userModel login(@Param("logonid") String logonid,@Param("passwd") String passwd);
}
