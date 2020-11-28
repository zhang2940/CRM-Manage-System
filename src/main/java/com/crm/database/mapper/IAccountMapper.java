package com.crm.database.mapper;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.crm.database.data.CrmAccount;

/**
 * @classComment 帐号数据访问接口
 * @author yangyongtao
 * @createTime 2020-11-25 上午11:12:58
 * @updateTime 2020-11-25 上午11:12:58
 * @version 1.0.0.0
 */
public interface IAccountMapper {

	/**
	 * desc: 登录验证时，获得帐号数据对象
	 * @param account
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@Results(id="accountResults", value = {
		@Result(property = "accountId", column = "account_id", id = true), 
		@Result(property = "accountName", column = "account_name"), 
		@Result(property = "accountPassword", column = "account_password"), 
		@Result(property = "accountGender", column = "account_gender"), 
		@Result(property = "operTime", column = "oper_time"),
		@Result(property = "crmRole", column = "role_id", one = @One(
				resultMap = "com.crm.database.mapper.IRoleMapper.roleResults"))
	})
	@Select("select account_id,account_name,account_password,account_gender,a.oper_time,a.role_id,role_name"
			+ " from crm_account a join crm_role r on a.role_id=r.role_id"
			+ " where account_name=#{account} and account_password=#{password}")
	public CrmAccount getAccountByLogin(@Param("account") String account,
			@Param("password") String password) throws Exception;
	
}
