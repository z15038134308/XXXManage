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
import com.lanou.service.AdminServiceImpl;
import com.lanou.service.IAdminService;
import com.lanou.util.JSONbean;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IAdminService idService = new AdminServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		
		if(op.equals("add")) {
			String adminname = req.getParameter("adminname");
			String pwd = req.getParameter("pwd");
			try {
				idService.addAdmin(adminname, pwd);
				PrintWriter pw = resp.getWriter();
				JSONbean jb = new JSONbean("200", "", null, null);
				String jsonStr = JSON.toJSONString(jb);
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("edit")) {
			String id = req.getParameter("id");
			String adminname = req.getParameter("adminname");
			String pwd = req.getParameter("pwd");
			try {
				idService.editAdmin(id, adminname, pwd);
				PrintWriter pw = resp.getWriter();
				JSONbean jb = new JSONbean("200", "", null, null);
				String jsonStr = JSON.toJSONString(jb);
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		
		if(op==null || op.equals("")) {
			String pagenum = req.getParameter("page");
			String pagecount = req.getParameter("limit");
			try {
				List<Admin> adminlist = idService.getByPage(Integer.parseInt(pagenum), Integer.parseInt(pagecount));
				resp.setContentType("text/html;charset=utf-8");
				
				PrintWriter pw = resp.getWriter();
				String msg = "";
				JSONbean jb = new JSONbean("0", msg, idService.getCount(), adminlist);
				String jsonStr = JSON.toJSONString(jb);
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("del")) {
				String id = req.getParameter("id");
				try {
					idService.delById(id);
					
					PrintWriter pw = resp.getWriter();
					JSONbean jb = new JSONbean("200", "", null, null);
					String jsonStr = JSON.toJSONString(jb);
					pw.write(jsonStr);
					pw.flush();
					pw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
}
