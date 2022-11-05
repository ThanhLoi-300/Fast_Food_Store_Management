
package GUI;

import Custom.Detail_Bill;
import Custom.Item_Product;
import Custom.Product;
import Custom.RoundPanel;
import DTO.Product_DTO;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class Sale_GUI extends javax.swing.JPanel {
    
    private ArrayList<Product_DTO> list_Product = new ArrayList<Product_DTO>();
    private ArrayList<Product_DTO> list_Detail_Bill = new ArrayList<Product_DTO>();
    private ArrayList<Integer> list_Quantity_Choice = new ArrayList<Integer>();
    
    public Sale_GUI() {
        initComponents();
        Detail_Bill_Panel.setLayout( new GridLayout(1,1,0,0));
        Product_Panel.setLayout( new GridLayout(3,3,15,15));
        list_Product.add( new Product_DTO("PD1","S","1","CT0",10000,10,"HBG.jpg",false,true));
        list_Product.add( new Product_DTO("PD2","M","2","CT0",20000,10,"HBG.jpg",false,true));
        list_Product.add( new Product_DTO("PD3","L","3","CT0",30000,10,"HBG.jpg",false,true));
        list_Product.add( new Product_DTO("PD4","XL","4","CT0",40000,10,"HBG.jpg",false,true));
        list_Product.add( new Product_DTO("PD5","XXL","5","CT0",50000,10,"HBG.jpg",false,true));
        list_Product.add( new Product_DTO("PD6","XXXL","6","CT0",60000,10,"HBG.jpg",false,true));
        list_Product.add( new Product_DTO("PD7","S","7","CT0",70000,10,"HBG.jpg",false,true));
        list_Product.add( new Product_DTO("PD8","M","8","CT0",80000,10,"HBG.jpg",false,true));
        list_Product.add( new Product_DTO("PD9","XL","9","CT0",90000,10,"HBG.jpg",false,true));
        for(int i = 0; i< list_Product.size();i++)
            addItem(list_Product.get(i));
        
    }

    public RoundPanel getDetail_Bill_Panel() {
        return Detail_Bill_Panel;
    }

    public void setDetail_Bill_Panel(RoundPanel Detail_Bill_Panel) {
        this.Detail_Bill_Panel = Detail_Bill_Panel;
    }

    public ArrayList<Product_DTO> getList_Product() {
        return list_Product;
    }

    public void setList_Product(ArrayList<Product_DTO> list_Product) {
        this.list_Product = list_Product;
    }
    
    public ArrayList<Product_DTO> getList_Detail_Bill() {
        return list_Detail_Bill;
    }

    public void setList_Detail_Bill(ArrayList<Product_DTO> list_Detail_Product) {
        this.list_Detail_Bill = list_Detail_Product;
    }
    
    public ArrayList<Integer> getList_Quantity_Choice() {
        return list_Quantity_Choice;
    }

    public void setList_Quantity_Choice(ArrayList<Integer> list_Quantity_Choice) {
        this.list_Quantity_Choice = list_Quantity_Choice;
    }
    
    public void addItem( Product_DTO data){
        Item_Product pd = new Item_Product();
        pd.setPreferredSize(new java.awt.Dimension(156,189));
        pd.setData(data);
        pd.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                new NewJFrame1( data, Sale_GUI.this);
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
        Product_Panel.add(pd);
        Product_Panel.repaint();
        Product_Panel.revalidate();
    }
    
    public void addBill( ArrayList<Product_DTO> list_Detail_Bill, ArrayList<Integer> list_Quantity_Choice){
        for(int e = 0; e < list_Detail_Bill.size();e++){
            Detail_Bill detail_Bill = new Detail_Bill();
            detail_Bill.setData( list_Detail_Bill.get(e), list_Quantity_Choice.get(e), e);
            Product_DTO product = list_Detail_Bill.get(e);
            
            int index = e;
            
            detail_Bill.getDetail_Panel().addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                new NewJFrame1(product, Sale_GUI.this);
            }     
        });
            
            detail_Bill.getLbl_Delete().addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                if(JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa loại sản phẩm này?", "Warnning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    getList_Detail_Bill().remove(index);
                    getList_Quantity_Choice().remove(index);
                    Detail_Bill_Panel.removeAll();
                    addBill(list_Detail_Bill, list_Quantity_Choice);
                }
            }     
        });
            
        Detail_Bill_Panel.add(detail_Bill);
        Detail_Bill_Panel.repaint();
        Detail_Bill_Panel.revalidate();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new Custom.RoundPanel();
        roundPanel2 = new Custom.RoundPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        button2 = new Custom.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        Detail_Bill_Panel = new Custom.RoundPanel();
        roundPanel6 = new Custom.RoundPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAdd1 = new Custom.Button();
        btnAdd = new Custom.Button();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        roundPanel3 = new Custom.RoundPanel();
        cbbSearchFilter = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        roundPanel4 = new Custom.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Product_Panel = new Custom.RoundPanel();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1040, 700));

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel1.setPreferredSize(new java.awt.Dimension(1035, 652));

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(70, 70, 70));
        jLabel1.setText("Tên khách hàng: ");
        jLabel1.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setOpaque(true);

        jTextField2.setBackground(new java.awt.Color(240, 240, 240));
        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(153, 153, 153));
        jTextField2.setText("Số điện thoại");
        jTextField2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });

        button2.setBackground(new java.awt.Color(240, 240, 240));
        button2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search.png"))); // NOI18N
        button2.setBorderPainted(false);
        button2.setColor(new java.awt.Color(240, 240, 240));
        button2.setColorClick(new java.awt.Color(247, 247, 247));
        button2.setColorOver(new java.awt.Color(230, 230, 230));
        button2.setDoubleBuffered(true);
        button2.setFocusPainted(false);
        button2.setIconTextGap(0);
        button2.setRadius(10);

        Detail_Bill_Panel.setAutoscrolls(true);

        javax.swing.GroupLayout Detail_Bill_PanelLayout = new javax.swing.GroupLayout(Detail_Bill_Panel);
        Detail_Bill_Panel.setLayout(Detail_Bill_PanelLayout);
        Detail_Bill_PanelLayout.setHorizontalGroup(
            Detail_Bill_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );
        Detail_Bill_PanelLayout.setVerticalGroup(
            Detail_Bill_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(Detail_Bill_Panel);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Tổng tiền:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Tiền nhận:");

        btnAdd1.setBackground(new java.awt.Color(240, 240, 240));
        btnAdd1.setBorder(null);
        btnAdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/plus.png"))); // NOI18N
        btnAdd1.setText("Thanh toán");
        btnAdd1.setColor(new java.awt.Color(240, 240, 240));
        btnAdd1.setColorClick(new java.awt.Color(240, 235, 235));
        btnAdd1.setColorOver(new java.awt.Color(255, 255, 255));
        btnAdd1.setFocusPainted(false);
        btnAdd1.setRadius(20);

        btnAdd.setBackground(new java.awt.Color(240, 240, 240));
        btnAdd.setBorder(null);
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/plus.png"))); // NOI18N
        btnAdd.setText("Hủy");
        btnAdd.setColor(new java.awt.Color(240, 240, 240));
        btnAdd.setColorClick(new java.awt.Color(240, 235, 235));
        btnAdd.setColorOver(new java.awt.Color(255, 255, 255));
        btnAdd.setFocusPainted(false);
        btnAdd.setRadius(20);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("0");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Tiền thừa:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("0");

        jTextField3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField3.setText("0");

        javax.swing.GroupLayout roundPanel6Layout = new javax.swing.GroupLayout(roundPanel6);
        roundPanel6.setLayout(roundPanel6Layout);
        roundPanel6Layout.setHorizontalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel6Layout.createSequentialGroup()
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(roundPanel6Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        roundPanel6Layout.setVerticalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jTextField2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanel3.setAutoscrolls(true);

        cbbSearchFilter.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbbSearchFilter.setMaximumRowCount(100);
        cbbSearchFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Loại sản phẩm" }));
        cbbSearchFilter.setBorder(null);
        cbbSearchFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        cbbSearchFilter.setFocusable(false);

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField1.setOpaque(false);

        jLabel4.setBackground(new java.awt.Color(102, 102, 102));
        jLabel4.setOpaque(true);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search.png"))); // NOI18N

        roundPanel4.setBackground(new java.awt.Color(255, 255, 255));

        Product_Panel.setBackground(new java.awt.Color(255, 255, 255));
        Product_Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        Product_Panel.setAutoscrolls(true);
        Product_Panel.setOpaque(true);

        javax.swing.GroupLayout Product_PanelLayout = new javax.swing.GroupLayout(Product_Panel);
        Product_Panel.setLayout(Product_PanelLayout);
        Product_PanelLayout.setHorizontalGroup(
            Product_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );
        Product_PanelLayout.setVerticalGroup(
            Product_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(Product_Panel);

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cbbSearchFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(roundPanel3Layout.createSequentialGroup()
                                .addGap(280, 280, 280)
                                .addComponent(jLabel10)))))
                .addGap(10, 10, 10))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cbbSearchFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        if(jTextField2.getText().equals("Số điện thoại")){
            jTextField2.setText("");
            jTextField2.setForeground( new Color(10,10,10));
        }
    }//GEN-LAST:event_jTextField2FocusGained

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        if(jTextField2.getText().equals("")){
            jTextField2.setText("Số điện thoại");
            jTextField2.setForeground( new Color(153,153,153));
        }
    }//GEN-LAST:event_jTextField2FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.RoundPanel Detail_Bill_Panel;
    private Custom.RoundPanel Product_Panel;
    private Custom.Button btnAdd;
    private Custom.Button btnAdd1;
    private Custom.Button button2;
    private javax.swing.JComboBox<String> cbbSearchFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private Custom.RoundPanel roundPanel1;
    private Custom.RoundPanel roundPanel2;
    private Custom.RoundPanel roundPanel3;
    private Custom.RoundPanel roundPanel4;
    private Custom.RoundPanel roundPanel6;
    // End of variables declaration//GEN-END:variables
}
