package com.hibernate.demo;

import java.util.List;

import com.hibernate.DaoUtils.HibernateUtils;
import com.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class ShortEmpInfoQueryDemo {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.getTransaction().begin();

            // Using constructor of ShortEmpInfo
            String sql = "Select new " + ShortEmpInfo.class.getName()
                    + "(e.empId, e.empNo, e.empName)" + " from "
                    + Employee.class.getName() + " e ";

            Query<ShortEmpInfo> query = session.createQuery(sql);


            // Execute query.
            // Get a List of ShortEmpInfo
            List<ShortEmpInfo> employees = query.getResultList();

            for (ShortEmpInfo emp : employees) {
                System.out.println("Emp: " + emp.getEmpNo() + " : "
                        + emp.getEmpName());
            }

            // Commit data.
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
    }

}
