package com.example.WordSearchApi1.services;

import org.springframework.stereotype.Service;

import com.example.WordSearchApi1.models.SoupModelRequest;
import com.example.WordSearchApi1.models.SoupModelResponse;

@Service
public interface SoupService {
	
	
	SoupModelResponse convertSearch(SoupModelRequest soup);
	
	boolean search(char[][]matrix, String word);
	
	

}
