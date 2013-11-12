package org.hanson.test;

import static org.junit.Assert.*;

import org.hanson.action.UserAction;
import org.hanson.model.Helloword;
import org.hanson.model.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring
{
	//����spring�Ĺ���
	private BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
	
	@Test
	public void testHello()
	{
		/*ͨ���������hello����
		*/
		//�˴���getBean�����helloword����beans.xml�е�id
		/*
		 * Helloword hello = (Helloword) factory.getBean("helloword");*/
		
		//����һ�ַ���
		Helloword hello = factory.getBean("helloword",Helloword.class);
		//��ʱ��hello������Ǳ�spring������Ķ���
		System.out.println(hello.hello());
		
		Helloword hello2 = factory.getBean("helloword",Helloword.class);
	
		/* �����beans��û��scope���ã�Ĭ����singleton������������������Ľ��Ϊtrue
		 * ����beans�е�scope����Ϊprototypeʱ�򣬾��Ƕ�����������Ľ��Ϊfalse
		*/
		System.out.println(hello2==hello);
	}
	
	@Test
	public void testUser1()
	{
		UserAction ua = factory.getBean("userAction",UserAction.class);
		
		User u = new User(1,"��ɭ");
		ua.setUser(u);
		ua.add();
		
		UserAction ua2 = factory.getBean("userAction",UserAction.class);
		ua2.add();
	}
}
