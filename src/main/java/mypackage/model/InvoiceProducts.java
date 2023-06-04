package mypackage.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblinvoiceproducts")
public class InvoiceProducts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoice_product_id;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "invoice_id")
	private InvoiceDetails invoicedetails;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "product_id")
	private Products products;
	private int quantity;
	public InvoiceProducts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InvoiceProducts(int invoice_product_id, InvoiceDetails invoicedetails, Products products, int quantity) {
		super();
		this.invoice_product_id = invoice_product_id;
		this.invoicedetails = invoicedetails;
		this.products = products;
		this.quantity = quantity;
	}
	public int getInvoice_product_id() {
		return invoice_product_id;
	}
	public void setInvoice_product_id(int invoice_product_id) {
		this.invoice_product_id = invoice_product_id;
	}
	public InvoiceDetails getInvoicedetails() {
		return invoicedetails;
	}
	public void setInvoicedetails(InvoiceDetails invoicedetails) {
		this.invoicedetails = invoicedetails;
	}
	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
