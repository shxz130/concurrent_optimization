package com.shxz.ForkJoin;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class Task extends RecursiveAction{

	private static final long serialVersionUID = 1L;
	private List<Product> products;
	private int first;
	private int last;
	private double increment;
	
	public Task(List<Product> products,int first,int last,double increment){
		this.products=products;
		this.first=first;
		this.last=last;
		this.increment=increment;
	}
	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		if(last-first<10){
			updatePrices();
		}else{
			int middle=(last+first)/2;
			System.out.println("Task:Pending tasks:"+getQueuedTaskCount());
			Task task1=new Task(products, first, middle+1, increment);
			Task task2=new Task(products, middle+1,last, increment);
			invokeAll(task1,task2);
			//执行一个主任务所创建的多个子任务，这是一个同步调用，等待子任务执行完成，然后继续执行。
		}
	}
	private void updatePrices() {
		// TODO Auto-generated method stub
		for(int i=first; i<last; i++){
			
			Product product=products.get(i);
			product.setPrice(product.getPrice()*(1+increment));
		}
	}

}
