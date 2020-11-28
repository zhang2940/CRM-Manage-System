package com.crm.database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.crm.database.data.CrmRole;


/**
 * @classComment 角色数据访问接口
 * @author yangyongtao
 * @createTime 2020-11-25 上午11:17:29
 * @updateTime 2020-11-25 上午11:17:29
 * @version 1.0.0.0
 */
public interface IRoleMapper {

	/**
	 * desc: 查询所有角色数据
	 * @return
	 * @throws Exception
	 */
	@Results(id="roleSimpleResults", value = {
			@Result(property = "roleId", column = "role_id", id = true),
			@Result(property = "roleName", column = "role_name"),
			@Result(property = "operUser", column = "oper_user"),
			@Result(property = "operTime", column = "oper_time"),
		})
	@Select("<script>"
		+ 	"select role_id,role_name,oper_user,oper_time from crm_role"
		+ 		"<where>"
		+ 			"<if test=\"roleName != null and roleName != ''\">"
		+				" role_name like '%${roleName}%'"
		+ 			"</if>"
		+ 		"</where>"
		+ 	" order by oper_time desc"
		+ "</script>")
	public List<CrmRole> queryAll(@Param("roleName") String roleName) throws Exception;
	
	/**
	 * desc:根据ID获得角色对象， 关联获得权限数据
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Results(id="roleResults", value = {
			@Result(property = "roleId", column = "role_id", id = true),
			@Result(property = "roleName", column = "role_name"),
			@Result(property = "crmPermissions", column = "role_id", 
			    many = @Many(select = "com.crm.database.mapper.IPermissionMapper.getByRoleId"))
		})
	@Select("select role_id,role_name from crm_role where role_id=#{id}")
	public CrmRole getById(Integer id) throws Exception;
	
	/**
	 * desc: 查询获得角色对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ResultMap("roleSimpleResults")
	@Select("select role_id,role_name from crm_role where role_id=#{id}")
	public CrmRole findById(Integer id) throws Exception;
	
	/**
	 * desc: 添加角色数据
	 * @param role
	 * @throws Exception
	 */
	@Insert("insert into crm_role(role_name,oper_user,oper_time) values(#{roleName}, #{operUser}, #{operTime})")
	public void add(CrmRole role) throws Exception;
	
	/**
	 * desc: 删除角色数据
	 * @param ids
	 * @throws Exception
	 */
	@Delete("<script>"
		+ 	"delete from crm_role where role_id in"
		+	"<foreach item=\"id\" collection=\"array\""
		+   	" open=\"(\" separator=\",\" close=\")\">"
		+       "#{id}"
		+   "</foreach>"
		+ "</script>")
	public void delete(Integer... ids) throws Exception;
	
	/**
	 * desc: 修改角色数据
	 * @param role
	 * @throws Exception
	 */
	@Update("update crm_role set role_name=#{roleName},oper_user=#{operUser},"
		+ "oper_time=#{operTime} where role_id=#{roleId}")
	public void update(CrmRole role) throws Exception;
	
	/**
	 * desc: 删除角色拥有的所有权限
	 * @param roleId
	 * @throws Exception
	 */
	@Delete("delete from crm_role_permission where role_id=#{roleId}")
	public void deletePermission(Integer roleId) throws Exception;
	
	/**
	 * desc: 添加角色的权限
	 * @param roleId
	 * @param permIds
	 * @throws Exception
	 */
	@Insert("<script>"
			+ 	"insert into crm_role_permission(role_id,perm_id) values"
			+	"<foreach item=\"id\" collection=\"ids\" separator=\",\">"
			+       "(#{roleId}, #{id})"
			+   "</foreach>"
			+ "</script>")
	public void addPermission(@Param("roleId") Integer roleId, 
			@Param("ids") Integer[] ids) throws Exception;
}
