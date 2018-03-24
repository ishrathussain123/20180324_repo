 package com.online.hub.commonUtils;

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