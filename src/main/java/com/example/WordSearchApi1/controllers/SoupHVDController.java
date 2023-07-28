package com.example.WordSearchApi1.controllers;
import com.example.WordSearchApi1.services.SoupHVDService;
import com.example.WordSearchApi1.services.SoupHVService;
import com.example.WordSearchApi1.models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;


@RestController
@RequestMapping("/search")
public class SoupHVDController{
    
	@Autowired
    SoupHVDService soupService;
    
    @GetMapping()
    public ResponseEntity<SoupModelResponse> searchWord(@RequestBody @Valid SoupModelRequest soap){    	
        SoupModelResponse response = soupService.convertSearch(soap);
        return new ResponseEntity<SoupModelResponse>(response, HttpStatus.OK);
    }    
}
