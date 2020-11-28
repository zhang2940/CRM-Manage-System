package com.crm.database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.crm.database.data.CrmAccount;

/**
 * @classComment 用户数据访问接口
 * @author yangyongtao
 * @createTime 2020-11-26 上午10:04:09
 * @updateTime 2020-11-26 上午10:04:09
 * @version 1.0.0.0
 */
public interface IUserMapper {

	/**
	 * 查询所有用户数据
	 * @param accountName
	 * @return
	 * @throws Exception
	 */
	@Results(id = "userResults", value = { @Result(property = "accountId", column = "account_id", id = true),
			@Result(property = "accountName", column = "account_name"),
			@Result(property = "accountPassword", column = "account_password"),
			@Result(property = "accountGender", column = "account_gender"),
			@Result(property = "operTime", column = "oper_time"),
			@Result(property = "crmRole", column = "role_id", one = @One(resultMap = "com.crm.database.mapper.IRoleMapper.roleResults")) })
	@Select("<script>"
			+ 	"select account_id,account_name,account_password,account_gender,a.oper_time,a.role_id,role_name"
			+     " from crm_account a join crm_role r on a.role_id=r.role_id"
			+ 		"<where>"
			+ 			"<if test=\"accountName != null and accountName != ''\">"
			+				" account_name like '%${accountName}%'"
			+ 			"</if>"
			+ 		"</where>"
			+ 	" order by oper_time desc"
			+ "</script>")
	public List<CrmAccount> queryAll(@Param("accountName") String accountName) throws Exception;

	/**
	 * 添加用户
	 * @param account
	 */
	@Insert("insert into crm_account(role_id,account_name,account_password,account_gender) values(#{crmRole.roleId}, #{accountName}, #{accountPassword}, #{accountGender})")
	public void addUser(CrmAccount account);

	/**
	 * 删除用户数据
	 * @param ids
	 * @throws Exception
	 */
	@Delete("<script>"
		+ 	"delete from crm_account where account_id in"
		+	"<foreach item=\"id\" collection=\"array\""
		+   	" open=\"(\" separator=\",\" close=\")\">"
		+       "#{id}"
		+   "</foreach>"
		+ "</script>")
	public void delete(Integer... ids);

	/**
	 * 根据ID获取用户对象
	 * @param id
	 * @return
	 */
	@ResultMap("userResults")
	@Select("select account_id,account_name,account_password,account_gender,a.oper_time,a.role_id from crm_account a where account_id = #{id}")
	public CrmAccount findById(Integer id);

	/**
	 * 修改用户
	 * @param account
	 */
	@Update("update crm_account set account_name=#{accountName},account_password=#{accountPassword},"
			+ "account_gender=#{accountGender},role_id=#{crmRole.roleId} where account_id=#{accountId}")
	public void update(CrmAccount account);

}
