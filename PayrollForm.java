/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.firstflatlaf;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Mallari
 */
public class PayrollForm extends javax.swing.JFrame {

    //temporary database
    private Database db = new Database();
    private static final String URL = "jdbc:mysql://localhost:3306/db_employee_management";
    private static final String USER = "root";
    private static final String PASSWORD = "!M@rkcc16";

    //hold data
    private String empIdString, empIdSalary;

    private Payroll payroll;
    //for row
    private int rowEmpPayrollId;
    private int rowEmpId;
    private double rowEmpSalary;

    //dashboard
    private BasicGUI gui;

    private UpdatePayrollForm upf;

    private TableRowSorter<DefaultTableModel> rowSorter;

    public PayrollForm() {
        initComponents();
        displayPayrollTable();

        //placeholder
        txtFieldSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search");
        //icons
        txtFieldSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("svg/search.svg"));
        btnAddSalary.setIcon(new FlatSVGIcon("svg/salary.svg"));
        btnBackToDashboard.setIcon(new FlatSVGIcon("svg/back.svg"));

        //validate and filter character in textfield
        txtFieldEmpId.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }

        });

        txtFieldSalary.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }

        });
    }

    private void displayPayrollTable() {
        String[] columns = {"Payroll ID", "Employee ID", "Salary"};

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM payroll";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int payrollId = rs.getInt("id");
                int employeeId = rs.getInt("employee_id");
                double empSalary = rs.getDouble("salary");

                model.addRow(new Object[]{
                    payrollId,
                    employeeId,
                    empSalary
                });
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        tblEmployeePayroll.setModel(model);
        tblEmployeePayroll.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        searchEmployeePayroll(model);

        tblEmployeePayroll.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tblEmployeePayroll.getSelectedRow();

                if (row != -1) {
                    rowEmpPayrollId = (Integer) tblEmployeePayroll.getValueAt(row, 0);
                    rowEmpId = (Integer) tblEmployeePayroll.getValueAt(row, 1);
                    rowEmpSalary = (Double) tblEmployeePayroll.getValueAt(row, 2);

                    if (upf == null || !upf.isDisplayable()) {
                        upf = new UpdatePayrollForm(rowEmpPayrollId, rowEmpId, rowEmpSalary);
                        upf.setVisible(true);
                        disposeForm();
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployeePayroll = new javax.swing.JTable();
        btnAddSalary = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtFieldEmpId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFieldSalary = new javax.swing.JTextField();
        btnBackToDashboard = new javax.swing.JButton();
        txtFieldSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee Payroll");

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel1.setText("Employee Payroll");

        tblEmployeePayroll.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblEmployeePayroll);

        btnAddSalary.setBackground(new java.awt.Color(102, 153, 255));
        btnAddSalary.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        btnAddSalary.setText("ADD EMPLOYEE SALARY");
        btnAddSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSalaryActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel2.setText("Employee ID");

        txtFieldEmpId.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setText("Salary");

        txtFieldSalary.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        btnBackToDashboard.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        btnBackToDashboard.setText("Back to Dashboard");
        btnBackToDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToDashboardActionPerformed(evt);
            }
        });

        txtFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtFieldEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFieldSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAddSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1328, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBackToDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnBackToDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFieldEmpId, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFieldSalary)
                            .addComponent(txtFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1472, 791));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSalaryActionPerformed
        empIdString = txtFieldEmpId.getText();
        empIdSalary = txtFieldSalary.getText();

        //validate textfield 
        if (empIdString.isEmpty() || empIdSalary.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please input Employee id and salary!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //convert to int
        int empId = Integer.parseInt(empIdString);
        //convert to double
        double salary = Double.parseDouble(empIdSalary);

        if (!db.isEmpIdExists(empId)) {
            JOptionPane.showMessageDialog(this, "Employee ID does not exists.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        payroll = new Payroll(empId, salary);

        JOptionPane.showMessageDialog(this,
                "Payroll of Employee Successfully added.", "Success",
                JOptionPane.INFORMATION_MESSAGE);

        db.addPayroll(empId, payroll);

        txtFieldEmpId.setText(null);
        txtFieldSalary.setText(null);

        displayPayrollTable();


    }//GEN-LAST:event_btnAddSalaryActionPerformed
    private void disposeForm() {
        this.dispose();
    }

    private void searchEmployeePayroll(DefaultTableModel model) {
        rowSorter = new TableRowSorter<>(model);

        tblEmployeePayroll.setRowSorter(rowSorter);

        txtFieldSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String searchText = txtFieldSearch.getText();
                if (searchText.trim().isEmpty()) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
                }
            }
        });
    }
    private void btnBackToDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToDashboardActionPerformed
        if (gui == null || !gui.isDisplayable()) {
            gui = new BasicGUI();
            gui.setVisible(true);
            disposeForm();
        }
    }//GEN-LAST:event_btnBackToDashboardActionPerformed

    private void txtFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldSearchActionPerformed

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
            java.util.logging.Logger.getLogger(PayrollForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PayrollForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PayrollForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PayrollForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PayrollForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSalary;
    private javax.swing.JButton btnBackToDashboard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmployeePayroll;
    private javax.swing.JTextField txtFieldEmpId;
    private javax.swing.JTextField txtFieldSalary;
    private javax.swing.JTextField txtFieldSearch;
    // End of variables declaration//GEN-END:variables
}
