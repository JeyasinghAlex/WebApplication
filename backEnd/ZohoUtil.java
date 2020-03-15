//$Id$
package com.alex.zoho;

public class ZohoUtil {
	
	private static ZohoUtil util = new ZohoUtil();
	private ZohoUtil(){
		
	}
	
	public static ZohoUtil getUtilInstance(){
		return util;
	}
	
	public  String encryptedPassword(String pwd){
        String encryptedPassword = "";
        String password = pwd;
        char []arr = password.toCharArray();
        for(int i = 0; i < arr.length; i++){
            int ch = (int)arr[i] + 2;
            char encryptedpwd  = (char)ch;
            encryptedPassword = encryptedPassword + encryptedpwd;
        }
        return encryptedPassword;
    }
	
	public boolean findBoolean(String data){
		
		if(data.equals("yes")){
			return true;
		}else{
			return false;
		}
	}
	
	public String isAllowRide(boolean result){
		
		if(result){
			return "yes";
		}else{
			return "no";
		}
	}
}
