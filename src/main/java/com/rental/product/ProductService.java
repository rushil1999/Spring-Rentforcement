package com.rental.product;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.handler.CustomException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	public boolean addProduct(Product prod) {
		
		if(this.validateProduct(prod)) {
			
			System.out.println(prod.getId());
			prod.setId(this.getProductId());
			productRepo.save(prod);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public ArrayList<Product> getPoductList(){
		ArrayList<Product> list = new ArrayList<Product>();
		Iterator<Product> it =  productRepo.findAll().iterator();
		
		while(it.hasNext()) {
			list.add((Product)it.next());
		}
		return list;
		
	}
	
	
	public Product getProductDetails(int id) throws CustomException {
		if(productRepo.existsById(id)) {
			 return productRepo.findById(id).get();
		}
		else {
			throw new CustomException("Entity Not Found");
		}
		
	}
	
	public ArrayList<Product> getProductListByCategory(String category){
		ArrayList<Product> tempList = new ArrayList<Product>();
		ArrayList<Product> list = new ArrayList<Product>();
		Iterator<Product> it = productRepo.findAll().iterator();
		while(it.hasNext()) {
			tempList.add(it.next());
		}
		for(int i = 0 ; i < tempList.size() ; i++) {
			if(tempList.get(i).getCategory().equals(category)) {
				list.add(tempList.get(i));
			}
		}
		return list;
	}
	
	public int getProductId() {
		ArrayList<Product> list = new ArrayList<Product>();
		Iterator<Product> it = productRepo.findAll().iterator();
		while(it.hasNext()) {
			list.add(it.next());
		}
		int max = 0;
		for(int i = 0;i < list.size(); i++) {
			if(list.get(i).getId() > max) {
				max = list.get(i).getId(); 
			}
		}
		return max + 1;
	}
	
	public boolean validateProduct(Product prod) {
		return true;
	}
	
	
}