package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.model.Student;
import com.spring.service.CService;

@RestController
public class Studentcontroller 
{
  @Autowired
  CService cs;
  
  
  @PostMapping("/student")
	public ResponseEntity<Student> add(@RequestPart("info")String json,@RequestPart("prof") MultipartFile tenmarksheet,@RequestPart("img") MultipartFile twelthMarksheet,@RequestPart("adhar") MultipartFile adhar,@RequestPart("pan")MultipartFile pancard,@RequestPart("sem1")MultipartFile semone,
		  @RequestPart("sem2")MultipartFile sem2,@RequestPart("sem3")MultipartFile sem3)
	{
	     System.out.println(json);
	     System.out.println(tenmarksheet.getOriginalFilename());
	     System.out.println(twelthMarksheet.getOriginalFilename());
	     System.out.println(adhar.getOriginalFilename());
	     System.out.println(pancard.getOriginalFilename());
	     System.out.println(semone.getOriginalFilename());
	     System.out.println(sem2.getOriginalFilename());
	     System.out.println(sem3.getOriginalFilename());
	     
	     
	   Student st=cs.savedata(json,tenmarksheet,twelthMarksheet,adhar, pancard,semone,sem2,sem3);
	  
	  return new ResponseEntity<Student>(st,HttpStatus.OK);
	}
  
    @GetMapping("/get")
    public ResponseEntity<List<Student>> get()
    {
    	 List<Student>list = cs.getAll();
    	return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
    }
    
  @PutMapping("/update/{rollno}")
 public ResponseEntity<Student> update(@RequestPart("info")String json,@RequestPart("prof") MultipartFile tenmarksheet,@RequestPart("img")MultipartFile twelthMarksheet,@RequestPart("adhar")MultipartFile adhar,@RequestPart("pan") MultipartFile pancard,@RequestPart("sem1")MultipartFile semone, @RequestPart("sem2")MultipartFile sem2,@RequestPart("sem3")MultipartFile sem3,@PathVariable int rollno)
    {
	  System.out.println(json);
	  System.out.println(tenmarksheet.getOriginalFilename());
	  System.out.println(twelthMarksheet.getOriginalFilename());
	  System.out.println(adhar.getOriginalFilename());
	  System.out.println(pancard.getOriginalFilename());
	  System.out.println(semone.getOriginalFilename());
	  System.out.println(sem2.getOriginalFilename());
	  System.out.println(sem3.getOriginalFilename());
	  
	  Student st = cs.save(json,tenmarksheet,twelthMarksheet, adhar,pancard,semone,sem2, sem3,rollno);
	  return new ResponseEntity<Student>(st,HttpStatus.OK);
	
	  
	  
    }
	
	 
}
