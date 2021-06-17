package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Post;
import service.PostsService;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String editTitle = request.getParameter("editTitle");
		String editContent = request.getParameter("editContent");

		PostsService ps = new PostsService();
		try {
			ps.updatePost(id, editTitle, editContent);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		Post showPost = new Post(id, editTitle, editContent);
		
//		Post showPost = new Post();
//		showPost.setId(id);
//		showPost.setTitle(editTitle);
//		showPost.setContent(editContent);

		HttpSession session = request.getSession();
		session.setAttribute("showPost", showPost);

		RequestDispatcher dispatcher = request.getRequestDispatcher( "/WEB-INF/jsp/show.jsp");
		dispatcher.forward(request, response);
	}

}
