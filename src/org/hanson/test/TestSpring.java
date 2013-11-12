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
	//创建spring的工厂
	private BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
	
	@Test
	public void testHello()
	{
		/*通过工厂获得hello对象
		*/
		//此处的getBean里面的helloword就是beans.xml中的id
		/*
		 * Helloword hello = (Helloword) factory.getBean("helloword");*/
		
		//另外一种方法
		Helloword hello = factory.getBean("helloword",Helloword.class);
		//此时的hello对象就是被spring所管理的对象
		System.out.println(hello.hello());
		
		Helloword hello2 = factory.getBean("helloword",Helloword.class);
	
		/* 如果在beans中没有scope配置，默认是singleton，即单例，所以下面的结果为true
		 * 当把beans中的scope设置为prototype时候，就是多例，则下面的结果为false
		*/
		System.out.println(hello2==hello);
	}
	
	@Test
	public void testUser1()
	{
		UserAction ua = factory.getBean("userAction",UserAction.class);
		
		User u = new User(1,"汉森");
		ua.setUser(u);
		ua.add();
		
		UserAction ua2 = factory.getBean("userAction",UserAction.class);
		ua2.add();
	}
}
