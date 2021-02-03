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
import com.lanou.bean.Type;
import com.lanou.service.ITypeService;
import com.lanou.service.TypeServiceImpl;
import com.lanou.util.JSONbean;

@WebServlet("/dataServlet")
public class DataServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ITypeService itService=new TypeServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		if(op.equals("first")) {
			try {
				List<Type> firstlist = itService.getFirstList();
				String jsonStr=JSON.toJSONString(firstlist);
				
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw=resp.getWriter();
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("second")) {
			String parentid = req.getParameter("parentid");
			try {
				List<Type> twolist=itService.getSecondList(parentid);
				String jsonStr=JSON.toJSONString(twolist);
				
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw=resp.getWriter();
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("third")) {
			String parentid = req.getParameter("parentid");
			try {
				List<Type> threelist=itService.getThirdList(parentid);
				String jsonStr=JSON.toJSONString(threelist);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw=resp.getWriter();
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
