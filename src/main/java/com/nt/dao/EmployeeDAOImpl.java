package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.nt.bo.EmployeeBO;
import com.nt.vo.EmployeeVO;

public final class EmployeeDAOImpl implements EmployeeDAO {
	private  static final  String   EMPLOYEE_INSERT_QUERY="INSERT INTO SPRING_EMPLOYEE1 VALUES(ENO_SEQ2.NEXTVAL,?,?,?,?,?,?)";
	private  DataSource ds;

	 //for constructor injection  (alt+shift+s,o)
		public EmployeeDAOImpl(DataSource ds) {
		this.ds = ds;
	}

	
	public int insert(EmployeeBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		EmployeeVO vo=new EmployeeVO();
		
		//get pooled jdbc connection
		con=ds.getConnection();
		//create PreparedStatement object
		ps=con.prepareStatement(EMPLOYEE_INSERT_QUERY);
		//set values to query params
		ps.setString(1,bo.getEname());
		ps.setString(2,bo.getEadd());
		ps.setString(3,bo.getDoj());
		ps.setFloat(4,bo.getBasicSalary());
		ps.setFloat(5, bo.getGrossSalary());
		ps.setFloat(6,bo.getNetSalary());
		//execute the SQL query
		count=ps.executeUpdate();
		//close jdbc objs
		ps.close();
		con.close();
		return count;
	}

}