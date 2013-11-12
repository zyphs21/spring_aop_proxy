package org.hanson.proxy;

import java.util.Date;

public class Logger
{
	//静态方法，直接用类名即可调用该方法
	public static void info(String info)
	{
		System.out.println(new Date() + "------>>" + info);
	}
}
