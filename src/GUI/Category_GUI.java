
package GUI;

import BUS.Category_BUS;
import BUS.DecentralizationDetail_BUS;
import DTO.Category_DTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class Category_GUI extends javax.swing.JPanel implements checkPermission{
    
    private Category_BUS category_BUS = new Category_BUS();
    private ArrayList<Category_DTO> category_List;
    private DecentralizationDetail_BUS dcdtBUS = new DecentralizationDetail_BUS();
    private int permissionType;
    String dcdt = "";
    
    public Category_GUI(int permissionType, String dcdt_Id) {
        initComponents();
        category_List = category_BUS.load_Data_Category();
        load_Data_Category(category_List);
        auto_Create_Id();
        this.permissionType = permissionType;
        this.dcdt = dcdt_Id;
   }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        roundPanel3 = new Custom.RoundPanel();
        roundPanel2 = new Custom.RoundPanel();
        txt_Search = new javax.swing.JTextField();
        button1 = new Custom.Button();
        scrCategoryList = new javax.swing.JScrollPane();
        tblCategoryList = new javax.swing.JTable();
        roundPanel1 = new Custom.RoundPanel();
        jPanel2 = new javax.swing.JPanel();
        lblCategoryIDConfig = new javax.swing.JLabel();
        txtCategoryID = new javax.swing.JTextField();
        lblCategoryNameConfig = new javax.swing.JLabel();
        txtCategoryName = new javax.swing.JTextField();
        lblBusinessStatusConfig = new javax.swing.JLabel();
        rdo_On = new javax.swing.JRadioButton();
        rdo_Off = new javax.swing.JRadioButton();
        btnRefresh = new Custom.Button();
        btnDelete = new Custom.Button();
        btnAdd = new Custom.Button();
        btnUpdate = new Custom.Button();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1030, 652));

        roundPanel3.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel3.setPreferredSize(new java.awt.Dimension(1049, 646));

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

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
        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button1MouseClicked(evt);
            }
        });

        scrCategoryList.setBackground(new java.awt.Color(255, 255, 255));
        scrCategoryList.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Categories List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12))); // NOI18N

        tblCategoryList.setModel(new javax.swing.table.DefaultTableModel(
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
                "CategoryID", "CategoryName", "BusinessStatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCategoryList.setRowHeight(30);
        tblCategoryList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoryListMouseClicked(evt);
            }
        });
        scrCategoryList.setViewportView(tblCategoryList);
        if (tblCategoryList.getColumnModel().getColumnCount() > 0) {
            tblCategoryList.getColumnModel().getColumn(0).setHeaderValue("CategoryID");
            tblCategoryList.getColumnModel().getColumn(1).setHeaderValue("CategoryName");
            tblCategoryList.getColumnModel().getColumn(2).setHeaderValue("BusinessStatus");
        }

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(scrCategoryList)
                        .addGap(1, 1, 1)))
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrCategoryList, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
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
                    category_List = category_BUS.load_Data_Category();
                    load_Data_Category(category_List);
                }
                else {
                    category_List = category_BUS.search_Category(txt_Search.getText());
                    load_Data_Category(category_List);
                }
            }
        });

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Category Configuration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12))); // NOI18N

        lblCategoryIDConfig.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCategoryIDConfig.setText("Category ID:");

        txtCategoryID.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCategoryID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCategoryID.setEnabled(false);

        lblCategoryNameConfig.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCategoryNameConfig.setText("Category name:");

        txtCategoryName.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        lblBusinessStatusConfig.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBusinessStatusConfig.setText("Business Status:");

        rdo_On.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdo_On);
        rdo_On.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdo_On.setSelected(true);
        rdo_On.setText("On");
        rdo_On.setFocusPainted(false);

        rdo_Off.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdo_Off);
        rdo_Off.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdo_Off.setText("Off");
        rdo_Off.setFocusPainted(false);

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblCategoryIDConfig)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCategoryID, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblCategoryNameConfig)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(txtCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblBusinessStatusConfig)
                                .addGap(48, 48, 48)
                                .addComponent(rdo_On)
                                .addGap(52, 52, 52)
                                .addComponent(rdo_Off)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoryIDConfig)
                    .addComponent(txtCategoryID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoryNameConfig)
                    .addComponent(txtCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBusinessStatusConfig)
                    .addComponent(rdo_On)
                    .addComponent(rdo_Off))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(roundPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    //Hiển thị dữ liệu của dòng được chọn ra textfield
    private void tblCategoryListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoryListMouseClicked
        int i = tblCategoryList.getSelectedRow();// Lấy vị trí được chọn trên table
        category_List = category_BUS.load_Data_Category();
        
        Category_DTO category = category_List.get(i);
        txtCategoryID.setText(category.getCategory_Id());
        txtCategoryName.setText(category.getCategory_Name());

        if( category.getBussiness_Status().equalsIgnoreCase("On") ) rdo_On.setSelected(true);
        else rdo_Off.setSelected(true);
        
    }//GEN-LAST:event_tblCategoryListMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        this.permissionType = dcdtBUS.readById(this.dcdt).getIsCategory();
        if(this.permissionType!=2){
            this.hienThiErrorMess();
            return;
        }
        if( txtCategoryName.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên");
        else{
            category_List = category_BUS.load_Data_Category();
            boolean flag = true;
            for(int i=0;i<category_List.size();i++){
                //Kiểm tra tên đã tồn tại hay chưa
                if( txtCategoryName.getText().equals(category_List.get(i).getCategory_Name()) ){
                    JOptionPane.showMessageDialog(null, "Tên đã tồn tại");
                    flag = false;
                    break;
                }
                //Check ID đã tồn tại hay chưa
                if( txtCategoryID.getText().equals(category_List.get(i).getCategory_Id()) ){
                    JOptionPane.showMessageDialog(null, "Mã này đã tồn tại, vui lòng tạo mã mới");
                    flag = false;
                    break;
                }
            }
            
            if(flag){
                //Xác nhận
                if(JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thêm loại sản phẩm này?", "Warnning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    String status = "";

                    if( rdo_On.isSelected()) status = rdo_On.getText();
                    else status = rdo_Off.getText();

                    Category_DTO category = new Category_DTO( txtCategoryID.getText(), txtCategoryName.getText(), status);
                    if(category_BUS.insert_Category(category)) 
                    {
                        JOptionPane.showMessageDialog(null, "Thêm thành công");
                        category_List = category_BUS.load_Data_Category();
                        load_Data_Category(category_List);
                        refresh();
                    }
                }
            }           
        }
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseClicked
        refresh();
    }//GEN-LAST:event_btnRefreshMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        this.permissionType = dcdtBUS.readById(this.dcdt).getIsCategory();
        if(this.permissionType!=2){
            this.hienThiErrorMess();
            return;
        }
        if(tblCategoryList.getSelectedRow()< 0)
            JOptionPane.showMessageDialog(null, "Vui lòng chọn loại sản phẩm muốn cập nhật");
        else if(txtCategoryName.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên");
        }
        else{ 
            if( category_BUS.check_Name(txtCategoryID.getText(), txtCategoryName.getText()) ){
                //Xác nhận
                if(JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn cập nhật loại sản phẩm này, trạng thái của các sản phẩm có thể bị thay đổi?", "Warnning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    String status = "";
                    int state = -1;

                    if( rdo_On.isSelected()) {
                        status = rdo_On.getText();
                        state = 1;
                    }
                    else {
                        status = rdo_Off.getText();
                        state = 0;
                    }

                    Category_DTO category = new Category_DTO( txtCategoryID.getText(), txtCategoryName.getText(), status);
                    if(category_BUS.update_Category(category)) 
                    {
                        category_BUS.update_Status_Category_And_Product(txtCategoryID.getText(),state);
                        JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                        category_List = category_BUS.load_Data_Category();
                        load_Data_Category(category_List);
                        refresh();
                    }
                }    
            }else JOptionPane.showMessageDialog(null, "Tên đã tồn tại"); 
        }
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        this.permissionType = dcdtBUS.readById(this.dcdt).getIsCategory();
        if(this.permissionType!=2){
            this.hienThiErrorMess();
            return;
        }
        if( txtCategoryName.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Vui lòng chọn loại sản phẩm muốn xóa");
        else{
            //Xác nhận
            if(category_BUS.count_Product_Belong_Category(txtCategoryID.getText()) !=0){
                if(JOptionPane.showConfirmDialog(null, "Thể loại này đang có "+category_BUS.count_Product_Belong_Category(txtCategoryID.getText())+" sản phẩm!\n Bạn có chắc muốn xóa tất cả sản phẩm?", "Warnning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    if(category_BUS.delete_Category(txtCategoryID.getText())){
                        category_BUS.delete_Product_From_Category(txtCategoryID.getText());
                        refresh();
                        category_List = category_BUS.load_Data_Category();
                        load_Data_Category(category_List);
                        JOptionPane.showMessageDialog(null, "Xóa thành công");
                    }
                }
            }else{
                if(JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa loại sản phẩm này?", "Warnning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    if(category_BUS.delete_Category(txtCategoryID.getText())){
                        refresh();
                        category_List = category_BUS.load_Data_Category();
                        load_Data_Category(category_List);
                        JOptionPane.showMessageDialog(null, "Xóa thành công");
                    }
                }
            }  
        }    
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseClicked
        if( txt_Search.getText().isEmpty() ){
            category_List = category_BUS.load_Data_Category();
            load_Data_Category(category_List);
        }
        else {
            category_List = category_BUS.search_Category(txt_Search.getText());
            load_Data_Category(category_List);
        }
    }//GEN-LAST:event_button1MouseClicked
    
    private void refresh(){
        txtCategoryName.setText("");
        rdo_On.setSelected(true);
        txt_Search.setText("");
        category_List = category_BUS.load_Data_Category();
        load_Data_Category(category_List);
        auto_Create_Id();
    }
    private void auto_Create_Id(){
        String Id = "CT" + category_BUS.get_All_Category();
        txtCategoryID.setText(Id);
    }
    
    private void load_Data_Category( ArrayList<Category_DTO> list) {
        DefaultTableModel model = (DefaultTableModel) tblCategoryList.getModel();
        model.setRowCount(0);
        for(Category_DTO category : list){
            model.addRow( new Object[] { category.getCategory_Id(), 
                                                   category.getCategory_Name(), 
                                                   category.getBussiness_Status()
                                                 });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.Button btnAdd;
    private Custom.Button btnDelete;
    private Custom.Button btnRefresh;
    private Custom.Button btnUpdate;
    private Custom.Button button1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblBusinessStatusConfig;
    private javax.swing.JLabel lblCategoryIDConfig;
    private javax.swing.JLabel lblCategoryNameConfig;
    private javax.swing.JRadioButton rdo_Off;
    private javax.swing.JRadioButton rdo_On;
    private Custom.RoundPanel roundPanel1;
    private Custom.RoundPanel roundPanel2;
    private Custom.RoundPanel roundPanel3;
    private javax.swing.JScrollPane scrCategoryList;
    private javax.swing.JTable tblCategoryList;
    private javax.swing.JTextField txtCategoryID;
    private javax.swing.JTextField txtCategoryName;
    private javax.swing.JTextField txt_Search;
    // End of variables declaration//GEN-END:variables

}
