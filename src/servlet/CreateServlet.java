package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostsDAO;


@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String createTitle = request.getParameter("createTitle");
		String createContent = request.getParameter("createContent");

		PostsDAO dao = new PostsDAO();
		dao.createPost(createTitle, createContent);

		RequestDispatcher dispatcher = request.getRequestDispatcher( "/WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);
	}

}
