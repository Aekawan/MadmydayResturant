/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import food.Regis.Empolyee;
import food.ADDFOOD.Foods;
import food.Regis.AddMember;
import food.ADDCoupon.AddCoupon;
import food.ADDCoupon.Coupons;
import food.ADDFOOD.AddFood;
import food.Regis.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BankSE
 */
public class Res extends javax.swing.JFrame {
    
    Connection connect = null;

    Statement s = null;
    
     PreparedStatement  pst = null;
    
    int se;
    
    String select;
    int ss;
    int selected;
    //เก็บตำแหน่งที่ซ้ำ
    int n;
    static int total=0;
  
    DecimalFormat df=new DecimalFormat("#,###.00");

    int money;
    // Model for Table
    

DefaultTableModel model,model2,model3,model4;
    
    

    /**
     * Creates new form Res
     */
    public Res() {
        initComponents();
        food();
        drink();
        sweet();
        
     
   
      String em = Empolyee.getempolyeename();
        il.setText(em);
      //  order();
      tf1.setText("0.00");
      tf4.setText("0.00");
        
       model4 = (DefaultTableModel) tb4.getModel(); 
        
    }
    
    public void cler(){
     model4.setRowCount(0);
         
         total = 0;
         String tot = String.valueOf(total);
         tf1.setText("0.00");
         tf4.setText("0.00");
         
         tf2.setText("");
         tf5.setText("");
    
    }
    
   
    
    //ตรวจเช็ครายการซ้ำ
    public boolean checkMenu(){
      //  selected=tb1.getSelectedRow();
      try {
        for (int i =0; i < tb4.getRowCount();i++){          
            
            if(select.equals(tb4.getValueAt(i,0))){
                
                n=i;
                System.out.println("รายการอาหารซ้ำกัน"+"ที่แถว="+n);
                return true;
            }
        }
       
        
         } catch (Exception e) {
 JOptionPane.showMessageDialog(this, e);
 }
       return false;
    }
    
    public void cfood(){
        try {
        
String jdbc = "jdbc:mysql://localhost:3306/rs?user=root&;password=";

String jdbcutf8 = "&useUnicode=true&characterEncoding=UTF-8";

connect = DriverManager.getConnection(jdbc+jdbcutf8);

s = connect.createStatement();


String sql = "SELECT * FROM food where Food_name = '"+select+"' ";


ResultSet rec = s.executeQuery(sql);

rec.next();

CheckFood c = new CheckFood();
c.setFoodid(rec.getString("Food_id"));
c.setFoodname(rec.getString("Food_name"));
c.setFoodprice(rec.getString("Food_price"));


        } catch (Exception e) {

// TODO Auto-generated catch block

JOptionPane.showMessageDialog(null, e.getMessage());

e.printStackTrace();

}


try {

if(s != null) {

s.close();

connect.close();

}

} catch (SQLException e) {

// TODO Auto-generated catch block

e.printStackTrace();

}
    
    }
    
    
    
     public void food(){
       
// Clear table

tb1.setModel(new DefaultTableModel());


// Model for Table

model = (DefaultTableModel) tb1.getModel();

model.addColumn("ชื่อ");

model.addColumn("ราคา");



    try {
       

Class.forName("com.mysql.jdbc.Driver");


connect =  DriverManager.getConnection("jdbc:mysql://localhost:3306/rs" +"?user=root&password=");

s = connect.createStatement();


String sql = "SELECT * FROM  food WHERE Food_type = 'food' ";


ResultSet rec = s.executeQuery(sql);

int row = 0;

while((rec!=null) && (rec.next()))

{ 
    
    model.addRow(new Object[0]);
    


model.setValueAt(rec.getString("Food_name"), row, 0);

model.setValueAt(rec.getString("Food_price"), row, 1);

row++;
    
}
rec.close();

} catch (Exception e) {

// TODO Auto-generated catch block

JOptionPane.showMessageDialog(null, e.getMessage());

e.printStackTrace();

}


try {

if(s != null) {

s.close();

connect.close();

}

} catch (SQLException e) {

// TODO Auto-generated catch block

e.printStackTrace();

}
}
     
     
     public void drink(){
       
// Clear table

tb2.setModel(new DefaultTableModel());


// Model for Table

model2 = (DefaultTableModel) tb2.getModel();

model2.addColumn("ชื่อ");

model2.addColumn("ราคา");



    try {
       

Class.forName("com.mysql.jdbc.Driver");


connect =  DriverManager.getConnection("jdbc:mysql://localhost:3306/rs" +"?user=root&password=");

s = connect.createStatement();


String sql = "SELECT * FROM  food WHERE Food_type = 'drink' ";


ResultSet rec = s.executeQuery(sql);

int row = 0;

while((rec!=null) && (rec.next()))

{ 
    
    model2.addRow(new Object[0]);
    


model2.setValueAt(rec.getString("Food_name"), row, 0);

model2.setValueAt(rec.getString("Food_price"), row, 1);

row++;
    
}
rec.close();

} catch (Exception e) {

// TODO Auto-generated catch block

JOptionPane.showMessageDialog(null, e.getMessage());

e.printStackTrace();

}


try {

if(s != null) {

s.close();

connect.close();

}

} catch (SQLException e) {

// TODO Auto-generated catch block

e.printStackTrace();

}
}
     
     
     public void sweet(){
       
// Clear table

tb3.setModel(new DefaultTableModel());


// Model for Table

model3 = (DefaultTableModel) tb3.getModel();

model3.addColumn("ชื่อ");

model3.addColumn("ราคา");



    try {
       

Class.forName("com.mysql.jdbc.Driver");

String jdbc = "jdbc:mysql://localhost:3306/rs?user=root&;password=";

String jdbcutf8 = "&useUnicode=true&characterEncoding=UTF-8";

connect = DriverManager.getConnection(jdbc+jdbcutf8);

s = connect.createStatement();


String sql = "SELECT * FROM  food WHERE Food_type = 'sweet' ";


ResultSet rec = s.executeQuery(sql);

int row = 0;

while((rec!=null) && (rec.next()))

{ 
    
    model3.addRow(new Object[0]);
    


model3.setValueAt(rec.getString("Food_name"), row, 0);

model3.setValueAt(rec.getString("Food_price"), row, 1);

row++;
    
}
rec.close();

} catch (Exception e) {

// TODO Auto-generated catch block

JOptionPane.showMessageDialog(null, e.getMessage());

e.printStackTrace();

}


try {

if(s != null) {

s.close();

connect.close();

}

} catch (SQLException e) {

// TODO Auto-generated catch block

e.printStackTrace();

}
}
     
     
     public void insertData3() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

String jdbc = "jdbc:mysql://localhost:3306/rs?user=root&;password=";

String jdbcutf8 = "&useUnicode=true&characterEncoding=UTF-8";

connect = DriverManager.getConnection(jdbc+jdbcutf8);

s = connect.createStatement();
             
            
            
            String sql2 = "select SName,Sprice,Snum,Stotalprice,SUM(Snum),SUM(Sprice),SUM(Stotalprice) from sporder  where SName = '"+select+"' Group by SName ";
            //String sql2 = "select * from food where Food_name = '"+select+"'";
            ResultSet rs = s.executeQuery(sql2);
            
            rs.next();
            
            //select();
           CheckFood c = new CheckFood(); 
           String g = rs.getString("SName");
          String r = CheckFood.getFoodname();
          
           int fid = Integer.parseInt(CheckFood.getFoodid());
         int sp = Integer.parseInt(rs.getString("Sprice"));
          int sn = Integer.parseInt(rs.getString("Snum"));
          int st = Integer.parseInt(rs.getString("Stotalprice"));
          int ssp = Integer.parseInt(rs.getString("SUM(Sprice)"));
          int ssn = Integer.parseInt(rs.getString("SUM(Snum)"));
          int sst = Integer.parseInt(rs.getString("SUM(Stotalprice)"));
          int a = Integer.parseInt(CheckFood.getFoodprice());
          int b = Integer.parseInt(jt1.getText());
if(g.equals(r)){
      String sql9 = "UPDATE sporder " +"SET  Sprice = '" +(a+ssp)+ "' " +", Snum = '" +(b+ssn)+ "' " +", Stotalprice = '" +(sst+a)+ "' where SName = '"+r+"' ";
       s.execute(sql9);
        
      
        
} else {
       
   String sql4 = "INSERT INTO sporder  " + "(Food_id,SName,Sprice,Snum,Stotalprice) " + "VALUES('"+fid+"',"+select+"','"+rs.getString("Food_price")+"','"+jt1.getText()+"','"+a*b+"')";
            //String sql = "INSERT INTO order " + "(Emailsa,Totalprice,Status) " + "VALUES('ISO','66','complete')";
           s.execute(sql4);

}

        } catch (Exception e) {
            e.printStackTrace();
        }
     }
     
     
     
     
   /*   public void select() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

String jdbc = "jdbc:mysql://localhost:3306/rs?user=root&;password=";

String jdbcutf8 = "&useUnicode=true&characterEncoding=UTF-8";

connect = DriverManager.getConnection(jdbc+jdbcutf8);

s = connect.createStatement();
             
            
            
            String sql2 = "select SName,Sprice,Snum,Stotalprice,Food_id,SUM(Snum),SUM(Sprice),SUM(Stotalprice) from sporder  Group by SName ";
            
            ResultSet re = s.executeQuery(sql2);
            
            re.next();
            
            
            
           String g = re.getString("SName");
           
           int sp = Integer.parseInt(re.getString("Sprice"));
           int sn = Integer.parseInt(re.getString("Snum"));
           int st = Integer.parseInt(re.getString("Stotalprice"));
           int ssp = Integer.parseInt(re.getString("SUM(Sprice)"));
          int ssn = Integer.parseInt(re.getString("SUM(Snum)"));
          int sst = Integer.parseInt(re.getString("SUM(Stotalprice)"));
       


        } catch (Exception e) {
            e.printStackTrace();
        }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb4 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        bt5 = new javax.swing.JButton();
        bt6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jt1 = new javax.swing.JTextField();
        bt1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb2 = new javax.swing.JTable();
        jt2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        bt2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb3 = new javax.swing.JTable();
        jt3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        bt3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbtotal = new javax.swing.JLabel();
        lbtotal1 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        tf4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        clear = new javax.swing.JButton();
        clear1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lbtotal3 = new javax.swing.JLabel();
        tf2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        lbtotal2 = new javax.swing.JLabel();
        tf5 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        clear2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        j11 = new javax.swing.JLabel();
        il = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(248, 248, 248));

        jPanel2.setBackground(new java.awt.Color(248, 248, 248));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setFocusable(false);

        tb4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ชื่อ", "ราคา", "จำนวน", "ราคารวม"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tb4);

        jLabel8.setFont(new java.awt.Font("TP Tankhun", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("รายการอาหารทั้งหมด");

        bt5.setText("ลบ");
        bt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt5ActionPerformed(evt);
            }
        });

        bt6.setText("แก้ไขจำนวน");
        bt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(bt5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(bt6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
        );

        tb1.setFont(new java.awt.Font("TP Tankhun", 1, 19)); // NOI18N
        tb1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ชื่อ", "ราคา"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb1);

        jLabel1.setFont(new java.awt.Font("TP Tankhun", 1, 30)); // NOI18N
        jLabel1.setText("รายการอาหาร");

        jt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt1ActionPerformed(evt);
            }
        });

        bt1.setText("ตกลง");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });

        jLabel5.setText("จำนวน");

        tb2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ชื่อ", "ราคา"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb2);

        jt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt2ActionPerformed(evt);
            }
        });

        jLabel6.setText("จำนวน");

        bt2.setText("ตกลง");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("TP Tankhun", 1, 30)); // NOI18N
        jLabel3.setText("ของหวาน");

        tb3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ชื่อ", "ราคา"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb3);

        jt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt3ActionPerformed(evt);
            }
        });

        jLabel7.setText("จำนวน");

        bt3.setText("ตกลง");
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("TP Tankhun", 1, 30)); // NOI18N
        jLabel2.setText("เครื่องดื่ม");

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        lbtotal.setBackground(new java.awt.Color(255, 255, 255));
        lbtotal.setFont(new java.awt.Font("TH Sarabun New", 0, 24)); // NOI18N
        lbtotal.setText("ราคารวม");

        lbtotal1.setBackground(new java.awt.Color(255, 255, 255));
        lbtotal1.setFont(new java.awt.Font("TH Sarabun New", 0, 24)); // NOI18N
        lbtotal1.setText("ราคาสุทธิ");

        tf1.setEditable(false);
        tf1.setFont(new java.awt.Font("TP Tankhun", 0, 30)); // NOI18N
        tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf1ActionPerformed(evt);
            }
        });

        tf4.setEditable(false);
        tf4.setFont(new java.awt.Font("TP Tankhun", 0, 30)); // NOI18N
        tf4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf4ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("TH Sarabun New", 0, 24)); // NOI18N
        jLabel9.setText("บาท");

        jLabel10.setFont(new java.awt.Font("TH Sarabun New", 0, 24)); // NOI18N
        jLabel10.setText("บาท");

        clear.setBackground(new java.awt.Color(255, 51, 51));
        clear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        clear.setText("ยกเลิก");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        clear1.setBackground(new java.awt.Color(102, 255, 102));
        clear1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        clear1.setText("ชำระ");
        clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear1ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(251, 251, 251));

        lbtotal3.setBackground(new java.awt.Color(255, 255, 255));
        lbtotal3.setFont(new java.awt.Font("TH Sarabun New", 0, 24)); // NOI18N
        lbtotal3.setText("รหัสสมาชิก");

        tf2.setFont(new java.awt.Font("TP Tankhun", 0, 30)); // NOI18N
        tf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf2ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 255, 51));
        jButton2.setText("ตกลง");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lbtotal2.setBackground(new java.awt.Color(255, 255, 255));
        lbtotal2.setFont(new java.awt.Font("TH Sarabun New", 0, 24)); // NOI18N
        lbtotal2.setText("รหัสคูปองส่วนลด");

        tf5.setFont(new java.awt.Font("TP Tankhun", 0, 30)); // NOI18N
        tf5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf5ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 255, 51));
        jButton3.setText("ตกลง");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtotal3)
                    .addComponent(lbtotal2))
                .addGap(38, 38, 38)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf5, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(tf2))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(32, 32, 32))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtotal3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtotal2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        clear2.setBackground(new java.awt.Color(255, 255, 51));
        clear2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        clear2.setText("ล้างการสั่งซื้อ");
        clear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbtotal)
                        .addGap(43, 43, 43)
                        .addComponent(tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbtotal1)
                        .addGap(43, 43, 43)
                        .addComponent(tf4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clear2)
                .addGap(127, 127, 127))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(clear1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(lbtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbtotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(71, 71, 71)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clear1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(clear2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(113, 113, 113)
                                    .addComponent(jLabel3))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jt1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bt1))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jt2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bt2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jt3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bt3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(bt1))
                        .addGap(7, 7, 7)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt2))
                        .addGap(0, 0, 0)
                        .addComponent(jLabel3)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt3))
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        jLabel12.setFont(new java.awt.Font("TP Tankhun", 1, 48)); // NOI18N
        jLabel12.setText("MadeMyDay Rastrurant");

        j11.setText(" ผู้ใช้งานระบบ :");

        il.setText("xxxxxxxx");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(j11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(il)
                        .addGap(385, 385, 385)
                        .addComponent(jLabel12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 36, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(j11)
                        .addComponent(il))
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));

        jMenu1.setText("File");

        jMenuItem6.setText("ผู้พัฒนาโปรแกรม");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem4.setText("ออกจากโปรแกรม");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Menu");

        jMenuItem1.setText("เพิ่มเมนูอาหาร");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("สมัครสมาชิก");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("เพิ่มคูปอง");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem5.setText("เพิ่มผู้ใช้งานระบบ");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb4MouseClicked
      ss = tb4.getSelectedRow();
              
    }//GEN-LAST:event_tb4MouseClicked

    private void bt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt5ActionPerformed
        //คำนวนเงินใหม่ //เมดธอดreplace ตัวแรกคือค่าเดิมมีคอมมา เราจะแทนที่ด้วยช่องว่างทำให้ลบได้
 if(tb4.isRowSelected(ss)){ 
        
        double moneySelected =Double.valueOf(tb4.getValueAt(ss,3).toString().replace(",","" ));
        System.out.println("แสดงจำนวนเงินที่ลบ ="+moneySelected);
        total-=moneySelected;
        tf1.setText(df.format(total));
         tf4.setText(df.format(total));
         
        
         if(total==0)
            tf1.setText("0.00");
            
         
        //ลบ
        model4.removeRow(ss);
        }
       
        else if(tb4.isRowSelected(ss)){ 
        
        double moneySelected2 =Double.valueOf(tb4.getValueAt(ss,3).toString().replace(",","" ));
        System.out.println("แสดงจำนวนเงินที่ลบ ="+moneySelected2);
        total-=moneySelected2;
         tf1.setText(df.format(total));
         tf4.setText(df.format(total));
       
        
         if(total==0)
            
            tf4.setText("0.00");
         
        //ลบ
        model4.removeRow(ss);
        }
        
        else {
        JOptionPane.showMessageDialog(this,"กรุณาเลือกรายการที่ต้องการลบ","คำเตือน" ,JOptionPane.ERROR_MESSAGE);
        }
        
       
    }//GEN-LAST:event_bt5ActionPerformed

    private void bt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt6ActionPerformed
        //ราคาก่อนแก้ไข
    if(tb4.isRowSelected(ss)){
            
           int before=Integer.parseInt(tb4.getValueAt(ss, 1).toString())*Integer.parseInt(tb4.getValueAt(ss, 2).toString().replace(",","" ));
           System.out.println("befor="+before);
            
       
        JOptionPane optionPane = new JOptionPane ( );
        optionPane.setWantsInput ( true );
        optionPane.setMessageType ( JOptionPane.QUESTION_MESSAGE );
        optionPane.setOptionType ( JOptionPane.OK_CANCEL_OPTION );
        optionPane.setMessage ( "ป้อนจำนวนที่ต้องการ" );
        JDialog dialog = optionPane.createDialog ( null, "หน้าต่างป้อนำนวน" );
        dialog.setVisible ( true );
        Integer selectedButton = ( Integer ) optionPane.getValue ( );
        
        if ( selectedButton == JOptionPane.OK_OPTION ){
            
            

   
                       String inputValue = ( String ) optionPane.getInputValue().toString();
                       
                       if(inputValue.isEmpty()){
                           JOptionPane.showMessageDialog(this,"กรุณาป้อนจำนวนที่ต้องการแก้ไข","คำเตือน" ,JOptionPane.ERROR_MESSAGE);
                       }else{
                      
                   
                        tb4.setValueAt(inputValue,ss,2 );
                        int amount=Integer.valueOf(inputValue);

                        int bnew=amount*Integer.parseInt(tb4.getValueAt(ss, 1).toString().replace(",","" ));
                        tb4.setValueAt(df.format(bnew),ss, 3);
                        System.out.println("ราคาใหม่"+bnew);
                        total=total-(before)+(bnew); 
                        System.out.println("ราคาใหม่="+total);
                      
                       tf1.setText(df.format(total));
                       tf4.setText(df.format(total));
                      
                       }
              
                      
          
            }

       } 
       else {   
            JOptionPane.showMessageDialog(this,"กรุณาเลือกรายการที่ต้องการแก้ไข","คำเตือน" ,JOptionPane.ERROR_MESSAGE);
           }
       

    }//GEN-LAST:event_bt6ActionPerformed

    private void tb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb1MouseClicked
    se = tb1.getSelectedRow();
    select = (String) tb1.getValueAt(se, 0);
    }//GEN-LAST:event_tb1MouseClicked

    private void jt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt1ActionPerformed

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
    //  insertData3();
//      order();
        
       Vector v = new Vector();
       
        if(jt1.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"กรุณาป้อนจำนวนอาหาร","คำเตือน" ,JOptionPane.ERROR_MESSAGE);
        }
       if(checkMenu()){
            int numfood = Integer.parseInt(tb4.getValueAt(n, 2).toString())+Integer.parseInt(jt1.getText());
            System.out.println("a="+numfood);
            int totalprice = numfood*Integer.parseInt(tb4.getValueAt(n, 1).toString());
            model4.setValueAt(numfood,n,2);
            model4.setValueAt(df.format(totalprice),n,3);
            int b = Integer.parseInt(jt1.getText().toString());    
        v.add(b);
            int i = Integer.parseInt(tb1.getValueAt(selected, 1).toString());
        money = i*b;
            total+=money;
            tf1.setText(df.format(total));
        } else {
         
        //นำข้อมูลลงมาในตาราง
       selected=tb1.getSelectedRow();
        v.add(tb1.getValueAt(selected,0));
        v.add(tb1.getValueAt(selected,1));
        int b = Integer.parseInt(jt1.getText().toString());    
        v.add(b);
        int i = Integer.parseInt(tb1.getValueAt(selected, 1).toString());
        money = i*b;
        total+=money;
        v.add(df.format(money));
        tf1.setText(df.format(total));
        tf4.setText(df.format(total));
        model4.addRow(v);
        
        
         
       
       }
    }//GEN-LAST:event_bt1ActionPerformed

    private void jt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt2ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
 Vector v = new Vector();
       
        if(jt2.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"กรุณาป้อนจำนวนอาหาร","คำเตือน" ,JOptionPane.ERROR_MESSAGE);
        }
       if(checkMenu()){
            int w = Integer.parseInt(tb4.getValueAt(n, 2).toString())
             +Integer.parseInt(jt2.getText());
            System.out.println("a="+w);
            int e = w*Integer.parseInt(tb4.getValueAt(n, 1).toString());
             
            model4.setValueAt(w, n,2);
            model4.setValueAt(df.format(e), n,3);
             
            int b = Integer.parseInt(jt2.getText().toString());    
        v.add(b);
            int i = Integer.parseInt(tb2.getValueAt(selected, 1).toString());
        money = i*b;
            total+=money;
            tf1.setText(df.format(total));
          
        } else {
         
        //นำข้อมูลลงมาในตาราง
       selected=tb2.getSelectedRow();
        v.add(tb2.getValueAt(selected,0));
        v.add(tb2.getValueAt(selected,1));
        int b = Integer.parseInt(jt2.getText().toString());    
        v.add(b);
        int i = Integer.parseInt(tb2.getValueAt(selected, 1).toString());
        money = i*b;
        total+=money;
        v.add(df.format(money));
        tf1.setText(df.format(total));
        tf4.setText(df.format(total));
        model4.addRow(v);
       
       }
        
       
       
    }//GEN-LAST:event_bt2ActionPerformed

    private void jt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt3ActionPerformed

    }//GEN-LAST:event_jt3ActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
Vector v = new Vector();
       
        if(jt3.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"กรุณาป้อนจำนวนอาหาร","คำเตือน" ,JOptionPane.ERROR_MESSAGE);
        }
       if(checkMenu()){
            int w = Integer.parseInt(tb4.getValueAt(n, 2).toString())
             +Integer.parseInt(jt3.getText());
            System.out.println("a="+w);
            int e = w*Integer.parseInt(tb4.getValueAt(n, 1).toString());
             
            model4.setValueAt(w, n,2);
            model4.setValueAt(df.format(e), n,3);
             int b = Integer.parseInt(jt3.getText().toString());    
        v.add(b);
            int i = Integer.parseInt(tb3.getValueAt(selected, 1).toString());
        money = i*b;
            total+=money;
            tf1.setText(df.format(total));
          
        } else {
         
        //นำข้อมูลลงมาในตาราง
       selected=tb3.getSelectedRow();
        v.add(tb3.getValueAt(selected,0));
        v.add(tb3.getValueAt(selected,1));
        int b = Integer.parseInt(jt3.getText().toString());    
        v.add(b);
        int i = Integer.parseInt(tb3.getValueAt(selected, 1).toString());
        money = i*b;
        total+=money;
        v.add(df.format(money));
        tf1.setText(df.format(total));
        tf4.setText(df.format(total));
        model4.addRow(v);
       
       }
              

    }//GEN-LAST:event_bt3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
 Dev d = new Dev(); 
 d.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
         this.dispose();
        Login in = new Login();
        in.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
     //   this.dispose();
        AddFood add = new AddFood();
        add.setVisible(true);        

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
  AddMember f = new AddMember();
  f.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // this.dispose();
        AddCoupon add = new AddCoupon();
        add.setVisible(true);       
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void tb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb2MouseClicked
se = tb2.getSelectedRow();
    select = (String) tb2.getValueAt(se, 0);
    }//GEN-LAST:event_tb2MouseClicked

    private void tb3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb3MouseClicked
se = tb3.getSelectedRow();
select = (String) tb3.getValueAt(se, 0);
    }//GEN-LAST:event_tb3MouseClicked

    private void clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear1ActionPerformed
       

        int rows = tb4.getRowCount();

      

            try{
                String jdbc = "jdbc:mysql://localhost:3306/rs?user=root&;password=";

                String jdbcutf8 = "&useUnicode=true&characterEncoding=UTF-8";

                connect = DriverManager.getConnection(jdbc+jdbcutf8);

                s = connect.createStatement();

                String ss = "SELECT MAX(Order_id) AS new_order FROM `order`";

                ResultSet rs = s.executeQuery(ss);

                rs.next();

                int orid = Integer.parseInt(rs.getString("new_order"));
                
               
               
                 
                
                String sql = "INSERT INTO `order` "+ "(Order_id,Food_name,Food_price,Food_total,Food_sumtotal,Or_totalprice,Or_netprice,Or_discount,Mem_id,Cou_id,Or_sumtotal,Em_id)"+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";
                pst = connect.prepareStatement(sql);

                int od;
              
                String fn;
                
                double pri;
               
                int tt;
                
                double sp;
                
                double ttp;
                
                double np;
               
                double dis;
                
                int mid;
                
                int cid;
                
                
                
                for(int row = 0 ; row<rows;row++){
                    
                    Order or = new Order();
                    Foods f = new Foods();
                    //
                    od = (orid+1);
                    or.setorderid(od);
                    //
                    fn = tb4.getValueAt(row, 0).toString();
                    f.setfoodname(fn);
                    //
                    pri = Double.valueOf(tb4.getValueAt(row, 1).toString().replace(",","" ));
                    f.setfoodprice(pri);
                    //
                    tt = Integer.parseInt(tb4.getValueAt(row, 2).toString());
                    or.settotal(tt);
                    //
                    sp = Double.valueOf(tb4.getValueAt(row,3).toString().replace(",","" ));
                    or.setsumprice(sp);
                    //
                    ttp = Double.valueOf(tf1.getText().replace(",","" ));
                    or.settotaoprice(ttp+.0);
                    //
                    np = Double.valueOf(tf4.getText().replace(",","" ));
                    or.setnetprice(np);
                    //
                    dis = ttp-np;
                    or.setdiscount(dis);
                    
                    
                    
                    //

                    if( tf2.getText().isEmpty()){
                        mid = 0;

                    } else{
                        mid = Member.getMemid();
                    }

                    //
                    if(tf5.getText().isEmpty()){
                        cid = 0;
                    }
                    else{
                        cid = Coupons.getcouid();
                    }
                         int tpp=0;   
                    for(int ro = 0 ; ro<rows;ro++){
                    int  tot = Integer.parseInt(tb4.getValueAt(ro, 2).toString());
                     tpp += tot;
                     or.setsumtotal(tpp);
                     }
                    
                    
                    

                    pst.setInt(1,Order.getorderid());
                    pst.setString(2,Foods.getfoodname());
                    pst.setDouble(3,Foods.getfoodprice());
                    pst.setInt(4,Order.gettotal());
                    pst.setDouble(5,Order.getsumprice());
                    pst.setDouble(6,Order.gettotalprice());
                    pst.setDouble(7,Order.getnetprice());
                    pst.setDouble(8,Order.getdiscount());
                    pst.setInt(9,mid);
                    pst.setInt(10,cid);
                    pst.setInt(11,Order.getsumtotal());
                    pst.setInt(12,Empolyee.getEmid());
                    pst.addBatch();

                }

                pst.executeBatch();

            } catch (Exception e) {

                // TODO Auto-generated catch block

                JOptionPane.showMessageDialog(null, e.getMessage());

                e.printStackTrace();

            }

            try {

                if(s != null) {

                    s.close();

                    connect.close();

                }

            } catch (SQLException e) {

                // TODO Auto-generated catch block

                e.printStackTrace();

            }
            Payment p = new Payment();
            p.setVisible(true);
    }//GEN-LAST:event_clear1ActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        //ล้างตารางทั้งหมด
        model4.setRowCount(0);

        total = 0;
        String tot = String.valueOf(total);
        tf1.setText("0.00");
        tf4.setText("0.00");

        tf2.setText("");
        tf5.setText("");

    }//GEN-LAST:event_clearActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
            String jdbc = "jdbc:mysql://localhost:3306/rs?user=root&;password=";

            String jdbcutf8 = "&useUnicode=true&characterEncoding=UTF-8";

            connect = DriverManager.getConnection(jdbc+jdbcutf8);

            s = connect.createStatement();
            
             Coupons ac = new Coupons();
            int cid = Integer.parseInt(tf5.getText());
            ac.setcouid(cid);

            String sql = "SELECT * FROM coupon WHERE Cou_id = '"+Coupons.getcouid()+"'";

            ResultSet rec = s.executeQuery(sql);

            if(rec.next()){
                ac.setcouname(rec.getString("Cou_name"));
                int dis = Integer.parseInt(rec.getString("Cou_discount"));
                ac.setcoudis(dis);

                JOptionPane.showMessageDialog(this, "รับส่วนลด "+Coupons.getcouname()+" "+Coupons.getcoudis()+"%");
                
                total -=((total*dis)/100);
                tf4.setText(df.format(total));
                //  tf4.setText(df.format(total-((total*dis)/100)));

            }
            else{
                JOptionPane.showMessageDialog(null, "ไม่คูปอง");
                tf4.setText(df.format(total));
            }

        } catch (Exception e) {

            // TODO Auto-generated catch block

            JOptionPane.showMessageDialog(null, e.getMessage());

            e.printStackTrace();

        }

        try {

            if(s != null) {

                s.close();

                connect.close();

            }

        } catch (SQLException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            String jdbc = "jdbc:mysql://localhost:3306/rs?user=root&;password=";

            String jdbcutf8 = "&useUnicode=true&characterEncoding=UTF-8";

            connect = DriverManager.getConnection(jdbc+jdbcutf8);

            s = connect.createStatement();
            
            Member mb = new Member();
            int mid = Integer.parseInt(tf2.getText());
            mb.setMemid(mid);

            String sql = "SELECT * FROM member where Mem_id = '"+Member.getMemid()+"'";
            
            ResultSet rec = s.executeQuery(sql);

            if(rec.next()){
                 mb.setMemname(rec.getString("Mem_name"));
                JOptionPane.showMessageDialog(this, "คุณ "+Member.getMemname()+" ได้รับส่วนลดสมาชิก 15% เรียบร้อยแล้ว");
                total -=(total*0.15);
                tf4.setText(df.format(total));

            }
            else{
                JOptionPane.showMessageDialog(null, "ไม่พบรหัสลูกค้า");
                tf4.setText(df.format(total));
            }

        } catch (Exception e) {

            // TODO Auto-generated catch block

            JOptionPane.showMessageDialog(null, e.getMessage());

            e.printStackTrace();

        }

        try {

            if(s != null) {

                s.close();

                connect.close();

            }

        } catch (SQLException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void tf4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf4ActionPerformed

    private void tf5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf5ActionPerformed

    private void tf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf2ActionPerformed

    private void tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf1ActionPerformed

    private void clear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear2ActionPerformed
        //ล้างตารางทั้งหมด
        model4.setRowCount(0);

        total = 0;
        String tot = String.valueOf(total);
        tf1.setText("0.00");
        tf4.setText("0.00");

        tf2.setText("");
        tf5.setText("");

    }//GEN-LAST:event_clear2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Res.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Res.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Res.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Res.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Res().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt5;
    private javax.swing.JButton bt6;
    private javax.swing.JButton clear;
    private javax.swing.JButton clear1;
    private javax.swing.JButton clear2;
    private javax.swing.JLabel il;
    private javax.swing.JLabel j11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jt1;
    private javax.swing.JTextField jt2;
    private javax.swing.JTextField jt3;
    private javax.swing.JLabel lbtotal;
    private javax.swing.JLabel lbtotal1;
    private javax.swing.JLabel lbtotal2;
    private javax.swing.JLabel lbtotal3;
    private javax.swing.JTable tb1;
    private javax.swing.JTable tb2;
    private javax.swing.JTable tb3;
    private javax.swing.JTable tb4;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf4;
    private javax.swing.JTextField tf5;
    // End of variables declaration//GEN-END:variables
}
