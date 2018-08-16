package com.teleware.service;

import com.teleware.entity.userModel;

public interface IUserService {

    userModel getUserById(String id);

    userModel login(String logonid, String passwd);
}
