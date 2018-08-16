package com.teleware.web;

import com.teleware.entity.userModel;
import com.teleware.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserModelController {


    @Autowired
    private DiscoveryClient client;
    @Autowired
    private IUserService userServiceImpl;
    

    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public userModel login(@RequestParam String logonid,@RequestParam String passwd) {
        userModel user = userServiceImpl.login(logonid,passwd);
        ServiceInstance instance = client.getLocalServiceInstance();
        String serverMessage = "host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ",Port:"+instance.getPort();
        user.setServerMessage(serverMessage);
        return user;
    }


    @RequestMapping(value = "/info" ,method = RequestMethod.GET)
    public String info() {
        return "默认页";
    }
}