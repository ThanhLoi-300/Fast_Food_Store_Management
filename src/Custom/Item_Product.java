
package Custom;

import BUS.Discount_BUS;
import DTO.Product_DTO;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Item_Product extends javax.swing.JPanel {
    
    private Product_DTO data;
    private Discount_BUS discount_BUS = new Discount_BUS();
    private int percent = 0;
    public Product_DTO getData() {
        return data;
    }
    public void setData( Product_DTO data){
        this.data = data;
        name.setText(data.getProductName());
        
        ImageIcon icon = new ImageIcon(data.getImage());
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(156, 104, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);
        Img.setIcon(icon);
        
        if(discount_BUS.check_Product_Discount(data.getProductID()) != -1){
            jButton8.setText("-"+ discount_BUS.check_Product_Discount(data.getProductID())+"%" );
            this.percent = discount_BUS.check_Product_Discount(data.getProductID());
        }else jButton8.setVisible(false);
    }

    public Button getjButton8() {
        return jButton8;
    }

    public void setjButton8(Button jButton8) {
        this.jButton8 = jButton8;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public Item_Product() {
        initComponents();
        setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Img = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jButton8 = new Custom.Button();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(176, 190));

        Img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

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
        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton8.setRadius(100);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(Img, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Img, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Img;
    private Custom.Button jButton8;
    private javax.swing.JLabel name;
    // End of variables declaration//GEN-END:variables
}
