package jp.co.iccom.suzuki_yoshihiro.springdata_jpa_bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.iccom.suzuki_yoshihiro.springdata_jpa_bbs.service.UserService;

@Controller
public class TopController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/top/", method = RequestMethod.GET)
	public ModelAndView showMessage(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "hello, world!!");
		mav.addObject("userInfoList", userService.getUserList());
		mav.setViewName("showMessage");
		return mav;
	}
}
