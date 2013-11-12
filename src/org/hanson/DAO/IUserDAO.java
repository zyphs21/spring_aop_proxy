package org.hanson.DAO;

import org.hanson.model.LogInfo;
import org.hanson.model.User;

public interface IUserDAO
{
	@LogInfo("����û���Ϣ")
	public void add(User user);
	
	@LogInfo("ɾ���û���Ϣ")
	public void delete(int id);
	
	public User load(int id);	
}
