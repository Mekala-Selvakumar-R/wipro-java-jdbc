package com.learn.model;
//empno   ename   job mgr  hiredate  sal  comm deptno

import java.time.LocalDate;

public class Employee {
	private int employeeId;
	private String employeeName;
	private  String job;
	private int mgr;
	private LocalDate  hireDate;
	private float salary;
	private float comm;
	private int deptno;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Employee(int employeeId, String employeeName, String job, int mgr, LocalDate hireDate, float salary,
			float comm, int deptno) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.job = job;
		this.mgr = mgr;
		this.hireDate = hireDate;
		this.salary = salary;
		this.comm = comm;
		this.deptno = deptno;
	}



	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public float getComm() {
		return comm;
	}

	public void setComm(float comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}



	@Override
	public String toString() {
		return  String.format("%-10s%-15s%-15s%-10s%-15s%-10s%-10s%-10s",employeeId,employeeName,job,mgr,hireDate,salary,comm,deptno);
	}
	

	
	
}
