package com.anjan.hibernate.dao;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anjan.hibernate.bean.EmployeeBean;

/**
 * DAO Class
 * 
 * @author Anjan
 *
 */

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void saveEmployee(EmployeeBean eb) {
		hibernateTemplate.save(eb);
	}

	@Override
	public void updateEmployee(EmployeeBean eb) {
		hibernateTemplate.update(eb);
	}

	@Override
	public void deleteEmployee(EmployeeBean eb) {
		hibernateTemplate.delete(eb);
	}

	@Override
	public EmployeeBean getBeanById(int id) {

		EmployeeBean eb = (EmployeeBean) hibernateTemplate.get(EmployeeBean.class, id);
		return eb;

	}

	@Override
	public List<EmployeeBean> getAllEmployee() {
		
		List<EmployeeBean> list = hibernateTemplate.loadAll(EmployeeBean.class);
		return list;

	}

}
