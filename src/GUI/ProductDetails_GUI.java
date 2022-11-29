
package GUI;
import BUS.Product_BUS;
import DTO.Product_DTO;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ProductDetails_GUI extends javax.swing.JFrame {
    private Sale_GUI sale_GUI ;
    private Product_DTO product;
    private Product_BUS product_BUS = new Product_BUS();;
    private double price_Discount = 0;
    Locale locale = new Locale("vi","VN");
    NumberFormat format = NumberFormat.getCurrencyInstance(locale);
    private int percent = 0;
    
    public  ProductDetails_GUI(){
        this.setVisible(false);
    }
    
    public  ProductDetails_GUI(Product_DTO product, String size, Sale_GUI sale_GUI, String title, int discount) {
        initComponents();
        this.setBackground(new Color(0,0,0,0));
        
        this.setTitle(title);
        this.sale_GUI = sale_GUI;
        this.product = product;

        format.setRoundingMode(RoundingMode.HALF_UP);
        
        if(this.getTitle().equals("Add new Product to Bill"))
            jButton4.setText(1+"");
        else{
            int index = sale_GUI.getList_Detail_Bill().indexOf(this.product);
            int newQuantity = sale_GUI.getList_Quantity_Choice().get(index);
            jButton4.setText(newQuantity +"");
        }
        int quantity = Integer.parseInt(jButton4.getText());
        
        if(discount >0){
            this.percent = discount;
            jButton7.setText("-"+ discount +"%");
            if(this.getTitle().equals("Add new Product to Bill")){
                price_Discount = product.getPrice() - (percent* product.getPrice())/100;
                jButton6.setText(format.format(product.getPrice() * quantity));
                jButton3.setText(format.format(price_Discount * quantity));
            }else{
                double price = product_BUS.getUnitPriceByID_Size(product.getProductID(), size);
                price_Discount = price - (percent* price)/100;
                jButton6.setText(format.format(price * quantity));
                jButton3.setText(format.format(price_Discount * quantity));
            }
        }else {
            price_Discount = product.getPrice();
            jButton6.setText(format.format(product.getPrice() * quantity));
            jButton7.setVisible(false);
            lbl.setVisible(false);
            jButton3.setVisible(false);
        }
        
        jButton1.setText(this.product.getProductName());
        
        Vector comboBoxItems=new Vector();
        ArrayList<String> productSizes = product_BUS.readSizeByProductID(product);
        for(int i=0; i<productSizes.size(); i++)
            comboBoxItems.add(productSizes.get(i));
        jComboBox1.setModel(new DefaultComboBoxModel(comboBoxItems));
        jComboBox1.setSelectedItem(size);
        
        ImageIcon icon = new ImageIcon(product.getImage());
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(lblProductImg.getX()+110, lblProductImg.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);
        lblProductImg.setIcon(icon);
        
        this.setVisible(true);
    }
    
    public Product_DTO checkOrderExits(Product_DTO product) {
        for(int i=0; i<sale_GUI.getList_Detail_Bill().size(); i++) {
            if(product.getProductID().equals(sale_GUI.getList_Detail_Bill().get(i).getProductID()) 
              && product.getSize().equals(sale_GUI.getList_Detail_Bill().get(i).getSize())) {
                return sale_GUI.getList_Detail_Bill().get(i);
            }
        }
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new Custom.RoundPanel();
        lblProductImg = new javax.swing.JLabel();
        lblProductName = new javax.swing.JLabel();
        button1 = new Custom.Button();
        button2 = new Custom.Button();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new Custom.Button();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new Custom.Button();
        button3 = new Custom.Button();
        button4 = new Custom.Button();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new Custom.Button();
        lbl = new javax.swing.JLabel();
        jButton6 = new Custom.Button();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton7 = new Custom.Button();
        jButton4 = new Custom.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(350, 100));
        setUndecorated(true);

        roundPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblProductImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProductImg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblProductName.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblProductName.setForeground(new java.awt.Color(255, 255, 255));
        lblProductName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProductName.setText("CHI TIẾT MUA HÀNG");
        lblProductName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblProductName.setName(""); // NOI18N

        button1.setBorder(null);
        button1.setText("-");
        button1.setColor(new java.awt.Color(255, 255, 255));
        button1.setColorClick(new java.awt.Color(153, 153, 153));
        button1.setColorOver(new java.awt.Color(153, 153, 153));
        button1.setFocusable(false);
        button1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        button1.setRadius(50);
        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button1MouseClicked(evt);
            }
        });

        button2.setBorder(null);
        button2.setText("+");
        button2.setColor(new java.awt.Color(255, 255, 255));
        button2.setColorClick(new java.awt.Color(153, 153, 153));
        button2.setColorOver(new java.awt.Color(153, 153, 153));
        button2.setFocusable(false);
        button2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        button2.setRadius(50);
        button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button2MouseClicked(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setBorder(null);
        jComboBox1.setFocusable(false);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setBorder(null);
        jButton1.setText("abc");
        jButton1.setColor(new java.awt.Color(255, 255, 255));
        jButton1.setColorClick(new java.awt.Color(255, 255, 255));
        jButton1.setColorOver(new java.awt.Color(255, 255, 255));
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setRadius(10);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tên sản phẩm : ");

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setBorder(null);
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/add-to-cart.png"))); // NOI18N
        jButton2.setText("      XÁC NHẬN");
        jButton2.setColor(new java.awt.Color(0, 0, 0));
        jButton2.setColorClick(new java.awt.Color(51, 51, 51));
        jButton2.setColorOver(new java.awt.Color(51, 51, 51));
        jButton2.setFocusPainted(false);
        jButton2.setFocusable(false);
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setRadius(50);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        button3.setBorder(null);
        button3.setText("-");
        button3.setFocusPainted(false);
        button3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        button3.setMaximumSize(new java.awt.Dimension(43, 25));
        button3.setMinimumSize(new java.awt.Dimension(43, 25));
        button3.setRadius(15);
        button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button3MouseClicked(evt);
            }
        });

        button4.setBorder(null);
        button4.setText("X");
        button4.setFocusPainted(false);
        button4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        button4.setRadius(15);
        button4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button4MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Giá : ");

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setBorder(null);
        jButton3.setText("abc");
        jButton3.setColor(new java.awt.Color(255, 255, 255));
        jButton3.setColorClick(new java.awt.Color(255, 255, 255));
        jButton3.setColorOver(new java.awt.Color(255, 255, 255));
        jButton3.setFocusPainted(false);
        jButton3.setFocusable(false);
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton3.setRadius(10);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        lbl.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbl.setForeground(new java.awt.Color(255, 255, 255));
        lbl.setText("Giảm còn : ");

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setBorder(null);
        jButton6.setText("abc");
        jButton6.setColor(new java.awt.Color(255, 255, 255));
        jButton6.setColorClick(new java.awt.Color(255, 255, 255));
        jButton6.setColorOver(new java.awt.Color(255, 255, 255));
        jButton6.setFocusPainted(false);
        jButton6.setFocusable(false);
        jButton6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton6.setRadius(10);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Số lượng : ");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Size : ");

        jButton7.setBackground(new java.awt.Color(255, 0, 51));
        jButton7.setBorder(null);
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("-20%");
        jButton7.setBorderPainted(false);
        jButton7.setColor(new java.awt.Color(255, 0, 51));
        jButton7.setColorClick(new java.awt.Color(255, 0, 51));
        jButton7.setColorOver(new java.awt.Color(255, 0, 51));
        jButton7.setFocusPainted(false);
        jButton7.setFocusable(false);
        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton7.setRadius(100);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setBorder(null);
        jButton4.setColor(new java.awt.Color(255, 255, 255));
        jButton4.setColorClick(new java.awt.Color(255, 255, 255));
        jButton4.setColorOver(new java.awt.Color(255, 255, 255));
        jButton4.setFocusPainted(false);
        jButton4.setFocusable(false);
        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton4.setRadius(10);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel4)
                                .addGap(43, 43, 43)))
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(roundPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl))
                                    .addGroup(roundPanel1Layout.createSequentialGroup()
                                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(lblProductImg, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(258, 258, 258))))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(lblProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProductImg, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked

    }//GEN-LAST:event_jButton3MouseClicked

    private void button4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button4MouseClicked
        this.dispose();
    }//GEN-LAST:event_button4MouseClicked

    private void button3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button3MouseClicked
        setState(this.ICONIFIED);
    }//GEN-LAST:event_button3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        int quantity = Integer.parseInt(jButton4.getText());
        if(quantity > product.getQuantity())
            JOptionPane.showMessageDialog(this, "Số lượng không đủ (Còn lại:"+product.getQuantity()+")", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        else if(checkOrderExits(this.product)!=null){
            System.out.println("updating");
            //Cập nhật quantity
            int index = sale_GUI.getList_Detail_Bill().indexOf(checkOrderExits(this.product));
            sale_GUI.getList_Quantity_Choice().set(index, quantity);
        }else{
            this.product.setPrice( (int) this.price_Discount);
            System.out.println("add new");
            sale_GUI.getList_Detail_Bill().add(this.product);
            sale_GUI.getList_Quantity_Choice().add(quantity);
        }

        int k = sale_GUI.getList_Detail_Bill().size();
        sale_GUI.getDetail_Bill_Panel().setLayout(new GridLayout(k+5,1,0,0));
        sale_GUI.getDetail_Bill_Panel().removeAll();
        sale_GUI.addBill(sale_GUI.getList_Detail_Bill(), sale_GUI.getList_Quantity_Choice());
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String size = jComboBox1.getSelectedItem().toString();
        String productId = this.product.getProductID();
        ArrayList<String> price_quantity = product_BUS.readProductPriceAndQuantity(productId, size);
        double unitPrice = Double.parseDouble(price_quantity.get(0));
        int quantity = Integer.parseInt(price_quantity.get(1));
        Product_DTO old_product = this.product;
        this.product = new Product_DTO(old_product.getProductID(), size, old_product.getProductName(), old_product.getCategoryID(), unitPrice, quantity, old_product.getImage(), old_product.isIsDeleted(), old_product.isBusinessStatus());
        
        int old_Quantity = Integer.parseInt(jButton4.getText());
        if(this.percent >0){
            if(this.getTitle().equals("Add new Product to Bill")){
                price_Discount = product.getPrice() - (percent* product.getPrice())/100;
                jButton6.setText(format.format(product.getPrice() * old_Quantity));
                jButton3.setText(format.format(price_Discount * old_Quantity));
            }else{
                double price = product_BUS.getUnitPriceByID_Size(product.getProductID(), size);
                price_Discount = price - (percent* price)/100;
                jButton6.setText(format.format(price * old_Quantity));
                jButton3.setText(format.format(price_Discount * old_Quantity));
            }
        }else {
            price_Discount = product.getPrice();
            jButton6.setText(format.format(product.getPrice() * old_Quantity));
        }
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void button2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button2MouseClicked
        int quantity = Integer.parseInt(jButton4.getText());
        if(quantity + 1 > product.getQuantity())
            JOptionPane.showMessageDialog(this, "Số lượng không đủ (Còn lại:"+product.getQuantity()+")", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        else{
            jButton4.setText( quantity + 1+"" );
            double price = (quantity+1) * product.getPrice();
            jButton6.setText(format.format(price));
            
            if(this.percent > 0){
                price = (quantity+1) * this.price_Discount;
                jButton3.setText(format.format(price));
            }
        }
    }//GEN-LAST:event_button2MouseClicked

    private void button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseClicked
        int quantity = Integer.parseInt(jButton4.getText());
        if(quantity == 1){}
        else {
            jButton4.setText( quantity - 1 +"" );
            double price = (quantity-1) * product.getPrice();
            jButton6.setText(format.format(price));
            
            if(this.percent > 0){
                price = (quantity-1) * this.price_Discount;
                jButton3.setText(format.format(price));
            }
        }
    }//GEN-LAST:event_button1MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseClicked

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
            java.util.logging.Logger.getLogger(ProductDetails_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductDetails_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductDetails_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductDetails_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               //new ProductDetails_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.Button button1;
    private Custom.Button button2;
    private Custom.Button button3;
    private Custom.Button button4;
    private Custom.Button jButton1;
    private Custom.Button jButton2;
    private Custom.Button jButton3;
    private Custom.Button jButton4;
    private Custom.Button jButton6;
    private Custom.Button jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblProductImg;
    private javax.swing.JLabel lblProductName;
    private Custom.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables
}
