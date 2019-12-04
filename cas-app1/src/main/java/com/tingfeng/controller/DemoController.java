package com.tingfeng.controller;

import com.google.gson.Gson;
import com.tingfeng.domain.User;
import com.tingfeng.remote.FerignApp2;
import com.tingfeng.utils.HttpProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    private FerignApp2 ferignApp2;

    private static String API_BASE_URL = "http://client1.com:8888/";

    @GetMapping("/hello")
    public String hello() {
        return "前端 app1  Hello 接口响应";
    }

    @GetMapping("/world")
    public String world() {

        String result = HttpProxy.httpRequest(API_BASE_URL + "/world", null, HttpMethod.GET);
        System.out.println("Client1 接口响应结果：" + result);

        return result;
    }

    @GetMapping("/users")
    public List<User> users() {
        String result = HttpProxy.httpRequest(API_BASE_URL + "/user/users", null, HttpMethod.GET);
        System.out.println("Client1 接口响应结果：" + result);

        if (null != result && !result.equals("")) {
            Gson gson = new Gson();
            List<User> userList = gson.fromJson(result, List.class);
            return userList;
        }

        return null;
    }

    @GetMapping("/books")
    public List<String> books() {

        String result = HttpProxy.httpRequest(API_BASE_URL + "/book/books", null, HttpMethod.GET);
        System.out.println("Client1 接口响应结果：" + result);

        if (null != result && !result.equals("")) {
            Gson gson = new Gson();
            List<String> nameList = gson.fromJson(result, List.class);
            return nameList;
        }

        return null;
    }

    @GetMapping("/remote")
    public String testApp2Service(){
        System.out.println("远程调用 app2");
        return ferignApp2.hello();
    }


}
