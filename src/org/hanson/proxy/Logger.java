package org.hanson.proxy;

import java.util.Date;

public class Logger
{
	//��̬������ֱ�����������ɵ��ø÷���
	public static void info(String info)
	{
		System.out.println(new Date() + "------>>" + info);
	}
}
