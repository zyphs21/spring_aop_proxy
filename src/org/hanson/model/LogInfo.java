package org.hanson.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) //�����Retentionʹ����Զ���annotation������ʱ���Է���
public @interface LogInfo
{
	public String value() default"";//������Ĭ��ֵΪ��
}
