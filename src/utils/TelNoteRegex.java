package utils;

public class TelNoteRegex {
	public boolean menuRegex(int n,int min,int max){
		boolean flag=false;
		
		if(n>=min&&n<=max){
			flag=true;
		}
		
		return flag;
	}
	
	public boolean nameRegex(String name){
		boolean flag=false;
		
		if(name.length()<=10){
			flag=true;
		}
		
		return flag;
	}
	
	public boolean ageRegex(int age){
		boolean flag=false;
		
		if(age>0&&age<=200){
			flag=true;
		}
		
		return flag;
	}
	
	public boolean sexRegex(String sex){
		boolean flag=false;
		
		if(sex.equals("ÄÐ")||sex.equals("Å®")){
			flag=true;
		}
		
		return flag;
	}
	
	public boolean telNumRegex(String telNum){
		boolean flag=false;
		if(telNum.length()>=6&&telNum.length()<=11){
			flag=true;
		}
		return flag;
	}
	
	public boolean addressRegex(String address){
		boolean flag=false;
		if(address.length()<=50){
			flag=true;
		}				
		return flag;
	}
}
