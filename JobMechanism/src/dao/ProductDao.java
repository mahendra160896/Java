package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import vo.AddProductVo;

public class ProductDao {
	static AnnotationConfiguration annotationConfiguration;
	static SessionFactory sessionFactory;
	Session session;
	Transaction transaction;
	Query query;
	void getConnection()
	{
		AnnotationConfiguration annotationConfiguration = new AnnotationConfiguration();
		annotationConfiguration.configure("hibernate.cfg.xml");
		sessionFactory = annotationConfiguration.buildSessionFactory();
		session = sessionFactory.openSession();
	}
	public void AddProduct(AddProductVo addProductVo) {
		// TODO Auto-generated method stub
		getConnection();
		Transaction transaction = session.beginTransaction();
		session.save(addProductVo);
		transaction.commit();
		session.close();
		
	}
	public List selectProduct() {
		List l ;
		getConnection();	
		l =  session.createQuery("from AddProductVo").list();
		return l;
		
		
	}
	public List selectProductName(int productId) {
		List l ;
		getConnection();	
		l =  session.createQuery("from AddProductVo where productId="+productId).list();
		return l;
	}
	
	
}
