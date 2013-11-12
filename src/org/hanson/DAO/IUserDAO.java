package org.hanson.DAO;

import org.hanson.model.LogInfo;
import org.hanson.model.User;

public interface IUserDAO
{
	@LogInfo("添加用户信息")
	public void add(User user);
	
	@LogInfo("删除用户信息")
	public void delete(int id);
	
	public User load(int id);	
}
