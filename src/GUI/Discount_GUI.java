
package GUI;

import BUS.Category_BUS;
import BUS.DecentralizationDetail_BUS;
import BUS.Discount_BUS;
import BUS.Product_BUS;
import DTO.Category_DTO;
import DTO.Discount_DTO;
import DTO.Discount_Detail_DTO;
import DTO.Product_DTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class Discount_GUI extends javax.swing.JPanel implements checkPermission{

    Discount_BUS discount_BUS = new Discount_BUS();
    Product_BUS product_BUS = new Product_BUS();
    
    private ArrayList<Discount_DTO> list_Discount = new ArrayList<Discount_DTO>();
    private ArrayList<Discount_Detail_DTO> list_Product_From_Discount;
    private ArrayList<Product_DTO> list_Product = new ArrayList<Product_DTO>();
    private ArrayList<String> list_Choose_Product = new ArrayList<>();
    private ArrayList<Category_DTO> list_Category = new ArrayList<Category_DTO>();
    private Category_BUS category_BUS = new Category_BUS();
    private DecentralizationDetail_BUS dcdtBUS = new DecentralizationDetail_BUS();
    String dcdt = "";
    SimpleDateFormat fmt = new SimpleDateFormat("MM dd,yyyy");
    private int permissionType;
    
    public Discount_GUI(int permissionType, String dcdt_Id){
        initComponents();
        Auto_Update_Discount();
        list_Category = category_BUS.load_Data_CategoryObBusiness();
        Vector comboBoxItems=new Vector();
        comboBoxItems.add("Tất cả");
        for(int i = 0; i< list_Category.size();i++)
            comboBoxItems.add(list_Category.get(i).getCategory_Name());
        jComboBox3.setModel(new DefaultComboBoxModel(comboBoxItems));
        refresh();
        this.permissionType = permissionType;
        this.dcdt = dcdt_Id;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new Custom.RoundPanel();
        roundPanel2 = new Custom.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAdd = new Custom.Button();
        btnUpdate = new Custom.Button();
        btnRefresh = new Custom.Button();
        jLabel3 = new javax.swing.JLabel();
        cbb_Status = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txt_Percent = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_Discount_Id = new javax.swing.JTextField();
        imageAvatar1 = new Custom.ImageAvatar();
        btnDelete = new Custom.Button();
        start_Time = new com.toedter.calendar.JDateChooser();
        end_Time = new com.toedter.calendar.JDateChooser();
        roundPanel3 = new Custom.RoundPanel();
        txt_Search = new javax.swing.JTextField();
        button1 = new Custom.Button();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Discount = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_Product = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txt_Search1 = new javax.swing.JTextField();
        button2 = new Custom.Button();
        jComboBox3 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(0, 0, 0));

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel1.setPreferredSize(new java.awt.Dimension(1031, 650));

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Ngày bắt đầu: ");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Ngày kết thúc: ");

        btnAdd.setBackground(new java.awt.Color(240, 240, 240));
        btnAdd.setBorder(null);
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/plus.png"))); // NOI18N
        btnAdd.setText("  Add    ");
        btnAdd.setColor(new java.awt.Color(240, 240, 240));
        btnAdd.setColorClick(new java.awt.Color(240, 235, 235));
        btnAdd.setColorOver(new java.awt.Color(255, 255, 255));
        btnAdd.setFocusPainted(false);
        btnAdd.setRadius(20);
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
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

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Trạng thái:");

        cbb_Status.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbb_Status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang áp dụng", "Ngừng áp dụng" }));
        cbb_Status.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cbb_Status.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Giá trị (%) :");

        txt_Percent.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Mã khuyến mãi:");

        txt_Discount_Id.setEditable(false);
        txt_Discount_Id.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_Discount_Id.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/black-friday.png"))); // NOI18N

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

        start_Time.setDateFormatString("dd-MM-yyyy");
        start_Time.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        end_Time.setDateFormatString("dd-MM-yyyy");
        end_Time.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageAvatar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(34, 34, 34)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbb_Status, 0, 200, Short.MAX_VALUE)
                            .addComponent(end_Time, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(39, 39, 39)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_Percent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(start_Time, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(27, 27, 27)
                        .addComponent(txt_Discount_Id)))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_Discount_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_Percent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(start_Time, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(end_Time, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbb_Status)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txt_Search.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_Search.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        button1.setBackground(new java.awt.Color(240, 240, 240));
        button1.setBorder(null);
        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search.png"))); // NOI18N
        button1.setColor(new java.awt.Color(240, 240, 240));
        button1.setColorClick(new java.awt.Color(240, 235, 235));
        button1.setColorOver(new java.awt.Color(255, 255, 255));
        button1.setFocusPainted(false);
        button1.setFocusable(false);
        button1.setRadius(5);

        jComboBox2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đang áp dụng", "Ngừng áp dụng" }));
        jComboBox2.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jComboBox2.setFocusable(false);
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        tbl_Discount.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbl_Discount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã khuyến mãi", "Giá trị (%)", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Discount.setGridColor(new java.awt.Color(51, 51, 51));
        tbl_Discount.setRowHeight(20);
        tbl_Discount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DiscountMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Discount);
        if (tbl_Discount.getColumnModel().getColumnCount() > 0) {
            tbl_Discount.getColumnModel().getColumn(0).setMinWidth(200);
            tbl_Discount.getColumnModel().getColumn(0).setMaxWidth(200);
            tbl_Discount.getColumnModel().getColumn(1).setMinWidth(200);
            tbl_Discount.getColumnModel().getColumn(1).setMaxWidth(200);
        }

        tbl_Product.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbl_Product.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Giá cũ", "Giá mới", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Product.setGridColor(new java.awt.Color(51, 51, 51));
        tbl_Product.setRowHeight(20);
        tbl_Product.setShowGrid(true);
        tbl_Product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ProductMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_Product);
        if (tbl_Product.getColumnModel().getColumnCount() > 0) {
            tbl_Product.getColumnModel().getColumn(0).setMinWidth(90);
            tbl_Product.getColumnModel().getColumn(0).setMaxWidth(90);
            tbl_Product.getColumnModel().getColumn(2).setMinWidth(100);
            tbl_Product.getColumnModel().getColumn(2).setMaxWidth(100);
            tbl_Product.getColumnModel().getColumn(3).setMinWidth(100);
            tbl_Product.getColumnModel().getColumn(3).setMaxWidth(100);
            tbl_Product.getColumnModel().getColumn(4).setMaxWidth(70);
        }

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        txt_Search1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_Search1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        button2.setBackground(new java.awt.Color(240, 240, 240));
        button2.setBorder(null);
        button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search.png"))); // NOI18N
        button2.setColor(new java.awt.Color(240, 240, 240));
        button2.setColorClick(new java.awt.Color(240, 235, 235));
        button2.setColorOver(new java.awt.Color(255, 255, 255));
        button2.setFocusPainted(false);
        button2.setFocusable(false);
        button2.setRadius(5);

        jComboBox3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Loại sản phẩm" }));
        jComboBox3.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jComboBox3.setFocusable(false);
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(roundPanel3Layout.createSequentialGroup()
                                .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                                .addComponent(txt_Search1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(button1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_Search, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(button2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_Search1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        txt_Search.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateFieldState();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateFieldState();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateFieldState();
            }

            protected void updateFieldState() {
                if( txt_Search.getText().isEmpty() || txt_Search.getText() == null){
                    list_Discount = discount_BUS.load_Discount(txt_Search.getText(), jComboBox2.getSelectedItem().toString());
                    load_Discount(list_Discount);
                }
                else {
                    list_Discount = discount_BUS.load_Discount(txt_Search.getText(),jComboBox2.getSelectedItem().toString());
                    load_Discount(list_Discount);
                }
            }
        });
        txt_Search1.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateFieldState();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateFieldState();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateFieldState();
            }

            protected void updateFieldState() {
                if(discount_BUS.check_Discount_Id(txt_Discount_Id.getText())){
                    DefaultTableModel model = (DefaultTableModel) tbl_Product.getModel();
                    model.setRowCount(0);
                    list_Choose_Product.clear();
                    load_Product_Remaining();
                }else{
                    list_Product_From_Discount = discount_BUS.load_Detail_Discount(txt_Discount_Id.getText());
                    load_Product_From_Discount(list_Product_From_Discount);
                }
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(roundPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        this.permissionType = dcdtBUS.readById(this.dcdt).getIsDiscount();
        if(this.permissionType!=2){
            this.hienThiErrorMess();
            return;
        }
        if(JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa loại sản phẩm này?", "Warnning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
           if(discount_BUS.delete_Discount(txt_Discount_Id.getText())){
               JOptionPane.showMessageDialog(null, "Xóa thành công");
               refresh();
           }else JOptionPane.showMessageDialog(null, "Xóa không thành công");
       }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        this.permissionType = dcdtBUS.readById(this.dcdt).getIsDiscount();
        if(this.permissionType!=2){
            this.hienThiErrorMess();
            return;
        }
        if( txt_Percent.getText().isEmpty() || ((JTextField)start_Time.getDateEditor().getUiComponent()).getText().isEmpty() || ((JTextField)end_Time.getDateEditor().getUiComponent()).getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ dữ liệu");
        else{
            int percent = 0;
            boolean flag = false;
            
            try {
                percent = Integer.parseInt(txt_Percent.getText());
                flag = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Trường giá trị chỉ được nhập số");
            }
            
            int status;
            if(cbb_Status.getSelectedIndex() == 0){
                status = 1;
            }else status = 0;
            
            if(discount_BUS.check_Name(Integer.parseInt(txt_Percent.getText()))){
                JOptionPane.showMessageDialog(null, "Giá trị đã tồn tại");
            }else if(percent < 1 || percent > 90){
                JOptionPane.showMessageDialog(null, "Giá trị phải từ 1 -> 90 ");
            }else if(flag){
                if(JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thêm loại sản phẩm này?", "Warnning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    String Id = txt_Discount_Id.getText();
                    
                    String start = ((JTextField)start_Time.getDateEditor().getUiComponent()).getText();
                    String end = ((JTextField)end_Time.getDateEditor().getUiComponent()).getText();
                    
                    Discount_DTO discount_DTO = new Discount_DTO(Id,percent,status,0,start,end);

                    if(discount_BUS.insert_Discount(discount_DTO)){
                        refresh();
                        JOptionPane.showMessageDialog(null, "Thêm thành công" );
                    }
                    else JOptionPane.showMessageDialog(null, "Thêm thất bại");
                }
            }
            
        }
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseClicked
        refresh();
    }//GEN-LAST:event_btnRefreshMouseClicked

    private void tbl_DiscountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DiscountMouseClicked
        int i = tbl_Discount.getSelectedRow();
        list_Discount = discount_BUS.load_Discount(txt_Search.getText(),jComboBox2.getSelectedItem().toString());
        
        Discount_DTO discount_DTO = list_Discount.get(i);
        txt_Discount_Id.setText(discount_DTO.getDiscount_Id());
        txt_Percent.setText(discount_DTO.getDiscount_Percent()+"");

        String start = discount_DTO.getStart_Time();
        Date date_Start = null;
        try {
            date_Start = new SimpleDateFormat("dd-MM-yyyy").parse(start);
        } catch (ParseException ex) {
            Logger.getLogger(Discount_GUI.class.getName()).log(Level.SEVERE, null, ex);
       }
        start_Time.setDate(date_Start);
        
        String end = discount_DTO.getEnd_Time();
        Date date_End = null;
        try {
            date_End = new SimpleDateFormat("dd-MM-yyyy").parse(end);
        } catch (ParseException ex) {
            Logger.getLogger(Discount_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        end_Time.setDate(date_End);

        if(discount_DTO.getStatus() == 1) cbb_Status.setSelectedIndex(0);
        else cbb_Status.setSelectedIndex(1);
        
        if(discount_BUS.check_Discount_Id(txt_Discount_Id.getText())){            
            DefaultTableModel model = (DefaultTableModel) tbl_Product.getModel();
            model.setRowCount(0);
            list_Choose_Product.clear();
            load_Product_Remaining();
        }else{
            list_Product_From_Discount = discount_BUS.load_Detail_Discount(txt_Discount_Id.getText());
            load_Product_From_Discount(list_Product_From_Discount); 
        }  
    }//GEN-LAST:event_tbl_DiscountMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        this.permissionType = dcdtBUS.readById(this.dcdt).getIsDiscount();
        if(this.permissionType!=2){
            this.hienThiErrorMess();
            return;
        }
        if(tbl_Discount.getSelectedRow()< 0)
            JOptionPane.showMessageDialog(null, "Vui lòng chọn loại giảm giá muốn cập nhật");
        else if( txt_Percent.getText().isEmpty() || ((JTextField)start_Time.getDateEditor().getUiComponent()).getText().isEmpty() || ((JTextField)end_Time.getDateEditor().getUiComponent()).getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ dữ liệu");
        }else{
            if(discount_BUS.check_Name(Integer.parseInt(txt_Percent.getText()), txt_Discount_Id.getText()))
                JOptionPane.showMessageDialog(null, "Giá trị bị  trùng");
            else{
                if(JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn cập nhật loại giảm giá này?", "Warnning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    int Status = 0;
                    if(cbb_Status.getSelectedIndex() == 0) Status = 1;
                    else Status = 0;
                    
                    String start = ((JTextField)start_Time.getDateEditor().getUiComponent()).getText();
                    String end = ((JTextField)end_Time.getDateEditor().getUiComponent()).getText();
                    
                    Discount_DTO discount = new Discount_DTO(txt_Discount_Id.getText(),Integer.parseInt(txt_Percent.getText()), Status, 0,start,end);
                    
                    if(discount_BUS.update_Discount(discount)){
                        JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                        discount_BUS.delete_Detail_Discount(txt_Discount_Id.getText());
                        for(String id : list_Choose_Product)
                            discount_BUS.inser_Detail_Discount(txt_Discount_Id.getText(), id);
                        
                        list_Choose_Product.clear();
                        refresh();
                    }else JOptionPane.showMessageDialog(null, "Cập nhật không thành công");
                }
            }
            
        }
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void tbl_ProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ProductMouseClicked
        int i  = tbl_Product.getSelectedRow();
        if( (boolean)tbl_Product.getValueAt(i, 4) == false){
            tbl_Product.setValueAt(true, i, 4);
            list_Choose_Product.add(tbl_Product.getValueAt(i, 0)+"");
        }else {
            tbl_Product.setValueAt(false, i, 4);
            list_Choose_Product.remove(tbl_Product.getValueAt(i, 0)+"");
        }
    }//GEN-LAST:event_tbl_ProductMouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        if( txt_Search.getText().isEmpty() || txt_Search.getText() == null){
            list_Discount = discount_BUS.load_Discount(txt_Search.getText(), jComboBox2.getSelectedItem().toString());
            load_Discount(list_Discount);
        }
        else {
            list_Discount = discount_BUS.load_Discount(txt_Search.getText(),jComboBox2.getSelectedItem().toString());
            load_Discount(list_Discount);
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        if(discount_BUS.check_Discount_Id(txt_Discount_Id.getText())){            
            DefaultTableModel model = (DefaultTableModel) tbl_Product.getModel();
            model.setRowCount(0);
            list_Choose_Product.clear();
            load_Product_Remaining();
        }else{
            list_Product_From_Discount = discount_BUS.load_Detail_Discount(txt_Discount_Id.getText());
            load_Product_From_Discount(list_Product_From_Discount); 
        }  
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void auto_Create_Id(){
        String Id = "KM" + discount_BUS.get_All_Discount();
        txt_Discount_Id.setText(Id);
    }
    
    private void refresh(){
        Auto_Update_Discount();
        txt_Search.setText("");
        txt_Search1.setText("");
        txt_Percent.setText("");
        start_Time.setDate(null);
        end_Time.setDate(null);
        list_Discount = discount_BUS.load_Discount(txt_Search.getText(),jComboBox2.getSelectedItem().toString());
        load_Discount(list_Discount);
        list_Product.clear();
        DefaultTableModel model = (DefaultTableModel) tbl_Product.getModel();
        model.setRowCount(0);
        auto_Create_Id();
    }
    
    private void load_Discount( ArrayList<Discount_DTO> list_Discount){
        DefaultTableModel model = (DefaultTableModel) tbl_Discount.getModel();
        model.setRowCount(0);
        String status = "";
        for(Discount_DTO discount : list_Discount){
            if(discount.getStatus() == 1) status = "Đang áp dụng";
            else status = "Ngừng áp dụng";
            
            model.addRow( new Object[] { discount.getDiscount_Id(), 
                                         discount.getDiscount_Percent(), status});
        }
    }
    
    private void load_Product_From_Discount( ArrayList<Discount_Detail_DTO> List_Product){
        DefaultTableModel model = (DefaultTableModel) tbl_Product.getModel();
        model.setRowCount(0);
        list_Choose_Product.clear();
        for(Discount_Detail_DTO detail : List_Product){
            Product_DTO product = discount_BUS.get_Product_By_Id(detail.getProduct_Id()); 
            Discount_DTO discount = discount_BUS.get_Discount_By_Id(detail.getDiscount_Id());
            double newPrice = product.getPrice() - product.getPrice() * discount.getDiscount_Percent()/100;
            list_Choose_Product.add(detail.getProduct_Id());
            model.addRow( new Object[] { detail.getProduct_Id(), product.getProductName(), product.getPrice(), newPrice, true});
        }
        load_Product_Remaining();
    }
    
    private void load_Product_Remaining(){
        ArrayList<Product_DTO> product_NotIn_Discount_Detail = discount_BUS.load_Product_Remaining(txt_Search1.getText(),jComboBox3.getSelectedItem().toString());
            
        DefaultTableModel model = (DefaultTableModel) tbl_Product.getModel();
        for(Product_DTO product : product_NotIn_Discount_Detail){
            model.addRow( new Object[] { product.getProductID(), product.getProductName(), product.getPrice(), null, false});
        }
    }
    
    private void Auto_Update_Discount(){
        int day = LocalDateTime.now().getDayOfMonth();
        int month = LocalDateTime.now().getMonthValue();
        int year = LocalDateTime.now().getYear();
        
        String now = day + "-" + month + "-" + year;
        Date date_Now = null ;
        try {
            date_Now = new SimpleDateFormat("dd-MM-yyyy").parse(now);
        } catch (ParseException ex) {
            Logger.getLogger(Discount_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ArrayList<Discount_DTO> list_Discount = discount_BUS.get_Discount();
        
        for(Discount_DTO discount : list_Discount){      
            try {
                if( date_Now.compareTo(new SimpleDateFormat("dd-MM-yyyy").parse(discount.getStart_Time())) >= 0 && date_Now.compareTo(new SimpleDateFormat("dd-MM-yyyy").parse(discount.getEnd_Time())) <= 0 && discount.getStatus() == 0 ){
                    discount_BUS.Auto_Update_Discount(discount.getDiscount_Id(),1);
                }
            } catch (ParseException ex) {
                Logger.getLogger(Discount_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                if( date_Now.compareTo(new SimpleDateFormat("dd-MM-yyyy").parse(discount.getStart_Time())) < 0 && discount.getStatus() == 1 || date_Now.compareTo(new SimpleDateFormat("dd-MM-yyyy").parse(discount.getEnd_Time())) > 0 && discount.getStatus() == 1 ){
                    discount_BUS.Auto_Update_Discount(discount.getDiscount_Id(),0);
                }
            } catch (ParseException ex) {
                Logger.getLogger(Discount_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.Button btnAdd;
    private Custom.Button btnDelete;
    private Custom.Button btnRefresh;
    private Custom.Button btnUpdate;
    private Custom.Button button1;
    private Custom.Button button2;
    private javax.swing.JComboBox<String> cbb_Status;
    private com.toedter.calendar.JDateChooser end_Time;
    private Custom.ImageAvatar imageAvatar1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private Custom.RoundPanel roundPanel1;
    private Custom.RoundPanel roundPanel2;
    private Custom.RoundPanel roundPanel3;
    private com.toedter.calendar.JDateChooser start_Time;
    private javax.swing.JTable tbl_Discount;
    private javax.swing.JTable tbl_Product;
    private javax.swing.JTextField txt_Discount_Id;
    private javax.swing.JTextField txt_Percent;
    private javax.swing.JTextField txt_Search;
    private javax.swing.JTextField txt_Search1;
    // End of variables declaration//GEN-END:variables
}
