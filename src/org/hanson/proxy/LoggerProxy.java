package org.hanson.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.hanson.model.LogInfo;

/*
 * 1.дһ����ʵ��InvocationHandler�ӿ�
 */
//Ҫʹ�ö�̬������ʵ�����InvocationHandler�ӿڻ����õ�ͬ����reflect���µ�Proxy�����
public class LoggerProxy implements InvocationHandler
{
	private LoggerProxy()//˽�еĹ��췽��
	{
	}
	//2.����һ���������
	private Object target;
	//3.����һ�����������ɶ���,��������Ĳ�����Ҫ����Ķ���getInstacne�����صĶ�����Ǵ���Ķ���
	public static Object getInstance(Object o)
	{
		//3.1������LoggerProxy����
		LoggerProxy proxy = new LoggerProxy();
		//3.2����������������
		proxy.target = o;
		//3.3��ͨ��Proxy�ķ�������������󣬵�һ��������Ҫ�������ĵ�classLoader����
		//     �ڶ���������Ҫ�����������ʵ�ֵĽӿڣ�������������ʵ����InvocationHandler�Ķ���
		//��ʱ��result����һ��������󣬴���ľ���o
		Object result = Proxy.newProxyInstance(o.getClass().getClassLoader(), 
				o.getClass().getInterfaces(), proxy);
		return result;
	}
	/**
	 * �����˴������󣬲�������������ִ��ʲô�������������һ�µ�invoke����
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable
	{
		//������Կ�����ִ����Щ������ʱ�����Logger.info�������������־��Ϣ
		/*
		if(method.getName().equals("add")||method.getName().equals("delete"))
		{
			Logger.info("��������Ӧ�Ĳ���");
		}
		*/
		//���ӿڵķ��������Զ����annotation��LogInfo��Ȼ������Ϳ��Թ��˺��и�annotation�ķ���
		//�����־��Ϣ
		if(method.isAnnotationPresent(LogInfo.class))
		{
			LogInfo li = method.getAnnotation(LogInfo.class);
			Logger.info(li.value());
		}
		
		Object obj = method.invoke(target,args);
		return obj;
	}

}
