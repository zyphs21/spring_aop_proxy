package org.hanson.service;

import javax.annotation.Resource;

import org.hanson.DAO.IUserDAO;
import org.hanson.model.User;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserService implements IUserService
{
	private IUserDAO userDAO;
	/*为需要用到的泪userDao创建getter和setter方法*/
	public IUserDAO getUserDAO()
	{
		return userDAO;
	}
	
	@Resource(name="userDynamicProxyDao")
	public void setUserDAO(IUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}

	@Override
	public void add(User user)
	{
		userDAO.add(user);
	}

	@Override
	public void delete(int id)
	{
		userDAO.delete(id);
	}

	@Override
	public User load(int id)
	{
		return userDAO.load(id);
	}

}
