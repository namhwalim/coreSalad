package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dto.BoardDto;
import board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardDto> selectBoardList() throws Exception {
		return boardMapper.selectBoardList();
	}
	@Override
	public void insertBoard(BoardDto board)throws Exception
	{
		boardMapper.insertBoard(board);
	}
	
	@Override
	public BoardDto selectBoardDetail(int board_idx) throws Exception {
		boardMapper.updateHitCount(board_idx);//상세조회한 게시글의 조회수를 증가시킨
		
		BoardDto board = boardMapper.selectBoardDetail(board_idx); //상세내용을 select해와서  board에 담는다 
		return board;
	}
}
	