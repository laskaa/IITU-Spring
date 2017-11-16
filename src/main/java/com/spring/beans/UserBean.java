package com.spring.beans;

import com.spring.dao.User;
import com.spring.dto.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutionException;

/**
 * Created by arman 03.11.17.
 */
public class UserBean {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void AddUser(User u){
        try{

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            session.save(u);
            transaction.commit();
            session.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Users> getUsersList(){
        List users = new ArrayList();

        try{

            Session session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

            CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

            Root<User> userTable = criteriaQuery.from(User.class);

            criteriaQuery.select(userTable);

            criteriaQuery.toString();

            Query query = session.createQuery(criteriaQuery);


            users = query.getResultList();
//            Query query = session.createQuery("SELECT ");
//            List list = query.getResultList();

        } catch (Exception e){
            e.printStackTrace();
        }

        return users;
    }
}
