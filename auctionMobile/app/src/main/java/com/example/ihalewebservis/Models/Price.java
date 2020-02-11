package com.example.ihalewebservis.Models;

public class Price{
	private float price;

	public void setPrice(float price){
		this.price = price;
	}

	public float getPrice(){
		return price;
	}

	@Override
 	public String toString(){
		return 
			"Price{" + 
			"price = '" + price + '\'' + 
			"}";
		}
}
