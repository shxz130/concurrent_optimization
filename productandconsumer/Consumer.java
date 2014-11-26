package com.shxz.productandconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	private BlockingQueue<Product> queue;
	
	public Consumer(BlockingQueue<Product> queue){
		this.queue=queue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("start Consumer id="+Thread.currentThread().getId());
		while(true){
			try {
				Product product=queue.take();
				if(null!=product){
					System.out.println("Consumer take data from queue:"+product);
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
