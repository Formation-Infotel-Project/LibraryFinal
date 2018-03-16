package com.formation.infotel.controller;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.formation.infotel.controller.dto.EditorDto;
import com.formation.infotel.controller.dto.LibraryDto;
import com.formation.infotel.entity.Library;
import com.formation.infotel.services.interfaces.EditorService;




public class EditorController extends HttpServlet{
	
	@Autowired
	EditorService editorService;
	
	 @PostMapping("/editor/add")
	    public void  EditorAdd(@RequestBody  EditorDto editorDto) {
		 
	 }
	    	
	    

}
