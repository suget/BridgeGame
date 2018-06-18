package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.IUsersBiz;
import biz.impl.UsersBizImpl;
import entity.Users;

@SuppressWarnings("serial")
public class LogoutUserServlet extends HttpServlet {
	
	// 注入业务逻辑层
	IUsersBiz uBiz = new UsersBizImpl();

	/**
	 * Constructor of the object.
	 */
	public LogoutUserServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); 
		System.out.println("src.servlet.LogoutUserServlet被销毁！");
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("执行src.servlet.LogoutUserServlet的doGet()方法");
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("执行src.servlet.LogoutUserServlet的doPost方法！");
		
		// 获取request的会话对象
		HttpSession session = request.getSession();
		Users u = (Users)session.getAttribute("nowUser");
		
		if(uBiz.userLogoutByName(u.getName())) { // 注销成功
			response.sendRedirect("../Bridge");
		} else if(u.getIndentity() == 0){		// 用户是管理员
			response.sendRedirect("jsp/admin/main.jsp");
		} else {		// 用户是普通用户
			response.sendRedirect("jsp/user/main.jsp");
		}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		System.out.println("执行servlet.LogoutUserServlet的init()方法");
	}

}
