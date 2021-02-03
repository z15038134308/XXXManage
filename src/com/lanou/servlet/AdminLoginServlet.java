package com.lanou.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.lanou.bean.Admin;
import com.lanou.dao.AdminDaoImpl;
import com.lanou.dao.IAdminDao;
import com.lanou.service.AdminServiceImpl;
import com.lanou.service.IAdminService;
import com.lanou.util.JSONbean;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IAdminService idService = new AdminServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String adminname = req.getParameter("adminname");
		String pwd = req.getParameter("pwd");
		
		try {
			Admin admin = idService.AdminLogin(adminname, pwd);
	
			req.getSession().setAttribute("admin", admin);
			resp.setContentType("text/html;charset=UTF-8");
			
			PrintWriter pw = resp.getWriter();
			String msg = "success";
			JSONbean jb = new JSONbean("0", msg, null, null);
			String jsonStr = JSON.toJSONString(jb);
			pw.write(jsonStr);
			pw.flush();
			pw.close();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
