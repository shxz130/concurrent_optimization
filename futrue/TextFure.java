package com.shxz.futrue;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class TextFure {
	private FutureTask<String> Task;

	public FutureTask<String> getTask() {
		if(Task==null){
			Task=new FutureTask<String>(new MyTask());
		}
		return Task;
	}

	public void setTask(FutureTask<String> task) {
		Task = task;
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		TextFure fure=new TextFure();
		ExecutorService executor=Executors.newFixedThreadPool(1);
		executor.submit(fure.getTask());
		System.out.println("请求完毕");
		for(int i=0; i<10; i++){
			Thread.sleep(1000);
			System.out.println(i);
		}
		System.out.println(fure.getTask().get());
		//运行程序会发现在执行完for循环之后，这条函数没有等待时间，也就是说这条函数的返回值已经在for循环执行过程中得到了。
		//也就是说Call方法在之前已经执行完成了，如果将for循环放在这条函数之后的话，需要等待call方法的执行完毕。
	}
	
}
