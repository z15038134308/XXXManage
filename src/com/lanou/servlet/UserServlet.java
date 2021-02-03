package com.lanou.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.lanou.bean.User;
import com.lanou.dao.IUserDao;
import com.lanou.dao.UserDaoImpl;
import com.lanou.service.IUserService;
import com.lanou.service.UserServiceImpl;
import com.lanou.util.JSONbean;

@WebServlet("/user/user")
public class UserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	IUserService iuService =  new UserServiceImpl();
	IUserDao iuDao = new UserDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String op = req.getParameter("op");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String phone = req.getParameter("phone");
		String mail = req.getParameter("mail");
		String address = req.getParameter("address");
		if(op.equals("add")) {
			try {
				iuService.addUser(name, pwd, phone, mail, address);
				JSONbean jb = new JSONbean("200", "", null, null);
				String jsonStr = JSON.toJSONString(jb);
				PrintWriter pw = resp.getWriter();
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("edit")){
			try {
				iuService.editUser(id, name, pwd, phone, mail, address);
				JSONbean jb = new JSONbean("200", "", null, null);
				String jsonStr = JSON.toJSONString(jb);
				PrintWriter pw = resp.getWriter();
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("query")) {
			try {		
				
				
				User user = iuService.UserLogin(name, pwd);
				PrintWriter pw = resp.getWriter();
				int userid=user.getId();
				if(user==null||user.equals("")) {
					pw.write("fail");
				}else {		
					
						Cookie cname = new Cookie("name",name);
						Cookie cpwd = new Cookie("pwd",pwd);
						Cookie cuserid = new Cookie("userid",userid+"");
						cname.setMaxAge(60*60*24);
						cpwd.setMaxAge(60*60*24);
						cuserid.setMaxAge(60*60*24);
						resp.addCookie(cname);
						resp.addCookie(cpwd);	
						resp.addCookie(cuserid);	
					pw.write("success");
				}
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("register")) {
			try {
				iuService.addUser(name, pwd, phone, mail, address);
				PrintWriter pw = resp.getWriter();
				pw.write("success");
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
				List<User> userlist = iuService.getByPage(Integer.parseInt(pagenum), Integer.parseInt(pagecount));
				resp.setContentType("text/html;charset=utf-8");
				
				PrintWriter pw = resp.getWriter();
				String msg = "";
				JSONbean jb = new JSONbean("0", msg, iuService.getCount(), userlist);
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
				iuService.delUser(id);
				
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
