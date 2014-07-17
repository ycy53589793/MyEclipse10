package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	private HibernateUtil(){}
	
    static{  
        Configuration cfg = new Configuration();  
        cfg.configure();  
        
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();    
        sessionFactory = cfg.buildSessionFactory(serviceRegistry);
    }
    
    public static SessionFactory getSessionFactory() {  
        return sessionFactory;  
    }
    
    public static Session openSession() {  
        return sessionFactory.openSession();  
    }
	
    public static Session getSession() {
    	//使用线程局部模式
    	ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
    	Session session=threadLocal.get();
    	//判断是否得到
		if(session==null){
			session=openSession();
			//把session对象设置到 threadLocal,相当于该session已经和线程绑定
			threadLocal.set(session);
		}
    	return session;
    }
    
    public static void closeSession(Session s) {
    	if(EmptyUtil.isNotNull(s)) {
    		s.close();
    	}
    }

}
