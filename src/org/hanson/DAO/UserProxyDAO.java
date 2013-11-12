package org.hanson.DAO;

import javax.annotation.Resource;

import org.hanson.model.User;
import org.hanson.proxy.Logger;
import org.springframework.stereotype.Component;

@Component("userProxyDao")
public class UserProxyDAO implements IUserDAO
{
	private IUserDAO userDAO;
	
	
	public IUserDAO getUserDAO()
	{
		return userDAO;
	}
	
	@Resource
	public void setUserDAO(IUserDAO userDao)
	{
		this.userDAO = userDao;
	}

	@Override
	public void add(User user)
	{
		Logger.info("添加了用户");
		userDAO.add(user);
	}

	@Override
	public void delete(int id)
	{
		Logger.info("删除了用户");
		userDAO.delete(id);
	}

	@Override
	public User load(int id)
	{
		return userDAO.load(id);
	}

}
