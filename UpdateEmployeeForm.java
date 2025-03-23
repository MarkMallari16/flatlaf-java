/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.firstflatlaf;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author Mallari
 */
public class UpdateEmployeeForm extends javax.swing.JFrame {

    private Database db = new Database();
    private int updEmpIdInt;
    private String selectedProfile;
    private String updEmpProfilePath;
    private String updEmpIdString, updEmpName, updEmpAge, updDateOfBirth, updEmpGender,
            updEmpdStatus, updEmpContactNum, updEmpEmail, updEmpDepartment, updEmpPosition, updEmpLocationType;
    private EmployeeForm empForm;
    //data
    private Employee employee;
    private JFileChooser fileChooser;
    private Date parsedDate;
    private SimpleDateFormat sdf;

    /**
     * Creates new form UpdateEmployeeForm
     */
    public UpdateEmployeeForm(int rowEmpIdInt, ImageIcon rowEmpProfile, String rowEmpName, String rowEmpAge, String rowEmpDateOfBirth, String rowEmpGender,
            String rowEmpStatus, String rowEmpContactNum, String rowEmpEmail, String rowEmpDepartment, String rowEmpPosition,
            String rowEmpLocationType) {
        initComponents();
        //make the default profile centered
        txtLblProfile.setHorizontalAlignment(SwingConstants.CENTER);
        txtLblProfile.setVerticalAlignment(SwingConstants.CENTER);

        String rowEmpIdString = String.valueOf(rowEmpIdInt);
        String rowEmpAgeString = String.valueOf(rowEmpAge);

        //personal details
        txtFieldEmpId.setText(rowEmpIdString);
        txtLblProfile.setIcon(rowEmpProfile);
        
        
        txtFieldName.setText(rowEmpName);
        txtFieldAge.setText(rowEmpAgeString);

        //parsing date
        sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            parsedDate = sdf.parse(rowEmpDateOfBirth);
        } catch (ParseException ex) {
            ex.printStackTrace();
            dcDateOfBirth.setDate(null);
        }
        dcDateOfBirth.setDate(parsedDate);

        cbGender.setSelectedItem(rowEmpGender);
        cbMaritalStatus.setSelectedItem(rowEmpStatus);
        txtFieldContactNum.setText(rowEmpContactNum);

        txtFieldEmail.setText(rowEmpEmail);

        //job details
        cbDepartment.setSelectedItem(rowEmpDepartment);
        txtFieldPosition.setText(rowEmpPosition);
        cbLocationType.setSelectedItem(rowEmpLocationType);

        //icons
        btnBack.setIcon(new FlatSVGIcon("svg/back.svg"));

        //gender
        String[] genders = {"Male", "Female"};
        displayCombox(genders, cbGender);

        //status
        String[] statuses = {"Single", "Married", "Divorced"};
        displayCombox(statuses, cbMaritalStatus);

        //department box
        String[] departments = {"IT", "HR", "Finance", "Marketing"};
        displayCombox(departments, cbDepartment);

        String[] workLocation = {"On-Site", "Remote", "Hybrid"};
        displayCombox(workLocation, cbLocationType);
        
        
    }

    private void displayCombox(String[] items, JComboBox cb) {
        cb.removeAllItems();
        for (String item : items) {
            cb.addItem(item);
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

        jLabel1 = new javax.swing.JLabel();
        txtFieldEmpId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtFieldPosition = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFieldContactNum = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFieldEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbDepartment = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbMaritalStatus = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbGender = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtFieldName = new javax.swing.JTextField();
        cbLocationType = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        dcDateOfBirth = new com.toedter.calendar.JDateChooser();
        txtFieldAge = new javax.swing.JTextField();
        btnUploadProfile = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtLblProfile = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Update Employee");

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel1.setText("Update Employee");

        txtFieldEmpId.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtFieldEmpId.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel2.setText("ID");

        btnUpdate.setBackground(new java.awt.Color(0, 102, 255));
        btnUpdate.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel4.setText("Department");

        txtFieldPosition.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setText("Position");

        txtFieldContactNum.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel6.setText("Contact Number");

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel7.setText("Email");

        txtFieldEmail.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel8.setText("Date of Birth");

        cbDepartment.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cbDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDepartmentActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel9.setText("Personal Information");

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel10.setText("Status");

        cbMaritalStatus.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cbMaritalStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMaritalStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaritalStatusActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel11.setText("Gender");

        cbGender.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGenderActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel12.setText("Job Details");

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel13.setText("Type");

        txtFieldName.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        cbLocationType.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cbLocationType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLocationType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocationTypeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setText("Name");

        txtFieldAge.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtFieldAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldAgeActionPerformed(evt);
            }
        });

        btnUploadProfile.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        btnUploadProfile.setText("Upload Profile");
        btnUploadProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadProfileActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel14.setText("Age");

        txtLblProfile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtFieldEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13)
                                .addComponent(cbLocationType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)
                            .addComponent(txtFieldPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(cbDepartment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(dcDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFieldName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFieldAge, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(cbMaritalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6)
                                    .addComponent(txtFieldContactNum)
                                    .addComponent(jLabel7)
                                    .addComponent(txtFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLblProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUploadProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(204, 204, 204))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFieldEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel9)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFieldContactNum, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbMaritalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFieldAge, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLblProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnUploadProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(32, 32, 32)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFieldPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbLocationType, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        setSize(new java.awt.Dimension(1520, 818));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        goBackToDashboard();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updEmpIdString = txtFieldEmpId.getText();
        //parsing
        updEmpIdInt = Integer.parseInt(updEmpIdString);

        updEmpName = txtFieldName.getText();
        updEmpAge = txtFieldAge.getText();
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        updDateOfBirth = sdf.format(dcDateOfBirth.getDate());
        updEmpGender = (String) cbGender.getSelectedItem();
        updEmpdStatus = (String) cbMaritalStatus.getSelectedItem();
        updEmpContactNum = txtFieldContactNum.getText();
        updEmpEmail = txtFieldEmail.getText();
        updEmpDepartment = (String) cbDepartment.getSelectedItem();
        updEmpPosition = txtFieldPosition.getText();
        updEmpLocationType = (String) cbLocationType.getSelectedItem();

        employee = new Employee(
                updEmpIdInt, updEmpProfilePath, updEmpName, updEmpAge,
                updDateOfBirth, updEmpGender, updEmpdStatus,
                updEmpContactNum, updEmpEmail, updEmpDepartment,
                updEmpPosition, updEmpLocationType);

        db.updateEmployee(updEmpIdInt, employee);

        JOptionPane.showMessageDialog(this, "Employee successfully update!", "Success", JOptionPane.INFORMATION_MESSAGE);

        goBackToDashboard();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void cbDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDepartmentActionPerformed

    }//GEN-LAST:event_cbDepartmentActionPerformed

    private void cbMaritalStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaritalStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMaritalStatusActionPerformed

    private void cbGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbGenderActionPerformed

    private void cbLocationTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocationTypeActionPerformed

    }//GEN-LAST:event_cbLocationTypeActionPerformed

    private void txtFieldAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldAgeActionPerformed

    private void btnUploadProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadProfileActionPerformed
        fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select profile");

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            updEmpProfilePath = selectedFile.getAbsolutePath();

            try {
                BufferedImage originalImage = ImageIO.read(selectedFile);
                Image resizedImage = originalImage.getScaledInstance(300, 200, Image.SCALE_SMOOTH);

                txtLblProfile.setIcon(new ImageIcon(resizedImage));
                txtLblProfile.setText(null);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnUploadProfileActionPerformed
    private void goBackToDashboard() {
        if (empForm == null || !empForm.isDisplayable()) {
            empForm = new EmployeeForm();
            empForm.setVisible(true);
            disposeForm();
        }
    }

    private void disposeForm() {
        this.dispose();
    }

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
            java.util.logging.Logger.getLogger(UpdateEmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateEmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateEmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateEmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new UpdateEmployeeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUploadProfile;
    private javax.swing.JComboBox<String> cbDepartment;
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JComboBox<String> cbLocationType;
    private javax.swing.JComboBox<String> cbMaritalStatus;
    private com.toedter.calendar.JDateChooser dcDateOfBirth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtFieldAge;
    private javax.swing.JTextField txtFieldContactNum;
    private javax.swing.JTextField txtFieldEmail;
    private javax.swing.JTextField txtFieldEmpId;
    private javax.swing.JTextField txtFieldName;
    private javax.swing.JTextField txtFieldPosition;
    private javax.swing.JLabel txtLblProfile;
    // End of variables declaration//GEN-END:variables
}
