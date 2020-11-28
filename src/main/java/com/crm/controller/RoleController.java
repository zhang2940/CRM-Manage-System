package com.crm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.crm.database.data.CrmAccount;
import com.crm.database.data.CrmPermission;
import com.crm.database.data.CrmRole;
import com.crm.service.IRoleService;

/**
 * @classComment 角色管理
 * @author yangyongtao
 * @createTime 2020-11-25 上午11:45:23
 * @updateTime 2020-11-25 上午11:45:23
 * @version 1.0.0.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {

	//注入业务实现接口对象
	@Resource
	private IRoleService iroleService;
	
	/**
	 * desc: 查询角色
	 * @param model
	 * @param roleName
	 * @return
	 */
	@RequestMapping("/query.do")
	public String query(Model model, String sroleName, Integer pageNum) {
		try {
			//访问业务实现接口的查询方法
			String nextPath = iroleService.query(model, sroleName, pageNum);
			//返回下一个视图路径
			return nextPath;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	/**
	 * desc: 展示添加角色视图
	 * @param model
	 * @return
	 */
	@RequestMapping("/addview.do")
	public String addView(Model model) {
		return "pages/role/roleadd";
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
	public String add(Model model, @SessionAttribute("userInfo") 
			CrmAccount account, String roleName) throws Exception {
		try {
			String nextPath = iroleService.add(model, account, roleName);
			return nextPath;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	/**
	 * desc: 删除角色
	 * @param model
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete.do")
	public String delete(Model model, String sroleName, Integer pageNum, 
			@RequestParam("id") Integer[] ids) {
		try {
			String nextPath = iroleService.delete(model, sroleName, pageNum, ids);
			return nextPath;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	/**
	 * desc: 展示修改角色视图
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateview.do")
	public String updateView(Model model, Integer id) throws Exception {
		try {
			String nextPath = iroleService.updateView(model, id);
			return nextPath;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	/**
	 * desc: 修改角色
	 * @param model
	 * @param account
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/update.do")
	public String update(Model model, @SessionAttribute("userInfo") 
			CrmAccount account, CrmRole role, CrmPermission perm) throws Exception {
		try {
			String nextPath = iroleService.update(model, account, role);
			return nextPath;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	/**
	 * desc: 展示分配权限视图
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/grantview.do")
	public String grantView(Model model, Integer id) throws Exception {
		try {
			String nextPath = iroleService.grantView(model, id);
			return nextPath;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	/**
	 * desc: 分配权限
	 * @param model
	 * @param roleId
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/grant.do")
	public String grant(Model model, Integer roleId, 
			@RequestParam("id") Integer[] ids) throws Exception {
		try {
			String nextPath = iroleService.grant(model, roleId, ids);
			return nextPath;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
	
}
