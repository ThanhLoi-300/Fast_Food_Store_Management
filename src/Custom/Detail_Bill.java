
package Custom;

import BUS.Discount_BUS;
import BUS.Product_BUS;
import DTO.Product_DTO;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Detail_Bill extends javax.swing.JPanel {

    private int index;
    private int percent = 0;
    private Product_BUS product_BUS = new Product_BUS();
    private Discount_BUS discount_BUS =  new Discount_BUS();
    
    public Detail_Bill() {
        initComponents();
    }
    
    private Product_DTO data;
    
    private Product_DTO getData(){
        return data;
    }
    
    public void setData(Product_DTO data, int quantity, int index){
        this.data = data;
        this.percent = discount_BUS.check_Discount_Percent(data.getProductID());
        lbl_Name.setText(data.getProductName()+" ("+data.getSize()+")");
        
        //Định dạng tiền tệ
        Locale locale = new Locale("vi","VN");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        format.setRoundingMode(RoundingMode.HALF_UP);
        lbl_Quantity_X_Price.setText( quantity + " x " + format.format(data.getPrice()));
        
        if(percent > 0 ){
            double price = product_BUS.getUnitPriceByID_Size(data.getProductID(), data.getSize());
            jButton8.setText("-"+percent+"%");
            lbl_Total1.setText("<html><strike>"+format.format(price)+"</strike><html>");
        }else{
            jButton8.setVisible(false);
            lbl_Total1.setText("");
        }
        double total = quantity * data.getPrice();
        lbl_Total.setText(format.format(total));
        this.index = index;
    }

    public JLabel getLbl_Delete() {
        return lbl_Delete;
    }

    public void setLbl_Delete(JLabel lbl_Delete) {
        this.lbl_Delete = lbl_Delete;
    }

    public JPanel getDetail_Panel() {
        return detail_Panel;
    }

    public void setDetail_Panel(JPanel detail_Panel) {
        this.detail_Panel = detail_Panel;
    }
    
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_Delete = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        detail_Panel = new javax.swing.JPanel();
        lbl_Name = new javax.swing.JLabel();
        lbl_Quantity_X_Price = new javax.swing.JLabel();
        lbl_Total = new javax.swing.JLabel();
        jButton8 = new Custom.Button();
        lbl_Total1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(333, 60));

        lbl_Delete.setBackground(new java.awt.Color(255, 255, 255));
        lbl_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/remove.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setOpaque(true);

        lbl_Name.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbl_Name.setText("jLabel1");

        lbl_Quantity_X_Price.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lbl_Quantity_X_Price.setText("jLabel1");

        lbl_Total.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lbl_Total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_Total.setText("jLabel1");

        jButton8.setBackground(new java.awt.Color(255, 0, 51));
        jButton8.setBorder(null);
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("-20%");
        jButton8.setBorderPainted(false);
        jButton8.setColor(new java.awt.Color(255, 0, 51));
        jButton8.setColorClick(new java.awt.Color(255, 0, 51));
        jButton8.setColorOver(new java.awt.Color(255, 0, 51));
        jButton8.setFocusPainted(false);
        jButton8.setFocusable(false);
        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jButton8.setRadius(100);

        lbl_Total1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lbl_Total1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_Total1.setText("jLabel1");

        javax.swing.GroupLayout detail_PanelLayout = new javax.swing.GroupLayout(detail_Panel);
        detail_Panel.setLayout(detail_PanelLayout);
        detail_PanelLayout.setHorizontalGroup(
            detail_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detail_PanelLayout.createSequentialGroup()
                .addGroup(detail_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detail_PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_Quantity_X_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_Total1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(detail_PanelLayout.createSequentialGroup()
                        .addComponent(lbl_Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        detail_PanelLayout.setVerticalGroup(
            detail_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detail_PanelLayout.createSequentialGroup()
                .addGroup(detail_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detail_PanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lbl_Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detail_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Total1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(detail_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_Quantity_X_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(detail_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_Delete))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(detail_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel detail_Panel;
    private Custom.Button jButton8;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbl_Delete;
    private javax.swing.JLabel lbl_Name;
    private javax.swing.JLabel lbl_Quantity_X_Price;
    private javax.swing.JLabel lbl_Total;
    private javax.swing.JLabel lbl_Total1;
    // End of variables declaration//GEN-END:variables
}
