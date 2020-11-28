package com.crm.service;

import org.springframework.ui.Model;

import com.crm.database.data.CrmAccount;
import com.crm.database.data.CrmRole;

/**
 * @classComment 角色管理业务接口
 * @author yangyongtao
 * @createTime 2020-11-25 上午11:34:38
 * @updateTime 2020-11-25 上午11:34:38
 * @version 1.0.0.0
 */
public interface IRoleService {

	/**
	 * desc: 查询角色
	 * @param model
	 * @param roleName
	 * @param pageNum
	 * @return
	 * @throws Exception
	 */
	public String query(Model model, String roleName, Integer pageNum) throws Exception;
	
	/**
	 * desc: 添加角色
	 * @param model
	 * @param account
	 * @param roleName
	 * @return
	 * @throws Exception
	 */
	public String add(Model model, CrmAccount account, String roleName) throws Exception;
	
	/**
	 * desc: 删除角色
	 * @param model
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public String delete(Model model, String roleName, Integer pageNum, Integer... ids) throws Exception;
	
	/**
	 * desc: 展示修改角色视图
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String updateView(Model model, Integer id) throws Exception;
	
	/**
	 * desc: 修改角色
	 * @param model
	 * @param accont
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public String update(Model model, CrmAccount account, CrmRole role) throws Exception;
	
	/**
	 * desc: 展示分配权限视图
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String grantView(Model model, Integer id) throws Exception;
	
	/**
	 * desc: 分配权限
	 * @param model
	 * @param roleId
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public String grant(Model model, Integer roleId, Integer[] ids) throws Exception;
	
}
