package app;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import entity.User;
import util.HibernateUtil;
import util.UserCRUDUtil;

public class CRUDMethod implements UserCRUDUtil {

	public void addUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			System.out.println("User is added");
		} catch (HibernateException ex) {
			session.getTransaction().rollback();
			System.out.println("Can't add user.");
		} finally {
			session.close();
		}
	}

	public void deleteUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
			System.out.println("user is deleted");
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			System.out.println("Can't delete user.");
		} finally {
			session.close();
		}
	}
	
	//must accept "newUser" with null value in fields
	public void updateUser(User newUser) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			User oldUser = (User) session.get(User.class, newUser.getId());
			session.clear();
			
			if(newUser.getFirstName() != null){ 
				oldUser.setFirstName(newUser.getFirstName()); 
			}
			
			if(newUser.getLastName() != null){ 
				oldUser.setLastName(newUser.getLastName()); 
			}
			
			if(newUser.getEmail() != null){ 
				oldUser.setEmail(newUser.getEmail()); 
			}
			
			 if(newUser.getPhone() != null){
				 oldUser.setPhone(newUser.getPhone()); 
			}
			
			session.beginTransaction();
			session.update(oldUser);
			session.getTransaction().commit();
			System.out.println("User has updated");
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			System.out.println("Can't update user.");
			e.printStackTrace();
		} finally {
			 session.close();
		}
	}

	public List <User>readAllUsers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return	session.createCriteria(entity.User.class).list();
		
	}
}
