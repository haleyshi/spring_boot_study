/**
 * 
 */
package com.sgh.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sgh.demo.exception.MyException;

/**
 * @author eguoshi
 *
 */
@Controller
public class HelloController {
	@RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("Error1");
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("Error2", 500);
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("home", "http://github.com/haleyshi");
        return "index";
    }
}
