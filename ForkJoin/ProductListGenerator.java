package com.shxz.ForkJoin;

import java.util.ArrayList;
import java.util.List;

//����һ�������Ʒ�б�
public class ProductListGenerator {
	public List<Product> generate(int size){
		List<Product> list=new ArrayList<>();
		for(int i=0; i<size; i++){
			Product product=new Product();
			product.setName("product"+i);
			product.setPrice(10);
			list.add(product);
		}
		return list;
	}
}