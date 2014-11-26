package com.shxz.masterworker;

import java.util.Map;  
import java.util.Set;  
public class ConcreteWorker extends AbstractWorker{

	@Override
	Object handle(Object input) {
		// TODO Auto-generated method stub
		Integer i=(Integer)input;
		return i*i*i;
	}
	
	public static void main(String[] args) {
		Master master=new Master(new ConcreteWorker(), 10);
		
		for(int i=0; i<100; i++){
			master.submit(i);
		}
		master.execute();
		int re= 0;  
	        //保存最终结算结果  
	    Map<String ,Object> resultMap =master.getResultMap();   
	        //不需要等待所有Worker都执行完成，即可开始计算最终结果  
	      //不需要等待所有Worker都执行完成，即可开始计算最终结果  
        while(resultMap.size()>0 || !master.isComplete()){  
            Set<String> keys = resultMap.keySet();  
            String key =null;  
            for(String k:keys){  
                key=k;  
                break;  
            }  
            Integer i =null;  
            if(key!=null){  
                i=(Integer)resultMap.get(key);  
            }  
            if(i!=null){  
                //最终结果  
                re+=i;  
              
            }  
            if(key!=null){  
                //移除已经被计算过的项  
                resultMap.remove(key);  
            } 
        }
        System.out.println(re);
	}
}
