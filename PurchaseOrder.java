public class PurchaseOrder {

	import java.util.ArrayList;
	import java.util.Date;
	import java.util.List;

	public class PurchaseOrder {
	    private Date orderDate;
	    private Date arrivalDate;
	    private String shipmentStatus;
	    private String paymentStatus;
	    private String paymentMethod;
	    private double paymentAmount;
	    private Customer customer;
	    private Supplier supplier;
	    private List<OrderItem> items;

	    public PurchaseOrder(Customer customer, Supplier supplier) {
	        this.customer = customer;
	        this.supplier = supplier;
	        this.items = new ArrayList<>();
	    }

	    public void addItem(OrderItem item) {
	        items.add(item);
	    }

	    public double getTotalCost() {
	        double totalCost = 0.0;
	        for (OrderItem item : items) {
	            totalCost += item.getUnitPrice() * item.getQuantity(); // Use getQuantity() with a lowercase 'q'
	        }
	        return totalCost;
	    }

		public static void main(String[] args) {
			ContactInformation customerContact = new ContactInformation("123-456-7890", "sai@customer.com");
	        Customer customer = new Customer("sai", "157 StoneBridge St", customerContact);

	        ContactInformation supplierContact = new ContactInformation("987-654-3210", "ABC@supplier.com");
	        Supplier supplier = new Supplier("ABC Inc", supplierContact);

	        PurchaseOrder purchaseOrder = new PurchaseOrder(customer, supplier);

	        OrderItem item1 = new OrderItem("chips", 5, 5.99, "tomato chips chrispy");
	        OrderItem item2 = new OrderItem("coke", 3, 2.99, "Soft drinks");
	        OrderItem item3 = new OrderItem("Chicken", 12, 3.99, "chickem wings");

	        purchaseOrder.addItem(item1);
	        purchaseOrder.addItem(item2);
	        purchaseOrder.addItem(item3);

	        double totalCost = purchaseOrder.getTotalCost();
	        System.out.println("Total Cost: $" + totalCost);
	    }
	}