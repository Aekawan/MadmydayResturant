/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.Regis;


public class Member {
    
    static int Memid;
    static String Memname;
    static String addr;
    static String tel;
    
     public void setMemid(int mid){
      Memid = mid;
    }
    public static int getMemid(){
    return Memid;
    }
    

    public void setMemname(String mn){
      Memname = mn;
    }
    public static String getMemname(){
    return Memname;
    }
    
    
    public void setaddr(String ad){
      addr = ad;
    }
    public static String getaddr(){
    return addr;
    }
    
     public void settel(String t){
      tel = t;
    }
    public static String gettel(){
    return tel;
    }
    
    
    
}
