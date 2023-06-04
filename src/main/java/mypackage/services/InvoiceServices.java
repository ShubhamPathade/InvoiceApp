package mypackage.services;

import mypackage.model.*;
import mypackage.repository.*;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServices {

	@Autowired
	CustomersRepository customersrepo;
	@Autowired
	InvoiceDetailsRepository invoicedetailsrepo;
	@Autowired
	InvoicePaymentsRepository invoicepaymentsrepo;
	@Autowired
	InvoiceProductsRepository invoiceproductsrepo;
	@Autowired
	ProductsRepository productsrepo;

	// Customers Code Opening.
	public List<Customers> GetAllCustomers() {// Get All Customers.
		List<Customers>lst=new ArrayList<Customers>();
		for(Customers c:customersrepo.findAll()) {
			Customers ct=new Customers(c.getCustomer_id(), c.getCustomer_name(), c.getCustomer_address(), c.getEmail_address(), c.getMobile_number(), c.getCity(), null);
			lst.add(ct);
		}
		return lst;
	}

	public Customers AddNewCustomers(Customers cust) {// Add New Customers.
		return customersrepo.save(cust);
	}

	public Customers GetCustomerById(int id) {// Get Customer By Id.
		Customers c=customersrepo.findById(id).get();
		Customers cust=new Customers(c.getCustomer_id(),c.getCustomer_name(),c.getEmail_address(),c.getMobile_number(),c.getCity(),c.getCustomer_address(),null);
		return cust;
	}

	public Customers UpdateCustomer(Customers cust) {// Update Customer By Id.
		return customersrepo.save(cust);
	}

	public Customers DeleteCustomerById(int customer_id) {
		Customers cust = GetCustomerById(customer_id);
		customersrepo.delete(cust);
		return cust;
	}
	// Customers Code Closing.

	// Products Code Opening.
	public Products AddNewProduct(Products prd) {// Add New Products.
		return productsrepo.save(prd);
	}

	public List<Products> GetAllProducts() {// Get All Products.
		List<Products>lst=new ArrayList<Products>();
		for(Products p:productsrepo.findAll()) {
			Products prd=new Products(p.getProduct_id(), p.getProduct_name(), p.getPurchase_rate(), p.getSelling_rate(), p.getTax(), p.getStock_quantity(), null);
			lst.add(prd);
		}
		return lst;
	}

	public Products GetProductBYid(int pid) {// Get Product By Id.
		Products p= productsrepo.findById(pid).get();
		Products prd=new Products(p.getProduct_id(), p.getProduct_name(), p.getPurchase_rate(), p.getSelling_rate(), p.getTax(), p.getStock_quantity(), null);
		return prd;
	}

	public Products UpdateProduct(Products prd) {// Update Existing Product.
		return productsrepo.save(prd);
	}

	public Products DeleteProduct(int product_id) {// Delete Product.
		Products p = GetProductBYid(product_id);
		productsrepo.delete(p);
		return p;
	}
	// Products Code Closing.

	
	
	
	//----------------Invoice Services---------------------//
	
	public InvoiceDetails GenerateInvoice(InvoiceDetails d) {
		InvoiceDetails id=new InvoiceDetails(0, d.getInvoice_date(), d.getCustomers(), d.getTotal_amount(), null, null);
		InvoiceDetails invoice=invoicedetailsrepo.save(id);
		for(InvoiceProducts p : d.getInvoiceproducts()) {
			InvoiceProducts pr=new InvoiceProducts(0, invoice, p.getProducts(), p.getQuantity());
			invoiceproductsrepo.save(pr);
		}
		return invoice;
	}
	
	public List<InvoiceModel>GetInvoices(){
		List<InvoiceModel>lst=new ArrayList<InvoiceModel>();
		for(InvoiceDetails d : invoicedetailsrepo.findAll()) {
			float paid_amount=0;
			for(InvoicePayments p : d.getInvoicepayments())
			{
				if(p.getInvoicedetails().getInvoice_id()==d.getInvoice_id()) {
					paid_amount+=p.getPayment_amount();
				}
			}
			float total_amount=d.getTotal_amount();
			
			float remaining_amount=total_amount-paid_amount;
			String status="";
			if(remaining_amount==0) {
				status="Paid";
			}
			else if(paid_amount==0) {
				status="Un Paid";
			}
			else if(paid_amount>0 && paid_amount<total_amount) {
				status="Partial Paid";
			}
			InvoiceModel im=new InvoiceModel(d.getInvoice_id(), d.getInvoice_date(), d.getCustomers().getCustomer_id(), d.getCustomers().getCustomer_name(), total_amount, paid_amount, remaining_amount, status);
			lst.add(im);
		}
		return lst;
	}
	
	
	
	
	public InvoiceModel GetInvoice(int id){
		InvoiceModel im=null;
		for(InvoiceModel d :GetInvoices())
		{
			if(d.getInvoice_id()==id)
			{
			  im= d;
			  break;
			}
		}
return im;
	}
	
	
	
public InvoicePayments AddPayment(InvoicePayments p) {
	InvoicePayments pm=new InvoicePayments(0, p.getInvoicedetails(), p.getPayment_date(), p.getPayment_amount(), p.getPayment_mode(),p.getDescription());
	return	invoicepaymentsrepo.save(pm);

}
	
//public Products UpdateStockQuantity(Products p) {
//	for(Products r:GetAllProducts()) {
//		if(r.getProduct_id()==p.getProduct_id()) {
//			
//		}
//	}
//	return null;
//}

}
