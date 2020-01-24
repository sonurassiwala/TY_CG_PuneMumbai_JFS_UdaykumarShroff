package com.capgemini.medicalhibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.medicalhibernate.dto.MessageBean;
import com.capgemini.medicalhibernate.dto.UserBean;
import com.capgemini.medicalhibernate.exception.MedicalException;

public class MessageDAOImpl implements MessageDAO {
	
	EntityManagerFactory entityManagerFactory=null;
	EntityManager entityManager=null;

	@Override
	public boolean sendMessage(int userId, String message, String type) {

		EntityTransaction transaction=null;

		boolean isSent=false;
		try {
			entityManagerFactory=Persistence.createEntityManagerFactory("test");
			entityManager=entityManagerFactory.createEntityManager();
			transaction=entityManager.getTransaction();
			MessageBean messageBean=new MessageBean();
			messageBean.setUserId(userId);
			messageBean.setMessage(message);
			messageBean.setType(type);
			transaction.begin();
			entityManager.persist(messageBean);
			transaction.commit();
			isSent=true;
		}catch(Exception e) {
			throw new MedicalException("Unable to send message");
		}
		return isSent;
	}

	@Override
	public List<MessageBean> getMessage(int uid) {
		
		List<MessageBean> messageBean=null;
		try {
			entityManagerFactory=Persistence.createEntityManagerFactory("test");
			entityManager=entityManagerFactory.createEntityManager();

			String jpql="FROM MessageBean WHERE type = 'question' ";
			Query query=entityManager.createQuery(jpql);
			List<MessageBean> ml = query.getResultList();
			System.out.println("----Messages---");
			for(MessageBean m : ml) {
				System.out.println("Message : "+m.getMessage());
				System.out.println("Id : "+m.getUserId());
				System.out.println("Message Id : "+m.getMsid());
				System.out.println("Type : "+m.getType());
				System.out.println("----------------------------");
			}


		}catch(Exception e) {
			throw new MedicalException("Unable to get message");
		}

		return messageBean;
	}

	@Override
	public boolean sendResponse(int userId, String message, String type) {

		EntityTransaction transaction=null;
		boolean isSent=false;
		try {
			entityManagerFactory=Persistence.createEntityManagerFactory("test");
			entityManager=entityManagerFactory.createEntityManager();
			transaction=entityManager.getTransaction();
			MessageBean messageBean=new MessageBean();
			messageBean.setUserId(userId);
			messageBean.setType(type);
			messageBean.setMessage(message);
			transaction.begin();
			entityManager.persist(messageBean);
			transaction.commit();
			isSent=true;

		}catch(Exception e){
			throw new MedicalException("Unable to send Response");
		}
		
		
		return isSent;
	}

	@Override
	public List<MessageBean> getResponse(int uid) {

		List<MessageBean> messageBean=null;
		try {
		entityManagerFactory=Persistence.createEntityManagerFactory("test");
		entityManager=entityManagerFactory.createEntityManager();
		
		String jpql="FROM MessageBean WHERE type = 'answer' and uid =: uid ";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("uid", uid);
		List<MessageBean> ml = query.getResultList();
		System.out.println("----Messages---");
		for(MessageBean m : ml) {
			System.out.println("Message : "+m.getMessage());
			System.out.println("Id : "+m.getUserId());
			System.out.println("Message Id : "+m.getMsid());
			System.out.println("Type : "+m.getType());
			System.out.println("------------------------------------");
		}
		
		
		}catch(Exception e) {
			throw new MedicalException("Unable to get response");
		}
		
		return messageBean;
	}

}
