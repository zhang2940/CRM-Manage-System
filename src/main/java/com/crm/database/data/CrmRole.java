package com.crm.database.data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 
 * @classComment 角色表持久化类
 * @author yangyongtao
 * @createTime 2020-11-25 上午11:09:18
 * @updateTime 2020-11-25 上午11:09:18
 * @version 1.0.0.0
 */
@SuppressWarnings("serial")
public class CrmRole implements Serializable {

	private Integer roleId; // 角色ID
	private String roleName; // 角色名称
	private List<CrmPermission> crmPermissions; // 关联权限的集合
	private String operUser; // 操作人
	private Timestamp operTime; // 操作时间

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<CrmPermission> getCrmPermissions() {
		return crmPermissions;
	}

	public void setCrmPermissions(List<CrmPermission> crmPermissions) {
		this.crmPermissions = crmPermissions;
	}

	public String getOperUser() {
		return operUser;
	}

	public void setOperUser(String operUser) {
		this.operUser = operUser;
	}

	public Timestamp getOperTime() {
		return operTime;
	}

	public void setOperTime(Timestamp operTime) {
		this.operTime = operTime;
	}

}
