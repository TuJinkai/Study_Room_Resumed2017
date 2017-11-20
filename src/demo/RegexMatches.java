package demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class RegexMatches
{
    public static void main( String args[] ){
 
      // 按指定模式在字符串查找
    	String str = "<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"/wEPDwUKMTI4NTE4MjA1NQ9kFgICAw9kFhQCAQ8WAh4JaW5uZXJodG1sBRHoh6rkuaDlrqQzMDIo5YyXKWQCAg8WAh8ABQNEMDlkAgMPFgIfAAUG5Zyo5bqnZAIEDxYCHwAFCDExOjAzOjI0ZAIFDxYCHwAFTOWcqOe7iOerrzIwMTUwMzA5MDEzMDPliLfljaHlu7bplb/oh6rkuaDlrqQzMDIo5YyXKSBEMDnlj7fluqfkvY3kvb/nlKjml7bpl7RkAgYPFgIeB1Zpc2libGVnZAIKDxYCHwFnZAILDxYCHwFoZAIMDxYCHwFnZAINDxYEHwBlHwFoZGTkf9Or2mHHTz+p3rlGnbKlPFDptvJ3jymqfqA81zpucA==\" />";
        Matcher m = Pattern.compile("<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"/([\\s\\S]*)\" />").matcher(str);
        while(m.find()){
            System.out.println(m.group(1));
        }
   }
}
