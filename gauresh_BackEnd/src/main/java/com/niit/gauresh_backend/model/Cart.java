package com.niit.gauresh_backend.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table
@Entity
@Component
public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Cart(){
	//	this.cartId = (int)(Math.random()*10000000000L);
	}
	
	@Id
	@Column(name = "cart_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GenericGenerator(name="fk", strategy="foreign", parameters= @Parameter(name="property", value="user"))
	private int cartId;
	
	@Column(name = "grand_total")
	private int grandTotal;
	
	@Column(name = "no_of_products")
	private int noOfProducts;
	
/*	@OneToOne
    @PrimaryKeyJoinColumn
	private User user;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
*/	
	
	
	
	@OneToMany(mappedBy="cart",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private List<CartItem> cartItem;

	public List<CartItem> getCartItem() {
		return cartItem;
	}
	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(int grandTotal) {
		this.grandTotal = grandTotal;
	}
	public int getNoOfProducts() {
		return noOfProducts;
	}
	public void setNoOfProducts(int noOfProducts) {
		this.noOfProducts = noOfProducts;
	}

}
