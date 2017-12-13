/**
 * 
 */
package com.sgh.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author eguoshi
 *
 */
@Controller
public class HelloController {

	@GetMapping("/hello")
	@ResponseBody
    public String hello(){
        return "hello";
    }
	
	@GetMapping("/bye")
	@ResponseBody
    public String bye(){
        return "bye";
    }
}
