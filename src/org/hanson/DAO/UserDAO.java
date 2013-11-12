package org.hanson.DAO;

import org.hanson.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//相当于完成了<bean id="userDao" calss="xxx"></bean>
//@Component("userDao") //公共创建bean的annotation
@Repository("userDao")  //Repository一般用于dao的注入，用于区分
public class UserDAO implements IUserDAO
{

	@Override
	public void add(User user)
	{
		System.out.println("添加 了"+user);
		
	}

	@Override
	public void delete(int id)
	{
		System.out.println("delete"+id);
		
	}

	@Override
	public User load(int id)
	{
		System.out.println("load"+id);
		return null;
	}

}
