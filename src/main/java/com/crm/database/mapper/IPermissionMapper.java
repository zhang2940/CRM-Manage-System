package com.crm.database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.crm.database.data.CrmPermission;


/**
 * @classComment 权限数据访问接口
 * @author yangyongtao
 * @createTime 2020-11-25 上午11:14:43
 * @updateTime 2020-11-25 上午11:14:43
 * @version 1.0.0.0
 */
public interface IPermissionMapper {

	/**
	 * desc: 查询所有权限
	 * @return
	 * @throws Exception
	 */
	@ResultMap("permissionResults")
	@Select("select perm_id,perm_name,perm_url,perm_parent_id,perm_order"
			+ " from crm_permission order by perm_order")
	public List<CrmPermission> queryAll() throws Exception;
	
	/**
	 * desc: 获得角色的权限
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@Results(id="permissionResults", value = {
		@Result(property = "permId", column = "perm_id", id = true),
		@Result(property = "permParentId", column = "perm_parent_id"),
		@Result(property = "permName", column = "perm_name"),
		@Result(property = "permUrl", column = "perm_url"),
		@Result(property = "permOrder", column = "perm_order")
	})
	@Select("select p.perm_id,perm_name,perm_url,perm_parent_id,perm_order from crm_role_permission rp join crm_permission"
			+ " p on rp.role_id=#{roleId} and rp.perm_id=p.perm_id order by perm_order")
	public List<CrmPermission> getByRoleId(Integer roleId) throws Exception;
	
}
