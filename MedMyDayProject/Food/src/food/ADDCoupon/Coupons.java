/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.ADDCoupon;


public class Coupons {
    
     public static String couname;
    public static int coudis;
    public static int couid;
    
    
   
     public void setcouname(String cname){
      couname = cname;
    }
    public static String getcouname(){
    return couname;
    }
    
    
    
    public void setcoudis(int cdis){
      coudis = cdis;
    }
    public static int getcoudis(){
    return coudis;
    }
    

     public void setcouid(int cid){
      couid = cid;
    }
    public static int getcouid(){
    return couid;
    }
    
    
    
}
