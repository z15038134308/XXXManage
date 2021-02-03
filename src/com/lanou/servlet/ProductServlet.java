package com.lanou.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.alibaba.fastjson.JSON;
import com.lanou.bean.Product;
import com.lanou.bean.Type;
import com.lanou.service.IProductService;
import com.lanou.service.ITypeService;
import com.lanou.service.ProductServiceImpl;
import com.lanou.service.TypeServiceImpl;
import com.lanou.util.JSONbean;

public class ProductServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IProductService ipService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		if(op==null || op.equals("")) {
			String pagenum = req.getParameter("page");
			String pagecount = req.getParameter("limit");
			
			try {
				List<Product> prolist = ipService.getByPage(Integer.parseInt(pagenum), Integer.parseInt(pagecount));
				resp.setContentType("text/html;charset=utf-8");
				
				String msg = "";
				PrintWriter pw = resp.getWriter();
				
				JSONbean jb = new JSONbean("0", msg, ipService.getCount(), prolist);
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
				ipService.delProduct(id);
				
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		String pname = req.getParameter("pname");
		String price = req.getParameter("price");
		String ptitle = req.getParameter("ptitle");
		String pv = req.getParameter("pv");
		String typeid = req.getParameter("typeid");
		String pimgs = req.getParameter("pimgs");
		
		if(op.equals("add") ) {
			try {
				ipService.addProduct(pname, pimgs, price, ptitle, pv, typeid);
				PrintWriter pw = resp.getWriter();
				JSONbean jb = new JSONbean("200", "", null, null);
				String jsonStr = JSON.toJSONString(jb);
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("edit")){
			String id = req.getParameter("id");		
			try {
				ipService.editProduct(id, pname, pimgs, price, ptitle, pv, typeid);
				PrintWriter pw = resp.getWriter();
				JSONbean jb = new JSONbean("200", "", null, null);
				String jsonStr = JSON.toJSONString(jb);
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("viewall")) {
			try {
				List<Product> prolist = ipService.getAll();
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw = resp.getWriter();
				JSONbean jb = new JSONbean("200", "", null, prolist);
				String jsonStr = JSON.toJSONString(jb);
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("viewsolo")) {
			String id = req.getParameter("parentid");
			try {
				List<Product> prolist = ipService.getAllById(id);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw = resp.getWriter();
				JSONbean jb = new JSONbean("0", "", null, prolist);
				String jsonStr = JSON.toJSONString(jb);
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}else if(op.equals("search")) {
			String proname = req.getParameter("proname");
			try {
				List<Product> prolist = ipService.queryByProname(proname);
				JSONbean jb = new JSONbean("0", "", null, prolist);
				String jsonStr = JSON.toJSONString(jb);
				resp.setContentType("text/html;charset=UTF-8");
				PrintWriter pw = resp.getWriter();
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("detail")) {
			String id = req.getParameter("id");
			try {
				List<Product> prolist = ipService.getAllById(id);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw = resp.getWriter();
				String jsonStr = JSON.toJSONString(prolist);
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
			
	}
}
