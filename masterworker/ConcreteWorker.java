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
	        //�������ս�����  
	    Map<String ,Object> resultMap =master.getResultMap();   
	        //����Ҫ�ȴ�����Worker��ִ����ɣ����ɿ�ʼ�������ս��  
	      //����Ҫ�ȴ�����Worker��ִ����ɣ����ɿ�ʼ�������ս��  
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
                //���ս��  
                re+=i;  
              
            }  
            if(key!=null){  
                //�Ƴ��Ѿ������������  
                resultMap.remove(key);  
            } 
        }
        System.out.println(re);
	}
}