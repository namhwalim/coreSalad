package board.dto;

import lombok.Data;

@Data
public class BoardDto {
	
	private int board_idx;
	
	private String title;
	
	private String contents;
	
	private int hit_cnt;
	
	private String created_id;
	
	private String created_datetime;
	
	private String updater_id;
	
	private String updated_datetime;
}