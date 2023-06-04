package mypackage.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tblcustomers")
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
	private String customer_name;
	private String customer_address;
	private String email_address;
	private String mobile_number;
	private String city;
	@OneToMany(mappedBy = "customers",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("customers")
	private Set<InvoiceDetails>invoicedetails;
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customers(int customer_id, String customer_name, String customer_address, String email_address,
			String mobile_number, String city, Set<InvoiceDetails> invoicedetails) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_address = customer_address;
		this.email_address = email_address;
		this.mobile_number = mobile_number;
		this.city = city;
		this.invoicedetails = invoicedetails;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_address() {
		return customer_address;
	}
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Set<InvoiceDetails> getInvoicedetails() {
		return invoicedetails;
	}
	public void setInvoicedetails(Set<InvoiceDetails> invoicedetails) {
		this.invoicedetails = invoicedetails;
	}
	
}
