
package GUI;

import java.awt.Color;

public class Product_GUI extends javax.swing.JPanel {

    public Product_GUI() {
        setBackground(new Color(51,51,51));
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        srcProductList1 = new javax.swing.JScrollPane();
        tblProductList1 = new javax.swing.JTable();
        pnlProductConfiguration1 = new javax.swing.JPanel();
        lblProductIDLabelConfig1 = new javax.swing.JLabel();
        txtProductID1 = new javax.swing.JTextField();
        lblSizeIDLabelConfig1 = new javax.swing.JLabel();
        txtSizeID1 = new javax.swing.JTextField();
        lblProductNameLabelConfig1 = new javax.swing.JLabel();
        txtProductName1 = new javax.swing.JTextField();
        txtPrice1 = new javax.swing.JTextField();
        lblPriceIDLabelConfig1 = new javax.swing.JLabel();
        lblQuantityLabelConfig1 = new javax.swing.JLabel();
        txtQuantity1 = new javax.swing.JTextField();
        lblCategoryIDLabelConfig1 = new javax.swing.JLabel();
        btnAdd1 = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        btnUpdate1 = new javax.swing.JButton();
        cbbCategoryID1 = new javax.swing.JComboBox<>();
        lblBusinessStatusLabelConfig1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        pnlProductDetails = new javax.swing.JPanel();
        lblProductIDLabel = new javax.swing.JLabel();
        lblProductIDDisplay = new javax.swing.JLabel();
        lblSizeIDLabel = new javax.swing.JLabel();
        lblSizeIDDisplay = new javax.swing.JLabel();
        lblProductNameDisplay = new javax.swing.JLabel();
        lblProductNameLabel = new javax.swing.JLabel();
        lblPriceLabel = new javax.swing.JLabel();
        lblPriceDisplay = new javax.swing.JLabel();
        lblQuantityDisplay = new javax.swing.JLabel();
        lblQuantityLabel = new javax.swing.JLabel();
        lblCategoryIDLabel = new javax.swing.JLabel();
        lblCategoryIDDisplay = new javax.swing.JLabel();
        lblBusinessStatusLabel = new javax.swing.JLabel();
        lblBusinessStatusDisplay = new javax.swing.JLabel();
        cbbSearchFilter = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        button1 = new Custom.Button();

        setPreferredSize(new java.awt.Dimension(1070, 700));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setAutoscrolls(true);
        jPanel2.setPreferredSize(new java.awt.Dimension(1070, 300));

        srcProductList1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Products List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12))); // NOI18N

        tblProductList1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ProductID", "SizeID", "ProductName", "Price", "Quantity", "BusinessStatus", "CategoryID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        srcProductList1.setViewportView(tblProductList1);

        pnlProductConfiguration1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product Configuration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12))); // NOI18N

        lblProductIDLabelConfig1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblProductIDLabelConfig1.setText("Product ID:");

        txtProductID1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        lblSizeIDLabelConfig1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblSizeIDLabelConfig1.setText("Size ID:");

        txtSizeID1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        lblProductNameLabelConfig1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblProductNameLabelConfig1.setText("Product name:");

        txtProductName1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtPrice1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        lblPriceIDLabelConfig1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblPriceIDLabelConfig1.setText("Price:");

        lblQuantityLabelConfig1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblQuantityLabelConfig1.setText("Quantity:");

        txtQuantity1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        lblCategoryIDLabelConfig1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCategoryIDLabelConfig1.setText("Category ID:");

        btnAdd1.setText("Add");

        btnDelete1.setText("Delete");

        btnUpdate1.setText("Update");

        lblBusinessStatusLabelConfig1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBusinessStatusLabelConfig1.setText("Business Status:");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("On");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jRadioButton2.setText("Off");

        javax.swing.GroupLayout pnlProductConfiguration1Layout = new javax.swing.GroupLayout(pnlProductConfiguration1);
        pnlProductConfiguration1.setLayout(pnlProductConfiguration1Layout);
        pnlProductConfiguration1Layout.setHorizontalGroup(
            pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductConfiguration1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProductConfiguration1Layout.createSequentialGroup()
                        .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(btnUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlProductConfiguration1Layout.createSequentialGroup()
                        .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProductIDLabelConfig1)
                            .addComponent(lblSizeIDLabelConfig1)
                            .addComponent(lblPriceIDLabelConfig1)
                            .addComponent(lblQuantityLabelConfig1)
                            .addComponent(lblBusinessStatusLabelConfig1)
                            .addComponent(lblProductNameLabelConfig1)
                            .addComponent(lblCategoryIDLabelConfig1))
                        .addGap(18, 18, 18)
                        .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbCategoryID1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtQuantity1)
                            .addComponent(txtPrice1)
                            .addComponent(txtProductName1)
                            .addComponent(txtSizeID1)
                            .addComponent(txtProductID1)
                            .addGroup(pnlProductConfiguration1Layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(34, 34, 34)
                                .addComponent(jRadioButton2)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        pnlProductConfiguration1Layout.setVerticalGroup(
            pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductConfiguration1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductIDLabelConfig1)
                    .addComponent(txtProductID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSizeIDLabelConfig1)
                    .addComponent(txtSizeID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductNameLabelConfig1)
                    .addComponent(txtProductName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPriceIDLabelConfig1)
                    .addComponent(txtPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantityLabelConfig1)
                    .addComponent(txtQuantity1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBusinessStatusLabelConfig1)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(18, 18, 18)
                .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoryIDLabelConfig1)
                    .addComponent(cbbCategoryID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd1)
                    .addComponent(btnDelete1)
                    .addComponent(btnUpdate1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlProductDetails.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12))); // NOI18N

        lblProductIDLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblProductIDLabel.setText("Product ID:");

        lblProductIDDisplay.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblProductIDDisplay.setText("PRD01");

        lblSizeIDLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblSizeIDLabel.setText("Size ID:");

        lblSizeIDDisplay.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblSizeIDDisplay.setText("L");

        lblProductNameDisplay.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblProductNameDisplay.setText("Fried Chicken");

        lblProductNameLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblProductNameLabel.setText("Product name:");

        lblPriceLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblPriceLabel.setText("Price:");

        lblPriceDisplay.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblPriceDisplay.setText("70000");

        lblQuantityDisplay.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblQuantityDisplay.setText("100");

        lblQuantityLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblQuantityLabel.setText("Quantity:");

        lblCategoryIDLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCategoryIDLabel.setText("Category ID:");

        lblCategoryIDDisplay.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblCategoryIDDisplay.setText("CATA01");

        lblBusinessStatusLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBusinessStatusLabel.setText("Business Status:");

        lblBusinessStatusDisplay.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblBusinessStatusDisplay.setText("On");

        javax.swing.GroupLayout pnlProductDetailsLayout = new javax.swing.GroupLayout(pnlProductDetails);
        pnlProductDetails.setLayout(pnlProductDetailsLayout);
        pnlProductDetailsLayout.setHorizontalGroup(
            pnlProductDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProductDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProductDetailsLayout.createSequentialGroup()
                        .addGroup(pnlProductDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProductNameLabel)
                            .addComponent(lblCategoryIDLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlProductDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCategoryIDDisplay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProductNameDisplay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlProductDetailsLayout.createSequentialGroup()
                        .addGroup(pnlProductDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProductIDLabel)
                            .addComponent(lblSizeIDLabel))
                        .addGap(55, 55, 55)
                        .addGroup(pnlProductDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlProductDetailsLayout.createSequentialGroup()
                                .addComponent(lblSizeIDDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(2, 2, 2))
                            .addComponent(lblProductIDDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))
                    .addGroup(pnlProductDetailsLayout.createSequentialGroup()
                        .addComponent(lblPriceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPriceDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlProductDetailsLayout.createSequentialGroup()
                        .addComponent(lblQuantityLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblQuantityDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlProductDetailsLayout.createSequentialGroup()
                        .addComponent(lblBusinessStatusLabel)
                        .addGap(18, 18, 18)
                        .addComponent(lblBusinessStatusDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlProductDetailsLayout.setVerticalGroup(
            pnlProductDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductDetailsLayout.createSequentialGroup()
                .addGroup(pnlProductDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductIDLabel)
                    .addComponent(lblProductIDDisplay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProductDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSizeIDLabel)
                    .addComponent(lblSizeIDDisplay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProductDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductNameLabel)
                    .addComponent(lblProductNameDisplay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProductDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPriceLabel)
                    .addComponent(lblPriceDisplay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProductDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantityLabel)
                    .addComponent(lblQuantityDisplay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProductDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCategoryIDDisplay)
                    .addComponent(lblCategoryIDLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProductDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBusinessStatusDisplay)
                    .addComponent(lblBusinessStatusLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbbSearchFilter.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbbSearchFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ProductID", "SizeID", "ProductName", "BusinessStatus", "CategoryID" }));

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        button1.setBackground(new java.awt.Color(255, 255, 255));
        button1.setBorder(null);
        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search.png"))); // NOI18N
        button1.setColor(new java.awt.Color(255, 255, 255));
        button1.setColorClick(new java.awt.Color(255, 255, 255));
        button1.setColorOver(new java.awt.Color(255, 255, 255));
        button1.setFocusPainted(false);
        button1.setRadius(5);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(srcProductList1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbbSearchFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlProductDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlProductConfiguration1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(srcProductList1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbbSearchFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(pnlProductDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pnlProductConfiguration1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdate1;
    private Custom.Button button1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbCategoryID;
    private javax.swing.JComboBox<String> cbbCategoryID1;
    private javax.swing.JComboBox<String> cbbSearchFilter;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblBusinessStatusDisplay;
    private javax.swing.JLabel lblBusinessStatusLabel;
    private javax.swing.JLabel lblBusinessStatusLabelConfig;
    private javax.swing.JLabel lblBusinessStatusLabelConfig1;
    private javax.swing.JLabel lblCategoryIDDisplay;
    private javax.swing.JLabel lblCategoryIDLabel;
    private javax.swing.JLabel lblCategoryIDLabelConfig;
    private javax.swing.JLabel lblCategoryIDLabelConfig1;
    private javax.swing.JLabel lblPriceDisplay;
    private javax.swing.JLabel lblPriceIDLabelConfig;
    private javax.swing.JLabel lblPriceIDLabelConfig1;
    private javax.swing.JLabel lblPriceLabel;
    private javax.swing.JLabel lblProductIDDisplay;
    private javax.swing.JLabel lblProductIDLabel;
    private javax.swing.JLabel lblProductIDLabelConfig;
    private javax.swing.JLabel lblProductIDLabelConfig1;
    private javax.swing.JLabel lblProductNameDisplay;
    private javax.swing.JLabel lblProductNameLabel;
    private javax.swing.JLabel lblProductNameLabelConfig;
    private javax.swing.JLabel lblProductNameLabelConfig1;
    private javax.swing.JLabel lblQuantityDisplay;
    private javax.swing.JLabel lblQuantityLabel;
    private javax.swing.JLabel lblQuantityLabelConfig;
    private javax.swing.JLabel lblQuantityLabelConfig1;
    private javax.swing.JLabel lblSizeIDDisplay;
    private javax.swing.JLabel lblSizeIDLabel;
    private javax.swing.JLabel lblSizeIDLabelConfig;
    private javax.swing.JLabel lblSizeIDLabelConfig1;
    private javax.swing.JPanel pnlProductConfiguration;
    private javax.swing.JPanel pnlProductConfiguration1;
    private javax.swing.JPanel pnlProductDetails;
    private javax.swing.JScrollPane srcProductList;
    private javax.swing.JScrollPane srcProductList1;
    private javax.swing.JTable tblProductList;
    private javax.swing.JTable tblProductList1;
    private javax.swing.JTextField txtBusinessStatus;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtPrice1;
    private javax.swing.JTextField txtProductID;
    private javax.swing.JTextField txtProductID1;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductName1;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtQuantity1;
    private javax.swing.JTextField txtSizeID;
    private javax.swing.JTextField txtSizeID1;
    // End of variables declaration//GEN-END:variables
}
