package com.shxz.productandconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Product {
	final int name;
	
	public Product(){
		Random input=new Random();
		name=input.nextInt();
	}
	@Override
	public String toString(){
		return "data"+name;
	}
	
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Product> queue=new LinkedBlockingQueue<>();
		Producer producer1=new Producer(queue);
		Producer producer2=new Producer(queue);
		Producer producer3=new Producer(queue);
		Producer producer4=new Producer(queue);
		Consumer consumer1=new Consumer(queue);
		Consumer consumer2=new Consumer(queue);
		Consumer consumer3=new Consumer(queue);
		Consumer consumer4=new Consumer(queue);
		ExecutorService service=Executors.newCachedThreadPool();
		service.execute(producer1);
		service.execute(producer2);
		service.execute(producer3);
		service.execute(producer4);
		service.execute(consumer1);
		service.execute(consumer2);
		service.execute(consumer3);
		service.execute(consumer4);
		producer1.stop();	
		producer2.stop();
		producer3.stop();
		producer4.stop();
		Thread.sleep(3000);
		service.shutdown();
	}
}
