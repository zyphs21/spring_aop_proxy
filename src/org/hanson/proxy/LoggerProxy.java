package org.hanson.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.hanson.model.LogInfo;

/*
 * 1.写一个类实现InvocationHandler接口
 */
//要使用动态代理，需实现这个InvocationHandler接口还有用到同样是reflect包下的Proxy这个类
public class LoggerProxy implements InvocationHandler
{
	private LoggerProxy()//私有的构造方法
	{
	}
	//2.创建一个代理对象
	private Object target;
	//3.创建一个方法来生成对象,这个方法的参数是要代理的对象，getInstacne所返回的对象就是代理的对象
	public static Object getInstance(Object o)
	{
		//3.1，创建LoggerProxy对象
		LoggerProxy proxy = new LoggerProxy();
		//3.2，设置这个代理对象
		proxy.target = o;
		//3.3，通过Proxy的方法创建代理对象，第一个参数是要代理对象的的classLoader方法
		//     第二个参数是要代理对象所有实现的接口，第三个参数是实现了InvocationHandler的对象
		//此时的result就是一个代理对象，代理的就是o
		Object result = Proxy.newProxyInstance(o.getClass().getClassLoader(), 
				o.getClass().getInterfaces(), proxy);
		return result;
	}
	/**
	 * 当有了代理对象后，不管这个代理对象执行什么方法，都会调用一下的invoke方法
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable
	{
		//这里可以控制在执行哪些方法的时候调用Logger.info方法，即输出日志信息
		/*
		if(method.getName().equals("add")||method.getName().equals("delete"))
		{
			Logger.info("进行了相应的操作");
		}
		*/
		//给接口的方法加上自定义的annotation：LogInfo，然后这里就可以过滤含有该annotation的方法
		//输出日志信息
		if(method.isAnnotationPresent(LogInfo.class))
		{
			LogInfo li = method.getAnnotation(LogInfo.class);
			Logger.info(li.value());
		}
		
		Object obj = method.invoke(target,args);
		return obj;
	}

}
