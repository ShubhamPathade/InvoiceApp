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
@Table(name="tblproducts")
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_id;
	private String product_name;
	private float purchase_rate;
	private float selling_rate;
	private float tax;
	private int stock_quantity;
	@OneToMany(mappedBy = "products",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("products")
	private Set<InvoiceProducts>invoiceproducts;
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Products(int product_id, String product_name, float purchase_rate, float selling_rate, float tax,
			int stock_quantity, Set<InvoiceProducts> invoiceproducts) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.purchase_rate = purchase_rate;
		this.selling_rate = selling_rate;
		this.tax = tax;
		this.stock_quantity = stock_quantity;
		this.invoiceproducts = invoiceproducts;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public float getPurchase_rate() {
		return purchase_rate;
	}
	public void setPurchase_rate(float purchase_rate) {
		this.purchase_rate = purchase_rate;
	}
	public float getSelling_rate() {
		return selling_rate;
	}
	public void setSelling_rate(float selling_rate) {
		this.selling_rate = selling_rate;
	}
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	public int getStock_quantity() {
		return stock_quantity;
	}
	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}
	public Set<InvoiceProducts> getInvoiceproducts() {
		return invoiceproducts;
	}
	public void setInvoiceproducts(Set<InvoiceProducts> invoiceproducts) {
		this.invoiceproducts = invoiceproducts;
	}

}
