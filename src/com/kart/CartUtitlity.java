package com.kart;

import java.util.ArrayList;
import java.util.List;

public class CartUtitlity {
   public static List<Cart> cartList =new ArrayList<>();

public static void addProductToCart(Cart cart) {
	//1.Check if the cartList is already contains a cart object with the specific custid and productid
	//2.If yes then update the qty of the existing object with the qty choosen for the latest cart object.
	//3.If no then add the cart object to cartList.
	
	int index=-1;
	Cart temp=null;
	for(Cart c:cartList) {
		index++;
		if(c.getCustid().equals(cart.getCustid()) && c.getProductid().equals(cart.getProductid())) {

			temp=c;
			break;	
		}
	}

    if(temp==null) {
		cartList.add(cart);
		System.out.println("Cart Added.......");
    } else {
    	temp.setQuantity(temp.getQuantity()+cart.getQuantity());
		cartList.set(index, temp);
		System.out.println("Cart updated...........");
}
     
    
}

}