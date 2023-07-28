package com.example.WordSearchApi1.models;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SoupModelResponse extends SoupModelRequest{
	
	private boolean contains;
	private Integer start_row;
	private Integer start_col;
	
	public boolean getContains() {
		return contains;
	}
	public void setContains(boolean contains) {
		this.contains = contains;
	}
	
	public Integer getStart_row() {
		return start_row;
	}
	public void setStart_row(Integer start_row) {
		this.start_row = start_row;
	}
	public Integer getStart_col() {
		return start_col;
	}
	public void setStart_col(Integer start_col) {
		this.start_col = start_col;
	}
    
}
