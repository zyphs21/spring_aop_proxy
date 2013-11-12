package org.hanson.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) //加这个Retention使这个自定的annotation在运行时可以访问
public @interface LogInfo
{
	public String value() default"";//让它的默认值为空
}
