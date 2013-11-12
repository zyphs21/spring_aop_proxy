package org.hanson.action;

import java.util.List;

import org.hanson.model.User;
import org.hanson.service.IUserService;
import org.springframework.stereotype.Component;

@Component("userAction")
public class UserAction
{
	private User user;
	private IUserService userService;
	private int id;
	private List<String> names;
	
	
	public List<String> getNames()
	{
		return names;
	}
	public void setNames(List<String> names)
	{
		this.names = names;
	}
	public UserAction(IUserService userService)
	{
		super();
		this.userService = userService;
	}
	public IUserService getUserService()
	{
		return userService;
	}
	public void setUserService(IUserService userService)
	{
		this.userService = userService;
	}
	
	
	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	
	public void add()
	{
		userService.add(user);
	}
	public void delete()
	{
		userService.delete(id);
	}
	public void load()
	{
		userService.load(id);
	}
}
