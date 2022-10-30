
package Custom;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.DecimalFormat;

public class Item_Product extends javax.swing.JPanel {

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }
    
    private boolean selected;
    
    private Product data;

    public Product getData() {
        return data;
    }
    public void setData( Product data){
        this.data = data;
        img.setImage(data.getImg());
        name.setText(data.name);
        //DecimalFormat df = new DecimalFormat("###.###");
        price.setText(  data.getPrice());
        setBounds(100,100,100,100);
    }
    
    public Item_Product() {
        initComponents();
        setOpaque(false);
    }
    
    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor( new Color(242,242,242));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        
        if(selected){
            g2.setColor( new Color(94,156,255));
            g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        }
        g2.dispose();
        super.paint(grphcs);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        img = new Custom.PictureBox();
        name = new javax.swing.JLabel();
        price = new javax.swing.JLabel();

        img.setImage(new javax.swing.ImageIcon(getClass().getResource("/Img/chicken-leg.png"))); // NOI18N

        name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        name.setText("jLabel1");

        price.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        price.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        price.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(price, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.PictureBox img;
    private javax.swing.JLabel name;
    private javax.swing.JLabel price;
    // End of variables declaration//GEN-END:variables
}
