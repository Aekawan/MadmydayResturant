/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;



/**
 *
 * @author BankSE
 */
public class CheckFood {
static String Foodid;
static String Foodname;
static String Foodprice;

  public void setFoodname(String fname){
      Foodname = fname;
    }
    public static String getFoodname(){
    return Foodname;
    }
   
    public void setFoodid(String fid){
      Foodid = fid;
    }
    public static String getFoodid(){
    return Foodid;
    }
    
     public void setFoodprice(String fp){
      Foodprice = fp;
    }
    public static String getFoodprice(){
    return Foodprice;
    }
    
}
