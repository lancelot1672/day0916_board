package model;

import java.util.HashMap;
import java.util.Map;

// 얘는 DAO가 못하는 비즈니스 로직등의 처리를 맡는 클래스.
// http 웹 요청에는 관여하지 않음. 웹은 Servlet 쪽에서 알아서 하라고 합시다.
public class BoardService {
	private static final int COUNT_PER_PAGE = 5;
	private BoardDao dao = new BoardDao();
	
	public Map<String, Object> makePage(int page){
		Map<String, Object> pageMap = new HashMap<>();
		
		pageMap.put("currPage", page);
		
		int totalCount = dao.selectTotalCount();
		int totalPage = totalCount / COUNT_PER_PAGE;		// ex 12개의 게시글 / 5 => 2
		if(totalCount % COUNT_PER_PAGE > 0) {				// ex 12개의 게시글 / 5 = > 2 인데 나머지 2개의 게시글 페이지 + 1 = 3
			totalPage ++;
		}
		
		int startPage = (page - 1) / 10 * 10 + 1;	// 1~10은 시작페이지 1, 11~20은 시작페이지 11
		int endPage = startPage + 9;	// 화면하단 끝 페이지는 시작페이지 + 9
		if(endPage > totalPage) {	// 혹시 총 게시글 자체가 적은 경우 끝 페이지 붙이기
			endPage = totalPage;
		}
		
		pageMap.put("totalPage", totalPage);
		pageMap.put("startPage", startPage);
		pageMap.put("endPage", endPage);
		
		int startRow = (page -1) * COUNT_PER_PAGE;		// 페이지 1이면 -> 0 ~ 5까지, 2이면 5~10
		
		pageMap.put("boardList", dao.selectList(startRow, COUNT_PER_PAGE));
		
		return pageMap;
	}
	public boolean write(BoardDTO board) {
		if(dao.insert(board) == 1) {
			return true;
		}else {
			return false;
			
		
		}
	}
	public BoardDTO selectOne(int bno) {
		return dao.selectOne(bno);
	}
}
