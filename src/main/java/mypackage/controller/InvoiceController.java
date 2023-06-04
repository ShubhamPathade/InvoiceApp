package mypackage.controller;

import mypackage.services.*;

import java.util.List;
import mypackage.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE }, allowedHeaders = "*")
public class InvoiceController {

	@Autowired
	InvoiceServices invoiceservice;

	// Customer API Opening.
	@PostMapping("api/customer") // Add New Customer.
	public Customers AddCustomers(@RequestBody Customers cust) {
		return invoiceservice.AddNewCustomers(cust);
	}

	@GetMapping("api/customer") // Get All Customers.
	public List<Customers> GetAllCustomers() {
		return invoiceservice.GetAllCustomers();
	}

	@GetMapping("api/customer/{cid}") // Get Customer By Id.
	public Customers GetCustomerById(@PathVariable("cid") int customer_id) {
		return invoiceservice.GetCustomerById(customer_id);
	}

	@PutMapping("api/customer") // update Existing Customer.
	public Customers UpdateCustomer(@RequestBody Customers cust) {
		return invoiceservice.UpdateCustomer(cust);
	}

	@DeleteMapping("api/customer/{cid}") // Delete Customer By Id.
	public Customers DeleteCustomer(@PathVariable("cid") int customer_id) {
		return invoiceservice.DeleteCustomerById(customer_id);
	}
	// Customer API Closing.

	// Products API Opening.
	@PostMapping("api/product")
	public Products AddNewProduct(@RequestBody Products prd) {
		return invoiceservice.AddNewProduct(prd);
	}

	@GetMapping("api/product") // Get All Products.
	public List<Products> GetAllProducts() {
		return invoiceservice.GetAllProducts();
	}

	@GetMapping("api/product/{pid}") // Get Product By Id.
	public Products GetProductById(@PathVariable("pid") int product_id) {
		return invoiceservice.GetProductBYid(product_id);
	}

	@PutMapping("api/product") // Update Existing Product.
	public Products UpdateProduct(@RequestBody Products prd) {
		return invoiceservice.UpdateProduct(prd);
	}

	@DeleteMapping("api/product/{pid}")
	public Products DeleteProduct(@PathVariable("pid") int product_id) {// Delete Existing Product.
		return invoiceservice.DeleteProduct(product_id);
	}
	// Products API Closing.

	
	//-------------------Invoice APis----------------------//
	
	@PostMapping("api/newinvoice")
	public InvoiceDetails NewInvoice(@RequestBody InvoiceDetails d) {
		System.out.println(d.getInvoice_date()+" "+d.getCustomers().getCustomer_id()+" "+d.getTotal_amount());
		for(InvoiceProducts p :d.getInvoiceproducts()) {
			System.out.println(p.getProducts().getProduct_id()+" "+p.getQuantity());
		}
		InvoiceDetails dc=invoiceservice.GenerateInvoice(d);
			return dc;
		//	return invoiceservice.GenerateInvoice(d);
	}

	
	
	@GetMapping("api/invoice")
	public List<InvoiceModel>GetInvoices(){
		return invoiceservice.GetInvoices();
	}
	@GetMapping("api/invoice/{id}")
	public  InvoiceModel GetInvoice(@PathVariable("id")int id){
		return invoiceservice.GetInvoice(id);
	}

	
	@PostMapping("api/payinvoice")
	public InvoicePayments AddPayment(@RequestBody InvoicePayments p) {
	
		System.out.println(p.getPayment_date()+" "+p.getPayment_amount()+" "+p.getDescription()+" "+p.getPayment_mode());
		
		return invoiceservice.AddPayment(p);
	}
}
