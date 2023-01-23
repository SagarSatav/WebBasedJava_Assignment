package pojos;
import javax.persistence.*;
import java.time.LocalDate;
@Entity	
@Table(name="Online_Service")
public class OnlineService {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)

private Integer id;
@Column(name="first_name",length=25)
private String fname;
@Column(name="last_name",length=25)
private String lname;
@Enumerated(EnumType.STRING)
private Product product;
@Column(name="delivery_Date",length=25)
private LocalDate deliveryDate;
public OnlineService(String fname, String lname, Product product, 
		LocalDate deliveryDate) {
	super();
	this.id = id;
	this.fname = fname;
	this.lname = lname;
	this.product = product;
	this.deliveryDate = deliveryDate;
}
public OnlineService() {
	super();
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public LocalDate getDeliveryDate() {
	return deliveryDate;
}
public void setDeliveryDate(LocalDate deliveryDate) {
	this.deliveryDate = deliveryDate;
}
@Override
public String toString() {
	return "OnlineService [id=" + id + ", fname=" + fname + ", lname=" + lname + ", product=" + product
			+ ", deliveryDate=" + deliveryDate + "]";
}



}
