
package Custom;

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

public class Item_Product extends javax.swing.JPanel {
    
    private Product_DTO data;

    public Product_DTO getData() {
        return data;
    }
    public void setData( Product_DTO data){
        this.data = data;
        name.setText("<html>"+data.getProductName()+" ("+data.getSize()+")</html>");
        //Định dạng tiền tệ
        Locale locale = new Locale("vi","VN");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        format.setRoundingMode(RoundingMode.HALF_UP);
        price.setText(format.format(data.getPrice()));
        
//        ImageIcon icon = new ImageIcon("src\\IMG\\"+ data.getImage());
        ImageIcon icon = new ImageIcon(data.getImage());
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(156, 104, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);
        Img.setIcon(icon);
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
        price = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(176, 190));

        Img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        price.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        price.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Img, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Img, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Img;
    private javax.swing.JLabel name;
    private javax.swing.JLabel price;
    // End of variables declaration//GEN-END:variables
}
