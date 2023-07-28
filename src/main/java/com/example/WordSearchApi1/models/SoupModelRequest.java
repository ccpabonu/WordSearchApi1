package com.example.WordSearchApi1.models;


import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;


public class SoupModelRequest{
	
	@Pattern(regexp = "^[a-z]+$", message = "Invalid searchword: Only Lower Letters")
    private String searchword;
	@Min(value = 1, message = "Invalid rows: Equals to zero or Less than zero")
    private Integer rows;
	@Pattern(regexp = "^[a-z]+$", message = "Invalid word: Only Lower Letters")
    private String word;
    
	public String getSearchword() {
		return searchword;
	}
	public void setSearchword(String searchword) {
		this.searchword = searchword;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
    
   
}
