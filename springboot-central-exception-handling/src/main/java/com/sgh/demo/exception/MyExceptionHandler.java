package com.sgh.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sgh.demo.domain.ErrorInfo;

@ControllerAdvice
public class MyExceptionHandler {
	
	// 处理Exception.class，使用error template
	@ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

    // 处理MyException.class，直接返回自定义封装的ErrorInfo
	@ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> myErrorHandler(HttpServletRequest req, MyException e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(e.getCode());
        r.setData(e.toString());
        r.setUrl(req.getRequestURL().toString());
        return r;
    }
}
