package com.kart;

import java.util.Scanner;

public class ShoppingKartMain {
	public static Scanner scan=new Scanner(System.in);
	public static Customer customer = null;
	public static String productid="";
	public static int quantity=0;
public static void main(String[] args) {
	int choice=0;
	do {
		showProducts();
		System.out.println("1. Add Product To Cart");
		System.out.println("2. View Cart Items");
		System.out.println("3. Delete Cart");
		System.out.println("4. Exit");
		System.out.println("Enter your choice");
		choice = scan.nextInt();
		switch(choice) {
		case 1:
			//1. We need to collect the customer details such as cusid,name,city;
			//2. We should again display the product list form which the customer can choose
			//3. We need to read the product details such as product id,quantity that need to be added to the cart
			//4. We need to create a Cart object and then add it to the Cartlist 
			if(customer==null) {
			readCustomerDetails();
			}
			showProducts();
			readProductDetails();
			createCartAndToCartList();
		    break;
		case 2:
			viewCartItems();
		    break;
	    case 3:
				deleteCart();
			    break; 
		default:
			System.out.println("Thank You!!!!");
			    
		}
	} while(choice<4);
}
private static void createCartAndToCartList() {
	Cart cart=new Cart(customer.getCustid(), productid, ProductUtility.getProductPrice(productid), quantity);
	CartUtitlity.addProductToCart(cart);
	
}
private static void readProductDetails() {
	System.out.println("Enter the product id");
	productid= scan.next();
	System.out.println("Enter quantity");
	quantity=scan.nextInt();
	
}
private static void readCustomerDetails() {
	customer =new Customer();
	String custid="";
	String custname="";
	String city="";
	System.out.println("Enter cust id");
	custid =scan.next();
	System.out.println("Enter cust name");
	custname =scan.next();
	System.out.println("Enter city");
	city =scan.next();
	
}
private static void viewCartItems() {
	// TODO Auto-generated method stub
	System.out.println("View Cart Items");
}
private static void deleteCart() {
	// TODO Auto-generated method stub
	System.out.println("Delete Cart Items......");
}
public static void addProductToCart() {
	// TODO Auto-generated method stub
	System.out.println("Add product to Cart");
	
}
public static void showProducts() {
	System.out.printf("%-8s%-15s%-8s%-12s%-8s","PRODUCT-ID","PRODUCT-NAME","PRICE","CATEGORY","STOCK");
	System.out.println();
	System.out.println("---------------------");
	for(Product p : ProductUtility.productList) {
	  System.out.printf("%-8s%-15s%-8d%-12s%-8d",p.getProductid(),p.getProductname(),p.getPrice(),p.getCategory(),p.getQuantity());	
	  System.out.println();
	}
}
}
