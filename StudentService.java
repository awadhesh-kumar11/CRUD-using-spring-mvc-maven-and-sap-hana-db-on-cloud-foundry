package com.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.Dao.StudentDao;
import com.Do.StudentDo;
//import com.Do.NotificationDo;
import com.Util.CommonUtil;
import com.Util.StudentResponse;

@Repository
public class StudentService implements StudentServiceLocal 
{
	@Autowired
	private StudentDao studentDao;
	
		
	public List<StudentDo> getStudent() 
	{
		return studentDao.getStudent();
	}
	
	public int addStudent(StudentDo studentDo)
	{
		return studentDao.addStudent(studentDo);
	}
	
	public String saveStudent(StudentDo student)
	{
		return studentDao.saveStudent(student);
	}
	
}

