package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Post;
import service.PostsService;

@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		int id = Integer.parseInt(request.getParameter("id"));
//		String title = null;
//		String content = null;
//
//		PostsDAO dao = new PostsDAO();
//		List<Post> pl = dao.displayPosts();
//
//		for(Post post: pl) {
//			int postId = post.getId();
//			if(postId == id) {
//				title = post.getTitle();
//				content = post.getContent();
//			}
//		}
//
//		Post showPost = new Post();
//		showPost.setId(id);
//		showPost.setTitle(title);
//		showPost.setContent(content);

		int id = Integer.parseInt(request.getParameter("id"));
		
		PostsService ps = new PostsService();
		Post p = ps.showPost(id);

		HttpSession session = request.getSession();
		session.setAttribute("showPost", p);

		RequestDispatcher dispatcher = request.getRequestDispatcher( "/WEB-INF/jsp/show.jsp");
		dispatcher.forward(request, response);
	}

}
