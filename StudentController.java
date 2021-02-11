package com.Controller;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Do.StudentDo;
//import com.Do.RoomsDo;
import com.Service.StudentServiceLocal;
import com.Util.StudentResponse;
import com.google.gson.Gson;
@Controller
@RequestMapping(value="/student")
public class StudentController 
{
	@Autowired
	private StudentServiceLocal studentServiceLocal; 
	@Autowired
	private SessionFactory factory;
	
	
	
	@ResponseBody
	@GetMapping("/message")
	public String message()
	{
		return "Welcome!";
	}
	
	@ResponseBody
	@GetMapping("/getStudent")
	public List<StudentDo> getStudent()
	{
		return studentServiceLocal.getStudent();
	}
	
	@ResponseBody
	@CrossOrigin(origins = "*")
	@PostMapping(value="/addStudent")
	public int addStudent(@RequestParam String data)
	{
		return studentServiceLocal.addStudent(new Gson().fromJson(data, StudentDo.class));
	}
	
	@RequestMapping("/studentform")    
    public String showform(Model m){    
        m.addAttribute("command", new StudentDo());  
        return "addStudentForm";   
    } 

	@RequestMapping(value="/save",method = RequestMethod.POST)    
	@ResponseBody
	public String saveStudent(@ModelAttribute("student") StudentDo student)
	{  
		return studentServiceLocal.saveStudent(student);
	}
	
	
}