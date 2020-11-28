package com.crm.service;

import org.springframework.ui.Model;

import com.crm.database.data.CrmAccount;

/** 
 * @classComment 用户管理业务接口
 * @author yangyongtao
 * @createTime 2020-11-26 上午10:33:37
 * @updateTime 2020-11-26 上午10:33:37
 * @version 1.0.0.0
 */
public interface IUserService {

	/**
	 * 查询用户
	 * @param model
	 * @param accountName
	 * @param pageNum
	 * @return
	 * @throws Exception
	 */
	public String query(Model model, String accountName, Integer pageNum) throws Exception;

	/**
	 * 展示添加视图
	 * @param model
	 * @return
	 */
	public String addView(Model model);

	/**
	 * 添加用户
	 * @param account
	 * @return
	 * @throws Exception 
	 */
	public String addUser(Model model,CrmAccount account) throws Exception;

	/**
	 * 删除用户
	 * @param model
	 * @param userName
	 * @param pageNum
	 * @param ids
	 * @return
	 * @throws Exception 
	 */
	public String delete(Model model, String userName, Integer pageNum, Integer... ids) throws Exception;

	/**
	 * 展示修改用户视图
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public String updateView(Model model, Integer id) throws Exception;

	/**
	 * 修改用户
	 * @param model
	 * @param account
	 * @return
	 * @throws Exception 
	 */
	public String update(Model model, CrmAccount account) throws Exception;
}

