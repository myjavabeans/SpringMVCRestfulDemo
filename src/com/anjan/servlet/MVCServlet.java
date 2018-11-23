package com.anjan.servlet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anjan.hibernate.bean.EmployeeBean;
import com.anjan.hibernate.bo.EmployeeBeanBO;
import com.anjan.rest.response.EmployeeResponse;

@RestController
public class MVCServlet {

	private final String sharedKey = "SHARED_KEY";
	private static final String SUCCESS_STATUS = "success";
	private static final String ERROR_SAVE_STATUS = "error in saving";
	private static final String ERROR_DELETE_STATUS = "error in deleting";
	private static final String ERROR_UPDATE_STATUS = "error in updating";
	private static final String ERROR_STATUS = "error";
	private static final int CODE_SUCCESS = 100;
	private static final int CODE_ERROR = 102;

	private EmployeeBeanBO employeeBeanBO;

	@Autowired(required = true)
	@Qualifier(value = "employeeBo")
	public void setPersonService(EmployeeBeanBO employeeBeanBO) {
		this.employeeBeanBO = employeeBeanBO;
	}

	@RequestMapping(value = "/getEmployee", method = RequestMethod.POST)
	public EmployeeResponse getEmployeeById(@RequestParam(value = "key") String key, @RequestBody EmployeeBean bean) {

		EmployeeResponse response = new EmployeeResponse();

		List<EmployeeBean> list = new ArrayList<EmployeeBean>();

		if (sharedKey.equals(key)) {

			int id = bean.getId();
			EmployeeBean rEmpBean = employeeBeanBO.getBeanById(id);

			list.add(rEmpBean);
			response.setEmployeeData(list);
			response.setStatus(SUCCESS_STATUS);
			response.setCode(CODE_SUCCESS);

		} else {
			response.setEmployeeData(list);
			response.setStatus(ERROR_STATUS);
			response.setCode(CODE_ERROR);
		}

		return response;
	}

	@RequestMapping(value = "/getAllEmployees", method = RequestMethod.POST)
	public EmployeeResponse displayEmployeeData(@RequestParam(value = "key") String key) {

		EmployeeResponse response = new EmployeeResponse();
		List<EmployeeBean> list = new ArrayList<EmployeeBean>();
		
		if (sharedKey.equals(key)) {

			list = employeeBeanBO.getAllEmployee();


			response.setEmployeeData(list);
			response.setStatus(SUCCESS_STATUS);
			response.setCode(CODE_SUCCESS);

		} else {
			response.setEmployeeData(list);
			response.setStatus(ERROR_STATUS);
			response.setCode(CODE_ERROR);
		}

		return response;

	}
	
	@RequestMapping(value="/saveEmployee", method = RequestMethod.POST)
	public EmployeeResponse saveEmployeeData(@RequestParam(value = "key") String key, @RequestBody EmployeeBean bean){
		
		EmployeeResponse response = new EmployeeResponse();
		List<EmployeeBean> list = new ArrayList<EmployeeBean>();
		
		if(sharedKey.equals(key)){
			
			employeeBeanBO.saveEmployee(bean);
			
			response.setEmployeeData(list);
			response.setStatus(SUCCESS_STATUS);
			response.setCode(CODE_SUCCESS);
			
		}else{
			response.setEmployeeData(list);
			response.setStatus(ERROR_STATUS);
			response.setCode(CODE_ERROR);
		}
		
		return response;
	}
	
	@RequestMapping(value="/updateEmployee", method = RequestMethod.POST)
	public EmployeeResponse updateEmployeeData(@RequestParam(value = "key") String key, @RequestBody EmployeeBean bean){
		
		EmployeeResponse response = new EmployeeResponse();
		List<EmployeeBean> list = new ArrayList<EmployeeBean>();
		
		if(sharedKey.equals(key)){
			
			employeeBeanBO.updateEmployee(bean);
			
			response.setEmployeeData(list);
			response.setStatus(SUCCESS_STATUS);
			response.setCode(CODE_SUCCESS);
			
		}else{
			response.setEmployeeData(list);
			response.setStatus(ERROR_STATUS);
			response.setCode(CODE_ERROR);
		}
		
		return response;
	}
	
	@RequestMapping(value="/deleteEmployee", method = RequestMethod.POST)
	public EmployeeResponse deleteEmployeeData(@RequestParam(value = "key") String key, @RequestBody EmployeeBean bean){
		
		EmployeeResponse response = new EmployeeResponse();
		List<EmployeeBean> list = new ArrayList<EmployeeBean>();
		
		if(sharedKey.equals(key)){
			
			employeeBeanBO.deleteEmployee(bean);
			
			response.setEmployeeData(list);
			response.setStatus(SUCCESS_STATUS);
			response.setCode(CODE_SUCCESS);
			
		}else{
			response.setEmployeeData(list);
			response.setStatus(ERROR_STATUS);
			response.setCode(CODE_ERROR);
		}
		
		return response;
	}
}
