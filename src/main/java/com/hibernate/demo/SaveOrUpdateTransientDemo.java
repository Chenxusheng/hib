package com.hibernate.demo;


import com.hibernate.Utils.DataUtils;
import com.hibernate.Utils.HibernateUtils;
import com.hibernate.entity.Employee;
import com.hibernate.entity.Timekeeper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveOrUpdateTransientDemo {
    private static DateFormat dataFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    private static Timekeeper saveOrUpdate_Transient(Session session, Employee employee){
        Timekeeper timekeeper=new Timekeeper();
        timekeeper.setDateTime(new Date());
        timekeeper.setInOut(Timekeeper.IN);
        timekeeper.setEmployee(employee);

        session.saveOrUpdate(timekeeper);

        session.flush();

        String id=timekeeper.getTimekeeperId();
        System.out.println("TimekeeperId:--------"+id);
        System.out.println("- inOut = " + timekeeper.getInOut());
        System.out.println("- dateTime = " + dataFormat.format(timekeeper.getDateTime()));

        return timekeeper;
    }

    public static void main(String[] args) {
        SessionFactory factory= HibernateUtils.getSessionFactory();
        Session session=factory.openSession();
        Employee employee=null;
        try {
            session.getTransaction().begin();
            employee= DataUtils.findEmployee(session,"E7499");
            saveOrUpdate_Transient(session,employee);

        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.getTransaction().commit();
        }
    }
}
