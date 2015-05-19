package com.neo.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
	public static boolean isEmpty(HttpSession session, String key) {
		Object object = session.getAttribute(key);
		System.out.println("[SessionUtils::isEmpty] " + (String)object);
		System.out.println("[SessionUtils::isEmpty] " + key);
		if(object == null) {
			return true;
		}
			
		return false;
	}
	
	public static String getStringValue(HttpSession session, String key) {
		
		if(isEmpty(session, key)){
			return null;
		}
		
		
		return (String)session.getAttribute(key);
	}
}
