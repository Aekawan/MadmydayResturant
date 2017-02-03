package food.ADDFOOD;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class Foods {
    
    public static String foodname;
    public static double foodprice;
    public static String foodtype;
    
    
   
     public void setfoodname(String fname){
      foodname = fname;
    }
    public static String getfoodname(){
    return foodname;
    }
    
    
    
    public void setfoodprice(double fprice){
      foodprice = fprice;
    }
    public static double getfoodprice(){
    return foodprice;
    }
    

     public void setfoodtype(String ftype){
      foodtype = ftype;
    }
    public static String getfoodtype(){
    return foodtype;
    }
    
    
    
}
