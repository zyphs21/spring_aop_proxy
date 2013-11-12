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
		Logger.info("������û�");
		userDAO.add(user);
	}

	@Override
	public void delete(int id)
	{
		Logger.info("ɾ�����û�");
		userDAO.delete(id);
	}

	@Override
	public User load(int id)
	{
		return userDAO.load(id);
	}

}
