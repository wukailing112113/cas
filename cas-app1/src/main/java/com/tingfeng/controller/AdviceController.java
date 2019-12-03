package com.tingfeng.controller;

import org.jasig.cas.client.validation.TicketValidationException;
import org.springframework.boot.autoconfigure.web.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

//@ControllerAdvice
@RestController
@RequestMapping(value = "error")
public class AdviceController extends BasicErrorController {

    public AdviceController() {
        super(new DefaultErrorAttributes(), new ErrorProperties());
    }

    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @Override
    public ResponseEntity error(HttpServletRequest request) {
        Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
        //log.info(JSONUtil.toJsonPrettyStr(body));
        // 错误信息
        String message = body.get("message").toString();
        if (message.contains("ShiroRealm")) {
            return new ResponseEntity<>("会话失效，请重新登录", HttpStatus.UNAUTHORIZED);
        }
        return ResponseEntity.ok(body);
    }

//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView exception(Exception exception, WebRequest request) {
//        ModelAndView modelAndView = new ModelAndView("error");// error页面
//        modelAndView.addObject("errorMessage", exception.getMessage());
//        return modelAndView;
//    }

    @ResponseBody
    @ExceptionHandler(value = TicketValidationException.class)
    public String exception(Exception exception) {
        return "fail";
    }
}
