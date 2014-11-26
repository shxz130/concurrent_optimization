package com.shxz.masterworker;

import java.util.Map;
import java.util.Queue;

public abstract class AbstractWorker  implements Runnable{

	//������У�����ȡ��������
	protected Queue<Object> workQueue;
	//�������������
	protected Map<String ,Object> resultMap;
	public void setWorkQueue(Queue<Object> workQueue){
		this.workQueue= workQueue;
	}
	
	public void setResultMap(Map<String ,Object> resultMap){
		this.resultMap=resultMap;
	}
	//�����������߼�����������ʵ�־����߼�
   abstract Object handle(Object input);
	
	
	@Override
	public void run() {
		
		while(true){
			//��ȡ������
			Object input= workQueue.poll();
			if(input==null){
				break;
			}
			//����������
			Object re = handle(input);
			resultMap.put(Integer.toString(input.hashCode()), re);
		}
	}

}
