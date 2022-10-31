
package GUI;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileFilter;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

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
        cbbCategoryID1 = new javax.swing.JComboBox<>();
        lblBusinessStatusLabelConfig1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        lblProductImgLabelConfig2 = new javax.swing.JLabel();
        btnProductImage = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        button4 = new Custom.Button();
        button5 = new Custom.Button();
        button6 = new Custom.Button();
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

        lblBusinessStatusLabelConfig1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBusinessStatusLabelConfig1.setText("Business Status:");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("On");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jRadioButton2.setText("Off");

        lblProductImgLabelConfig2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblProductImgLabelConfig2.setText("Product Image:");

        btnProductImage.setText("Choose an image");
        btnProductImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductImage.setFocusable(false);
        btnProductImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductImageMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/chicken-leg.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(120, 120));

        button4.setText("Update");
        button4.setColor(new java.awt.Color(255, 255, 255));
        button4.setColorClick(new java.awt.Color(255, 255, 255));
        button4.setColorOver(new java.awt.Color(242, 152, 174));
        button4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        button5.setText("Add");
        button5.setColor(new java.awt.Color(255, 255, 255));
        button5.setColorClick(new java.awt.Color(255, 255, 255));
        button5.setColorOver(new java.awt.Color(242, 152, 174));
        button5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });

        button6.setText("Delete");
        button6.setColor(new java.awt.Color(255, 255, 255));
        button6.setColorClick(new java.awt.Color(255, 255, 255));
        button6.setColorOver(new java.awt.Color(242, 152, 174));
        button6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProductConfiguration1Layout = new javax.swing.GroupLayout(pnlProductConfiguration1);
        pnlProductConfiguration1.setLayout(pnlProductConfiguration1Layout);
        pnlProductConfiguration1Layout.setHorizontalGroup(
            pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductConfiguration1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProductConfiguration1Layout.createSequentialGroup()
                        .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProductIDLabelConfig1)
                            .addComponent(lblSizeIDLabelConfig1)
                            .addComponent(lblPriceIDLabelConfig1)
                            .addComponent(lblQuantityLabelConfig1)
                            .addComponent(lblBusinessStatusLabelConfig1)
                            .addComponent(lblProductNameLabelConfig1)
                            .addComponent(lblCategoryIDLabelConfig1)
                            .addComponent(lblProductImgLabelConfig2))
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
                                .addGap(0, 0, Short.MAX_VALUE))
<<<<<<< Updated upstream
                            .addComponent(btnProductImage, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProductConfiguration1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
=======
                            .addComponent(btnProductImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlProductConfiguration1Layout.createSequentialGroup()
                        .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
>>>>>>> Stashed changes
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProductConfiguration1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblProductImgLabelConfig2)
                    .addComponent(btnProductImage))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
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
        button1.setColorOver(new java.awt.Color(242, 152, 174));
        button1.setFocusPainted(false);
        button1.setRadius(5);
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< Updated upstream
                    .addComponent(srcProductList1, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
=======
                    .addComponent(srcProductList1, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
>>>>>>> Stashed changes
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbbSearchFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlProductConfiguration1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlProductConfiguration1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbbSearchFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(srcProductList1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button1ActionPerformed

    private void btnProductImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductImageMouseClicked
        JFileChooser filechooser = new JFileChooser();//Mở form chọn ảnh cho người dùng
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("IMG","jpg","png");//Chỉ chọn file png và jpg
        filechooser.setFileFilter(imageFilter);
        filechooser.setMultiSelectionEnabled(false);// Không cho chọn nhiều ảnh một lúc
        
        int x = filechooser.showDialog(this, "Chọn file");
        if( x == JFileChooser.APPROVE_OPTION){
            File f = filechooser.getSelectedFile();
            //Resize file ảnh vừa chọn
            ImageIcon icon = new ImageIcon( f.getAbsolutePath());
            Image img = icon.getImage();
            Image resize_Img = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), img.SCALE_SMOOTH);
            icon = new ImageIcon(resize_Img);
            //Gán icon cho label
            jLabel1.setIcon(icon);
        }
    }//GEN-LAST:event_btnProductImageMouseClicked

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button4ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button5ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProductImage;
    private Custom.Button button1;
    private Custom.Button button4;
    private Custom.Button button5;
    private Custom.Button button6;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbCategoryID1;
    private javax.swing.JComboBox<String> cbbSearchFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblBusinessStatusLabelConfig1;
    private javax.swing.JLabel lblCategoryIDLabelConfig1;
    private javax.swing.JLabel lblPriceIDLabelConfig1;
    private javax.swing.JLabel lblProductIDLabelConfig1;
    private javax.swing.JLabel lblProductImgLabelConfig2;
    private javax.swing.JLabel lblProductNameLabelConfig1;
    private javax.swing.JLabel lblQuantityLabelConfig1;
    private javax.swing.JLabel lblSizeIDLabelConfig1;
    private javax.swing.JPanel pnlProductConfiguration1;
    private javax.swing.JScrollPane srcProductList1;
    private javax.swing.JTable tblProductList1;
    private javax.swing.JTextField txtPrice1;
    private javax.swing.JTextField txtProductID1;
    private javax.swing.JTextField txtProductName1;
    private javax.swing.JTextField txtQuantity1;
    private javax.swing.JTextField txtSizeID1;
    // End of variables declaration//GEN-END:variables
}
