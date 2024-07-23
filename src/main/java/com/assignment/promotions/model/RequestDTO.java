package com.assignment.promotions.model;

import java.util.List;
import java.util.Objects;

public class RequestDTO {
	
	private List<Product> products;
	private String clientType;
	
    public RequestDTO() {
		
	}

	public RequestDTO(List<Product> products, String clientType) {
		
		this.products = products;
		this.clientType = clientType;
	}
    
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientType, products);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestDTO other = (RequestDTO) obj;
		return Objects.equals(clientType, other.clientType) && Objects.equals(products, other.products);
	}


}
