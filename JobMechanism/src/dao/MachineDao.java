package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import vo.MachineOneVo;
import vo.MachineTwoVo;

public class MachineDao {
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
	public void machineOneDetail(MachineOneVo machineOneVo) {
		// TODO Auto-generated method stub
		getConnection();
		Transaction transaction = session.beginTransaction();
		session.save(machineOneVo);
		transaction.commit();
		session.close();
		
	}
	public void machineTwoDetail(MachineTwoVo machineTwoVo) {
		// TODO Auto-generated method stub
		getConnection();
		Transaction transaction = session.beginTransaction();
		session.save(machineTwoVo);
		transaction.commit();
		session.close();
		
		
	}
	public void updateWaitingTime(String workingTime, int m2Id) {
		// TODO Auto-generated method stub
		getConnection();
	 	String qry = "update table machineOne set waiting_time="+workingTime+"where machine_id="+m2Id;
	 	Transaction transaction = session.beginTransaction();
		session.createSQLQuery(qry).executeUpdate();
		transaction.commit();
		session.close();
	}
	public List getMachineDetail(int productId) {
		List l ;
		getConnection();	
		l =  session.createQuery("from MachineOneVo where productId="+productId).list();
		return l;
	}
	public List machineGetDetail(int mId) {
		List l ;
		getConnection();	
		l =  session.createQuery("from MachineTwoVo where MachineOneVo="+mId).list();
		return l;
	}
	
	

}
