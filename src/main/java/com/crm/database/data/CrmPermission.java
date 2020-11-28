package com.crm.database.data;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @classComment 权限表持久化类
 * @author yangyongtao
 * @createTime 2020-11-25 上午11:08:56
 * @updateTime 2020-11-25 上午11:08:56
 * @version 1.0.0.0
 */
@SuppressWarnings("serial")
public class CrmPermission implements Serializable {

	private Integer permId; // 权限ID
	private Integer permParentId; // 权限父级ID
	private String permName; // 权限名称
	private String permUrl; // 访问路径
	private String permOrder; // 权限节点顺序
	private List<CrmRole> crmRoles; // 关联角色的集合

	public Integer getPermId() {
		return permId;
	}

	public void setPermId(Integer permId) {
		this.permId = permId;
	}

	public Integer getPermParentId() {
		return permParentId;
	}

	public void setPermParentId(Integer permParentId) {
		this.permParentId = permParentId;
	}

	public String getPermName() {
		return permName;
	}

	public void setPermName(String permName) {
		this.permName = permName;
	}

	public String getPermUrl() {
		return permUrl;
	}

	public void setPermUrl(String permUrl) {
		this.permUrl = permUrl;
	}

	public String getPermOrder() {
		return permOrder;
	}

	public void setPermOrder(String permOrder) {
		this.permOrder = permOrder;
	}

	public List<CrmRole> getCrmRoles() {
		return crmRoles;
	}

	public void setCrmRoles(List<CrmRole> crmRoles) {
		this.crmRoles = crmRoles;
	}

	

}
