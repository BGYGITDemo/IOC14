package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

public class RealTimeDITest {

	public static void main(String[] args) {
		Scanner sc = null;
		String ename = null, eadd = null, doj = null, basicSalary = null;
		EmployeeVO vo = null;
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		MainController controller = null;
		String result = null;
		// read inputs
		sc = new Scanner(System.in);
		System.out.println("enter Employee name :: ");
		ename = sc.next();
		System.out.println("Enter Employee Addrs::");
		eadd = sc.next();
		System.out.println("Enter Employee Date of Joining::");
		doj = sc.next();
		System.out.println("Enter Basic Salary::");
		basicSalary = sc.next();
	
		// Store inputs in VO class object
		vo = new EmployeeVO();
		vo.setEname(ename);
		vo.setEadd(eadd);
		vo.setDoj(doj);
		vo.setBasicSalary(basicSalary);
		
		// create BEanFacory IOC container
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		// get Controller Bean class object..
		controller = factory.getBean("controller", MainController.class);
		// invoke the method
		try {
			result = controller.processStudent(vo);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Internal Problem");
			e.printStackTrace();
		}
	}// main
}// class