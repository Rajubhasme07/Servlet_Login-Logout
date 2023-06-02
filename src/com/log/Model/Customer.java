package com.log.Model;

public class Customer 
{
	
	private int uid;
	private String uname;
	private  String upass;
	
//	setter getter
	public void setUid(int uid){
		this.uid=uid;
	}
	public int getUid(){
		return uid;
	}
	
	public void setUname(String uname){
		this.uname=uname;
		
	}
	public String getUname(){
		return uname;
		
	}
	public void setUpass(String upass){
		this.upass=upass;
	}
    public String getUpass(){
    	return upass;
    }
    
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int uid,String uname,String upass){
		this.uid=uid;
		this.uname=uname;
		this.upass=upass;
	}
	
	

public String toString(){
	return "uid="+uid+"upass="+upass+"";
}
    
//    Default Constructor
 
    
    
    
	
	

}
