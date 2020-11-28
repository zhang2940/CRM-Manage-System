package com.crm.database.data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * @classComment 帐号持久化类
 * @author yangyongtao
 * @createTime 2020-11-25 上午11:05:36
 * @updateTime 2020-11-25 上午11:05:36
 * @version 1.0.0.0
 */
@SuppressWarnings("serial")
public class CrmAccount implements Serializable {

	private Integer accountId; // ID
	private String accountName; // 帐号
	private String accountPassword; // 密码
	private String accountGender; // 性别
	private Timestamp operTime; // 操作时间
	private CrmRole crmRole; // 角色

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public String getAccountGender() {
		return accountGender;
	}

	public void setAccountGender(String accountGender) {
		this.accountGender = accountGender;
	}

	public Timestamp getOperTime() {
		return operTime;
	}

	public void setOperTime(Timestamp operTime) {
		this.operTime = operTime;
	}

	public CrmRole getCrmRole() {
		return crmRole;
	}

	public void setCrmRole(CrmRole crmRole) {
		this.crmRole = crmRole;
	}

	
}
