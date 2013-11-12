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
	
	//�������캯����һ����������һ����������
	public User()
	{
		
	}
	public User(int id, String username)
	{
		super();
		this.id = id;
		this.username = username;
	}
	
	//generate toString�������Ϳ���ֱ��ʹ����������ӡ���
	@Override
	public String toString()
	{
		return "User [id=" + id + ", username=" + username + "]";
	}
	
	
}
