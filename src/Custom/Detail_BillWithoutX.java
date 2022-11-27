
package Custom;

import DTO.Product_DTO;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Detail_BillWithoutX extends javax.swing.JPanel {

    
    public Detail_BillWithoutX() {
        initComponents();
    }
    
    public void setData(String name, String size, int quantity, double unitPrice){
        lbl_Name.setText(name+" ("+size+")");
        //Định dạng tiền tệ
        Locale locale = new Locale("vi","VN");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        format.setRoundingMode(RoundingMode.HALF_UP);
        lbl_Quantity_X_Price.setText( quantity + " x " + format.format(unitPrice));
        double total = quantity * unitPrice;
        lbl_Total.setText(format.format(total));
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
        lbl_Total = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(333, 60));

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setOpaque(true);

        lbl_Name.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbl_Name.setText("jLabel1");

        lbl_Quantity_X_Price.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lbl_Quantity_X_Price.setText("jLabel1");

        javax.swing.GroupLayout detail_PanelLayout = new javax.swing.GroupLayout(detail_Panel);
        detail_Panel.setLayout(detail_PanelLayout);
        detail_PanelLayout.setHorizontalGroup(
            detail_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detail_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detail_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detail_PanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbl_Quantity_X_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(114, Short.MAX_VALUE))
                    .addComponent(lbl_Name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        detail_PanelLayout.setVerticalGroup(
            detail_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detail_PanelLayout.createSequentialGroup()
                .addComponent(lbl_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Quantity_X_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lbl_Total.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lbl_Total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_Total.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(detail_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_Total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(detail_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel detail_Panel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbl_Name;
    private javax.swing.JLabel lbl_Quantity_X_Price;
    private javax.swing.JLabel lbl_Total;
    // End of variables declaration//GEN-END:variables
}
