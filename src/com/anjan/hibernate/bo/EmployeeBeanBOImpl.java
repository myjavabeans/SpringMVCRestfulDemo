package com.anjan.hibernate.bo;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anjan.hibernate.bean.EmployeeBean;
import com.anjan.hibernate.dao.EmployeeDao;

/**
 * Service Class
 * @author Anjan
 *
 */

@Service
public class EmployeeBeanBOImpl implements EmployeeBeanBO{

	EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}


	@Override
	@Transactional
	public void saveEmployee(EmployeeBean eb) {
		employeeDao.saveEmployee(eb);
	}

	@Override
	@Transactional
	public void updateEmployee(EmployeeBean eb) {
		employeeDao.updateEmployee(eb);
	}

	@Override
	@Transactional
	public void deleteEmployee(EmployeeBean eb) {
		employeeDao.deleteEmployee(eb);
	}

	@Override
	public EmployeeBean getBeanById(int id) {
		return employeeDao.getBeanById(id);
	}

	@Override
	public List<EmployeeBean> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}
	
}
