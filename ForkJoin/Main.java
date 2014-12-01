package com.shxz.ForkJoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) throws Exception {
		ProductListGenerator generator=new ProductListGenerator();
		List<Product> products=generator.generate(10000);
		Task task=new Task(products, 0, products.size(), 0.3 );
		ForkJoinPool pool=new ForkJoinPool();
		pool.execute(task);
		do{
			System.out.println("Main£º thread Count :"+pool.getActiveThreadCount());
			System.out.println("Main: thread Steal:"+pool.getStealCount());
			System.out.println("Main: Parallelism:"+pool.getParallelism());
			TimeUnit.MILLISECONDS.sleep(5);
		
		}while(task.isDone());
		pool.shutdown();
		
		Thread.sleep(1000);
		if(task.isCompletedNormally()){
			System.out.println("Main: The Process has complete normally");
		}
		for(int i=0; i<products.size(); i+=2){
			System.out.println(products.get(i).getPrice());
		}
		
	
	}
	
}
