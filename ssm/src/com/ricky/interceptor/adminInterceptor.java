package com.ricky.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.http.HttpRequest;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import php.java.bridge.http.HttpResponse;

public class adminInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=request.getSession();
		Object admin=session.getAttribute("admin");
		System.out.println(admin);
		if(admin==null){
			request.setAttribute("login", "login");
			response.sendRedirect("login.jsp");
			return null;
		}else{
			invocation.invoke();
		}
		return null;
	}

}
