package com.anjan.rest.response;

import java.util.List;

import com.anjan.hibernate.bean.EmployeeBean;

public class EmployeeResponse {
	
	private String status;
	private Integer code;
	private List<EmployeeBean> employeeData;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public List<EmployeeBean> getEmployeeData() {
		return employeeData;
	}
	public void setEmployeeData(List<EmployeeBean> employeeData) {
		this.employeeData = employeeData;
	}

}
