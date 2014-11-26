package com.shxz.productandconsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
	private volatile boolean isRunning=true;
	
	private BlockingQueue<Product> queue;
	
	public Producer(BlockingQueue<Product> queue){
		this.queue=queue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Product product=new Product();
		System.out.println("start producer id="+Thread.currentThread().getId());
		queue.add(product);
		try{
		while(isRunning){
			Thread.sleep(500);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void stop(){
		this.isRunning=false;
	}
}
