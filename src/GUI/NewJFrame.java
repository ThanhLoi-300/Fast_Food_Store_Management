
package GUI;

import Custom.Button;
import Custom.Item_Product;
import Custom.Product;
import Custom.RoundPanel;
import Custom.detailProduct;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class NewJFrame extends javax.swing.JFrame {
    
    public NewJFrame() {
        initComponents();
        roundPanel1.setLayout( new GridLayout(1,1,0,0));
        roundPanel3.setLayout( new GridLayout(25,2,10,10));
        ArrayList<String> list = new ArrayList<String>();
        int i = 0;
        for(int j =0;j<50;j++){
            i++;
            list.add(i+"");
        }
        for(int e = 0;e<list.size();e++)
            addItem(new Product ("0",list.get(e),new ImageIcon(getClass().getResource("/Img/chicken-leg.png")),"0"));
    }

    public RoundPanel getRoundPanel1() {
        return roundPanel1;
    }

    public void setRoundPanel1(RoundPanel roundPanel1) {
        this.roundPanel1 = roundPanel1;
    }
    
    public void addItem( Product data){
        Item_Product pd = new Item_Product();
        pd.setData(data);
        pd.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println(data.getId());
                System.out.println(this.getClass());
                new NewJFrame1(data.getName(), NewJFrame.this);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                pd.setBorder( new LineBorder(Color.BLUE).createGrayLineBorder());
                pd.setPreferredSize(new java.awt.Dimension(pd.getWidth()-1, pd.getHeight()-1));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                pd.setBorder(null);
            }      
        });
        roundPanel3.add(pd);
        roundPanel3.repaint();
        roundPanel3.revalidate();
    }
    
    public void addBill( ArrayList<String> detail_List){
        for(int e = 0;e<detail_List.size();e++){
            detailProduct detail = new detailProduct();
            detail.setData(detail_List.get(e));
            String str = detail_List.get(e);
            detail.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                new NewJFrame1(str, NewJFrame.this);
            }     
        });
            roundPanel1.add(detail);
        roundPanel1.repaint();
        roundPanel1.revalidate();
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        roundPanel2 = new Custom.RoundPanel();
        roundPanel3 = new Custom.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        roundPanel1 = new Custom.RoundPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        roundPanel2.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel2.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                roundPanel2MouseWheelMoved(evt);
            }
        });

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 317, Short.MAX_VALUE)
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(472, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(roundPanel2);

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 403, Short.MAX_VALUE)
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(roundPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void roundPanel2MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_roundPanel2MouseWheelMoved

    }//GEN-LAST:event_roundPanel2MouseWheelMoved

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private Custom.RoundPanel roundPanel1;
    private Custom.RoundPanel roundPanel2;
    private Custom.RoundPanel roundPanel3;
    // End of variables declaration//GEN-END:variables
    ArrayList<String> detail_List = new ArrayList<String>();
}
