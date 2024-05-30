package com.spring.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.model.Admission;
import com.spring.model.Result;
import com.spring.model.Student;
import com.spring.repo.SRepository;

@Service

public class Cserviceimpl implements CService {

	@Autowired
	SRepository er;

	@Override
	public Student savedata(String json, MultipartFile tenmarksheet, MultipartFile twelthMarksheet, MultipartFile adhar,
			MultipartFile pancard, MultipartFile semone, MultipartFile sem2, MultipartFile sem3) {
		ObjectMapper ob = new ObjectMapper();
		Student st = null;
		
		try {
			st = ob.readValue(json, Student.class);

		} catch (JsonMappingException je) {

			je.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();

		}
		if (st != null) {
			try {
				Admission ad = new Admission();
				Result rr = new Result();

				ad.setTenmarksheet(tenmarksheet.getBytes());
				ad.setTwelthmarksheet(twelthMarksheet.getBytes());
				ad.setPancard(pancard.getBytes());
				ad.setAdharcard(adhar.getBytes());

				rr.setSem1(semone.getBytes());
				rr.setSem2(sem2.getBytes());
				rr.setSem3(sem3.getBytes());
				st.setAdmission(ad);
				st.setResult(rr);

			}

			catch (IOException ie) {
				ie.printStackTrace();
			}

		}

		return er.save(st);

	}

	@Override
	public List<Student> getAll() {
		List<Student> st=(List<Student>) er.findAll();
		return st;
	}

	@Override
	public Student save(String json, MultipartFile tenmarksheet, MultipartFile twelthMarksheet, MultipartFile adhar,
			MultipartFile pancard, MultipartFile semone, MultipartFile sem2, MultipartFile sem3, int rollno) 
	{
		ObjectMapper mp = new ObjectMapper();
		 Student s =null;
		 try 
		 {
			s = mp.readValue(json, Student.class);
		 }
		 catch(JsonMappingException je)
		 {
			 je.printStackTrace();
		 }
		 catch(JsonProcessingException jp)
		 {
			 jp.printStackTrace();
		 }
		 if(s!=null)
		 {
			 try {
				  Admission ad = new Admission();
				  Result rr = new Result();
				  ad.setTenmarksheet(tenmarksheet.getBytes());
				  ad.setTwelthmarksheet(twelthMarksheet.getBytes());
				  ad.setAdharcard(adhar.getBytes());
				  ad.setPancard(pancard.getBytes());
				  
				  rr.setSem1(semone.getBytes());
				  rr.setSem2(sem2.getBytes());
				   rr.setSem3(sem3.getBytes());
				 
				   
				   s.setAdmission(ad);
					s.setResult(rr);
			     }
			 catch(IOException i)
			 {
				 i.printStackTrace();
			 }
			 
			 
			 
		 }
		 
		 return er.save(s);
	}

}
