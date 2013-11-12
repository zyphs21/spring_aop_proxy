package org.hanson.DAO;

import org.hanson.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//�൱�������<bean id="userDao" calss="xxx"></bean>
//@Component("userDao") //��������bean��annotation
@Repository("userDao")  //Repositoryһ������dao��ע�룬��������
public class UserDAO implements IUserDAO
{

	@Override
	public void add(User user)
	{
		System.out.println("��� ��"+user);
		
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
