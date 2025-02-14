package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.EmpowermentgroupDao;
import com.example.demo.pojo.Empowermentgroup;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmpowermentgroupService {
	
	@Autowired 
	EmpowermentgroupDao empowermentgroupdao;

	public List<Empowermentgroup> displayinfo() {
		
		return empowermentgroupdao.findAll() ;
	}

	public String saveEmpGrp(Empowermentgroup obj) {
		empowermentgroupdao.save(obj);
		return "empowermwnt group addded";
	}

	public String deleteEmpGrp(Long id) {
		empowermentgroupdao.deleteById(id);
		return "Empowerment group deleted...";
	}

	public String updateEmpGrp(Long id, Empowermentgroup obj) {
		empowermentgroupdao.save(obj);
		return "Empowerment group updated....";
	}
	
	
	
	

	
	
	
	
}
