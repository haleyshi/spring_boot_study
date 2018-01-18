package com.sgh.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sgh.demo.domain.User;
import com.sgh.demo.service.UserService;

@Controller   // do not use RestController
@RequestMapping(value = "/users") // 通过这里配置使下面的映射都在 /users
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String getUserList(ModelMap map) {
		map.addAttribute("userList", userService.findAll());
		return "userList";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createUserForm(ModelMap map) {
		map.addAttribute("user", new User());
		map.addAttribute("action", "create");
		return "userForm";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postUser(ModelMap map,
                           @ModelAttribute @Valid User user,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            map.addAttribute("action", "create");
            return "userForm";
        }

        userService.insertByUser(user);

        return "redirect:/users/";
    }
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable Long id, ModelMap map) {
        map.addAttribute("user", userService.findById(id));
        map.addAttribute("action", "update");
        return "userForm";
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public String putUser(ModelMap map,
                          @ModelAttribute @Valid User user,
                          BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            map.addAttribute("action", "update");
            return "userForm";
        }

        userService.update(user);
        return "redirect:/users/";
    }
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/users/";
    }
}
