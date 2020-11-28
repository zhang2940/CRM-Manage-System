package com.crm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crm.service.ILoginoutService;


/**
 * 
 * @classComment 登录及注销控制器
 * @author yangyongtao
 * @createTime 2020-11-25 上午11:44:31
 * @updateTime 2020-11-25 上午11:44:31
 * @version 1.0.0.0
 */
@Controller
@SessionAttributes({"userInfo"})
public class LoginoutController {
	
	//注入业务接口Bean对象
	@Resource
	private ILoginoutService iloginoutService;
	
	/**
	 * desc: 登录
	 * @param model
	 * @param account
	 * @param password
	 * @return
	 */
	@RequestMapping("/login.do")
	public String login(Model model, String account, String password) {
		try {
			String nextPath = iloginoutService.login(
					model, account, password);
			return nextPath;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	/**
	 * desc: 注销
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout.do")
	public String logout(Model model, SessionStatus sessionStatus, 
			RedirectAttributes attributes) {
		try {
			return iloginoutService.logout(model, sessionStatus);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	@RequestMapping(value="/getsessiondata.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getSessionData(@SessionAttribute String userInfo) {
		System.out.println("userInfo: "+userInfo);
		return "userInfo: "+userInfo;
	}

}










