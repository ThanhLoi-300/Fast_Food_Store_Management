package GUI;

import BUS.DecentralizationDetail_BUS;
import BUS.Product_BUS;
import BUS.ReceivedNoteDetail_BUS;
import BUS.ReceivedNote_BUS;
import DTO.ReceivedNote;
import DTO.ReceivedNoteDetail;
import DTO.ReceivedProduct_DTO;
import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Recieved_GUI extends javax.swing.JPanel implements checkPermission {

    ArrayList<ReceivedProduct_DTO> listReceivedProduct = new ArrayList();
    ArrayList<ReceivedProduct_DTO> listReceivedProductDetail = new ArrayList();
    ArrayList<ReceivedProduct_DTO> searchList = new ArrayList();
    Product_BUS productBUS = new Product_BUS();
    ReceivedNote_BUS receiveBUS = new ReceivedNote_BUS();
    ReceivedNoteDetail_BUS receiveDetailBUS = new ReceivedNoteDetail_BUS();
    private DecentralizationDetail_BUS dcdtBUS = new DecentralizationDetail_BUS();
    ReceivedProduct_DTO selectedProduct, selectedProductDetail;
    String loggedInStaff;
    private int permissionType;
    String dcdt = "";

    public Recieved_GUI(String staffID, int permissionType, String dcdt_Id) {
        initComponents();
        loggedInStaff = staffID;
        this.permissionType = permissionType;
        this.dcdt = dcdt_Id;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel3 = new Custom.RoundPanel();
        roundPanel1 = new Custom.RoundPanel();
        scrProductList = new javax.swing.JScrollPane();
        tblProductList = new javax.swing.JTable();
        cbbSearchFilter = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new Custom.Button();
        btnAdd1 = new Custom.Button();
        btnImport = new Custom.Button();
        jLabel5 = new javax.swing.JLabel();
        roundPanel2 = new Custom.RoundPanel();
        lblTotalValue = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Supplier = new javax.swing.JLabel();
        btnDelete = new Custom.Button();
        jLabel4 = new javax.swing.JLabel();
        srcReceiveDetail = new javax.swing.JScrollPane();
        tblReceiveDetail = new javax.swing.JTable();
        btnNhapHang = new Custom.Button();
        lblSupplier = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblTaxValue = new javax.swing.JLabel();
        lblFinalValue = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setAutoscrolls(true);

        roundPanel3.setBackground(new java.awt.Color(51, 51, 51));

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblProductList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProductID", "Size", "ProductName", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductList.setRowHeight(30);
        tblProductList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductListMouseClicked(evt);
            }
        });
        scrProductList.setViewportView(tblProductList);

        cbbSearchFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ProductID", "Size", "ProductName" }));
        cbbSearchFilter.setFocusable(false);

        txtSearch.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtSearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnSearch.setBackground(new java.awt.Color(240, 240, 240));
        btnSearch.setBorder(null);
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search.png"))); // NOI18N
        btnSearch.setColor(new java.awt.Color(240, 240, 240));
        btnSearch.setColorClick(new java.awt.Color(255, 255, 255));
        btnSearch.setColorOver(new java.awt.Color(255, 255, 255));
        btnSearch.setFocusPainted(false);
        btnSearch.setRadius(5);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnAdd1.setBackground(new java.awt.Color(240, 240, 240));
        btnAdd1.setBorder(null);
        btnAdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/plus.png"))); // NOI18N
        btnAdd1.setText("  Add    ");
        btnAdd1.setColor(new java.awt.Color(240, 240, 240));
        btnAdd1.setColorClick(new java.awt.Color(240, 235, 235));
        btnAdd1.setColorOver(new java.awt.Color(255, 255, 255));
        btnAdd1.setEnabled(false);
        btnAdd1.setFocusPainted(false);
        btnAdd1.setRadius(20);
        btnAdd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdd1MouseClicked(evt);
            }
        });

        btnImport.setBackground(new java.awt.Color(240, 240, 240));
        btnImport.setBorder(null);
        btnImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/folder.png"))); // NOI18N
        btnImport.setText("Chọn danh sách sản phẩm");
        btnImport.setColor(new java.awt.Color(240, 240, 240));
        btnImport.setColorClick(new java.awt.Color(255, 255, 255));
        btnImport.setColorOver(new java.awt.Color(255, 255, 255));
        btnImport.setFocusPainted(false);
        btnImport.setRadius(10);
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setOpaque(true);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrProductList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                        .addComponent(cbbSearchFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbSearchFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(scrProductList, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblTotalValue.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTotalValue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalValue.setText("0");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Tổng:  ");

        Supplier.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Supplier.setText("Nhà cung cấp:");

        btnDelete.setBackground(new java.awt.Color(240, 240, 240));
        btnDelete.setBorder(null);
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancel.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.setColor(new java.awt.Color(240, 240, 240));
        btnDelete.setColorClick(new java.awt.Color(255, 255, 255));
        btnDelete.setColorOver(new java.awt.Color(255, 255, 255));
        btnDelete.setEnabled(false);
        btnDelete.setFocusPainted(false);
        btnDelete.setRadius(10);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("Chi tiết phiếu nhập");

        srcReceiveDetail.setBackground(new java.awt.Color(255, 255, 255));
        srcReceiveDetail.setBorder(null);

        tblReceiveDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProductID", "Size", "ProductName", "Price", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
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
        tblReceiveDetail.setRowHeight(30);
        tblReceiveDetail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tblReceiveDetailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblReceiveDetailFocusLost(evt);
            }
        });
        tblReceiveDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReceiveDetailMouseClicked(evt);
            }
        });
        srcReceiveDetail.setViewportView(tblReceiveDetail);

        btnNhapHang.setBackground(new java.awt.Color(240, 240, 240));
        btnNhapHang.setBorder(null);
        btnNhapHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ad.png"))); // NOI18N
        btnNhapHang.setText("Nhập hàng");
        btnNhapHang.setColor(new java.awt.Color(240, 240, 240));
        btnNhapHang.setColorClick(new java.awt.Color(255, 255, 255));
        btnNhapHang.setColorOver(new java.awt.Color(255, 255, 255));
        btnNhapHang.setEnabled(false);
        btnNhapHang.setFocusPainted(false);
        btnNhapHang.setRadius(10);
        btnNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapHangActionPerformed(evt);
            }
        });

        lblSupplier.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblSupplier.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Thuế:");

        lblTaxValue.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTaxValue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTaxValue.setText("0");

        lblFinalValue.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblFinalValue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFinalValue.setText("0");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Giá trị sau thuế:");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(srcReceiveDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(roundPanel2Layout.createSequentialGroup()
                                        .addComponent(btnNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(roundPanel2Layout.createSequentialGroup()
                                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel9)
                                            .addComponent(Supplier))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblFinalValue, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                            .addComponent(lblTaxValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblTotalValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel4)
                        .addGap(0, 144, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(srcReceiveDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalValue)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTaxValue)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFinalValue)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Supplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        this.permissionType = dcdtBUS.readById(this.dcdt).getIsRecept();
        if(this.permissionType!=2){
            this.hienThiErrorMess();
            return;
        }
        JFileChooser fc = new JFileChooser();
        fc.removeChoosableFileFilter(fc.getFileFilter());
        FileFilter filter = new FileNameExtensionFilter("Excel files (.xlsx)", "xlsx");
        fc.setFileFilter(filter);
        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File imported = fc.getSelectedFile();
            listReceivedProduct.clear();
            try {
                FileInputStream in = new FileInputStream(imported);
                XSSFWorkbook xFile = new XSSFWorkbook(in);
                XSSFSheet sheet = xFile.getSheetAt(0);
                System.out.println("Log");
                String id = "", size = "", name = "";
                int price = 123;

                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        if (row.getRowNum() != 0) {
                            if (cell.getColumnIndex() == 0) {
                                id = cell.getStringCellValue();
                            } else if (cell.getColumnIndex() == 1) {
                                size = cell.getStringCellValue();
                            } else if (cell.getColumnIndex() == 2) {
                                name = cell.getStringCellValue();
                            } else if (cell.getColumnIndex() == 3) {
                                price = (int) cell.getNumericCellValue();
                            }
                        }
                    }
                    if (!"".equals(id)) {
                        ReceivedProduct_DTO rProduct = new ReceivedProduct_DTO(id, name, size, price);
                        listReceivedProduct.add(rProduct);
                    }
                }

                lblSupplier.setText(imported.getName().replace(".xlsx", ""));
                in.close();
                loadReceivedProducts(listReceivedProduct);
            } catch (Exception e) {
                System.out.println("An error has occured at btnImportActionPerformed in Recieved_GUI class");
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btnImportActionPerformed

    private void tblProductListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductListMouseClicked
        int i = tblProductList.getSelectedRow();
        selectedProduct = listReceivedProduct.get(i);
        btnAdd1.setEnabled(true);
    }//GEN-LAST:event_tblProductListMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        this.permissionType = dcdtBUS.readById(this.dcdt).getIsRecept();
        if(this.permissionType!=2){
            this.hienThiErrorMess();
            return;
        }
        if (selectedProductDetail != null) {
            listReceivedProductDetail.remove(selectedProductDetail);
            loadReceivedProductsDetail(listReceivedProductDetail);
            btnDelete.setEnabled(false);
            checkDetails();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblReceiveDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReceiveDetailMouseClicked
        int i = tblReceiveDetail.getSelectedRow();
        selectedProductDetail = listReceivedProductDetail.get(i);
        btnDelete.setEnabled(true);
    }//GEN-LAST:event_tblReceiveDetailMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (!txtSearch.getText().isEmpty()) {
            search(txtSearch.getText(), cbbSearchFilter.getSelectedItem() + "");
            loadReceivedProducts(searchList);
        } else {
            loadReceivedProducts(listReceivedProduct);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAdd1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdd1MouseClicked
        this.permissionType = dcdtBUS.readById(this.dcdt).getIsRecept();
        if(this.permissionType!=2){
            this.hienThiErrorMess();
            return;
        }
        if (!listReceivedProductDetail.contains(selectedProduct)) {
            listReceivedProductDetail.add(selectedProduct);
            loadReceivedProductsDetail(listReceivedProductDetail);
            btnAdd1.setEnabled(false);
            checkDetails();
        } else {
            JOptionPane.showMessageDialog(this, "Sản phẩm đã được thêm");
        }
    }//GEN-LAST:event_btnAdd1MouseClicked

    private void tblReceiveDetailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblReceiveDetailFocusGained
        checkDetails();
    }//GEN-LAST:event_tblReceiveDetailFocusGained

    private void tblReceiveDetailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblReceiveDetailFocusLost
        checkDetails();
    }//GEN-LAST:event_tblReceiveDetailFocusLost

    private void checkDetails() {
        boolean flag = true;
        try {
            for (int i = 0; i < tblReceiveDetail.getRowCount(); i++) {
                if (tblReceiveDetail.getValueAt(i, 4) == null || tblReceiveDetail.getValueAt(i, 4).toString().trim().length() == 0 || Integer.parseInt(tblReceiveDetail.getValueAt(i, 4).toString()) <= 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                btnNhapHang.setEnabled(true);
                int total = 0, tax = 0, finalValue = 0;
                for (int i = 0; i < tblReceiveDetail.getRowCount(); i++) {
                    int price = (int) tblReceiveDetail.getValueAt(i, 3);
                    int quantity = (int) tblReceiveDetail.getValueAt(i, 4);
                    total += (int) price * quantity;

                }
                tax = (int) (total * 0.08);
                finalValue = tax + total;
                lblTotalValue.setText(total + "");
                lblTaxValue.setText(tax + "");
                lblFinalValue.setText(finalValue + "");
            } else {
                btnNhapHang.setEnabled(false);
                lblTotalValue.setText("0");
                lblTaxValue.setText("0");
                lblFinalValue.setText("0");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng nhập vào phải là số nguyên dương");
        }
    }
    
    private void btnNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapHangActionPerformed
        this.permissionType = dcdtBUS.readById(this.dcdt).getIsRecept();
        if(this.permissionType!=2){
            this.hienThiErrorMess();
            return;
        }
        ArrayList<ReceivedNoteDetail> rndList = new ArrayList();
        ArrayList<Integer> quantityList = new ArrayList();
        ReceivedNote rn = new ReceivedNote(receiveBUS.autoID(), LocalDateTime.now(), Double.parseDouble(lblTotalValue.getText()), Double.parseDouble(lblTaxValue.getText()), Double.parseDouble(lblFinalValue.getText()), lblSupplier.getText(), loggedInStaff);
        boolean receivedNoteInserted = false;
        String receivednoteID = receiveBUS.autoID();
        if (receiveBUS.insert(rn)) {
            receivedNoteInserted = true;
        } else {
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi trong quá trình thêm!");
        }

        for (int i = 0; i < tblReceiveDetail.getRowCount(); i++) {
            if (tblReceiveDetail.getValueAt(i, 4) != null) {
                quantityList.add((int) tblReceiveDetail.getValueAt(i, 4));
            }
        }

        if (receivedNoteInserted) {
            int counter = 0;
            for (ReceivedProduct_DTO rp : listReceivedProductDetail) {
                int totalPrice = rp.getPrice() * quantityList.get(counter);
                ReceivedNoteDetail rnd = new ReceivedNoteDetail(receivednoteID, rp.getProductID(), rp.getSize(), quantityList.get(counter), rp.getPrice(), totalPrice);
                if (!receiveDetailBUS.insert(rnd)) {
                    JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi trong quá trình thêm!");
                    break;
                } else {
                    productBUS.incQuantity(rp.getProductID(), rp.getSize(), quantityList.get(counter));
                }
                counter++;
            }
            JOptionPane.showMessageDialog(this, "Nhập hàng thành công");
            reset();
        }

    }//GEN-LAST:event_btnNhapHangActionPerformed

    private void loadReceivedProductsDetail(ArrayList<ReceivedProduct_DTO> list) {
        DefaultTableModel model = (DefaultTableModel) tblReceiveDetail.getModel();
        model.setRowCount(0);
        for (ReceivedProduct_DTO rProduct : list) {
            model.addRow(new Object[]{rProduct.getProductID(), rProduct.getSize(), rProduct.getProductName(), rProduct.getPrice()});
        }
    }

    private void loadReceivedProducts(ArrayList<ReceivedProduct_DTO> list) {
        DefaultTableModel model = (DefaultTableModel) tblProductList.getModel();
        model.setRowCount(0);
        for (ReceivedProduct_DTO rProduct : list) {
            model.addRow(new Object[]{rProduct.getProductID(), rProduct.getSize(), rProduct.getProductName(), rProduct.getPrice()});
        }
    }

    private void search(String keyword, String filter) {
        if (!keyword.equals("")) {
            switch (filter) {
                case "ProductID":
                    searchList.clear();
                    for (ReceivedProduct_DTO rProduct : listReceivedProduct) {
                        if (rProduct.getProductID().toLowerCase().contains(keyword.toLowerCase())) {
                            searchList.add(rProduct);
                        }
                    }
                    break;
                case "Size":
                    searchList.clear();
                    for (ReceivedProduct_DTO rProduct : listReceivedProduct) {
                        if (rProduct.getSize().toLowerCase().contains(keyword.toLowerCase())) {
                            searchList.add(rProduct);
                        }
                    }
                    break;
                case "ProductName":
                    searchList.clear();
                    for (ReceivedProduct_DTO rProduct : listReceivedProduct) {
                        if (rProduct.getProductName().toLowerCase().contains(keyword.toLowerCase())) {
                            searchList.add(rProduct);
                        }
                    }
                    break;
            }
        }
    }

    public void reset() {
        DefaultTableModel model = (DefaultTableModel) tblReceiveDetail.getModel();
        model.setRowCount(0);
        DefaultTableModel modelDetail = (DefaultTableModel) tblProductList.getModel();
        modelDetail.setRowCount(0);
        listReceivedProduct.clear();
        listReceivedProductDetail.clear();
        searchList.clear();
        txtSearch.setText("");
        btnAdd1.setEnabled(false);
        btnDelete.setEnabled(false);
        btnNhapHang.setEnabled(false);
        lblTotalValue.setText("0");
        lblTaxValue.setText("0");
        lblFinalValue.setText("0");
        lblSupplier.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Supplier;
    private Custom.Button btnAdd1;
    private Custom.Button btnDelete;
    private Custom.Button btnImport;
    private Custom.Button btnNhapHang;
    private Custom.Button btnSearch;
    private javax.swing.JComboBox<String> cbbSearchFilter;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblFinalValue;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JLabel lblTaxValue;
    private javax.swing.JLabel lblTotalValue;
    private Custom.RoundPanel roundPanel1;
    private Custom.RoundPanel roundPanel2;
    private Custom.RoundPanel roundPanel3;
    private javax.swing.JScrollPane scrProductList;
    private javax.swing.JScrollPane srcReceiveDetail;
    private javax.swing.JTable tblProductList;
    private javax.swing.JTable tblReceiveDetail;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
