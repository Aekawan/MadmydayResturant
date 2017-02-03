
package food.Regis;

public class Empolyee {
    
    public static int Emid;
    public static String Emname;
    public static String Empass;
    public static String Emdepart;
    public static String Emtel;
    public static String Emaddr;
       
    
    
   
     public void setempolyeename(String ename){
      Emname = ename;
    }
    public static String getempolyeename(){
    return Emname;
    }
    
    
    
    public void setEmid(int eid){
      Emid = eid;
    }
    public static int getEmid(){
    return Emid;
    }
    
    
    
    public void setEmpass(String epass){
      Empass = epass;
    }
    public static String getEmpass(){
    return Empass;
    }
    
   
    
}

    

