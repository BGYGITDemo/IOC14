package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.MainController;
import com.nt.vo.CustomerVO;

public class RealTimeDITest {

	public static void main(String[] args) {
		Scanner sc = null;
		String name = null, cadd = null, pamt = null, rate = null, time = null;
		CustomerVO vo = null;
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		MainController controller = null;
		String result=null;
		// read inputs
		sc = new Scanner(System.in);
		System.out.println("Enter Customer Name::");
		name = sc.next();
		System.out.println("Enter Customer Address::");
		cadd = sc.next();
		System.out.println("Enter Principle Amount::");
		pamt = sc.next();
		System.out.println("Enter Rate of Interst::");
		rate = sc.next();
		System.out.println("Enter Time of Amount::");
		time = sc.next();
//Store inputs in VO class obj
		vo = new CustomerVO();
		vo.setCname(name);
		vo.setCadd(cadd);
		vo.setpAmt(pamt);
		vo.setRate(rate);
		vo.setTime(time);
//create BeanFactroy IOC Cotainer
		factory = new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
//get Controller Bean class obj
		controller = factory.getBean("controller", MainController.class);
//invoke the method
		try {
			result = controller.processCustomer(vo);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Enternal Problem");
			e.printStackTrace();
		}
	}// main
}// class
