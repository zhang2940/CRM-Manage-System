package com.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.crm.database.data.CrmAccount;
import com.crm.database.data.CrmRole;
import com.crm.database.mapper.IRoleMapper;
import com.crm.database.mapper.IUserMapper;
import com.crm.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/** 
 * @classComment 用户管理业务实现类
 * @author yangyongtao
 * @createTime 2020-11-26 上午10:39:51
 * @updateTime 2020-11-26 上午10:39:51
 * @version 1.0.0.0
 */
@Service
public class UserServiceImpl implements IUserService {

	//注入数据访问映射接口对象
	@Resource
	private IUserMapper iuserMapper;
	@Resource
	private IRoleMapper iroleMapper;
	@Override
	public String query(Model model, String accountName, Integer pageNum) throws Exception {
		        //判断是否获得页码
				pageNum = pageNum==null ? 1 : pageNum;
				//启用分页
				PageHelper.startPage(pageNum, 10);
				//查询角色数据
				List<CrmAccount> list = iuserMapper.queryAll(accountName);
				//获得分页相关信息
				PageInfo<CrmAccount> pageInfo = new PageInfo<CrmAccount>(list, 10);
				//封装模型数据
				model.addAttribute("list", list);
				model.addAttribute("pageInfo", pageInfo);
				return "pages/user/userlist";
	}
	
	@Override
	public String addView(Model model) {
		try {
			List<CrmRole> roles = iroleMapper.queryAll(null);
			model.addAttribute("roles", roles);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "pages/user/useradd";
	}

	@Override
	public String addUser(Model model,CrmAccount account) throws Exception {
		iuserMapper.addUser(account);
		return query(model, null, 1); 
	}

	@Override
	public String delete(Model model, String userName, Integer pageNum, Integer... ids) throws Exception {
		iuserMapper.delete(ids);
		return query(model, userName, pageNum);
	}

	@Override
	public String updateView(Model model, Integer id) throws Exception {
		CrmAccount account = iuserMapper.findById(id);
		List<CrmRole> roles = iroleMapper.queryAll(null);
		model.addAttribute("roles", roles);
		model.addAttribute("account", account);
		return "pages/user/userupdate";
	}

	@Override
	public String update(Model model, CrmAccount account) throws Exception {
		iuserMapper.update(account);
		return query(model, null, 1);
	}

}

