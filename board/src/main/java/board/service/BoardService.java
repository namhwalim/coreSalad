package board.service;

import java.util.List;
import board.dto.BoardDto;

public interface BoardService {
	
	List<BoardDto> selectBoardList() throws Exception;//게시글목록 모두 가져와야 하므로 list에 줄줄이 붙혀서 가져오자
	
	void insertBoard(BoardDto board)throws Exception;
	
	BoardDto selectBoardDetail(int board_idx) throws Exception;//단건만 가져오자
}


