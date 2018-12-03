/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.EmployeeController;
import controllers.Interface.EmployeeControllerInterface;
import daos.GeneralDAO;
import entities.Department;
import entities.Employee;
import entities.Job;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Nitani
 */
public class EmployeesView extends javax.swing.JInternalFrame {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private GeneralDAO edao;
    private SessionFactory factory;
    private EmployeeControllerInterface eci = new EmployeeController(sessionFactory);

    /**
     * Creates new form EmployeesView
     */
    public EmployeesView() {
        initComponents();
        selectDepartmentId();
        selectEmployeeId();
        selectJobId();
        bindingTable(eci.search(txtSearch.getText()));
    }

    public void bindingTable(List<Object> employees) {
        Object[] header = {"Employee Id", "First Name", "Last Name", "Email", "Phone Number", "Hire Date", "Job", "Salary", "Commission Pct", "Manager", "Department"};
        DefaultTableModel model = new DefaultTableModel(null, header);
        getidTable.setModel(model);

        try {
            for (Object employee : employees) {
                Employee emp = (Employee) employee;
                String isi1 = String.valueOf(emp.getEmployeeId());
                String isi2 = emp.getFirstName();
                String isi3 = emp.getLastName();
                String isi4 = emp.getEmail();
                String isi5 = emp.getPhoneNumber();
                String isi6 = String.valueOf(emp.getHireDate());
                String isi7 = String.valueOf(emp.getJobId().getJobTitle());
                String isi8 = String.valueOf(emp.getSalary());
                String isi9 = "0";
                if (emp.getCommissionPct() != null) {
                    isi9 = "" + emp.getCommissionPct();
                }
                String isi10 = String.valueOf(emp.getManagerId().getLastName());
                String isi11 = "-";
                if (emp.getDepartmentId() != null) {
                    isi11 = "" + emp.getDepartmentId().getDepartmentName();
                }

                String kolom[] = {isi1, isi2, isi3, isi4, isi5, isi6, isi7, isi8, isi9, isi10, isi11};
                model.addRow(kolom);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ops! " + e.getMessage());
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

        email_field = new javax.swing.JTextField();
        phonenumber_field = new javax.swing.JTextField();
        jobid_field = new javax.swing.JComboBox<>();
        salary_field = new javax.swing.JTextField();
        commissionpct_field = new javax.swing.JTextField();
        cbxmanageId = new javax.swing.JComboBox<>();
        cbxDepartmentId = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        getidTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        deletebutton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        update_Button = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        insertbutton = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        searchId = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        notifId = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        employeeid_field = new javax.swing.JTextField();
        firstname_field = new javax.swing.JTextField();
        lastname_field = new javax.swing.JTextField();
        dateField = new org.jdesktop.swingx.JXDatePicker();

        setClosable(true);

        jobid_field.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Job" }));
        jobid_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobid_fieldActionPerformed(evt);
            }
        });

        cbxmanageId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Manager" }));
        cbxmanageId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxmanageIdActionPerformed(evt);
            }
        });

        cbxDepartmentId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Department" }));
        cbxDepartmentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDepartmentIdActionPerformed(evt);
            }
        });

        jLabel11.setText("Manager");

        getidTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "EMPLOYEE_ID", "FIRST_NAME", "LAST_NAME", "EMAIL", "PHONE_NUMBER", "HIRE_DATE", "JOB_ID", "SALARY", "COMMISSION_PCT", "MANAGER_ID", "DEPARTMENT_ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        getidTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getidTabletableClick(evt);
            }
        });
        jScrollPane1.setViewportView(getidTable);

        jLabel4.setText("First Name");

        jLabel5.setText("Last Name");

        jLabel12.setText("Department");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel3.setText("Employee ID");

        deletebutton.setText("Delete");
        deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebuttonActionPerformed(evt);
            }
        });

        jLabel6.setText("Email");

        update_Button.setText("Update");
        update_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_ButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Phone Number");

        insertbutton.setText("Add");
        insertbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbuttonActionPerformed(evt);
            }
        });

        jLabel14.setText("Hire Date");

        searchId.setText("Search ID");
        searchId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchIdActionPerformed(evt);
            }
        });

        jLabel8.setText("Job");

        notifId.setText("Masukkan ID Employee");

        jLabel9.setText("Salary");

        jLabel10.setText("Commission Pct");

        employeeid_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                employeeid_fieldKeyReleased(evt);
            }
        });

        firstname_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstname_fieldActionPerformed(evt);
            }
        });
        firstname_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                firstname_fieldKeyReleased(evt);
            }
        });

        lastname_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastname_fieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(notifId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbxDepartmentId, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(commissionpct_field))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(salary_field))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jobid_field, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cbxmanageId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dateField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lastname_field))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(firstname_field))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(employeeid_field, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(phonenumber_field, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(searchId, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(deletebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(update_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(insertbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(notifId)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(employeeid_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstname_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lastname_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phonenumber_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jobid_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(salary_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(commissionpct_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxmanageId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxDepartmentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(insertbutton)
                            .addComponent(deletebutton)
                            .addComponent(update_Button))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchId)))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jobid_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobid_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobid_fieldActionPerformed

    private void cbxmanageIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxmanageIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxmanageIdActionPerformed

    private void cbxDepartmentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDepartmentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxDepartmentIdActionPerformed

    private void getidTabletableClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getidTabletableClick
        // TODO add your handling code here:
        int i = getidTable.getSelectedRow();
        TableModel model = getidTable.getModel();
        employeeid_field.setText(model.getValueAt(i, 0).toString());
        firstname_field.setText(model.getValueAt(i, 1).toString());
        lastname_field.setText(model.getValueAt(i, 2).toString());
        email_field.setText(model.getValueAt(i, 3).toString());
        phonenumber_field.setText(model.getValueAt(i, 4).toString());
        jobid_field.setSelectedItem(model.getValueAt(i, 6).toString());
        salary_field.setText(model.getValueAt(i, 7).toString());
        commissionpct_field.setText(model.getValueAt(i, 8).toString());
        cbxmanageId.setSelectedItem(model.getValueAt(i, 9).toString());
        cbxDepartmentId.setSelectedItem(model.getValueAt(i, 10).toString());
        employeeid_field.setEnabled(false);
        insertbutton.setEnabled(false);
        update_Button.setEnabled(true);
    }//GEN-LAST:event_getidTabletableClick

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        bindingTable(eci.search(txtSearch.getText()));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed
        // TODO add your handling code here:
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Hapus data?", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            String nil = employeeid_field.getText();
            if (eci.delete(nil) == true) {
                employeeid_field.setEnabled(true);
                bindingTable(eci.search(""));
                JOptionPane.showConfirmDialog(null, "Data berhasil di hapus", "Warning", dialogButton);
                //kosongData();
                employeeid_field.setEnabled(false);
                //employeeid_field.setText(employeeController.lastId());
            } else {
                JOptionPane.showConfirmDialog(null, "Data gagal di hapus", "Warning", dialogButton);
            }
        }
    }//GEN-LAST:event_deletebuttonActionPerformed

    private void update_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_ButtonActionPerformed
        // TODO add your handling code here:
        //        String empFN = firstname_field.getText();
        //        String empLN = lastname_field.getText();
        //        String email = email_field.getText();
        //        String phoneNum = phonenumber_field.getText();
        //        String hireNum = hiredate_field.getText();
        //        String jobid = (String) jobid_field.getSelectedItem();
        //        int sal = Integer.valueOf(salary_field.getText());
        //        double comm = Double.valueOf(commissionpct_field.getText());
        //        String managerId = (String) cbxmanageId.getSelectedItem();
        //        String departmentId = (String) cbxDepartmentId.getSelectedItem();
        //        int ID = Integer.valueOf(employeeid_field.getText());
        //        String jobId = jobid.substring(0, jobid.indexOf(" "));
        //        String mngId = managerId.substring(0, managerId.indexOf(" "));
        //        String dprtId = departmentId.substring(0, departmentId.indexOf(" "));
        //        int dialogButton = JOptionPane.YES_NO_OPTION;
        //        int dialogResult = JOptionPane.showConfirmDialog(null, "Update data?", "Warning", dialogButton);
        //        if (dialogResult == JOptionPane.YES_OPTION) {
        //            if (employeeController.update(empFN, empLN, email, phoneNum, hireNum, jobId, sal, comm, mngId, dprtId, ID) == true) {
        //                JOptionPane.showMessageDialog(null, "Update Berhasil");
        //                kosongData();
        //                insertbutton.setEnabled(true);
        //                deletebutton.setEnabled(true);
        //                update_Button.setEnabled(false);
        //                bindingTable(employeeController.gets());
        //                employeeid_field.setEnabled(false);
        //                employeeid_field.setText(employeeController.lastId());
        //            } else {
        //                JOptionPane.showMessageDialog(null, "Update Gagal");
        //                employeeid_field.setEnabled(false);
        //                employeeid_field.setText(employeeController.lastId());
        //            }
        //        } else {
        //            kosongData();
        //            insertbutton.setEnabled(true);
        //            deletebutton.setEnabled(true);
        //            update_Button.setEnabled(false);
        //            employeeid_field.setEnabled(false);
        //            employeeid_field.setText(employeeController.lastId());
        //        }
    }//GEN-LAST:event_update_ButtonActionPerformed

    private void insertbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbuttonActionPerformed
        DateFormat formats = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        String employeeid = employeeid_field.getText();
        String firstname = firstname_field.getText();
        String lastname = lastname_field.getText();
        String email = email_field.getText();
        String phonenumber = phonenumber_field.getText();
        Date hiredate = dateField.getDate();
        String dates = formats.format(hiredate);

        String jobid = (String) jobid_field.getSelectedItem();
        String salary = salary_field.getText();
        String commissionpct = commissionpct_field.getText();
        String managerId = (String) cbxmanageId.getSelectedItem();
        String departmentid = (String) cbxDepartmentId.getSelectedItem();
        String jobId = jobid.substring(0, jobid.indexOf(" "));
        String mngId = managerId.substring(0, managerId.indexOf(" "));
        String dprtId = departmentid.substring(0, departmentid.indexOf(" "));

        if (!employeeid.equals("") && !firstname.equals("")
                && !lastname.equals("") && !email.equals("")
                && !phonenumber.equals("") && !hiredate.equals("")
                && !jobid.equals("") && !salary.equals("")
                && !commissionpct.equals("") && !managerId.equals("")
                && !departmentid.equals("")) {
            if (eci.insert(employeeid, firstname,
                    lastname, email,
                    phonenumber,
                    dates, jobId,
                    salary, commissionpct,
                    mngId, dprtId)) {
                JOptionPane.showMessageDialog(null, "insert berhasil");
                //kosongData();
                bindingTable(eci.search(""));
                employeeid_field.setEnabled(false);
                //employeeid_field.setText(employeeController.lastId());
            } else {
                JOptionPane.showMessageDialog(null, "insert gagal");
            }

        } else {
            JOptionPane.showMessageDialog(null, "form input tidak boleh kosong");
        }
    }//GEN-LAST:event_insertbuttonActionPerformed

    private void searchIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchIdActionPerformed
        // TODO add your handling code here:
        Employee ed = (Employee) eci.getById(employeeid_field.getText());
        employeeid_field.setText(ed.getEmployeeId()+"");
        firstname_field.setText(ed.getFirstName());
        lastname_field.setText(ed.getLastName());
        email_field.setText(ed.getEmail());
        phonenumber_field.setText(ed.getPhoneNumber());
        salary_field.setText(ed.getSalary()+"");
        commissionpct_field.setText(ed.getCommissionPct()+"");
        
//        Object[] header = {"Employee Id", "First Name", "Last Name", "Email", "Phone Number", "Hire Date", "Job", "Salary", "Commission Pct", "Manager", "Department"};
//        DefaultTableModel model = new DefaultTableModel(null, header);
//        getidTable.setModel(model);
//        if (!txtSearch.getText().equals("")) {
//            try {
//                Object id = eci.getById(employeeid_field.getText());
//                Employee emp = (Employee) id;
//                String isi1 = String.valueOf(emp.getEmployeeId());
//                String isi2 = emp.getFirstName();
//                String isi3 = emp.getLastName();
//                String isi4 = emp.getEmail();
//                String isi5 = emp.getPhoneNumber();
//                String isi6 = String.valueOf(emp.getHireDate());
//                String isi7 = String.valueOf(emp.getJobId().getJobTitle());
//                String isi8 = String.valueOf(emp.getSalary());
//                String isi9 = "0";
//                if (emp.getCommissionPct() != null) {
//                    isi9 = "" + emp.getCommissionPct();
//                }
//                String isi10 = String.valueOf(emp.getManagerId().getLastName());
//                String isi11 = "-";
//                if (emp.getDepartmentId() != null) {
//                    isi11 = "" + emp.getDepartmentId().getDepartmentName();
//                }
//
//                String kolom[] = {isi1, isi2, isi3, isi4, isi5, isi6, isi7, isi8, isi9, isi10, isi11};
//                model.addRow(kolom);
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Ops! " + e.getMessage());
//            }
//        }

        employeeid_field.setEnabled(true);
        employeeid_field.setText("");
        notifId.setVisible(true);
    }//GEN-LAST:event_searchIdActionPerformed

    private void employeeid_fieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_employeeid_fieldKeyReleased
        // TODO add your handling code here:
        String nil = employeeid_field.getText();
        int id = Integer.valueOf(nil);
        //bindingTable(employeeController.getSearch(txtSearch.getText()));
    }//GEN-LAST:event_employeeid_fieldKeyReleased

    private void firstname_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstname_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstname_fieldActionPerformed

    private void firstname_fieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstname_fieldKeyReleased
        // TODO add your handling code here:
        //employeeid_field.setText(employeeController.lastId());
        employeeid_field.setEnabled(false);
    }//GEN-LAST:event_firstname_fieldKeyReleased

    private void lastname_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastname_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastname_fieldActionPerformed

    public void selectJobId() {
        String jobId;
        try {
            for (Object job : eci.jobId("")) {
                Job j = (Job) job;
                jobId = j.getJobId();
                String jobName = j.getJobTitle();
                String mix = jobId + " " + jobName;
                jobid_field.addItem(mix);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "selectJob is " + e.getMessage());
        }
    }

    public void selectEmployeeId() {
        String employeeId;
        try {
            for (Object employee : eci.search("")) {
                Employee e = (Employee) employee;
                employeeId = String.valueOf(e.getManagerId().getEmployeeId());
                String employeeName = e.getLastName();
                String mix = employeeId + " " + employeeName;
                cbxmanageId.addItem(mix);
//                cbxmanageId.addItem(employeeId);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "selectEmployee is " + e.getMessage());
        }
    }

    public void selectDepartmentId() {
        String departmentId;
        try {
            for (Object department : eci.departmentId("")) {
                Department d = (Department) department;
                departmentId = String.valueOf(d.getDepartmentId());
                String departmentName = d.getDepartmentName();
                String mix = departmentId + " " + departmentName;
                cbxDepartmentId.addItem(mix);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "selectDepartment is " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxDepartmentId;
    private javax.swing.JComboBox<String> cbxmanageId;
    private javax.swing.JTextField commissionpct_field;
    private org.jdesktop.swingx.JXDatePicker dateField;
    private javax.swing.JButton deletebutton;
    private javax.swing.JTextField email_field;
    private javax.swing.JTextField employeeid_field;
    private javax.swing.JTextField firstname_field;
    private javax.swing.JTable getidTable;
    private javax.swing.JButton insertbutton;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jobid_field;
    private javax.swing.JTextField lastname_field;
    private javax.swing.JLabel notifId;
    private javax.swing.JTextField phonenumber_field;
    private javax.swing.JTextField salary_field;
    private javax.swing.JButton searchId;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JButton update_Button;
    // End of variables declaration//GEN-END:variables
}
