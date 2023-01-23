package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ServiceDaoImpl;
import pojos.OnlineService;
import pojos.Product;

public class TestService {

	public static void main(String[] args) {
		try(SessionFactory sf1= getFactory(); Scanner sc=new Scanner(System.in);)
		{
			ServiceDaoImpl serviceDao=new ServiceDaoImpl();
			System.out.println("Enter details: fname,  lname,  product, deliveryDate");
			OnlineService service=new OnlineService(sc.next(), sc.next(), Product.valueOf(sc.next().toUpperCase()), LocalDate.parse(sc.next()));
			System.out.println(serviceDao.saveDetails(service));
			
			//System.out.println("hibernate up and running +"+sf1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	}


