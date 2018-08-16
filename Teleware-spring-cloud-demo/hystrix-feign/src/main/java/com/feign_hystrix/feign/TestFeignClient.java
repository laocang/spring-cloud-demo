package com.feign_hystrix.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.feign_hystrix.feign.TestFeignClient.HystrixClientFallback;


@FeignClient(name = "service-login",fallback = HystrixClientFallback.class)
public interface TestFeignClient {
	
  @RequestMapping("/login")
  public String login(@RequestParam("logonid") String logonid,@RequestParam("passwd") String passwd);

  @Component
  static class HystrixClientFallback implements TestFeignClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallback.class);

	@Override
	public String login(String logonid, String passwd) {
		HystrixClientFallback.LOGGER.info("异常发生，进入fallback方法，接收的参数： {},{}",logonid,passwd);
		return "登录失败，登录服务异常!";
	}
  }
}