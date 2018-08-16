package com.teleware.service.impl;

import com.teleware.entity.userModel;
import com.teleware.mapper.IUserDao;
import com.teleware.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements IUserService {

    @Autowired
    private IUserDao mapper;
    @Override
    public userModel getUserById(String id) {
        return mapper.getUserById(id);
    }

    @Override
    public userModel login(String logonid, String passwd) {
        return mapper.login(logonid,passwd);
    }
}
