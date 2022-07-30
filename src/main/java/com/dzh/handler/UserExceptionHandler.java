package com.dzh.handler;

import com.dzh.exception.UserExceptin;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();

        if (ex instanceof NullPointerException) {
            modelAndView.addObject("msg","空指针异常");
        } else if (ex instanceof UserExceptin) {
            modelAndView.addObject("msg", "用户自定义异常");
        } else {
            //getMessage 表示异常信息
            modelAndView.addObject("msg", ex.getMessage());
        }

        modelAndView.setViewName("/error/error");
        return modelAndView;
    }

}
