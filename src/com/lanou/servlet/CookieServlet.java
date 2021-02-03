package com.lanou.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.lanou.bean.User;

@WebServlet("/user/cookie")
public class CookieServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = "";
		String pwd = "";
		Cookie[] cs = req.getCookies();
		if(cs==null||cs.equals("")) {
			
		}
		else {
			for(Cookie c:cs){
				String key = c.getName();
				if(key.equals("name")){
					name = c.getValue();
				}if(key.equals("pwd")){
					pwd = c.getValue();
				}
			}
		}
		
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		String jsonStr = JSON.toJSONString(user);
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		pw.write(jsonStr);
		pw.flush();
		pw.close();
			
	}
	
}
