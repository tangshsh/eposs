package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.Dao;
import entity.YdManager;
import entity.YdUse;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, 
					IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		System.out.println("action:"+action);
		if("/login".equals(action)){
			String name = request.getParameter("username");
			String pwd = request.getParameter("password");
			System.out.println(name+" "+pwd);
			Dao dao = new Dao();
			YdUse user = dao.FindUser(name);
			YdManager manager = dao.FindManager(name);
			ObjectMapper om = new ObjectMapper(); 
			PrintWriter out = response.getWriter();
			if(name==""||pwd==""){
				return;
			}
			
			if(user==null&&manager==null){
           		String json = om.writeValueAsString("没有个用户名或桌号");
           		out.println(json);
           		
           		return;
           			
			}else if(user==null&&manager!=null&&!manager.getPsd().equals(pwd)){
				System.out.println("用户名密码错误");
				String json = om.writeValueAsString("用户名密码错误");
				out.println(json);
				return;
			}
			else if(manager==null&&user!=null&&!user.getPsd().equals(pwd)){
				String json = om.writeValueAsString("桌号密码错误");
				out.println(json);
				return;
			}else if(manager==null&&user!=null&&user.getPsd().equals(pwd)){
				System.out.println("桌号登陆成功");
				HttpSession session = request.getSession();
				session.setAttribute("user",user );
				String json = om.writeValueAsString("桌号登陆成功");
				out.println(json);
				System.out.println("桌号登陆成功结束");
				return;
			}
			else if(user==null&&manager!=null&&manager.getPsd().equals(pwd)){
				HttpSession session = request.getSession();
				session.setAttribute("manager",manager);
				String json = om.writeValueAsString("用户登陆成功");
				out.println(json);
				return;
			}
			
		}
	
	}

}
