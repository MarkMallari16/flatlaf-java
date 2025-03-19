/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.firstflatlaf;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Desktop;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author Mallari
 */
public class EmployeeForm extends javax.swing.JFrame {

    //database
    private Database db = new Database();

    //link for AddEmpForm
    private AddingEmployeeForm addingEmployeeForm;
    private TableRowSorter<DefaultTableModel> rowSorter;
    private DeleteForm df;
    private int rowEmpIdInt;
    private String rowEmpName, rowEmpAge, rowEmpDateOfBirth, rowEmpGender, rowEmpStatus, rowEmpContactNum,
            rowEmpEmail, rowEmpDepartment, rowEmpPosition, rowEmpLocationType;
    private UpdateEmployeeForm empUpdateForm;
    private BasicGUI gui;

    /**
     * Creates new form EmployeeForm
     */
    public EmployeeForm() {
        initComponents();
        //displaying Employee Table
        displayEmpTable();

        //placeholder
        txtFieldSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search");

//        txtFieldOne.putClientProperty("JComponent.roundRect", true);
        //icons
        txtFieldSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("svg/search.svg"));
        btnBackToDashboard.setIcon(new FlatSVGIcon("svg/back.svg"));
        btnAdd.setIcon(new FlatSVGIcon("svg/add.svg"));
        btnDeleteLink.setIcon(new FlatSVGIcon("svg/delete.svg"));
        btnExportPDF.setIcon(new FlatSVGIcon("svg/pdf.svg"));
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
        btnAdd = new javax.swing.JButton();
        btnDeleteLink = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        txtFieldSearch = new javax.swing.JTextField();
        btnBackToDashboard = new javax.swing.JButton();
        btnExportPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee");

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel1.setText("Employees");

        btnAdd.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDeleteLink.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        btnDeleteLink.setText("Delete");
        btnDeleteLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteLinkActionPerformed(evt);
            }
        });

        tblEmployee.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblEmployee);

        txtFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldSearchActionPerformed(evt);
            }
        });

        btnBackToDashboard.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        btnBackToDashboard.setText("Back to Dashboard");
        btnBackToDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToDashboardActionPerformed(evt);
            }
        });

        btnExportPDF.setBackground(new java.awt.Color(255, 102, 102));
        btnExportPDF.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        btnExportPDF.setText("Export to PDF");
        btnExportPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnBackToDashboard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(btnAdd)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnDeleteLink)))
                            .addGap(26, 26, 26)
                            .addComponent(btnExportPDF)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnBackToDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteLink, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportPDF, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        setSize(new java.awt.Dimension(1472, 791));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
  private void displayEmpTable() {
        String[] columns = {"Employee ID", "Name", "Age", "Date of Birth", "Gender",
            "Status", "Contact Number", "Email", "Department", "Position", "Location Type"};

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (int empId : db.getEmployee().keySet()) {
            Employee employeeData = db.getEmployee().get(empId);

            if (employeeData != null) {
                model.addRow(new Object[]{
                    empId,
                    employeeData.getName(),
                    employeeData.getAge(),
                    employeeData.getDateOfBirth(),
                    employeeData.getGender(),
                    employeeData.getStatus(),
                    employeeData.getContactNum(),
                    employeeData.getEmail(),
                    employeeData.getDepartment(),
                    employeeData.getPosition(),
                    employeeData.getLocationType()});
            }
        }
        tblEmployee.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblEmployee.setModel(model);
        
        //clicking row
        tblEmployee.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tblEmployee.getSelectedRow();

                if (row != -1) {
                    rowEmpIdInt = (Integer) tblEmployee.getValueAt(row, 0);
                    rowEmpName = (String) tblEmployee.getValueAt(row, 1);
                    rowEmpAge = (String) tblEmployee.getValueAt(row, 2);
                    rowEmpDepartment = (String) tblEmployee.getValueAt(row, 3);
                    rowEmpPosition = (String) tblEmployee.getValueAt(row, 4);
                    rowEmpContactNum = (String) tblEmployee.getValueAt(row, 5);
                    rowEmpEmail = (String) tblEmployee.getValueAt(row, 6);

                    if (empUpdateForm == null || !empUpdateForm.isDisplayable()) {
                        empUpdateForm = new UpdateEmployeeForm(rowEmpIdInt, rowEmpName, rowEmpAge, rowEmpDateOfBirth,
                                rowEmpGender, rowEmpStatus, rowEmpContactNum, rowEmpEmail,
                                rowEmpDepartment, rowEmpPosition, rowEmpLocationType);
                        empUpdateForm.setVisible(true);
                        disposeForm();
                    }
                }
            }

        });

        searchEmployee(model);
    }

    private void searchEmployee(DefaultTableModel model) {
        rowSorter = new TableRowSorter<>(model);
        tblEmployee.setRowSorter(rowSorter);

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
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (addingEmployeeForm == null || !addingEmployeeForm.isDisplayable()) {
            addingEmployeeForm = new AddingEmployeeForm();
            disposeForm();
            addingEmployeeForm.setVisible(true);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteLinkActionPerformed
        if (df == null || !df.isDisplayable()) {
            df = new DeleteForm();
            df.setVisible(true);
            disposeForm();
        }
    }//GEN-LAST:event_btnDeleteLinkActionPerformed

    private void disposeForm() {
        this.dispose();
    }
    private void txtFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldSearchActionPerformed

    private void btnBackToDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToDashboardActionPerformed
        if (gui == null || !gui.isDisplayable()) {
            gui = new BasicGUI();
            gui.setVisible(true);
            disposeForm();
        }
    }//GEN-LAST:event_btnBackToDashboardActionPerformed

    private void btnExportPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportPDFActionPerformed
        try {
            String filePath = "exported_employees.pdf";

            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            float margin = 50;
            float y = page.getMediaBox().getHeight() - 50;

            // Table Header
            contentStream.beginText();
            contentStream.newLineAtOffset(margin, y);
            contentStream.showText("ID    Name           Age   Department     Position");
            contentStream.endText();

            y -= 20;

            contentStream.setFont(PDType1Font.HELVETICA, 10);
            for (int empId : db.getEmployee().keySet()) {
                Employee employee = db.getEmployee().get(empId);

                contentStream.beginText();
                contentStream.newLineAtOffset(50, y);
                contentStream.showText(empId + "    " + employee.getName() + "    " + employee.getAge() + "    "
                        + employee.getDepartment() + "    " + employee.getPosition());
                contentStream.endText();

                y -= 20;
            }

            contentStream.close();

            document.save(filePath);
            document.close();

            JOptionPane.showMessageDialog(this, "Employees PDF Exported Successfully!");

            File pdfFile = new File(filePath);

            if (pdfFile.exists() && Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(pdfFile);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnExportPDFActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBackToDashboard;
    private javax.swing.JButton btnDeleteLink;
    private javax.swing.JButton btnExportPDF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTextField txtFieldSearch;
    // End of variables declaration//GEN-END:variables
}
