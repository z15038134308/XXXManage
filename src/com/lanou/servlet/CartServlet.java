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

import com.alibaba.fastjson.JSON;
import com.lanou.bean.Cart;
import com.lanou.service.CartServiceImpl;
import com.lanou.service.ICartService;
import com.lanou.util.JSONbean;

@WebServlet("/user/cart")
public class CartServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ICartService icService = new CartServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pagenum = req.getParameter("page");
		String pagecount = req.getParameter("limit");
		try {
			List<Cart> cartlist = icService.queryByPage(Integer.parseInt(pagenum), Integer.parseInt(pagecount));
			resp.setContentType("text/html;charset=utf-8");
			JSONbean jb = new JSONbean("0", "", icService.queryCount(), cartlist);
			String jsonStr = JSON.toJSONString(jb);
			PrintWriter pw = resp.getWriter();
			pw.write(jsonStr);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		String id = req.getParameter("id");
		String productid = req.getParameter("productid");
		String userid = "";
		Cookie[] cs = req.getCookies();
		if(cs!=null && cs.length!=0){
			for(Cookie c:cs){
				String key = c.getName();
				if(key.equals("userid")){
					userid = c.getValue();
				}
			}
		}
		
		if(op.equals("del")) {
			try {
				icService.deleteById(Integer.parseInt(id));
				resp.setContentType("text/html;charset=utf-8");
				JSONbean jb = new JSONbean("200", "", null, null);
				String jsonStr = JSON.toJSONString(jb);
				PrintWriter pw = resp.getWriter();
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("chart")) {
			
			try {
				List<Cart> cartlist = icService.queryAll();
				resp.setContentType("text/html;charset=utf-8");
				String jsonStr = JSON.toJSONString(cartlist);
				PrintWriter pw = resp.getWriter();
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("addproduct")) {
			try {
				icService.add(Integer.parseInt(userid), Integer.parseInt(productid));
				String jsonStr = JSON.toJSONString("success");
				PrintWriter pw = resp.getWriter();
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
