package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;

public class Main {

	public static void main(String[] args)  {
		// TODO �Զ����ɵķ������
		
		try {
			SeatChooseBegin();
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
	
	
	//��ʱ��ʱ����
	public static final void SeatChooseBegin() throws InterruptedException {
		
		for(;;){
			Thread.sleep(2000);
			ArrayList<String []> list = new ArrayList<>();
	        //��ȡ�˺�
	        list = ContinueSeatUser();
			//��ȡ��ǰʱ��
			Calendar now = Calendar.getInstance();
			System.out.println("��������ʱ���� ...����ʱ����"+now.get(Calendar.HOUR_OF_DAY)+"��"+now.get(Calendar.MINUTE)+"��");
			//ʱ����ж�
			if( now.get(Calendar.HOUR_OF_DAY)==11 || now.get(Calendar.HOUR_OF_DAY)==16){
	    	System.out.println("This is the time!!");
			for (int i = 0; i < list.size(); i++) {
				System.out.println("������ʱ���˺��ǣ�"+list.get(i)[0]+" "+list.get(i)[1]);
				TimeContinued.TimeContinued(list.get(i)[0],list.get(i)[1]);
				
				}
			}else
				continue;
			
		}
		

		
		
	}
	
	
	
	//��ȡ�˺����벢����
	public static final  ArrayList<String []> ContinueSeatUser() {
		
//		File file = new File("C:\\ContinueSeatUser\\User.txt");
		File file = new File("User.txt");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String s = null;
			ArrayList<String []> list = new ArrayList<>();
			String [] str;
			while ((s = reader.readLine())!=null) {
				str = s.split(",");
				list.add(str);
			}
			//��ӡ�˺��������ڲ���
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i)[0]+" "+list.get(i)[1]);
				
			}
			reader.close();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
		
	}

}
