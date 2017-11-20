package demo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class TimeContinued {
	
	public static final void  TimeContinued(String txt_LoginID,String txt_Password) {
		// 创建默认的httpClient实例.    
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        // 创建httppost    
        HttpPost httppost = new HttpPost("http://zwfp.jxnu.jadl.net/Login.aspx");  
        // 创建参数队列    
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
        formparams.add(new BasicNameValuePair("txt_LoginID", txt_LoginID));  
        formparams.add(new BasicNameValuePair("txt_Password", txt_Password));  
        formparams.add(new BasicNameValuePair("__VIEWSTATEGENERATOR", "C2EE9ABB"));  
        formparams.add(new BasicNameValuePair("__VIEWSTATE", "/wEPDwUKLTI1Nzg1ODIyMGQYAQUeX19Db250cm9sc1JlcXVpcmVQb3N0QmFja0tleV9fFgEFEGNoa19SZW1QYXNzcHdvcmTiU5zolo6/Gtin2EhtwQjwibMyu11t2YOmrWpFNSXQOw=="));  
        formparams.add(new BasicNameValuePair("__EVENTVALIDATION", "/wEWBALGu8H0CwK1lMLgCgLS9cL8AgKXzJ6eD1PrwC/+tEuQt/W6kERZa2FJGBofrpzrzMbXnOcWuVzp")); 
        formparams.add(new BasicNameValuePair("subCmd", "Login"));  
//        formparams.add(new BasicNameValuePair("chk_RemPasspword", "true"));  
        UrlEncodedFormEntity uefEntity;  
        try {  
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");  
            httppost.setEntity(uefEntity);  
            System.out.println("executing request " + httppost.getURI());  
            CloseableHttpResponse response = httpclient.execute(httppost);  
            try {  
                HttpEntity entity = response.getEntity();  
                if (entity != null) {
                	
                    System.out.println("--------------------------------------");  
                    System.out.println("程序执行 ");  
                    System.out.println("--------------------------------------"); 
                    String urlAfter1 = "http://zwfp.jxnu.jadl.net/MainFunctionPage.aspx";
                    String s = HttpGet(urlAfter1,httpclient);
                    String urlAfter2 = "http://zwfp.jxnu.jadl.net/UserInfos/UserInfo.aspx";
                    HttpGet(urlAfter2,httpclient);
                    String urlAfter3 = "http://zwfp.jxnu.jadl.net/UserInfos/UserInfo.aspx#page1";
                    ContinuedWhen(urlAfter3, httpclient,s);
//                    HttpGet(urlAfter2,httpclient);
                   
                }  
            } finally {  
                response.close(); 
                
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e1) {  
            e1.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            // 关闭连接,释放资源    
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
		
	}
	
	//Get页面访问函数
	public static final String HttpGet(String urlAfter,CloseableHttpClient httpclient) {
		
		try {
			HttpGet httpget = new HttpGet(urlAfter);
	        CloseableHttpResponse response2;
			response2 = httpclient.execute(httpget);
			HttpEntity entity2 = response2.getEntity();
			String s = EntityUtils.toString(entity2, "UTF-8");
		    System.out.println("页面访问: " + s);
		    return s;
		        
		} catch (ClientProtocolException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
       
		
		return null;
		
	}
	
	//续时函数
	public static final HttpEntity ContinuedWhen(String urlAfter,CloseableHttpClient httpclient,String s) {
		
		HttpPost httppost = new HttpPost(urlAfter);  
        // 创建参数队列    
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("__VIEWSTATEGENERATOR", "0B745CAF"));  
        formparams.add(new BasicNameValuePair("__VIEWSTATE",Retrun__VIEWSTATE(s)));  
        formparams.add(new BasicNameValuePair("__EVENTVALIDATION", "/wEWAgLLyKuuBgLgu8z3BqFDex8IRpNRUdTH6c/vRndacwSKfoiHlswfOrFSbOvj")); 
        formparams.add(new BasicNameValuePair("subCmd", "ContinuedWhen"));  
        formparams.add(new BasicNameValuePair("subBookNo", ""));   
        UrlEncodedFormEntity uefEntity; 
        try {
        	 uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");  
             httppost.setEntity(uefEntity);    
             CloseableHttpResponse response = httpclient.execute(httppost);  
             HttpEntity entity = response.getEntity();
             System.out.println("续时函数: " + EntityUtils.toString(entity, "UTF-8"));
             
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        return null;
		
	}
	
	public static final String Retrun__VIEWSTATE(String s) {
		// 按指定模式在字符串查找
    	String str = "<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"/wEPDwUKMTI4NTE4MjA1NQ9kFgICAw9kFhQCAQ8WAh4JaW5uZXJodG1sBRHoh6rkuaDlrqQzMDIo5YyXKWQCAg8WAh8ABQNEMDlkAgMPFgIfAAUG5Zyo5bqnZAIEDxYCHwAFCDExOjAzOjI0ZAIFDxYCHwAFTOWcqOe7iOerrzIwMTUwMzA5MDEzMDPliLfljaHlu7bplb/oh6rkuaDlrqQzMDIo5YyXKSBEMDnlj7fluqfkvY3kvb/nlKjml7bpl7RkAgYPFgIeB1Zpc2libGVnZAIKDxYCHwFnZAILDxYCHwFoZAIMDxYCHwFnZAINDxYEHwBlHwFoZGTkf9Or2mHHTz+p3rlGnbKlPFDptvJ3jymqfqA81zpucA==\" />";
        Matcher m = Pattern.compile("<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"([\\s\\S]*)\" />").matcher(str);
        while(m.find()){
            System.out.println(m.group(1));
            s=m.group(1).toString();
        }
        
        
		
		return s;
		
	}

}
