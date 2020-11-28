package com.crm.controller;


import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crm.database.data.CrmAccount;
import com.crm.service.IUserService;

/** 
 * @classComment 用户管理
 * @author yangyongtao
 * @createTime 2020-11-26 上午9:58:34
 * @updateTime 2020-11-26 上午9:58:34
 * @version 1.0.0.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

	//注入业务实现接口对象
	@Resource
	private IUserService iuserService;
	
	/**
	 * desc: 查询用户
	 * @param model
	 * @param saccountName
	 * @return
	 */
	@RequestMapping("/query.do")
	public String query(Model model, String saccountName, Integer pageNum) {
		try {
			//访问业务实现接口的查询方法
			String nextPath = iuserService.query(model, saccountName, pageNum);
			//返回下一个视图路径
			return nextPath;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	/**
	 * desc: 展示添加用户视图
	 * @param model
	 * @return
	 */
	@RequestMapping("/addview.do")
	public String addView(Model model) {
		try {
			//访问业务实现接口的查询方法
			String nextPath = iuserService.addView(model);
			//返回下一个视图路径
			return nextPath;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "error";		
	}
	
	/**
	 * desc: 添加角色
	 * @param model
	 * @param account
	 * @param roleName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add.do")
	public String add(Model model,CrmAccount account) throws Exception {
		try {
			String nextPath = iuserService.addUser(model,account);
			return nextPath;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	/**
	 * desc: 删除用户
	 * @param model
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete.do")
	public String delete(Model model, String saccountName, Integer pageNum, 
			@RequestParam("id") Integer[] ids) {
		try {
			String nextPath = iuserService.delete(model, saccountName, pageNum, ids);
			return nextPath;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	/**
	 * desc: 展示修改用户视图
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateview.do")
	public String updateView(Model model, Integer id) throws Exception {
		try {
			String nextPath = iuserService.updateView(model, id);
			return nextPath;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	/**
	 * 修改用户
	 * @param model
	 * @param account
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/update.do")
	public String update(Model model, CrmAccount account) throws Exception {
		try {
			String nextPath = iuserService.update(model, account);
			return nextPath;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
}

