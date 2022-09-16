package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDTO;
import model.BoardService;

@WebServlet("/board")
public class BoardServlet extends HttpServlet{
	private BoardService service = new BoardService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if("list".equals(action)) {
			String pageStr = request.getParameter("page");
			int page = 1;	// 기본 1페이지
			if(pageStr != null && pageStr.length() > 0) {		// 페이지 요청 왔으면 해당 페이지
				page = Integer.parseInt(pageStr);
				
			}
			request.setAttribute("boardPage", service.makePage(page));
			request.getRequestDispatcher("BoardList.jsp").forward(request, response);
			
		}else if("write".equals(action)) {
			request.getRequestDispatcher("BoardWrite.jsp").forward(request, response);
		}else if("search".equals(action)) {
			int bno = Integer.parseInt(request.getParameter("bno"));
			request.setAttribute("board", service.selectOne(bno));
			request.getRequestDispatcher("BoardSearch.jsp").forward(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		
		if("write".equals(action)) {
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			BoardDTO board = new BoardDTO(title, writer, content);
			if(service.write(board)) {
				request.getRequestDispatcher("BoardWriteSuccess.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("BoardWriteError.jsp").forward(request, response);
			}
		}
	}
}
