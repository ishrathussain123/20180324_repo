package com.curd.app.utils;
import java.util.List;

public class CommonUtils {


	public static boolean isNotNullAndEmpty(List list)
	{
		boolean isNotNullAndEmpty = false;
		if(list != null && list.size() > 0)
		{
			isNotNullAndEmpty = true;
		}
		return isNotNullAndEmpty;
	}

	public static boolean isNotNull(Object obj)
	{
		boolean isNotNull = false;
		if(obj != null)
		{
			isNotNull = true;
		}
		return isNotNull;
	}
	public static boolean isNotNullAndEmpty(String str)
	{
		boolean isNotNullAndEmpty = false;
		if(str != null && !str.equalsIgnoreCase(""))
		{
			isNotNullAndEmpty = true;
		}
		return isNotNullAndEmpty;
	}
}