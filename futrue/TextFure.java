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
		System.out.println("�������");
		for(int i=0; i<10; i++){
			Thread.sleep(1000);
			System.out.println(i);
		}
		System.out.println(fure.getTask().get());
		//���г���ᷢ����ִ����forѭ��֮����������û�еȴ�ʱ�䣬Ҳ����˵���������ķ���ֵ�Ѿ���forѭ��ִ�й����еõ��ˡ�
		//Ҳ����˵Call������֮ǰ�Ѿ�ִ������ˣ������forѭ��������������֮��Ļ�����Ҫ�ȴ�call������ִ����ϡ�
	}
	
}