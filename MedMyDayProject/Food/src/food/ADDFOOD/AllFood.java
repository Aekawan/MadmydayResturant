package food.ADDFOOD;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BankSE
 */
public class AllFood extends javax.swing.JFrame {
    
    Foods af = new Foods();
    
    Connection connect = null;

    Statement s = null;
    
    String edit;
    
    int edits;
    
    String xname =null;
   
   DefaultTableModel model,model2,model3;

    /**
     * Creates new form AllFood
     */
    public AllFood() {
        initComponents();
        food();
        drink();
        sweet();
       
        
      
      
    }
    
    public void select(){
    try {

Class.forName("com.mysql.jdbc.Driver");

String jdbc = "jdbc:mysql://localhost:3306/rs?user=root&;password=";

String jdbcutf8 = "&useUnicode=true&characterEncoding=UTF-8";

connect = DriverManager.getConnection(jdbc+jdbcutf8);

s = connect.createStatement();



String sql3 = "SELECT * FROM  food WHERE Food_name= '"+edit+"'";
ResultSet rec = s.executeQuery(sql3);


while(rec.next()){
tf1.setText(rec.getString("Food_name"));
tf2.setText(rec.getString("Food_price"));
tf3.setText(rec.getString("Food_type"));

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
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb3 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tf3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jToggleButton2 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

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

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("รายการอาหารทั้งหมด");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("รายการอาหาร");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("เครื่องดื่ม");

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
        jScrollPane3.setViewportView(tb2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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
        jScrollPane2.setViewportView(tb3);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("แก้ไขรายการอาหาร");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ชื่อ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ราคา");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ประเภท");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf1, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(tf2)
                            .addComponent(tf3))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setText("ปิด");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setText("ลบเมนูอาหาร");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jToggleButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jToggleButton2.setText("แก้ไข");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel1)
                        .addGap(408, 408, 408))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(jLabel2))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(jLabel3))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(26, 26, 26))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb1MouseClicked
   edits = tb1.getSelectedRow();
   edit = tb1.getValueAt(edits, 0).toString();
   select();
    }//GEN-LAST:event_tb1MouseClicked

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
 try {

Class.forName("com.mysql.jdbc.Driver");

String jdbc = "jdbc:mysql://localhost:3306/rs?user=root&;password=";

String jdbcutf8 = "&useUnicode=true&characterEncoding=UTF-8";

connect = DriverManager.getConnection(jdbc+jdbcutf8);

s = connect.createStatement();

String tt = tf1.getText();

af.setfoodname(tt);

String sql3 = "SELECT Food_name FROM food WHERE Food_name = '"+Foods.getfoodname()+"'";
ResultSet rec = s.executeQuery(sql3);


//String xname = rec.getString("Food_name");


  if (rec.next()) {
                    JOptionPane.showMessageDialog(null,"มีชื่ออาหารนี้ในระบบแล้ว");
            } else {
int fp = Integer.parseInt(tf2.getText());
af.setfoodname(tf1.getText());
af.setfoodprice(fp);
af.setfoodtype(tf3.getText());

String sql = "UPDATE food " +"SET  Food_name = '" + Foods.getfoodname() + "' , Food_price = '" + Foods.getfoodprice() + "' , Food_type = '" + Foods.getfoodtype() + "' WHERE Food_name = '"+edit+"'";

s.execute(sql);

 

JOptionPane.showMessageDialog(null, "แก้ไขข้อมูลเสร็จสิ้น");

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

System.out.println(e.getMessage());

e.printStackTrace();

}

food();
drink();
sweet();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     this.dispose();
        AddFood add = new AddFood();
        add.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb2MouseClicked
     edits = tb2.getSelectedRow();
     edit = tb2.getValueAt(edits, 0).toString();
       select();
    }//GEN-LAST:event_tb2MouseClicked

    private void tb3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb3MouseClicked
      edits = tb3.getSelectedRow();
   edit = tb3.getValueAt(edits, 0).toString();
       select();
    }//GEN-LAST:event_tb3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    
        int index = edits;

if (index < 0) {

JOptionPane.showMessageDialog(null,"กรุณาเลือกข้อมูลที่ต้องการลบ!");

} else {

String fna = edit;

Object[] options = { "ใช่", "ไม่" };

int n = JOptionPane.showOptionDialog(null,"ต้องการลบข้อมูล?","Confirm to Delete?",
        JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, options,options[1]);

if (n == 0) // Confirm Delete = Yes

{
   
    
        try {

Class.forName("com.mysql.jdbc.Driver");

String jdbc = "jdbc:mysql://localhost:3306/rs?user=root&;password=";

String jdbcutf8 = "&useUnicode=true&characterEncoding=UTF-8";

connect = DriverManager.getConnection(jdbc+jdbcutf8);

s = connect.createStatement();


  
String sql = "DELETE FROM food  WHERE Food_name = '"+edit+"'";

s.execute(sql);

 

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

System.out.println(e.getMessage());

e.printStackTrace();

}

food();
drink();
sweet();
}
JOptionPane.showMessageDialog(null, "ลบข้อมูลสำเร็จ");
}
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(AllFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AllFood().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JTable tb1;
    private javax.swing.JTable tb2;
    private javax.swing.JTable tb3;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    // End of variables declaration//GEN-END:variables
}
