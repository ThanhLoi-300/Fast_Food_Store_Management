
package GUI;

import Custom.Button;
import Custom.Item_Product;
import Custom.Product;
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
        roundPanel3.setLayout( new GridLayout(25,4,10,10));
        ArrayList<String> list = new ArrayList<String>();
        int i = 0;
        for(int j =0;j<100;j++){
            i++;
            list.add(i+"");
        }
        for(int e = 0;e<list.size();e++)
            addItem(new Product ("0",list.get(e),new ImageIcon(getClass().getResource("/Img/chicken-leg.png")),"0"));
    }
    
    public void addItem( Product data){
        Item_Product pd = new Item_Product();
        pd.setData(data);
        pd.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println(data.getId());
                new NewJFrame1(data.getName());
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        roundPanel2 = new Custom.RoundPanel();
        roundPanel3 = new Custom.RoundPanel();

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
            .addGap(0, 654, Short.MAX_VALUE)
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(roundPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
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
    private Custom.RoundPanel roundPanel2;
    private Custom.RoundPanel roundPanel3;
    // End of variables declaration//GEN-END:variables
}
