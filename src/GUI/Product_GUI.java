package GUI;

import BUS.Category_BUS;
import BUS.Product_BUS;
import DTO.Category_DTO;
import DTO.Product_DTO;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Product_GUI extends javax.swing.JPanel {

    Product_BUS productBUS = new Product_BUS();
    ArrayList<Product_DTO> listProduct;
    String chosenImg = "/Img/chicken-leg.png";

    public Product_GUI() {
        setBackground(new Color(51, 51, 51));
        listProduct = productBUS.loadDataProduct();
        initComponents();
        loadProductList(listProduct);
        loadCategoryComboboxModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlAddSize = new javax.swing.JPanel();
        lblAddSize = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSizeAddSize = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPriceAddSize = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtQuantityAddSize = new javax.swing.JTextField();
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
        rdOn = new javax.swing.JRadioButton();
        rdOff = new javax.swing.JRadioButton();
        lblProductImgLabelConfig2 = new javax.swing.JLabel();
        btnProductImage = new javax.swing.JButton();
        lblProductImg = new javax.swing.JLabel();
        button4 = new Custom.Button();
        button5 = new Custom.Button();
        button6 = new Custom.Button();
        btnAddSize = new Custom.Button();
        cbbSearchFilter = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        button1 = new Custom.Button();

        lblAddSize.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblAddSize.setText("Adding a new size for product \"P01\"");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Size:");

        txtSizeAddSize.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("Price:");

        txtPriceAddSize.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("Quantity:");

        txtQuantityAddSize.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnlAddSizeLayout = new javax.swing.GroupLayout(pnlAddSize);
        pnlAddSize.setLayout(pnlAddSizeLayout);
        pnlAddSizeLayout.setHorizontalGroup(
            pnlAddSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddSizeLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlAddSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAddSize)
                    .addGroup(pnlAddSizeLayout.createSequentialGroup()
                        .addGroup(pnlAddSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlAddSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSizeAddSize)
                            .addComponent(txtPriceAddSize)
                            .addComponent(txtQuantityAddSize))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        pnlAddSizeLayout.setVerticalGroup(
            pnlAddSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddSizeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAddSize)
                .addGap(18, 18, 18)
                .addGroup(pnlAddSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSizeAddSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlAddSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPriceAddSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlAddSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtQuantityAddSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

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
        tblProductList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductList1MouseClicked(evt);
            }
        });
        srcProductList1.setViewportView(tblProductList1);
        if (tblProductList1.getColumnModel().getColumnCount() > 0) {
            tblProductList1.getColumnModel().getColumn(5).setResizable(false);
            tblProductList1.getColumnModel().getColumn(6).setResizable(false);
        }

        pnlProductConfiguration1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product Configuration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12))); // NOI18N

        lblProductIDLabelConfig1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblProductIDLabelConfig1.setText("Product ID:");

        txtProductID1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtProductID1.setEnabled(false);

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

        cbbCategoryID1.setToolTipText("Tip: ");

        lblBusinessStatusLabelConfig1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBusinessStatusLabelConfig1.setText("Business Status:");

        buttonGroup1.add(rdOn);
        rdOn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rdOn.setSelected(true);
        rdOn.setText("On");

        buttonGroup1.add(rdOff);
        rdOff.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rdOff.setText("Off");

        lblProductImgLabelConfig2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblProductImgLabelConfig2.setText("Product Image:");

        btnProductImage.setText("Choose an image");
        btnProductImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductImage.setFocusable(false);
        btnProductImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductImageActionPerformed(evt);
            }
        });

        lblProductImg.setPreferredSize(new java.awt.Dimension(120, 120));

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

        btnAddSize.setText("Add size");
        btnAddSize.setColor(new java.awt.Color(255, 255, 255));
        btnAddSize.setColorClick(new java.awt.Color(255, 255, 255));
        btnAddSize.setColorOver(new java.awt.Color(242, 152, 174));
        btnAddSize.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAddSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSizeActionPerformed(evt);
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
                                .addComponent(rdOn)
                                .addGap(34, 34, 34)
                                .addComponent(rdOff)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(btnProductImage, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(pnlProductConfiguration1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlProductConfiguration1Layout.createSequentialGroup()
                                .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlProductConfiguration1Layout.createSequentialGroup()
                                .addComponent(btnAddSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1)))
                        .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProductConfiguration1Layout.createSequentialGroup()
                                .addComponent(lblProductImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProductConfiguration1Layout.createSequentialGroup()
                                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
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
                    .addComponent(rdOn)
                    .addComponent(rdOff))
                .addGap(18, 18, 18)
                .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoryIDLabelConfig1)
                    .addComponent(cbbCategoryID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblProductImgLabelConfig2)
                    .addComponent(btnProductImage))
                .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProductConfiguration1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblProductImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProductConfiguration1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddSize, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(srcProductList1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
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
                .addGap(70, 70, 70))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button1ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        //Update button
        if (isInputEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống thông tin sản phẩm!");
        } else {
            int i = tblProductList1.getSelectedRow();
            Product_DTO selectedProduct = listProduct.get(i);
            Product_DTO product = new Product_DTO(selectedProduct.getProductID(), txtSizeID1.getText(), txtProductName1.getText(), cbbCategoryID1.getSelectedItem() + "", Integer.parseInt(txtPrice1.getText()), Integer.parseInt(txtQuantity1.getText()), chosenImg, false, selectedBusinessStatus());
            if (productBUS.updateProduct(product)) {
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin sản phẩm thành công!");
                listProduct = productBUS.loadDataProduct();
                loadProductList(listProduct);
                refresh();
            }
        }
    }//GEN-LAST:event_button4ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        //Add button
        try {
            String newID;
            newID = productBUS.autoID();
            if (isInputEmpty()) {
                JOptionPane.showMessageDialog(this, "Không được để trống thông tin sản phẩm!");
            }
            else if (productBUS.productDeletedPreviously(txtSizeID1.getText(), txtProductName1.getText(), Integer.parseInt(txtPrice1.getText()), Integer.parseInt(txtQuantity1.getText()), cbbCategoryID1.getSelectedItem()+"")) {
                if (productBUS.restoreProduct(txtSizeID1.getText(), txtProductName1.getText())) {
                    JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
                    listProduct = productBUS.loadDataProduct();
                    loadProductList(listProduct);
                    refresh();
                }
            }
            else if (productBUS.productNameExisted(newID, txtProductName1.getText())) {
                JOptionPane.showMessageDialog(this, "Tên sản phẩm đã tồn tại!");
            } else {
                chosenImg = chosenImg.replace("\\", "/");
                Product_DTO product = new Product_DTO(newID, txtSizeID1.getText(), txtProductName1.getText(), cbbCategoryID1.getSelectedItem() + "", Integer.parseInt(txtPrice1.getText()), Integer.parseInt(txtQuantity1.getText()), chosenImg, false, true);
                if (productBUS.insertProduct(product)) {
                    JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
                    listProduct = productBUS.loadDataProduct();
                    loadProductList(listProduct);
                    refresh();
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá sản phẩm và số lượng sản phẩm phải là số nguyên");
        }
    }//GEN-LAST:event_button5ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        //Delete button
        if (txtProductID1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần xóa");
        } else {
            int i = tblProductList1.getSelectedRow();
            Product_DTO selectedProduct = listProduct.get(i);
            if (productBUS.deleteProduct(selectedProduct.getProductID(),selectedProduct.getSize())) {
                JOptionPane.showMessageDialog(this, "Xóa sản phẩm thành công");
                listProduct = productBUS.loadDataProduct();
                loadProductList(listProduct);
                refresh();
            }
        }
    }//GEN-LAST:event_button6ActionPerformed

    private void tblProductList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductList1MouseClicked
        int i = tblProductList1.getSelectedRow();
        Product_DTO selectedProduct = listProduct.get(i);

        txtProductID1.setText(selectedProduct.getProductID());
        txtProductName1.setText(selectedProduct.getProductName());
        txtSizeID1.setText(selectedProduct.getSize());
        txtPrice1.setText(selectedProduct.getPrice() + "");
        txtQuantity1.setText(selectedProduct.getQuantity() + "");
        if (selectedProduct.isBusinessStatus()) {
            rdOn.setSelected(true);
        } else {
            rdOff.setSelected(true);
        }
        cbbCategoryID1.setSelectedItem(selectedProduct.getCategoryID());
        lblProductImg.setIcon(new ImageIcon(selectedProduct.getImage()));
    }//GEN-LAST:event_tblProductList1MouseClicked

    private void btnProductImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductImageActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            chosenImg = file.getPath();
            File file2 = new File("src\\Img\\"+file.getName());
            file.renameTo(file2);
            chosenImg = file2.getPath();
            ImageIcon icon = new ImageIcon(chosenImg);
            Image image = icon.getImage();
            Image scaledImage = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);
            lblProductImg.setIcon(icon);
        }
    }//GEN-LAST:event_btnProductImageActionPerformed

    private void btnAddSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSizeActionPerformed
        if (!txtProductID1.getText().isEmpty()) {
            int i = tblProductList1.getSelectedRow();
            Product_DTO selectedProduct = listProduct.get(i);
            String id = selectedProduct.getProductID();
            lblAddSize.setText("Adding a new size for product \"" + id + "\"");
            int option = JOptionPane.showConfirmDialog(this, pnlAddSize, "Adding new product size", JOptionPane.YES_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                try {
                    if (txtPriceAddSize.getText().isEmpty() || txtSizeAddSize.getText().isEmpty() || txtQuantityAddSize.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(pnlAddSize, "Không được để trống thông tin");
                    } else {
                        Product_DTO product = new Product_DTO(selectedProduct.getProductID(), txtSizeAddSize.getText(), selectedProduct.getProductName(), selectedProduct.getCategoryID(), Integer.parseInt(txtPriceAddSize.getText()), Integer.parseInt(txtQuantityAddSize.getText()), selectedProduct.getImage(), false, selectedProduct.isBusinessStatus());
                        if (productBUS.insertProduct(product)) {
                            JOptionPane.showMessageDialog(pnlAddSize, "Thêm size sản phẩm thành công");
                            listProduct = productBUS.loadDataProduct();
                            loadProductList(listProduct);
                        }
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(pnlAddSize, "Giá sản phẩm phải là số nguyên");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần thêm size");
        }
    }//GEN-LAST:event_btnAddSizeActionPerformed

    private void loadCategoryComboboxModel() {
        Category_BUS categoryBUS = new Category_BUS();
        ArrayList<Category_DTO> tempList = categoryBUS.load_Data_Category();

        cbbCategoryID1.removeAllItems();
        for (Category_DTO cate : tempList) {
            cbbCategoryID1.addItem(cate.getCategory_Id());
            cbbCategoryID1.setToolTipText(cbbCategoryID1.getToolTipText() + cate.getCategory_Id() + "=" + cate.getCategory_Name() + " | ");
        }
    }

    private void loadProductList(ArrayList<Product_DTO> listProduct) {
        DefaultTableModel model = (DefaultTableModel) tblProductList1.getModel();
        model.setRowCount(0);
        for (Product_DTO product : listProduct) {
            model.addRow(new Object[]{product.getProductID(), product.getSize(), product.getProductName(), product.getPrice(), product.getQuantity(), product.getBusinessStatus(), product.getCategoryID()});
        }
    }

    private void refresh() {
        txtProductID1.setText("");
        txtProductName1.setText("");
        txtSizeID1.setText("");
        txtPrice1.setText("");
        txtQuantity1.setText("");
        rdOn.setSelected(true);
        cbbCategoryID1.setSelectedIndex(0);
        lblProductImg.setIcon(null);
    }

    private boolean isInputEmpty() {
        return txtProductName1.getText().isEmpty()
                || txtSizeID1.getText().isEmpty()
                || txtPrice1.getText().isEmpty()
                || txtQuantity1.getText().isEmpty()
                || (!rdOn.isSelected() && !rdOff.isSelected())
                || lblProductImg.getIcon() == null;
    }
    
    private boolean selectedBusinessStatus() {
        return rdOn.isSelected();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.Button btnAddSize;
    private javax.swing.JButton btnProductImage;
    private Custom.Button button1;
    private Custom.Button button4;
    private Custom.Button button5;
    private Custom.Button button6;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbCategoryID1;
    private javax.swing.JComboBox<String> cbbSearchFilter;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblAddSize;
    private javax.swing.JLabel lblBusinessStatusLabelConfig1;
    private javax.swing.JLabel lblCategoryIDLabelConfig1;
    private javax.swing.JLabel lblPriceIDLabelConfig1;
    private javax.swing.JLabel lblProductIDLabelConfig1;
    private javax.swing.JLabel lblProductImg;
    private javax.swing.JLabel lblProductImgLabelConfig2;
    private javax.swing.JLabel lblProductNameLabelConfig1;
    private javax.swing.JLabel lblQuantityLabelConfig1;
    private javax.swing.JLabel lblSizeIDLabelConfig1;
    private javax.swing.JPanel pnlAddSize;
    private javax.swing.JPanel pnlProductConfiguration1;
    private javax.swing.JRadioButton rdOff;
    private javax.swing.JRadioButton rdOn;
    private javax.swing.JScrollPane srcProductList1;
    private javax.swing.JTable tblProductList1;
    private javax.swing.JTextField txtPrice1;
    private javax.swing.JTextField txtPriceAddSize;
    private javax.swing.JTextField txtProductID1;
    private javax.swing.JTextField txtProductName1;
    private javax.swing.JTextField txtQuantity1;
    private javax.swing.JTextField txtQuantityAddSize;
    private javax.swing.JTextField txtSizeAddSize;
    private javax.swing.JTextField txtSizeID1;
    // End of variables declaration//GEN-END:variables
}
