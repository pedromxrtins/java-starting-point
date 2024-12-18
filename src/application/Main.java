package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		System.out.print ("Birth date (DD/MM/YYYY): ");
		Date clientBDate = sdf.parse(sc.next());
		Client client = new Client(clientName, clientEmail, clientBDate);
		
		
		
		System.out.println("Order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order (new Date(), status, client);
		
		
		
		System.out.println("How many items to this order? ");
		int n = sc.nextInt();
		
		for (int i=1 ; i<=n ; i++ ) {
				 System.out.println("Enter #" + i + " item data: ");
				 System.out.println("Product name: ");
				 sc.nextLine();
				 String productName = sc.nextLine();
				 System.out.println("Product price: ");
				 Double productPrice = sc.nextDouble();
				 Product product = new Product(productName, productPrice);
				 
				 System.out.print("Quantity: ");
				 Integer quantity = sc.nextInt();
				 
				 OrderItem orderItem = new OrderItem (quantity, productPrice, product);
				 
				 order.addItem(orderItem);
				
				 }
		
		
		System.out.println("Order Sumary: ");
		
		System.out.println(order);
		
		
		sc.close();

	}

}
