package com.crm.service;


import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;


/**
 * 
 * @classComment 登录及注销业务接口
 * @author yangyongtao
 * @createTime 2020-11-25 上午11:35:16
 * @updateTime 2020-11-25 上午11:35:16
 * @version 1.0.0.0
 */
public interface ILoginoutService {

	/**
	 * desc: 登录
	 * @param model
	 * @param account
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public String login(Model model, String account, 
			String password) throws Exception;
	
	/**
	 * desc: 注销
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public String logout(Model model, 
			SessionStatus sessionStatus) throws Exception;
	
}
