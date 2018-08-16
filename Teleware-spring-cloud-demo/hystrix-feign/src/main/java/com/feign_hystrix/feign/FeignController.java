package com.feign_hystrix.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
  @Autowired
  private TestFeignClient testFeignClient;

  @RequestMapping(value = "/login" , method = RequestMethod.GET)
  public String login(@RequestParam("logonid") String logonid,@RequestParam("passwd") String passwd) {
    String string = this.testFeignClient.login(logonid,passwd);
    return string;
  }
}