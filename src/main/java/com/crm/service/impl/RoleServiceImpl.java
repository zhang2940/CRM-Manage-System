package com.crm.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.crm.database.data.CrmAccount;
import com.crm.database.data.CrmPermission;
import com.crm.database.data.CrmRole;
import com.crm.database.mapper.IPermissionMapper;
import com.crm.database.mapper.IRoleMapper;
import com.crm.service.IRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @classComment 角色管理业务实现类
 * @author yangyongtao
 * @createTime 2020-11-25 上午11:38:18
 * @updateTime 2020-11-25 上午11:38:18
 * @version 1.0.0.0
 */
@Service
public class RoleServiceImpl implements IRoleService {

	//注入数据访问映射接口对象
	@Resource
	private IRoleMapper iroleMapper;
	@Resource
	private IPermissionMapper ipermissionMapper;
	
	@Override
	public String query(Model model, String roleName, Integer pageNum) throws Exception {
		//判断是否获得页码
		pageNum = pageNum==null ? 1 : pageNum;
		//启用分页
		PageHelper.startPage(pageNum, 10);
		//查询角色数据
		List<CrmRole> list = iroleMapper.queryAll(roleName);
		//获得分页相关信息
		PageInfo<CrmRole> pageInfo = new PageInfo<CrmRole>(list, 10);		
		//封装模型数据
		model.addAttribute("list", list);
		model.addAttribute("pageInfo", pageInfo);
		return "pages/role/rolelist";
	}

	@Override
	public String add(Model model, CrmAccount account, String roleName) throws Exception {
		//创建角色对象
		CrmRole role = new CrmRole();
		//封装角色数据
		role.setRoleName(roleName);
		role.setOperUser(account.getAccountName());
		role.setOperTime(new Timestamp(System.currentTimeMillis()));
		//添加角色数据
		iroleMapper.add(role);
		//更新数据列表
		return query(model, null, 1); 
	}

	@Override
	public String delete(Model model, String roleName, Integer pageNum, Integer... ids) throws Exception {
		//删除角色数据
		iroleMapper.delete(ids);
		//更新数据列表
		return query(model, roleName, pageNum);
	}

	@Override
	public String updateView(Model model, Integer id) throws Exception {
		//获得角色数据
		CrmRole role = iroleMapper.findById(id);
		//封装模型数据
		model.addAttribute("role", role);
		//返回修改视图的路径
		return "pages/role/roleupdate";
	}

	@Override
	public String update(Model model, CrmAccount account, CrmRole role) throws Exception {
		//封装角色数据
		role.setOperUser(account.getAccountName());
		role.setOperTime(new Timestamp(System.currentTimeMillis()));
		//修改角色数据
		iroleMapper.update(role);
		//更新数据列表
		return query(model, null, 1);
	}

	@Override
	public String grantView(Model model, Integer id) throws Exception {
		//查询所有权限
		List<CrmPermission> perms = ipermissionMapper.queryAll();
		//查询角色及角色拥有的权限
		CrmRole role = iroleMapper.getById(id);
		//封装模型数据
		model.addAttribute("perms", perms);
		model.addAttribute("role", role);
		//返回分配权限视图的路径
		return "pages/role/rolegrant";
	}

	@Override
	public String grant(Model model, Integer roleId, Integer[] ids) throws Exception {
		//清除角色拥有的权限
		iroleMapper.deletePermission(roleId);
		//添加角色新权限
		iroleMapper.addPermission(roleId, ids);
		//更新数据列表
		return query(model, null, 1);
	}

}
