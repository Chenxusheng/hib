package com.hibernate.Utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();//创建配置对象
        sessionFactory = configuration.buildSessionFactory();//创建会话工厂
        return sessionFactory;
    }
}
