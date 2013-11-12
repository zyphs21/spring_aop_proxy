package org.hanson.model;

public class User
{
	private int id;
	private String username;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	//建立构造函数，一个带参数，一个不带参数
	public User()
	{
		
	}
	public User(int id, String username)
	{
		super();
		this.id = id;
		this.username = username;
	}
	
	//generate toString，这样就可以直接使用类名来打印输出
	@Override
	public String toString()
	{
		return "User [id=" + id + ", username=" + username + "]";
	}
	
	
}
