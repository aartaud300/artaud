package com.objis.springmvcdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.objis.springmvcdemo.dao.IEmployeDao;
import com.objis.springmvcdemo.domaine.*;

public class EmployeManager implements IEmployeManager {
	
	private IEmployeDao employeDAO;

	public void setEmployeDAO(IEmployeDao employeDAO) {
		this.employeDAO = employeDAO;
	}

	public Employe getEmploye(String login){
		Employe employe = employeDAO.getEmployeByLogin(login);
		return employe ;
	}
	
	public Employe getEmploye(int id){		
		Employe employe = employeDAO.getEmployeById(id);
		return employe ;
	}
	public List<Employe> getAllEmployes() {
		
		List<Employe> listAllEmployes = new ArrayList<Employe>();
		listAllEmployes = (List<Employe>) employeDAO.getAllEmployes();
		return listAllEmployes;
	}

	@Override
	public void createEmployes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployes() {
		// TODO Auto-generated method stub
		
	}
	

}
