package model;

import java.util.HashMap;
import java.util.Map;

// ��� DAO�� ���ϴ� ����Ͻ� �������� ó���� �ô� Ŭ����.
// http �� ��û���� �������� ����. ���� Servlet �ʿ��� �˾Ƽ� �϶�� �սô�.
public class BoardService {
	private static final int COUNT_PER_PAGE = 5;
	private BoardDao dao = new BoardDao();
	
	public Map<String, Object> makePage(int page){
		Map<String, Object> pageMap = new HashMap<>();
		
		pageMap.put("currPage", page);
		
		int totalCount = dao.selectTotalCount();
		int totalPage = totalCount / COUNT_PER_PAGE;		// ex 12���� �Խñ� / 5 => 2
		if(totalCount % COUNT_PER_PAGE > 0) {				// ex 12���� �Խñ� / 5 = > 2 �ε� ������ 2���� �Խñ� ������ + 1 = 3
			totalPage ++;
		}
		
		int startPage = (page - 1) / 10 * 10 + 1;	// 1~10�� ���������� 1, 11~20�� ���������� 11
		int endPage = startPage + 9;	// ȭ���ϴ� �� �������� ���������� + 9
		if(endPage > totalPage) {	// Ȥ�� �� �Խñ� ��ü�� ���� ��� �� ������ ���̱�
			endPage = totalPage;
		}
		
		pageMap.put("totalPage", totalPage);
		pageMap.put("startPage", startPage);
		pageMap.put("endPage", endPage);
		
		int startRow = (page -1) * COUNT_PER_PAGE;		// ������ 1�̸� -> 0 ~ 5����, 2�̸� 5~10
		
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
