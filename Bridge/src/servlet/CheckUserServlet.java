package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Users;
import biz.IUsersBiz;
import biz.impl.UsersBizImpl;

@SuppressWarnings("serial")
public class CheckUserServlet extends HttpServlet {

	// 注入业务逻辑层
	IUsersBiz uBiz = new UsersBizImpl();

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); 
		System.out.println("src.servlet.CheckUserServlet被销毁！");
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

		System.out.println("执行src.servlet.CheckUserServlet的doGet()方法");
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
		System.out.println("执行src.servlet.CheckUserServlet的doPost方法！");

		String name = request.getParameter("user_name");
		String pwd = request.getParameter("user_pwd");
		Users u = uBiz.selectUserByName(name);      // 通过name获取用户的详细信息

		// 获取request的会话对象
		HttpSession session = request.getSession();
		String errorInformation = "";
		
		if(u == null) {		// 用户名不存在
			errorInformation = "用户名不存在！";
			session.setAttribute("errInf", errorInformation);
			response.sendRedirect("jsp/error/errorInf.jsp");
		} else if(!pwd.equals(u.getPassword())) {	// 密码错误！
			System.out.println(pwd + ", " + u.getPassword());
			errorInformation = "密码错误！";
			session.setAttribute("errInf", errorInformation);
			response.sendRedirect("jsp/error/errorInf.jsp");
		} else {
			session.setAttribute("nowUser", u);
			uBiz.userLoginByName(name);		// 执行用户登录操作
			
			if(u.getIndentity() == 0)	// 用户是管理员
				response.sendRedirect("jsp/admin/main.jsp");         // 跳转到管理员操作界面
			else
				response.sendRedirect("jsp/user/main.jsp");         // 跳转到普通用户操作界面
		}

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		System.out.println("执行servlet.CheckUserServlet的init()方法");
	}

}
