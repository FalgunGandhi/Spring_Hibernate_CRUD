package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.RegDAO;
import com.model.RegVO;
import com.model.loginVO;

@Controller
public class RegController {
	
	@Autowired
	private RegDAO dao;
	
	@RequestMapping(value="register.html",method=RequestMethod.GET)
	public ModelAndView Load1(){
		return new ModelAndView("register1","reg",new RegVO()); 
	}

	@RequestMapping(value="save1.html",method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute RegVO v,HttpSession session){
		//session.setAttribute("s",v);
		dao.insert(v);
		System.out.println("insert done...");
		return new ModelAndView("redirect:search1.html","r",new loginVO());
		//return new ModelAndView("redirect:search1.html","r",new loginVO()); 
	}
	
	@RequestMapping(value="search1.html",method=RequestMethod.GET)
	public ModelAndView search(){
		//session.setAttribute("s",v);
		
		List is=dao.search();
		return new ModelAndView("Sprint","is",is); 
	}
	
	@RequestMapping(value="delete.html",method=RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute RegVO v,HttpServletRequest r){
		//session.setAttribute("s",v);
		int id=Integer.parseInt(r.getParameter("x"));
		v.setId(id);
		dao.delete(v);
		return new ModelAndView("redirect:search1.html"); 
	}
	
	@RequestMapping(value="edit.html",method=RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute RegVO v,HttpServletRequest r){
		//session.setAttribute("s",v);
		int id=Integer.parseInt(r.getParameter("y"));
		v.setId(id);
		List is=dao.edit(v);
		
		RegVO v1=(RegVO) is.get(0);
		return new ModelAndView("register1","reg",v1); 
	}
	
	/*
	@RequestMapping(value="verify.html",method=RequestMethod.POST)
	public ModelAndView verify(@ModelAttribute loginVO l,HttpSession session){
		//@RequestParam String un
		RegVO r=(RegVO) session.getAttribute("s");
		
		if(l.getUn().equals(r.getUn()) && l.getPwd().equals(r.getPwd()))
		{
			
			return new ModelAndView("welcome");
		}
		
		else
		{
			return new ModelAndView("login");
		}
		 
	}*/
}
