package com.controller;

import java.util.*;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.RegVO;


@Controller
public class DemoController {
	
	@RequestMapping(value="hello.html", method = RequestMethod.GET)
	public ModelAndView Load()
	{
		String s = "This is Spring Example...";
		return new ModelAndView("demo","msg",s);

		//1. JSP name
		//2. Key
		//3. value
	
		// /WEB-INF/view/Demo.jsp
		
		
	}
	
	@RequestMapping(value="1.html",method=RequestMethod.GET)
	public ModelAndView demo(){
		return new ModelAndView("register"); 
	}

	@RequestMapping(value="save.html",method=RequestMethod.GET)
	public ModelAndView save(HttpServletRequest request){
		String fn=request.getParameter("fn");
		String ln=request.getParameter("ln");
		
		List is=new ArrayList<>();
		is.add(fn);
		is.add(ln);
		
		return new ModelAndView("rprint","is1",is); 
	}
	
	
}
