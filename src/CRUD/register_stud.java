package CRUD;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class register_stud extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement sql;
    String studid;

    public register_stud() {
        initComponents();
        table_refresh();
        table_style();
        table_text_alignment();
    }

    private void table_style() {
        studtable.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 12));
        studtable.getTableHeader().setOpaque(false);
        studtable.getTableHeader().setBackground(new Color(32, 136, 203));
        studtable.getTableHeader().setForeground(new Color(255, 255, 255));
        studtable.setRowHeight(25);
    }

    private void updateDuplicateValidation() {
        try {
            System.out.println(this.studnametxt.getText());
            String studname = studnametxt.getText();
            dbh();
            sql = conn.prepareStatement("select * from student");
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {
                if (rs.getString("stud_name").equals(studname)) {
                    System.out.println("False");
                    updatebtn.setEnabled(false);
                    break;
                } else {
                    updatebtn.setEnabled(true);
                    System.out.println("True");

                }
            }

        } catch (Exception x) {
            JOptionPane.showMessageDialog(this, x.getMessage());
        }
    }

    private void table_text_alignment() {
        DefaultTableCellRenderer rendar = new DefaultTableCellRenderer();
        rendar.setHorizontalAlignment(jLabel1.CENTER);
        for (int i = 0; i < studtable.getColumnCount(); i++) {
            studtable.getColumnModel().getColumn(i).setCellRenderer(rendar);
        }
        ((DefaultTableCellRenderer) studtable.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        studnametxt = new javax.swing.JTextField();
        contacttxt = new javax.swing.JTextField();
        coursetxt = new javax.swing.JTextField();
        addbtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        studtable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setText("Student Registration");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setText("Student Name");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setText("Contact #");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setText("Course");

        studnametxt.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        studnametxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                studnametxtKeyReleased(evt);
            }
        });

        contacttxt.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        coursetxt.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        addbtn.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        addbtn.setText("ADD");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        updatebtn.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        updatebtn.setText("Update");
        updatebtn.setEnabled(false);
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(coursetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(addbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(updatebtn))
                            .addComponent(studnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contacttxt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(studnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addComponent(contacttxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(coursetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addbtn)
                    .addComponent(updatebtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        studtable.setBackground(new java.awt.Color(230, 230, 230));
        studtable.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        studtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Contact", "Course"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        studtable.setGridColor(new java.awt.Color(255, 255, 255));
        studtable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        studtable.setRowHeight(25);
        studtable.setSelectionBackground(new java.awt.Color(204, 0, 102));
        studtable.getTableHeader().setReorderingAllowed(false);
        studtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(studtable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void dbh() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/javacrud", "root", "magantokim099");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void table_refresh() {
        try {

            int c;

            dbh();

            sql = conn.prepareStatement("select * from student");
            ResultSet rs = sql.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            c = rsmd.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) studtable.getModel();
            df.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();

                for (int a = 1; a <= c; a++) {
                    v.add(rs.getString("stud_id"));
                    v.add(rs.getString("stud_name"));
                    v.add(rs.getString("contact"));
                    v.add(rs.getString("stud_course"));
                }
                df.addRow(v);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        String studname = studnametxt.getText();
        String contact = contacttxt.getText();
        String course = coursetxt.getText();

        try {
            boolean status = false;
            dbh();
            sql = conn.prepareStatement("select * from student");
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {
                if (rs.getString("stud_name").equals(studname)) {
                    System.out.println("String " + studname);
                    System.out.println("Database data " + rs.getString("stud_name"));
                    JOptionPane.showMessageDialog(null, "Registered already", "Transaction Error!", JOptionPane.ERROR_MESSAGE);
                    status = true;
                    break;
                }
            }
            if (status == false) {
                sql = conn.prepareStatement("insert into student(stud_name,contact,stud_course) values(?,?,?)");

                sql.setString(1, studname);
                sql.setString(2, contact);
                sql.setString(3, course);

                sql.executeUpdate();

                JOptionPane.showMessageDialog(this, "Record Added");
                studnametxt.setText("");
                contacttxt.setText("");
                coursetxt.setText("");

                studnametxt.requestFocus();
                table_refresh();

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_addbtnActionPerformed

    private void studtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studtableMouseClicked
        try {

            DefaultTableModel df = (DefaultTableModel) studtable.getModel();
            int selectedIndex = studtable.getSelectedRow();

            studid = df.getValueAt(selectedIndex, 0).toString();
            studnametxt.setText(df.getValueAt(selectedIndex, 1).toString());
            contacttxt.setText(df.getValueAt(selectedIndex, 2).toString());
            coursetxt.setText(df.getValueAt(selectedIndex, 3).toString());
            
            updateDuplicateValidation();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_studtableMouseClicked

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
//        try {
//            String studname = studnametxt.getText();
//            String contact = contacttxt.getText();
//            String course = coursetxt.getText();
//            
//            boolean status = false;
//            dbh();
//            sql = conn.prepareStatement("select * from student");
//            ResultSet rs = sql.executeQuery();
//            while (rs.next()) {
//                if (rs.getString("stud_name").equals(studname)) {
//                    System.out.println("String " + studname);
//                    System.out.println("Database data " + rs.getString("stud_name"));
//                    JOptionPane.showMessageDialog(null, "Registered already", "Transaction Error!", JOptionPane.ERROR_MESSAGE);
//                    status = true;
//                    break;
//                }
//            }
//        } catch (Exception e) {
//
//        }

    }//GEN-LAST:event_updatebtnActionPerformed

    private void studnametxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studnametxtKeyReleased
        updateDuplicateValidation();
    }//GEN-LAST:event_studnametxtKeyReleased

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(register_stud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(register_stud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(register_stud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(register_stud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new register_stud().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JTextField contacttxt;
    private javax.swing.JTextField coursetxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField studnametxt;
    private javax.swing.JTable studtable;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
