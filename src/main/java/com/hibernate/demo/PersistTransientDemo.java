package com.hibernate.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.hibernate.Utils.DataUtils;
import com.hibernate.Utils.HibernateUtils;
import com.hibernate.entity.Employee;
import com.hibernate.entity.Timekeeper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PersistTransientDemo {

    private static DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    private static Timekeeper persist_Transient(Session session, Employee emp) {


        Timekeeper tk1 = new Timekeeper();
//
//        tk1.setEmployee(emp);
//        tk1.setInOut(Timekeeper.IN);
//        tk1.setDateTime(new Date());
        tk1.setEmployee(emp);
        tk1.setDateTime(new Date());
        tk1.setInOut(Timekeeper.IN);



        // Now, 'tk1' is transient object
        System.out.println("- tk1 Persistent? " + session.contains(tk1));

        System.out.println("====== CALL persist(tk).... ===========");


        // Hibernate assign value to Id of 'tk1'
        // No action to DB.
        //session.persist(tk1);
        session.persist(tk1);

        System.out
                .println("- tk1.getTimekeeperId() = " + tk1.getTimekeeperId());


        // Now 'tk1' is Persistent object.
        // But no action with DB.
        // ==> true
        System.out.println("- tk1 Persistent? " + session.contains(tk1));

        System.out.println("- Call flush..");


        // Flush data to DB.
        // Hibernate execute insert statement.
        //session.flush();
        session.flush();

        String timekeeperId = tk1.getTimekeeperId();
        System.out.println("- timekeeperId = " + timekeeperId);
        System.out.println("- inOut = " + tk1.getInOut());
        System.out.println("- dateTime = " + df.format(tk1.getDateTime()));
        System.out.println();
        return tk1;
    }

    public static void main(String[] args) {
        SessionFactory factory = HibernateUtils.getSessionFactory();

        Session session = factory.openSession();
        Employee emp = null;
        try {
            session.getTransaction().begin();

            emp = DataUtils.findEmployee(session, "E7499");

            persist_Transient(session, emp);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

}
