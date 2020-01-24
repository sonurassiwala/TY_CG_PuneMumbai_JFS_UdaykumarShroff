package com.capgemini.medicalspringrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.medicalspringrest.bean.MessageBean;

@Repository
public class MessageDAOImpl implements MessageDAO {

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Override
	public boolean sendMessage(int userId, String message, String type) {
		
		boolean isSent=false;
		try {
			EntityManager entityManager=emf.createEntityManager();
			EntityTransaction transaction=entityManager.getTransaction();
			MessageBean messageBean=new MessageBean();
			messageBean.setUserId(userId);
			messageBean.setMessage(message);
			messageBean.setType(type);
			transaction.begin();
			entityManager.persist(messageBean);
			transaction.commit();
			isSent=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSent;
		
	}

	@Override
	public List<MessageBean> getMessage() {
		List<MessageBean> messageList;
		try {
			EntityManager manager = emf.createEntityManager();
			String type = "Question";
			String jpql = "from MessageBean where type =: type";
			Query query = manager.createQuery(jpql);
			query.setParameter("type", type);
			messageList = query.getResultList();
			return messageList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean sendResponse(int userId, String message, String type) {
		
		 
		boolean isSent=false;
		try {
			EntityManager entityManager=emf.createEntityManager();
			EntityTransaction transaction=entityManager.getTransaction();
			MessageBean messageBean=new MessageBean();
			messageBean.setUserId(userId);
			messageBean.setType(type);
			messageBean.setMessage(message);
			transaction.begin();
			entityManager.persist(messageBean);
			transaction.commit();
			isSent=true;

		}catch(Exception e){
			e.printStackTrace();
		}
		return isSent;
		
	}

	@Override
	public List<MessageBean> getResponse(int userId) {
		List<MessageBean> messageList;
		try {
			EntityManager manager = emf.createEntityManager();
			String type = "Answer";
			String jpql = "from MessageBean where type =: type and userId =: userId";
			Query query = manager.createQuery(jpql);
			query.setParameter("type", type);
			query.setParameter("userId", userId);
			messageList = query.getResultList();
			return messageList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
