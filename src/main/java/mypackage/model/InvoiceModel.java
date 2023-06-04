package mypackage.model;

public class InvoiceModel {

	private int invoice_id;
	private String invoice_date;
	private int customer_id;
	private String customer_name;
	private float total_amount;
	private float paid_amount;
	private float remaining_amount;
	private String status;
	public InvoiceModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InvoiceModel(int invoice_id, String invoice_date, int customer_id, String customer_name, float total_amount,
			float paid_amount, float remaining_amount, String status) {
		super();
		this.invoice_id = invoice_id;
		this.invoice_date = invoice_date;
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.total_amount = total_amount;
		this.paid_amount = paid_amount;
		this.remaining_amount = remaining_amount;
		this.status = status;
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
	public float getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(float total_amount) {
		this.total_amount = total_amount;
	}
	public float getPaid_amount() {
		return paid_amount;
	}
	public void setPaid_amount(float paid_amount) {
		this.paid_amount = paid_amount;
	}
	public float getRemaining_amount() {
		return remaining_amount;
	}
	public void setRemaining_amount(float remaining_amount) {
		this.remaining_amount = remaining_amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
