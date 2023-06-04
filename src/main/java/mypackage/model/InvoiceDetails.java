package mypackage.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tblinvoicedetails")
public class InvoiceDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoice_id;
	private String invoice_date;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "customer_id")
	private Customers customers;
	private float total_amount;
	@OneToMany(mappedBy = "invoicedetails",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("invoicedetails")
	private Set<InvoiceProducts>invoiceproducts;
	@OneToMany(mappedBy = "invoicedetails",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("invoicedetails")
	private Set<InvoicePayments> invoicepayments;
	public InvoiceDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InvoiceDetails(int invoice_id, String invoice_date, Customers customers, float total_amount,
			Set<InvoiceProducts> invoiceproducts, Set<InvoicePayments> invoicepayments) {
		super();
		this.invoice_id = invoice_id;
		this.invoice_date = invoice_date;
		this.customers = customers;
		this.total_amount = total_amount;
		this.invoiceproducts = invoiceproducts;
		this.invoicepayments = invoicepayments;
	}
	public int getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}
	public String getInvoice_date() {
		return invoice_date;
	}
	public void setInvoice_date(String invoice_date) {
		this.invoice_date = invoice_date;
	}
	public Customers getCustomers() {
		return customers;
	}
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	public float getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(float total_amount) {
		this.total_amount = total_amount;
	}
	public Set<InvoiceProducts> getInvoiceproducts() {
		return invoiceproducts;
	}
	public void setInvoiceproducts(Set<InvoiceProducts> invoiceproducts) {
		this.invoiceproducts = invoiceproducts;
	}
	public Set<InvoicePayments> getInvoicepayments() {
		return invoicepayments;
	}
	public void setInvoicepayments(Set<InvoicePayments> invoicepayments) {
		this.invoicepayments = invoicepayments;
	}
	
}
