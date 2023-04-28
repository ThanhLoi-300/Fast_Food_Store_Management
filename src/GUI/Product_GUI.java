package GUI;

import BUS.Category_BUS;
import BUS.DecentralizationDetail_BUS;
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
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Product_GUI extends javax.swing.JPanel implements checkPermission{

    Product_BUS productBUS = new Product_BUS();
    ArrayList<Product_DTO> listProduct;
    private DecentralizationDetail_BUS dcdtBUS = new DecentralizationDetail_BUS();
    String chosenImg = "/Img/chicken-leg.png";
    private int permissionType;
    String dcdt = "";

    public Product_GUI(int permissionType, String dcdt_Id) {
        setBackground(new Color(51, 51, 51));
        listProduct = productBUS.loadDataProduct();
        initComponents();
        loadProductList(listProduct);
        loadCategoryComboboxModel();
        this.permissionType = permissionType;
        this.dcdt = dcdt_Id;
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
        roundPanel1 = new Custom.RoundPanel();
        roundPanel2 = new Custom.RoundPanel();
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
        btnAddSize = new Custom.Button();
        btnAdd = new Custom.Button();
        btnUpdate = new Custom.Button();
        btnDelete = new Custom.Button();
        btnRefresh = new Custom.Button();
        roundPanel3 = new Custom.RoundPanel();
        cbbSearchFilter = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new Custom.Button();
        srcProductList1 = new javax.swing.JScrollPane();
        tblProductList1 = new javax.swing.JTable();

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

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1070, 700));

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        pnlProductConfiguration1.setBackground(new java.awt.Color(255, 255, 255));
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

        btnAddSize.setBackground(new java.awt.Color(240, 240, 240));
        btnAddSize.setBorder(null);
        btnAddSize.setText("Add size");
        btnAddSize.setColor(new java.awt.Color(240, 240, 240));
        btnAddSize.setColorClick(new java.awt.Color(255, 255, 255));
        btnAddSize.setColorOver(new java.awt.Color(255, 255, 255));
        btnAddSize.setFocusPainted(false);
        btnAddSize.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAddSize.setRadius(20);
        btnAddSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSizeActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(240, 240, 240));
        btnAdd.setBorder(null);
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/plus.png"))); // NOI18N
        btnAdd.setText("  Add    ");
        btnAdd.setColor(new java.awt.Color(240, 240, 240));
        btnAdd.setColorClick(new java.awt.Color(240, 235, 235));
        btnAdd.setColorOver(new java.awt.Color(255, 255, 255));
        btnAdd.setFocusPainted(false);
        btnAdd.setRadius(20);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(240, 240, 240));
        btnUpdate.setBorder(null);
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/wrench.png"))); // NOI18N
        btnUpdate.setText("  Update");
        btnUpdate.setColor(new java.awt.Color(240, 240, 240));
        btnUpdate.setColorClick(new java.awt.Color(240, 235, 235));
        btnUpdate.setColorOver(new java.awt.Color(255, 255, 255));
        btnUpdate.setFocusPainted(false);
        btnUpdate.setRadius(20);
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(240, 240, 240));
        btnDelete.setBorder(null);
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/delete.png"))); // NOI18N
        btnDelete.setText("  Delete");
        btnDelete.setColor(new java.awt.Color(240, 240, 240));
        btnDelete.setColorClick(new java.awt.Color(240, 235, 235));
        btnDelete.setColorOver(new java.awt.Color(255, 255, 255));
        btnDelete.setFocusPainted(false);
        btnDelete.setRadius(20);
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(240, 240, 240));
        btnRefresh.setBorder(null);
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/refresh.png"))); // NOI18N
        btnRefresh.setText("  Refresh");
        btnRefresh.setColor(new java.awt.Color(240, 240, 240));
        btnRefresh.setColorClick(new java.awt.Color(240, 235, 235));
        btnRefresh.setColorOver(new java.awt.Color(255, 255, 255));
        btnRefresh.setFocusPainted(false);
        btnRefresh.setRadius(20);
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefreshMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlProductConfiguration1Layout = new javax.swing.GroupLayout(pnlProductConfiguration1);
        pnlProductConfiguration1.setLayout(pnlProductConfiguration1Layout);
        pnlProductConfiguration1Layout.setHorizontalGroup(
            pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductConfiguration1Layout.createSequentialGroup()
                .addContainerGap()
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
                        .addGap(0, 124, Short.MAX_VALUE))
                    .addComponent(btnProductImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(pnlProductConfiguration1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProductConfiguration1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblProductImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(pnlProductConfiguration1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblProductImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlProductConfiguration1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btnAddSize, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlProductConfiguration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlProductConfiguration1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlProductConfiguration1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));

        cbbSearchFilter.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbbSearchFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ProductID", "SizeID", "ProductName", "CategoryID" }));
        cbbSearchFilter.setFocusable(false);

        txtSearch.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnSearch.setBorder(null);
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search.png"))); // NOI18N
        btnSearch.setColor(new java.awt.Color(240, 240, 240));
        btnSearch.setColorClick(new java.awt.Color(255, 255, 255));
        btnSearch.setColorOver(new java.awt.Color(255, 255, 255));
        btnSearch.setFocusPainted(false);
        btnSearch.setFocusable(false);
        btnSearch.setRadius(5);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        srcProductList1.setBackground(new java.awt.Color(255, 255, 255));
        srcProductList1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Products List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12))); // NOI18N

        tblProductList1.setAutoCreateRowSorter(true);
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
        tblProductList1.setOpaque(false);
        tblProductList1.setRowHeight(30);
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

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(srcProductList1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(cbbSearchFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbSearchFilter, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(txtSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(srcProductList1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (!txtSearch.getText().isEmpty()) {
            ArrayList<Product_DTO> resultList = productBUS.searchProduct(txtSearch.getText(),cbbSearchFilter.getSelectedItem()+"");
            loadProductList(resultList);
            refresh();
        }
        else {
            loadProductList(listProduct);
            refresh();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tblProductList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductList1MouseClicked
        int i = tblProductList1.getSelectedRow();
        String selectedID = (String) tblProductList1.getValueAt(i, 0);
        String selectedSize = (String) tblProductList1.getValueAt(i, 1);
        Product_DTO selectedProduct = listProduct.get(i);
        
        for (Product_DTO pd : listProduct) {
            if (pd.getProductID().equalsIgnoreCase(selectedID) && pd.getSize().equalsIgnoreCase(selectedSize)) {
                selectedProduct = pd;
            }
        }

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
        
        ImageIcon icon = new ImageIcon(selectedProduct.getImage());
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(lblProductImg.getWidth(), lblProductImg.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);
        //chosenImg = selectedProduct.getImage();
        lblProductImg.setIcon(icon);
    }//GEN-LAST:event_tblProductList1MouseClicked

    private void btnProductImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductImageActionPerformed
        this.permissionType = dcdtBUS.readById(this.dcdt).getIsProduct();
        if(this.permissionType!=2){
            this.hienThiErrorMess();
            return;
        }
        JFileChooser fc = new JFileChooser();
        fc.removeChoosableFileFilter(fc.getFileFilter());
        FileFilter filter = new FileNameExtensionFilter("Images (.jpeg, .jpg, .png)","jpeg","jpg","png");
        fc.setFileFilter(filter);
        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            chosenImg = file.getPath();
            File file2 = new File("src\\Img\\" + file.getName());
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
        this.permissionType = dcdtBUS.readById(this.dcdt).getIsProduct();
        if(this.permissionType!=2){
            this.hienThiErrorMess();
            return;
        }
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
                        if (productBUS.productDeletedPreviously(id, txtSizeAddSize.getText())) {
                            if (productBUS.restoreProduct(id, txtSizeAddSize.getText(), Integer.parseInt(txtPriceAddSize.getText()), Integer.parseInt(txtQuantityAddSize.getText()))) {
                                JOptionPane.showMessageDialog(pnlAddSize, "Thêm size sản phẩm thành công");
                                listProduct = productBUS.loadDataProduct();
                                loadProductList(listProduct);
                            }
                        } else {
                            Product_DTO product = new Product_DTO(selectedProduct.getProductID(), txtSizeAddSize.getText(), selectedProduct.getProductName(), selectedProduct.getCategoryID(), Integer.parseInt(txtPriceAddSize.getText()), Integer.parseInt(txtQuantityAddSize.getText()), selectedProduct.getImage(), false, selectedProduct.isBusinessStatus());
                            if (productBUS.insertProduct(product)) {
                                JOptionPane.showMessageDialog(pnlAddSize, "Thêm size sản phẩm thành công");
                                listProduct = productBUS.loadDataProduct();
                                loadProductList(listProduct);
                            }
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

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        //Add button
        this.permissionType = dcdtBUS.readById(this.dcdt).getIsProduct();
        if(this.permissionType!=2){
            this.hienThiErrorMess();
            return;
        }
        try {
            String newID;
            newID = productBUS.autoID();
            if (isInputEmpty()) {
                JOptionPane.showMessageDialog(this, "Không được để trống thông tin sản phẩm!");
            } else if (productBUS.productNameExisted(newID, txtProductName1.getText())) {
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
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        this.permissionType = dcdtBUS.readById(this.dcdt).getIsProduct();
        if(this.permissionType!=2){
            this.hienThiErrorMess();
            return;
        }
        if (isInputEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống thông tin sản phẩm!");
        } else {
            int i = tblProductList1.getSelectedRow();
            Product_DTO selectedProduct = listProduct.get(i);
            Product_DTO product = new Product_DTO(selectedProduct.getProductID(), txtSizeID1.getText(), txtProductName1.getText(), cbbCategoryID1.getSelectedItem() + "", Double.parseDouble(txtPrice1.getText()), Integer.parseInt(txtQuantity1.getText()), chosenImg, false, selectedBusinessStatus());
            chosenImg = chosenImg.replace("\\", "/");
            if (productBUS.updateProduct(product,selectedProduct.getSize())) {
                productBUS.update_Status_Of_All_Product(product);
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin sản phẩm thành công!");
                listProduct = productBUS.loadDataProduct();
                loadProductList(listProduct);
                refresh();
            }
        }
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        //Delete button
        this.permissionType = dcdtBUS.readById(this.dcdt).getIsProduct();
        if(this.permissionType!=2){
            this.hienThiErrorMess();
            return;
        }
        if (txtProductID1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần xóa");
        } else {
            if(JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa loại sản phẩm này?", "Warnning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                int i = tblProductList1.getSelectedRow();
                String selectedID = (String) tblProductList1.getValueAt(i, 0);
                String selectedSize = (String) tblProductList1.getValueAt(i, 1);
                Product_DTO selectedProduct = listProduct.get(i);
                
                for (Product_DTO pd : listProduct) {
                    if (pd.getProductID().equalsIgnoreCase(selectedID) && pd.getSize().equalsIgnoreCase(selectedSize)) {
                        selectedProduct = pd;
                    }
                }
                
                
                if (productBUS.deleteProduct(selectedProduct.getProductID(), selectedProduct.getSize())) {
                    JOptionPane.showMessageDialog(this, "Xóa sản phẩm thành công");
                    listProduct = productBUS.loadDataProduct();
                    loadProductList(listProduct);
                    refresh();
                }
            }
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseClicked
        refresh();
    }//GEN-LAST:event_btnRefreshMouseClicked

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
    private Custom.Button btnAdd;
    private Custom.Button btnAddSize;
    private Custom.Button btnDelete;
    private javax.swing.JButton btnProductImage;
    private Custom.Button btnRefresh;
    private Custom.Button btnSearch;
    private Custom.Button btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbCategoryID1;
    private javax.swing.JComboBox<String> cbbSearchFilter;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private Custom.RoundPanel roundPanel1;
    private Custom.RoundPanel roundPanel2;
    private Custom.RoundPanel roundPanel3;
    private javax.swing.JScrollPane srcProductList1;
    private javax.swing.JTable tblProductList1;
    private javax.swing.JTextField txtPrice1;
    private javax.swing.JTextField txtPriceAddSize;
    private javax.swing.JTextField txtProductID1;
    private javax.swing.JTextField txtProductName1;
    private javax.swing.JTextField txtQuantity1;
    private javax.swing.JTextField txtQuantityAddSize;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSizeAddSize;
    private javax.swing.JTextField txtSizeID1;
    // End of variables declaration//GEN-END:variables
}
