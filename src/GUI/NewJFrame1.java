
package GUI;

import BUS.Product_BUS;
import DTO.Product_DTO;
import java.awt.GridLayout;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class NewJFrame1 extends javax.swing.JFrame {
    private Sale_GUI sale_GUI ;
    private Product_DTO product;
    private Product_BUS product_BUS;
    private double price_Discount = 0;
    public NewJFrame1(){
        this.setVisible(false);
    }
    public NewJFrame1( Product_DTO product, String size, Sale_GUI sale_GUI, String title, int discount) {
        initComponents();
        this.setTitle(title);
        this.sale_GUI= sale_GUI;
        
        if(discount >0){
            int percent = discount;
            price_Discount = product.getPrice() - (percent* product.getPrice())/100;
            jLabel4.setText("-"+ discount +"%");
        }else {
            price_Discount = product.getPrice();
            jLabel4.setText("");
        }
        this.product = product;
        
        jLabel1.setText(this.product.getProductName());
        //Định dạng tiền tệ
        Locale locale = new Locale("vi","VN");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        format.setRoundingMode(RoundingMode.HALF_UP);
        jLabel2.setText(format.format(price_Discount));
        
        if(this.getTitle().equals("Add new Product to Bill"))
            jLabel3.setText(1+"");
        else{
            int index = sale_GUI.getList_Detail_Bill().indexOf(this.product);
            int newQuantity = sale_GUI.getList_Quantity_Choice().get(index);
            jLabel3.setText(newQuantity +"");
        }
        Vector comboBoxItems=new Vector();
        product_BUS = new Product_BUS();
        ArrayList<String> productSizes = product_BUS.readSizeByProductID(product);
        for(int i=0; i<productSizes.size(); i++)
            comboBoxItems.add(productSizes.get(i));
        jComboBox1.setModel(new DefaultComboBoxModel(comboBoxItems));
        jComboBox1.setSelectedItem(size);
        
        
        setVisible(true);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new Custom.Button();
        button1 = new Custom.Button();
        button2 = new Custom.Button();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("jLabel3");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setBorder(null);
        jButton1.setText("XÁC NHẬN");
        jButton1.setColor(new java.awt.Color(255, 255, 255));
        jButton1.setColorClick(new java.awt.Color(153, 153, 153));
        jButton1.setColorOver(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setRadius(10);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

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

        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        int quantity = Integer.parseInt(jLabel3.getText());
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
    }//GEN-LAST:event_jButton1MouseClicked

    private void button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseClicked
        if(Integer.parseInt(jLabel3.getText()) == 1){}
        else
            jLabel3.setText( ((Integer.parseInt(jLabel3.getText())-1) +"" ));
    }//GEN-LAST:event_button1MouseClicked

    private void button2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button2MouseClicked
        jLabel3.setText( ((Integer.parseInt(jLabel3.getText())+1) +"" ));
    }//GEN-LAST:event_button2MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String size = jComboBox1.getSelectedItem().toString();
        String productId = this.product.getProductID();
        ArrayList<String> price_quantity = product_BUS.readProductPriceAndQuantity(productId, size);
        double unitPrice = Double.parseDouble(price_quantity.get(0));
        int quantity = Integer.parseInt(price_quantity.get(1));
        Product_DTO old_product = this.product;
        this.product = new Product_DTO(old_product.getProductID(), size, old_product.getProductName(), old_product.getCategoryID(), unitPrice, quantity, old_product.getImage(), old_product.isIsDeleted(), old_product.isBusinessStatus());
        if(checkOrderExits(this.product)!=null) {
            System.out.println("yes update");
//            this.setTitle("Update Detail Product in Bill");
            int index = sale_GUI.getList_Detail_Bill().indexOf(checkOrderExits(this.product));
            int newQuantity = sale_GUI.getList_Quantity_Choice().get(index);
            jLabel3.setText(newQuantity +"");
        }
        else {
            System.out.println("yes add new");
//            this.setTitle("Add new Product to Bill");
            jLabel3.setText(1+"");
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new NewJFrame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.Button button1;
    private Custom.Button button2;
    private Custom.Button jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
