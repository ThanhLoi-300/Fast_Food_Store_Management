
package GUI;

public class Icon_GUI extends javax.swing.JPanel {

    public Icon_GUI() {
        initComponents();
        setVisible(true);
            
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(646, 703));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 440, 335));
    }// </editor-fold>                        

    private void formComponentResized(java.awt.event.ComponentEvent evt) {                                      
        try{
            if(this.getWidth()>=800){
                jLabel1.setBounds(400,140,jLabel1.getWidth(),jLabel1.getHeight());
                this.add(jLabel1);
            }else{
                jLabel1.setBounds(200,140,jLabel1.getWidth(),jLabel1.getHeight());
                this.add(jLabel1);
            }
        }catch(Exception e){
            //System.out.println("abc "+ (int)(getWidth()));
        }
    }                                     


    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}
