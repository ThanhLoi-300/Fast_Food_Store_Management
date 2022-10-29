/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

/**
 *
 * @author Josie
 */
public class Account_GUI extends javax.swing.JPanel {

    /**
     * Creates new form Account_GUI
     */
    public Account_GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new Custom.RoundPanel();
        scrAccountList = new javax.swing.JScrollPane();
        tblAccountList = new javax.swing.JTable();
        cbbSearchFilter = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new Custom.Button();
        pnlAccountDetails = new javax.swing.JPanel();
        lblAccountID = new javax.swing.JLabel();
        lblAccountIDDisplay = new javax.swing.JLabel();
        lblUserNameDisplay = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblPasswordDisplay = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblTypeDisplay = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        lblStaffIDDisplay = new javax.swing.JLabel();
        lblStaffID = new javax.swing.JLabel();
        pnlAccountConfiguration = new javax.swing.JPanel();
        lblAccountIDConfig = new javax.swing.JLabel();
        txtAccountID = new javax.swing.JTextField();
        lblUserNameConfig = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        lblPasswordConfig = new javax.swing.JLabel();
        txtType = new javax.swing.JTextField();
        lblTypeConfig = new javax.swing.JLabel();
        txtStaffID = new javax.swing.JTextField();
        lblStaffIDConfig = new javax.swing.JLabel();
        btnAdd = new Custom.Button();
        btnDelete = new Custom.Button();
        btnUpdate = new Custom.Button();
        btnImportFile = new Custom.Button();
        btnExportFile = new Custom.Button();

        setPreferredSize(new java.awt.Dimension(1070, 700));

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel1.setPreferredSize(new java.awt.Dimension(1070, 700));

        scrAccountList.setBorder(javax.swing.BorderFactory.createTitledBorder("Account List"));
        scrAccountList.setName(""); // NOI18N
        scrAccountList.setPreferredSize(new java.awt.Dimension(470, 423));

        tblAccountList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "AccountID", "Usename", "Password", "Type", "StaffID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrAccountList.setViewportView(tblAccountList);

        cbbSearchFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AccountID", "UserName", "Password", "Type", "StaffID" }));
        cbbSearchFilter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search.png"))); // NOI18N
        btnSearch.setColor(new java.awt.Color(255, 255, 255));
        btnSearch.setColorClick(new java.awt.Color(255, 255, 255));
        btnSearch.setColorOver(new java.awt.Color(242, 152, 174));
        btnSearch.setRadius(5);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        pnlAccountDetails.setBorder(javax.swing.BorderFactory.createTitledBorder("Account Details"));

        lblAccountID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAccountID.setText("AccountID:");

        lblAccountIDDisplay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAccountIDDisplay.setText("A01");

        lblUserNameDisplay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUserNameDisplay.setText("Max");

        lblUserName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUserName.setText("UserName:");

        lblPasswordDisplay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPasswordDisplay.setText("123456");

        lblPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPassword.setText("Password:");

        lblTypeDisplay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTypeDisplay.setText("Manager");

        lblType.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblType.setText("Type:");

        lblStaffIDDisplay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblStaffIDDisplay.setText("S01");

        lblStaffID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblStaffID.setText("StaffID:");

        javax.swing.GroupLayout pnlAccountDetailsLayout = new javax.swing.GroupLayout(pnlAccountDetails);
        pnlAccountDetails.setLayout(pnlAccountDetailsLayout);
        pnlAccountDetailsLayout.setHorizontalGroup(
            pnlAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccountDetailsLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAccountDetailsLayout.createSequentialGroup()
                        .addComponent(lblAccountID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(lblAccountIDDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAccountDetailsLayout.createSequentialGroup()
                        .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblUserNameDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAccountDetailsLayout.createSequentialGroup()
                        .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPasswordDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAccountDetailsLayout.createSequentialGroup()
                        .addComponent(lblType, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTypeDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAccountDetailsLayout.createSequentialGroup()
                        .addComponent(lblStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblStaffIDDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlAccountDetailsLayout.setVerticalGroup(
            pnlAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccountDetailsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAccountID)
                    .addComponent(lblAccountIDDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnlAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName)
                    .addComponent(lblUserNameDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnlAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(lblPasswordDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnlAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblType)
                    .addComponent(lblTypeDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnlAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStaffID)
                    .addComponent(lblStaffIDDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlAccountConfiguration.setBorder(javax.swing.BorderFactory.createTitledBorder("Account Configuration"));
        pnlAccountConfiguration.setPreferredSize(new java.awt.Dimension(340, 410));

        lblAccountIDConfig.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAccountIDConfig.setText("AccountID:");

        txtAccountID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAccountIDActionPerformed(evt);
            }
        });

        lblUserNameConfig.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUserNameConfig.setText("UserName:");

        lblPasswordConfig.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPasswordConfig.setText("Password:");

        lblTypeConfig.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTypeConfig.setText("Type:");

        lblStaffIDConfig.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblStaffIDConfig.setText("StaffID:");

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAdd.setText("Add");
        btnAdd.setColor(new java.awt.Color(255, 255, 255));
        btnAdd.setColorClick(new java.awt.Color(255, 255, 255));
        btnAdd.setColorOver(new java.awt.Color(242, 152, 174));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDelete.setText("Delete");
        btnDelete.setColor(new java.awt.Color(255, 255, 255));
        btnDelete.setColorClick(new java.awt.Color(255, 255, 255));
        btnDelete.setColorOver(new java.awt.Color(242, 152, 174));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpdate.setText("Update");
        btnUpdate.setColor(new java.awt.Color(255, 255, 255));
        btnUpdate.setColorClick(new java.awt.Color(255, 255, 255));
        btnUpdate.setColorOver(new java.awt.Color(242, 152, 174));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnImportFile.setBackground(new java.awt.Color(255, 255, 255));
        btnImportFile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnImportFile.setText("Import File");
        btnImportFile.setColor(new java.awt.Color(255, 255, 255));
        btnImportFile.setColorClick(new java.awt.Color(255, 255, 255));
        btnImportFile.setColorOver(new java.awt.Color(242, 152, 174));
        btnImportFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportFileActionPerformed(evt);
            }
        });

        btnExportFile.setBackground(new java.awt.Color(255, 255, 255));
        btnExportFile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExportFile.setText("Export File");
        btnExportFile.setColor(new java.awt.Color(255, 255, 255));
        btnExportFile.setColorClick(new java.awt.Color(255, 255, 255));
        btnExportFile.setColorOver(new java.awt.Color(242, 152, 174));
        btnExportFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAccountConfigurationLayout = new javax.swing.GroupLayout(pnlAccountConfiguration);
        pnlAccountConfiguration.setLayout(pnlAccountConfigurationLayout);
        pnlAccountConfigurationLayout.setHorizontalGroup(
            pnlAccountConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccountConfigurationLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlAccountConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAccountConfigurationLayout.createSequentialGroup()
                        .addComponent(lblAccountIDConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAccountID))
                    .addGroup(pnlAccountConfigurationLayout.createSequentialGroup()
                        .addComponent(lblUserNameConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUserName))
                    .addGroup(pnlAccountConfigurationLayout.createSequentialGroup()
                        .addComponent(lblPasswordConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPassword))
                    .addGroup(pnlAccountConfigurationLayout.createSequentialGroup()
                        .addComponent(lblTypeConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtType))
                    .addGroup(pnlAccountConfigurationLayout.createSequentialGroup()
                        .addComponent(lblStaffIDConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStaffID))
                    .addGroup(pnlAccountConfigurationLayout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addContainerGap())
            .addGroup(pnlAccountConfigurationLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btnImportFile, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExportFile, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlAccountConfigurationLayout.setVerticalGroup(
            pnlAccountConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccountConfigurationLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlAccountConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAccountIDConfig)
                    .addComponent(txtAccountID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnlAccountConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserNameConfig)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnlAccountConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPasswordConfig)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnlAccountConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTypeConfig)
                    .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnlAccountConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStaffIDConfig)
                    .addComponent(txtStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlAccountConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAccountConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImportFile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportFile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(cbbSearchFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrAccountList, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAccountConfiguration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAccountDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel1Layout.createSequentialGroup()
                        .addComponent(pnlAccountDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlAccountConfiguration, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbSearchFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(scrAccountList, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtAccountIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAccountIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAccountIDActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnImportFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImportFileActionPerformed

    private void btnExportFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportFileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.Button btnAdd;
    private Custom.Button btnDelete;
    private Custom.Button btnExportFile;
    private Custom.Button btnImportFile;
    private Custom.Button btnSearch;
    private Custom.Button btnUpdate;
    private javax.swing.JComboBox<String> cbbSearchFilter;
    private javax.swing.JLabel lblAccountID;
    private javax.swing.JLabel lblAccountIDConfig;
    private javax.swing.JLabel lblAccountIDDisplay;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPasswordConfig;
    private javax.swing.JLabel lblPasswordDisplay;
    private javax.swing.JLabel lblStaffID;
    private javax.swing.JLabel lblStaffIDConfig;
    private javax.swing.JLabel lblStaffIDDisplay;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblTypeConfig;
    private javax.swing.JLabel lblTypeDisplay;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblUserNameConfig;
    private javax.swing.JLabel lblUserNameDisplay;
    private javax.swing.JPanel pnlAccountConfiguration;
    private javax.swing.JPanel pnlAccountDetails;
    private Custom.RoundPanel roundPanel1;
    private javax.swing.JScrollPane scrAccountList;
    private javax.swing.JTable tblAccountList;
    private javax.swing.JTextField txtAccountID;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtStaffID;
    private javax.swing.JTextField txtType;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
