package dao;

import org.hibernate.Session;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;
import pojos.OnlineService;

public class ServiceDaoImpl implements ServiceDao {

	@Override
	public String saveDetails(OnlineService service) {
		String msg="service is close";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		try {
			Integer Id= (Integer)session.save(service);
			tx.commit();
			msg="service is open";
		} catch (RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
				}
			throw e;
			// TODO: handle exception
		}
		return msg;
	}

}
