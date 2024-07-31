package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.dto.BoardDto;
import board.service.BoardService;
import ch.qos.logback.core.model.Model;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService; 
	
	@RequestMapping("/board/openBoardList.do")
	public ModelAndView openBoardList() throws Exception{
		ModelAndView mv = new ModelAndView("/board/boardList");
		
		List<BoardDto> list = boardService.selectBoardList();
		System.out.println(list);
		mv.addObject("list", list);
		
		return mv;
	}

	@RequestMapping("/board/openBoardWrite.do")
		public String openBoardWrite() throws Exception{
			return "/board/boardWrite";
		}
	@RequestMapping("/board/saladFind.do")
	public String openSaladFind() throws Exception{
		return "/board/saladFind";
	}
	
	@RequestMapping("/board/insertBoard.do")
	public String insertBoard(BoardDto board)throws Exception{
		boardService.insertBoard(board);
		return "redirect:/board/openBoardList.do";
		
	}
	@RequestMapping("/board/openBoardDetail.do")
	public ModelAndView openBoardDetail(@RequestParam int board_idx)throws Exception{
		ModelAndView mv = new ModelAndView("/board/boardDetail");//mv를 만들고
		System.out.println("board_idx: "+board_idx);
		BoardDto board = boardService.selectBoardDetail(board_idx);//게시판 번호를 파라미터로 넘겨서 select해오자
		mv.addObject("board", board);
		
		return mv;//화면으로 보내주자
	}
	
	
}