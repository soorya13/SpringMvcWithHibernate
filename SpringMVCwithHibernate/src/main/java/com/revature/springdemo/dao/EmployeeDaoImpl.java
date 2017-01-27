package com.revature.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.springdemo.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	SessionFactory sessionFactory;

	public void addEmployee(Employee e) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(e);
			tx.commit();

		} finally {
			session.close();
		}

	}

	public Employee getEmployeeById(int id) {
		Employee emp;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			emp = (Employee) session.load(Employee.class, id);
		} finally {
			session.close();
		}
		return emp;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployee() {
		Session session = null;
		List<Employee> empList;
		try {
			session = sessionFactory.openSession();
			empList = session.createQuery("from Employee").list();

		} finally {
			session.close();
		}
		return empList;
	}

	public void updateEmployee(Employee e) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.merge(e);
			tx.commit();
		} finally {
			session.close();
		}

	}

	public void deleteEmployee(int id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Employee temp=(Employee) session.load(Employee.class,id);
			if(temp!=null)
			{
				session.delete(temp);
			}
			tx.commit();

		} finally {
			session.close();
		}

	}

}
