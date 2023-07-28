package com.example.WordSearchApi1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.WordSearchApi1.helpers.MatrixSearchHelper;
import com.example.WordSearchApi1.models.*;

@Component
public class SoupHVService implements SoupService{
	
	@Autowired
	private MatrixSearchHelper matrixHelper;
    
    @Override
    public SoupModelResponse convertSearch(SoupModelRequest soup){
    	
    	SoupModelResponse modelResponse = new SoupModelResponse();
    	modelResponse.setSearchword(soup.getSearchword());
    	modelResponse.setRows(soup.getRows());
    	modelResponse.setWord(soup.getWord());
    	
    	modelResponse.setContains(this.search(matrixHelper.matrixConvert(soup), soup.getWord()));
    	if(modelResponse.getContains()){
    		modelResponse.setStart_col(matrixHelper.getnumIndex()[1]);
    		modelResponse.setStart_row(matrixHelper.getnumIndex()[0]);    		
    	}    	
        return modelResponse;
    }
    
    @Override
    public boolean search(char[][]matrix, String word){
    	return matrixHelper.searchHorizontal(matrix, word) || matrixHelper.searchVertical(matrix, word);
    }
}