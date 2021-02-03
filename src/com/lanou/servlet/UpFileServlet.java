package com.lanou.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.alibaba.fastjson.JSON;
import com.lanou.service.IProductService;
import com.lanou.service.ProductServiceImpl;
import com.lanou.util.JSONbean;

public class UpFileServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IProductService ipService = new ProductServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		try {
			Part part = req.getPart("file");
			String filename = part.getSubmittedFileName();
			String path = req.getServletContext().getRealPath("");
			path = path.substring(0, path.lastIndexOf("\\"));
			path = path+File.separator+"img"+File.separator;
			part.write(path+filename);
			resp.setContentType("text/html;charset=UTF-8");
		
			PrintWriter pw = resp.getWriter();
			JSONbean jb = new JSONbean("0", "", null, filename);
			String jsonStr = JSON.toJSONString(jb);
			
			pw.write(jsonStr);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
