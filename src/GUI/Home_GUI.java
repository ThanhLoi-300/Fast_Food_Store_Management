
package GUI;

import BUS.Decentralization_BUS;
import BUS.Discount_BUS;
import DTO.DecentralizationDetail;
import DTO.Discount_DTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Home_GUI extends javax.swing.JFrame implements checkPermission{
    
    private ArrayList<String> staffInfo;
    private Discount_BUS discount_BUS = new Discount_BUS();
    private DecentralizationDetail dcdt = new DecentralizationDetail();
    private Decentralization_BUS decentralization_BUS = new Decentralization_BUS();
    private String dcdt_Id = "";
    
    public Home_GUI(ArrayList<String> staffInfo, DecentralizationDetail dcdt) throws ParseException {
        initComponents();
        set_Time();
        setBackground(new Color(0,0,0,0));
        this.staffInfo = staffInfo;
        this.dcdt = dcdt;
        this.dcdt_Id = dcdt.getDecentralizeID();
        jLabel2.setText(this.staffInfo.get(1));
        jLabel1.setText(this.staffInfo.get(2));
        
        Auto_Update_Discount();
        DisableTabsForDecentralize();
        if(this.dcdt.getIsSale()==0){
            Active(roundPanel10);
            OpenChildForm( new Statistic_GUI());
        }
        else {
            Active(roundPanel7);
            OpenChildForm( new Sale_GUI(this.staffInfo.get(0), this.dcdt.getIsSale(),this.dcdt_Id));
        }
        setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel2 = new Custom.RoundPanel();
        header2 = new Custom.Header();
        button4 = new Custom.Button();
        button5 = new Custom.Button();
        lb_Time = new javax.swing.JLabel();
        roundPanel3 = new Custom.RoundPanel();
        imageAvatar1 = new Custom.ImageAvatar();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        roundPanel4 = new Custom.RoundPanel();
        roundPanel7 = new Custom.RoundPanel();
        jLabel10 = new javax.swing.JLabel();
        imageAvatar9 = new Custom.ImageAvatar();
        roundPanel9 = new Custom.RoundPanel();
        jLabel12 = new javax.swing.JLabel();
        imageAvatar4 = new Custom.ImageAvatar();
        roundPanel11 = new Custom.RoundPanel();
        jLabel14 = new javax.swing.JLabel();
        imageAvatar8 = new Custom.ImageAvatar();
        roundPanel13 = new Custom.RoundPanel();
        jLabel16 = new javax.swing.JLabel();
        imageAvatar2 = new Custom.ImageAvatar();
        roundPanel8 = new Custom.RoundPanel();
        jLabel11 = new javax.swing.JLabel();
        imageAvatar6 = new Custom.ImageAvatar();
        roundPanel10 = new Custom.RoundPanel();
        jLabel13 = new javax.swing.JLabel();
        imageAvatar7 = new Custom.ImageAvatar();
        roundPanel12 = new Custom.RoundPanel();
        jLabel15 = new javax.swing.JLabel();
        imageAvatar5 = new Custom.ImageAvatar();
        roundPanel16 = new Custom.RoundPanel();
        jLabel19 = new javax.swing.JLabel();
        imageAvatar12 = new Custom.ImageAvatar();
        roundPanel14 = new Custom.RoundPanel();
        jLabel17 = new javax.swing.JLabel();
        imageAvatar10 = new Custom.ImageAvatar();
        roundPanel15 = new Custom.RoundPanel();
        jLabel18 = new javax.swing.JLabel();
        imageAvatar11 = new Custom.ImageAvatar();
        roundPanel17 = new Custom.RoundPanel();
        jLabel20 = new javax.swing.JLabel();
        imageAvatar13 = new Custom.ImageAvatar();
        jPanel1 = new Custom.RoundPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        roundPanel2.setBackground(new java.awt.Color(0, 0, 0));
        roundPanel2.setPreferredSize(new java.awt.Dimension(1000, 720));

        header2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                header2MouseDragged(evt);
            }
        });
        header2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                header2MousePressed(evt);
            }
        });

        button4.setBorder(null);
        button4.setText("X");
        button4.setFocusPainted(false);
        button4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        button4.setRadius(15);
        button4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button4MouseClicked(evt);
            }
        });

        button5.setBorder(null);
        button5.setText("-");
        button5.setFocusPainted(false);
        button5.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        button5.setMaximumSize(new java.awt.Dimension(43, 25));
        button5.setMinimumSize(new java.awt.Dimension(43, 25));
        button5.setRadius(15);
        button5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button5MouseClicked(evt);
            }
        });

        lb_Time.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lb_Time.setForeground(new java.awt.Color(255, 255, 255));
        lb_Time.setText("jLabel2");

        javax.swing.GroupLayout header2Layout = new javax.swing.GroupLayout(header2);
        header2.setLayout(header2Layout);
        header2Layout.setHorizontalGroup(
            header2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(lb_Time, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1034, Short.MAX_VALUE)
                .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        header2Layout.setVerticalGroup(
            header2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(header2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_Time))
                .addContainerGap())
        );

        roundPanel3.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel3.setPreferredSize(new java.awt.Dimension(170, 117));

        imageAvatar1.setForeground(new java.awt.Color(255, 255, 255));
        imageAvatar1.setBorderSize(2);
        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/bell-boy.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Vai trò:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        roundPanel4.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel4.setAutoscrolls(true);

        roundPanel7.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roundPanel7MouseClicked(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Bán hàng");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        imageAvatar9.setForeground(new java.awt.Color(255, 255, 255));
        imageAvatar9.setBorderSize(2);
        imageAvatar9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lunch.png"))); // NOI18N

        javax.swing.GroupLayout roundPanel7Layout = new javax.swing.GroupLayout(roundPanel7);
        roundPanel7.setLayout(roundPanel7Layout);
        roundPanel7Layout.setHorizontalGroup(
            roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel7Layout.setVerticalGroup(
            roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageAvatar9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel9.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roundPanel9MouseClicked(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(51, 51, 51));
        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Sản phẩm");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        imageAvatar4.setForeground(new java.awt.Color(255, 255, 255));
        imageAvatar4.setBorderSize(2);
        imageAvatar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/chicken-leg.png"))); // NOI18N

        javax.swing.GroupLayout roundPanel9Layout = new javax.swing.GroupLayout(roundPanel9);
        roundPanel9.setLayout(roundPanel9Layout);
        roundPanel9Layout.setHorizontalGroup(
            roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel9Layout.setVerticalGroup(
            roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imageAvatar4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel11.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roundPanel11MouseClicked(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(51, 51, 51));
        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Loại sản phẩm");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        imageAvatar8.setForeground(new java.awt.Color(255, 255, 255));
        imageAvatar8.setBorderSize(2);
        imageAvatar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/fast-food_1.png"))); // NOI18N

        javax.swing.GroupLayout roundPanel11Layout = new javax.swing.GroupLayout(roundPanel11);
        roundPanel11.setLayout(roundPanel11Layout);
        roundPanel11Layout.setHorizontalGroup(
            roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel14)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        roundPanel11Layout.setVerticalGroup(
            roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageAvatar8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel13.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel13.setPreferredSize(new java.awt.Dimension(157, 50));
        roundPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roundPanel13MouseClicked(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(51, 51, 51));
        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Nhập hàng");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        imageAvatar2.setForeground(new java.awt.Color(255, 255, 255));
        imageAvatar2.setBorderSize(2);
        imageAvatar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/delivery-truck.png"))); // NOI18N

        javax.swing.GroupLayout roundPanel13Layout = new javax.swing.GroupLayout(roundPanel13);
        roundPanel13.setLayout(roundPanel13Layout);
        roundPanel13Layout.setHorizontalGroup(
            roundPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel13Layout.setVerticalGroup(
            roundPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel8.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roundPanel8MouseClicked(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(51, 51, 51));
        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Hóa đơn");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        imageAvatar6.setForeground(new java.awt.Color(255, 255, 255));
        imageAvatar6.setBorderSize(2);
        imageAvatar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/transaction.png"))); // NOI18N

        javax.swing.GroupLayout roundPanel8Layout = new javax.swing.GroupLayout(roundPanel8);
        roundPanel8.setLayout(roundPanel8Layout);
        roundPanel8Layout.setHorizontalGroup(
            roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel8Layout.setVerticalGroup(
            roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageAvatar6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel10.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roundPanel10MouseClicked(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(51, 51, 51));
        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Thống kê");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        imageAvatar7.setForeground(new java.awt.Color(255, 255, 255));
        imageAvatar7.setBorderSize(2);
        imageAvatar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/trend.png"))); // NOI18N

        javax.swing.GroupLayout roundPanel10Layout = new javax.swing.GroupLayout(roundPanel10);
        roundPanel10.setLayout(roundPanel10Layout);
        roundPanel10Layout.setHorizontalGroup(
            roundPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel10Layout.setVerticalGroup(
            roundPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageAvatar7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel12.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roundPanel12MouseClicked(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(51, 51, 51));
        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Tài khoản");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        imageAvatar5.setForeground(new java.awt.Color(255, 255, 255));
        imageAvatar5.setBorderSize(2);
        imageAvatar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/id.png"))); // NOI18N

        javax.swing.GroupLayout roundPanel12Layout = new javax.swing.GroupLayout(roundPanel12);
        roundPanel12.setLayout(roundPanel12Layout);
        roundPanel12Layout.setHorizontalGroup(
            roundPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel12Layout.setVerticalGroup(
            roundPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imageAvatar5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel16.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roundPanel16MouseClicked(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(51, 51, 51));
        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Nhân viên");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        imageAvatar12.setForeground(new java.awt.Color(255, 255, 255));
        imageAvatar12.setBorderSize(2);
        imageAvatar12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/man.png"))); // NOI18N

        javax.swing.GroupLayout roundPanel16Layout = new javax.swing.GroupLayout(roundPanel16);
        roundPanel16.setLayout(roundPanel16Layout);
        roundPanel16Layout.setHorizontalGroup(
            roundPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel19)
                .addContainerGap(120, Short.MAX_VALUE))
        );
        roundPanel16Layout.setVerticalGroup(
            roundPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imageAvatar12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel14.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roundPanel14MouseClicked(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(51, 51, 51));
        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Khách hàng");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        imageAvatar10.setForeground(new java.awt.Color(255, 255, 255));
        imageAvatar10.setBorderSize(2);
        imageAvatar10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/people.png"))); // NOI18N

        javax.swing.GroupLayout roundPanel14Layout = new javax.swing.GroupLayout(roundPanel14);
        roundPanel14.setLayout(roundPanel14Layout);
        roundPanel14Layout.setHorizontalGroup(
            roundPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel14Layout.setVerticalGroup(
            roundPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imageAvatar10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel15.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roundPanel15MouseClicked(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(51, 51, 51));
        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Giảm giá");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        imageAvatar11.setForeground(new java.awt.Color(255, 255, 255));
        imageAvatar11.setBorderSize(2);
        imageAvatar11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/big-sale.png"))); // NOI18N

        javax.swing.GroupLayout roundPanel15Layout = new javax.swing.GroupLayout(roundPanel15);
        roundPanel15.setLayout(roundPanel15Layout);
        roundPanel15Layout.setHorizontalGroup(
            roundPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel15Layout.setVerticalGroup(
            roundPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imageAvatar11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel17.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roundPanel17MouseClicked(evt);
            }
        });

        jLabel20.setBackground(new java.awt.Color(51, 51, 51));
        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Phân quyền");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        imageAvatar13.setForeground(new java.awt.Color(255, 255, 255));
        imageAvatar13.setBorderSize(2);
        imageAvatar13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/locksmith.png"))); // NOI18N

        javax.swing.GroupLayout roundPanel17Layout = new javax.swing.GroupLayout(roundPanel17);
        roundPanel17.setLayout(roundPanel17Layout);
        roundPanel17Layout.setHorizontalGroup(
            roundPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel17Layout.setVerticalGroup(
            roundPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imageAvatar13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(roundPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(roundPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(roundPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(roundPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(roundPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(roundPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(roundPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(roundPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(roundPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(roundPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(roundPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(1059, 700));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1031, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(header2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                    .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1031, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void roundPanel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundPanel13MouseClicked
        this.dcdt = decentralization_BUS.get_Decentralize_By_Name(jLabel1.getText());
        if(this.dcdt.getIsRecept()!=0){
            Active(roundPanel13);
            OpenChildForm( new Recieved_GUI(this.staffInfo.get(0), this.dcdt.getIsRecept(),this.dcdt_Id));
        }
        else this.hienThiErrorMess();
    }//GEN-LAST:event_roundPanel13MouseClicked

    private void roundPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundPanel12MouseClicked
        this.dcdt = decentralization_BUS.get_Decentralize_By_Name(jLabel1.getText());
        if(this.dcdt.getIsAccount()!=0){
            Active(roundPanel12);
            OpenChildForm(new Account_GUI(this.dcdt.getIsAccount(),this.dcdt_Id));
        }
        else this.hienThiErrorMess();
    }//GEN-LAST:event_roundPanel12MouseClicked

    private void roundPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundPanel10MouseClicked
        Active(roundPanel10);
        OpenChildForm(new Statistic_GUI());
    }//GEN-LAST:event_roundPanel10MouseClicked

    private void roundPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundPanel8MouseClicked
        this.dcdt = decentralization_BUS.get_Decentralize_By_Name(jLabel1.getText());
        if(this.dcdt.getIsBill()!=0){
            Active(roundPanel8);
            OpenChildForm( new Bill_GUI());
        }
        else this.hienThiErrorMess();
    }//GEN-LAST:event_roundPanel8MouseClicked

    private void roundPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundPanel11MouseClicked
        this.dcdt = decentralization_BUS.get_Decentralize_By_Name(jLabel1.getText());
        if(this.dcdt.getIsCategory()!=0){
            Active(roundPanel11);
            OpenChildForm( new Category_GUI(this.dcdt.getIsCategory(),this.dcdt_Id));
        }
        else this.hienThiErrorMess();
    }//GEN-LAST:event_roundPanel11MouseClicked

    private void roundPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundPanel9MouseClicked
        this.dcdt = decentralization_BUS.get_Decentralize_By_Name(jLabel1.getText());
        if(this.dcdt.getIsProduct()!=0){
            Active(roundPanel9);
            OpenChildForm( new Product_GUI(this.dcdt.getIsProduct(),this.dcdt_Id));
        }
        else this.hienThiErrorMess();
    }//GEN-LAST:event_roundPanel9MouseClicked

    private void roundPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundPanel7MouseClicked
        this.dcdt = decentralization_BUS.get_Decentralize_By_Name(jLabel1.getText());
        if(this.dcdt.getIsSale()!=0){
            Active(roundPanel7);
            OpenChildForm( new Sale_GUI(this.staffInfo.get(0), this.dcdt.getIsSale(),this.dcdt_Id));
        }
        else this.hienThiErrorMess();
    }//GEN-LAST:event_roundPanel7MouseClicked

    private void button5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button5MouseClicked
        setState(Home_GUI.ICONIFIED);
    }//GEN-LAST:event_button5MouseClicked

    private void button4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button4MouseClicked
        int message = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn thoát!!!","Quit",JOptionPane.YES_NO_OPTION);
        if (message == JOptionPane.YES_OPTION)
        {
            this.dispose();
            new Login_GUI();
        }
    }//GEN-LAST:event_button4MouseClicked

    private void header2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_header2MousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_header2MousePressed

    private void header2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_header2MouseDragged
        super.setLocation(super.getX() + evt.getX() - mouseX , super.getY() + evt.getY() - mouseY);
    }//GEN-LAST:event_header2MouseDragged

    private void roundPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundPanel14MouseClicked
        this.dcdt = decentralization_BUS.get_Decentralize_By_Name(jLabel1.getText());
        if(this.dcdt.getIsCustomer()!=0){
            Active(roundPanel14);
            OpenChildForm(new Customer_GUI(this.dcdt.getIsCustomer(),this.dcdt_Id));
        }
        else this.hienThiErrorMess();
    }//GEN-LAST:event_roundPanel14MouseClicked

    private void roundPanel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundPanel15MouseClicked
        this.dcdt = decentralization_BUS.get_Decentralize_By_Name(jLabel1.getText());
        if(this.dcdt.getIsDiscount()!=0){
            Active(roundPanel15);
            OpenChildForm(new Discount_GUI(this.dcdt.getIsDiscount(),this.dcdt_Id));
        }
        else this.hienThiErrorMess();
    }//GEN-LAST:event_roundPanel15MouseClicked

    private void roundPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundPanel16MouseClicked
        this.dcdt = decentralization_BUS.get_Decentralize_By_Name(jLabel1.getText());
        if(this.dcdt.getIsStaff()!=0){
            Active(roundPanel16);
            OpenChildForm(new Staff_GUI(this.dcdt.getIsStaff(),this.dcdt_Id));
        }
        else this.hienThiErrorMess();
    }//GEN-LAST:event_roundPanel16MouseClicked

    private void roundPanel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundPanel17MouseClicked
        this.dcdt = decentralization_BUS.get_Decentralize_By_Name(jLabel1.getText());
        if(this.dcdt.getIsDecentralize()!=0){
            Active(roundPanel17);
            OpenChildForm(new Decentralization_GUI(this.dcdt.getIsDecentralize(), Home_GUI.this,this.dcdt_Id));
        }
        else this.hienThiErrorMess();
    }//GEN-LAST:event_roundPanel17MouseClicked
    
    public void DisableTabsForDecentralize(){
        String decentralize_Name =  jLabel1.getText();
        DecentralizationDetail dd = decentralization_BUS.get_Decentralize_By_Name(decentralize_Name);
        if(dd.getIsSale()==0) roundPanel7.setBackground(Color.red);
        else roundPanel7.setBackground(new Color(51,51,51));
        if(dd.getIsProduct()==0) roundPanel9.setBackground(Color.red);
        else roundPanel9.setBackground(new Color(51,51,51));
        if(dd.getIsCategory()==0) roundPanel11.setBackground(Color.red);
        else roundPanel11.setBackground(new Color(51,51,51));
        if(dd.getIsRecept()==0) roundPanel13.setBackground(Color.red);
        else roundPanel13.setBackground(new Color(51,51,51));
        if(dd.getIsBill()==0) roundPanel8.setBackground(Color.red);
        else roundPanel8.setBackground(new Color(51,51,51));
        if(dd.getIsAccount()==0) roundPanel12.setBackground(Color.red);
        else roundPanel12.setBackground(new Color(51,51,51));
        if(dd.getIsStaff()==0) roundPanel16.setBackground(Color.red);
        else roundPanel16.setBackground(new Color(51,51,51));
        if(dd.getIsCustomer()==0) roundPanel14.setBackground(Color.red);
        else roundPanel14.setBackground(new Color(51,51,51));
        if(dd.getIsDiscount()==0) roundPanel15.setBackground(Color.red);
        else roundPanel15.setBackground(new Color(51,51,51));
        if(dd.getIsDecentralize()==0) {
            Active(roundPanel10);
            OpenChildForm( new Statistic_GUI());
            roundPanel17.setBackground(Color.red);
        }
        else roundPanel17.setBackground(new Color(51,51,51));
    }
    
    public void set_Background_roundPanel17(){
        roundPanel17.setBackground(new Color(25,25,25));
    }
    
    private void Active( JPanel btn) {     
        Disable();
        currentBtn = btn;
        currentBtn.setBackground( new Color(25,25,25));
    }           
    
    private void Disable()
    {
        if(currentBtn != null)
            currentBtn.setBackground( new Color(51,51,51));
    }
    
    private void OpenChildForm(JPanel panel){
        jPanel1.removeAll();
        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(panel);
        jPanel1.repaint();
        jPanel1.revalidate();
    }
    
    private void set_Time() {
        LocalDate date = LocalDate.now();// Lấy ngày tháng năm hiện tại
        String dateString = String.valueOf(date);
        String[] dateArray = dateString.split("-");
        String day = dateArray[2];
        String month = dateArray[1];
        String year = dateArray[0];
        lb_Time.setText(day+"-"+month+"-"+year+" : ");
        Thread a = new Thread(){
            public void run(){
                try{
                    while(true){
                        Date now = new Date();
                        SimpleDateFormat format = new SimpleDateFormat();
                        format.applyPattern("hh:mm:ss aa");
                        String time = format.format(now);
                        lb_Time.setText(day+"-"+month+"-"+year+" : "+time);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        };
        a.start();
    }
    
    private void Auto_Update_Discount() throws ParseException{
        String[] time = lb_Time.getText().split(" : ");
        ArrayList<Discount_DTO> list_Discount = discount_BUS.get_Discount();
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(time[0]);
        
        for(Discount_DTO discount : list_Discount){
            
            if( date.compareTo(new SimpleDateFormat("dd-MM-yyyy").parse(discount.getStart_Time())) >= 0 && date.compareTo(new SimpleDateFormat("dd-MM-yyyy").parse(discount.getEnd_Time())) <= 0 && discount.getStatus() == 0 ){
                discount_BUS.Auto_Update_Discount(discount.getDiscount_Id(),1);
            }
            
            if( date.compareTo(new SimpleDateFormat("dd-MM-yyyy").parse(discount.getStart_Time())) < 0 && discount.getStatus() == 1 || date.compareTo(new SimpleDateFormat("dd-MM-yyyy").parse(discount.getEnd_Time())) > 0 && discount.getStatus() == 1 ){
                discount_BUS.Auto_Update_Discount(discount.getDiscount_Id(),0);
            }
        }
        
    }
    
    
    private JPanel currentBtn;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.Button button4;
    private Custom.Button button5;
    private Custom.Header header2;
    private Custom.ImageAvatar imageAvatar1;
    private Custom.ImageAvatar imageAvatar10;
    private Custom.ImageAvatar imageAvatar11;
    private Custom.ImageAvatar imageAvatar12;
    private Custom.ImageAvatar imageAvatar13;
    private Custom.ImageAvatar imageAvatar2;
    private Custom.ImageAvatar imageAvatar4;
    private Custom.ImageAvatar imageAvatar5;
    private Custom.ImageAvatar imageAvatar6;
    private Custom.ImageAvatar imageAvatar7;
    private Custom.ImageAvatar imageAvatar8;
    private Custom.ImageAvatar imageAvatar9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private Custom.RoundPanel jPanel1;
    private javax.swing.JLabel lb_Time;
    private Custom.RoundPanel roundPanel10;
    private Custom.RoundPanel roundPanel11;
    private Custom.RoundPanel roundPanel12;
    private Custom.RoundPanel roundPanel13;
    private Custom.RoundPanel roundPanel14;
    private Custom.RoundPanel roundPanel15;
    private Custom.RoundPanel roundPanel16;
    private Custom.RoundPanel roundPanel17;
    private Custom.RoundPanel roundPanel2;
    private Custom.RoundPanel roundPanel3;
    private Custom.RoundPanel roundPanel4;
    private Custom.RoundPanel roundPanel7;
    private Custom.RoundPanel roundPanel8;
    private Custom.RoundPanel roundPanel9;
    // End of variables declaration//GEN-END:variables
    private int mouseX,mouseY;
}
