package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;

public class Main {

	public static void main(String[] args)  {
		// TODO 自动生成的方法存根
		
		try {
			SeatChooseBegin();
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	
	//定时续时函数
	public static final void SeatChooseBegin() throws InterruptedException {
		
		for(;;){
			Thread.sleep(2000);
			ArrayList<String []> list = new ArrayList<>();
	        //读取账号
	        list = ContinueSeatUser();
			//获取当前时间
			Calendar now = Calendar.getInstance();
			System.out.println("这里是续时程序 ...现在时间是"+now.get(Calendar.HOUR_OF_DAY)+"点"+now.get(Calendar.MINUTE)+"分");
			//时间的判定
			if( now.get(Calendar.HOUR_OF_DAY)==11 || now.get(Calendar.HOUR_OF_DAY)==16){
	    	System.out.println("This is the time!!");
			for (int i = 0; i < list.size(); i++) {
				System.out.println("现在续时的账号是："+list.get(i)[0]+" "+list.get(i)[1]);
				TimeContinued.TimeContinued(list.get(i)[0],list.get(i)[1]);
				
				}
			}else
				continue;
			
		}
		

		
		
	}
	
	
	
	//读取账号密码并返回
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
			//打印账号密码用于测试
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
