package com.tingfeng.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 服务之间的调用，这里是消费者，调用app2接口或服务
 * 这里无需服务注册中心，直接通过url来调用
 */
@FeignClient(value = "app2",url="http://localhost:6660/water")
public interface FerignApp2 {

    @GetMapping("/api/hello")
    public String hello();
}
