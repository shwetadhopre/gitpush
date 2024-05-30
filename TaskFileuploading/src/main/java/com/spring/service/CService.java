package com.spring.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.spring.model.Student;

public interface CService {

	Student savedata(String json, MultipartFile tenmarksheet, MultipartFile twelthMarksheet, MultipartFile adhar,
			MultipartFile pancard, MultipartFile semone, MultipartFile sem2, MultipartFile sem3);

	List<Student> getAll();

	Student save(String json, MultipartFile tenmarksheet, MultipartFile twelthMarksheet, MultipartFile adhar,
			MultipartFile pancard, MultipartFile semone, MultipartFile sem2, MultipartFile sem3, int rollno);

}
