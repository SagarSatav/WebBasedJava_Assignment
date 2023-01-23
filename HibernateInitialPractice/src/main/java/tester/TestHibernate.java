package tester;
import static utils.HibernateUtils.*;
import org.hibernate.SessionFactory;
public class TestHibernate {

	public static void main(String[] args) {
		try(SessionFactory sf1= getFactory())
		{
			System.out.println("hibernate up and running +"+sf1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
