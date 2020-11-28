package com.crm.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;

import com.crm.database.data.CrmAccount;
import com.crm.database.mapper.IAccountMapper;
import com.crm.service.ILoginoutService;


/**
 * @classComment 登录及注销业务实现类
 * @author yangyongtao
 * @createTime 2020-11-25 上午11:39:37
 * @updateTime 2020-11-25 上午11:39:37
 * @version 1.0.0.0
 */
@Service
public class LoginServiceImpl implements ILoginoutService {

	//注入数据访问接口对象
	@Resource
	private IAccountMapper iaccountMapper; 
	
	@Override
	public String login(Model model, String account, 
			String password) throws Exception {
		//查询登录帐号，根据帐号、密码获得帐号对象
		CrmAccount crmAccount = iaccountMapper.getAccountByLogin(account, password);
		//验证用户是否可以登录
		if(crmAccount != null) {
			model.addAttribute("userInfo", crmAccount);
			return "index";
		}
		model.addAttribute("error", "用户名或密码错误!");
		return "login";
	}

	@Override
	public String logout(Model model,
			SessionStatus sessionStatus) throws Exception {
		//model.addAttribute("userInfo", null);
		//销毁session对象
		//session.invalidate();
		//清理框架中Session缓存数据
		sessionStatus.setComplete();
		//重定向
		return "redirect:login.jsp";
	}

}
