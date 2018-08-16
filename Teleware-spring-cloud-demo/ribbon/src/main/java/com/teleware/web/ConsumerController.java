package com.teleware.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired  
    private LoadBalancerClient loadBalancerClient;  

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam String logonid,@RequestParam String passwd) {
    	this.loadBalancerClient.choose("service-login");//随机访问策略
        return restTemplate.getForEntity("http://service-login/login?logonid="+logonid+"&passwd="+passwd, String.class).getBody();
    	
    }
    
}