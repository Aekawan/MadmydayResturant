/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import java.util.Vector;


public class Order {
  //  public static String empolyeename;
    public static int orderid;
    public static int total;
    public static double sumprice;
    public static int sumtotal;
    public static double totalprice;
    public static double netprice;
    public static double discount;
   
    
    
    
    
    
    
   
   //  public void setempolyeename(String ename){
  //    empolyeename = ename;
 //   }
  //  public static String getempolyeename(){
 //   return empolyeename;
  //  }
    
    
    
    public void setorderid(int orid){
      orderid = orid;
    }
    public static int getorderid(){
    return orderid;
    }
    
    
    public void settotaoprice(double ttp){
      totalprice = ttp;
    }
    public static double gettotalprice(){
    return totalprice;
    }
    
    public void setdiscount(double dis){
      discount = dis;
    }
    public static double getdiscount(){
    return discount;
    }
    
   
    
    public void setnetprice(double net){
      netprice = net;
    }
    public static double getnetprice(){
    return netprice;
    }
    

      public void settotal(int tt){
      total = tt;
    }
    public static int gettotal(){
    return total;
    }
    
      public void setsumprice(double sump){
      sumprice = sump;
    }
    public static double getsumprice(){
    return sumprice;
    }
    
    
       public void setsumtotal(int stt){
      sumtotal = stt;
    }
    public static int getsumtotal(){
    return sumtotal;
    }
    
}
