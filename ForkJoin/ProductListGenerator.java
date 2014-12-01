package com.shxz.ForkJoin;

import java.util.ArrayList;
import java.util.List;

//生成一个随机产品列表
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
