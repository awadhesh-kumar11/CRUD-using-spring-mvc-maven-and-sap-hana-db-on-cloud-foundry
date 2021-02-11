package com.Service;

import java.util.List;

//import com.Controller.ModelAttribute;
import com.Do.StudentDo;
import com.Util.StudentResponse;

public interface StudentServiceLocal {
	public List<StudentDo> getStudent();
	public int addStudent(StudentDo studentDo);
	public String saveStudent(StudentDo student);
	
}
