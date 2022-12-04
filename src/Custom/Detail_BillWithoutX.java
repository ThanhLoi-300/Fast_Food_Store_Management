
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

public class Detail_BillWithoutX extends javax.swing.JPanel {

    private int percent = 0;
    private Product_BUS product_BUS = new Product_BUS();
    private Discount_BUS discount_BUS =  new Discount_BUS();
    public Detail_BillWithoutX() {
        initComponents();
    }
    
    public void setData(String name, String size, int quantity, double unitPrice, int percent){
        lbl_Name.setText(name+" ("+size+")");
        //Định dạng tiền tệ
        Locale locale = new Locale("vi","VN");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        format.setRoundingMode(RoundingMode.HALF_UP);
        
        if(percent > 0 ){
            lbl_Quantity_X_Price.setText( quantity + " x " + format.format(unitPrice - unitPrice*percent/100));
            jButton8.setText("-"+percent+"%");
            lbl_Total1.setText("<html><strike>"+format.format(unitPrice)+"</strike><html>");
            double total = quantity * (unitPrice - unitPrice*percent/100);
            lbl_Total.setText(format.format(total));
        }else{
            lbl_Quantity_X_Price.setText( quantity + " x " + format.format(unitPrice));
            jButton8.setVisible(false);
            lbl_Total1.setText("");
            double total = quantity * unitPrice;
            lbl_Total.setText(format.format(total));
        }
        
    }



    public JPanel getDetail_Panel() {
        return detail_Panel;
    }

    public void setDetail_Panel(JPanel detail_Panel) {
        this.detail_Panel = detail_Panel;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        detail_Panel = new javax.swing.JPanel();
        lbl_Name = new javax.swing.JLabel();
        lbl_Quantity_X_Price = new javax.swing.JLabel();
        lbl_Total1 = new javax.swing.JLabel();
        lbl_Total = new javax.swing.JLabel();
        jButton8 = new Custom.Button();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(333, 60));

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setOpaque(true);

        detail_Panel.setBackground(new java.awt.Color(255, 255, 255));

        lbl_Name.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbl_Name.setText("jLabel1");

        lbl_Quantity_X_Price.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lbl_Quantity_X_Price.setText("jLabel1");

        lbl_Total1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lbl_Total1.setText("jLabel1");

        javax.swing.GroupLayout detail_PanelLayout = new javax.swing.GroupLayout(detail_Panel);
        detail_Panel.setLayout(detail_PanelLayout);
        detail_PanelLayout.setHorizontalGroup(
            detail_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detail_PanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl_Quantity_X_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_Total1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(detail_PanelLayout.createSequentialGroup()
                .addComponent(lbl_Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(58, 58, 58))
        );
        detail_PanelLayout.setVerticalGroup(
            detail_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detail_PanelLayout.createSequentialGroup()
                .addComponent(lbl_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detail_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Quantity_X_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Total1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(detail_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 246, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(detail_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel detail_Panel;
    private Custom.Button jButton8;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbl_Name;
    private javax.swing.JLabel lbl_Quantity_X_Price;
    private javax.swing.JLabel lbl_Total;
    private javax.swing.JLabel lbl_Total1;
    // End of variables declaration//GEN-END:variables
}
