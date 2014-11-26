package com.shxz.futrue;

import java.util.concurrent.Callable;

public class MyTask implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		for(int i=0; i<1000; i++)
		{
			Thread.sleep(10);
		}
		return "My Name is Shxz130";
	}
}
