package jp.co.iccom.suzuki_yoshihiro.springdata_jpa_bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.iccom.suzuki_yoshihiro.springdata_jpa_bbs.service.MessageService;
import jp.co.iccom.suzuki_yoshihiro.springdata_jpa_bbs.service.UserService;

@Controller
public class TopController {

	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;

	@RequestMapping(value = "/top/", method = RequestMethod.GET)
	public ModelAndView showMessage(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "hello, world!!");
		mav.addObject("userInfoList", userService.getUserList());
		mav.setViewName("top");
		return mav;
	}

	@RequestMapping(value = "/user/id/{id}", method = RequestMethod.GET)
	public ModelAndView showUserInfo(@PathVariable int id){
		ModelAndView mav = new ModelAndView();
		mav.addObject("userInfo", userService.getUser(id));
		mav.addObject("messages", messageService.getMessageById(id));
		mav.setViewName("userinfo");

		return mav;
	}
}
