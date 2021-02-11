package com.Dao;

import java.sql.Blob;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.Do.StudentDo;
//import com.Dto.LoginDto;
import com.Util.StudentResponse;
//import com.Util.LoginRequest;
//import com.Util.LoginResponse;
//import com.Util.OtpResponse;
//import com.Util.StatusResponse;

@Repository
public class StudentDao
{
	@Autowired
	private BaseDao baseDao;
	private Session session;
	private Transaction transaction;
	@SuppressWarnings(value="unchecked")
	public List<StudentDo> getStudent()
	{
		
		//List<StudentDo> rooms=new ArrayList<StudentDo>();
		session=baseDao.getSession();
		List<StudentDo >student=session.createQuery("from com.Do.StudentDo").list();
		session.close();
		return student;
	}
	
	public int addStudent(StudentDo studentDo)
	{
		int eId=0;
		try 
		{
			session=baseDao.getSession();
			transaction=session.beginTransaction();
			//studentDo.setUsername(studentDo.getEmail().toLowerCase());
			eId= (Integer)session.save(studentDo);
			transaction.commit();
		} 
		catch (HibernateException e) 
		{
			transaction.rollback();
			System.out.println(e.getMessage());
		}
		session.close();
		return eId;
	}
	
	public String saveStudent(StudentDo student)
	{
		int eId=0;
		try 
		{
			session=baseDao.getSession();
			transaction=session.beginTransaction();
			//studentDo.setUsername(studentDo.getEmail().toLowerCase());
			eId= (Integer)session.save(student);
			transaction.commit();
		} 
		catch (HibernateException e) 
		{
			transaction.rollback();
			System.out.println(e.getMessage());
		}
		session.close();
		return "Success";
	}
	
	
	public StudentDo getStudentById(int id)
	{
		
		StudentDo studentDO=null;
		session=baseDao.getSession();
		try
		{
			studentDO=session.get(StudentDo.class, id);
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		session.close();
		return studentDO;
	}
	
	 
	
	
		
}
