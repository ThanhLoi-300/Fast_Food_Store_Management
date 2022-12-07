/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.BillDetail_BUS;
import BUS.Bill_BUS;
import BUS.Customer_BUS;
import BUS.Product_BUS;
import BUS.ReceivedNoteDetail_BUS;
import BUS.ReceivedNote_BUS;
import DTO.statisticalObject;
import java.awt.Insets;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bum
 */
public class Statistic_GUI extends javax.swing.JPanel {

    private final Customer_BUS cBUS;
    private final Product_BUS pBUS;
    private final ReceivedNoteDetail_BUS rndBUS;
    private final ReceivedNote_BUS rnBUS;
    private final Bill_BUS bBUS;
    private final BillDetail_BUS bdBUS;
    private DefaultTableModel model;
    private String date;
    private ArrayList<statisticalObject> soL;
    private double[] Profit;
    private GUI.RevenueChart myChart1;
    private GUI.PieChart customerChart,soldProductChart,receivedProductChart;
    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
    //Định dạng tiền tệ
        Locale locale = new Locale("vi","VN");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        
    public Statistic_GUI() {
        cBUS = new Customer_BUS();
        bBUS = new Bill_BUS();
        rnBUS = new ReceivedNote_BUS();
        rndBUS= new ReceivedNoteDetail_BUS();
        pBUS = new Product_BUS();
        bdBUS = new BillDetail_BUS();
        initComponents();
        loadData();
        setChart();
        Insets insets = UIManager.getInsets("TabbedPane.contentBorderInsets");
        insets.top = -1;
        insets.bottom= -1;
        insets.right= -1;
        insets.left = -1;
        UIManager.put("TabbedPane.contentBorderInsets", insets);
        format.setRoundingMode(RoundingMode.HALF_UP);
        
    }
    private void loadData(){
        calendar.setVisible(true);
        date = fmt.format(calendar.getDate());
        double eV =bBUS.getEarnedValueByDate(date);
        double pV =rnBUS.getPaidValueByDate(date);
        earnedValue.setText(format.format(eV));
        payValue.setText(format.format(pV));
        totalValue.setText(format.format(eV-pV));
        customerCount.setText(String.valueOf(bBUS.totalCustomerByDay(date)));
        CustomerCount1.setText(customerCount.getText());
        rnCount.setText(String.valueOf(rnBUS.countRNByDay(date)));
        rnpCount.setText(String.valueOf(rndBUS.totalReceivedProductByDay(date)));
        bCount.setText(String.valueOf(bBUS.countBillByDay(date)));
        bpCount.setText(String.valueOf(bdBUS.totalSoldProductByDay(date)));
        loadTable(date);
    }
    public void loadTable(String date){
        soL=bBUS.countCustomerByDay(date);
        renderCustomerTable(soL,khTable);
        soL=rndBUS.countReceivedProductByDay(date);
        renderProductTable(soL,nhTable);
        soL=bdBUS.countSoldProductByDay(date);
        renderProductTable(soL,bhTable);
    }
    public void loadTable(String sdate,String edate){
        renderlnTable();
        soL=bBUS.countCustomerByDay(sdate, edate);
        renderCustomerTable(soL,khsTable);
        soL=rndBUS.countReceivedProductByDay(sdate,edate);
        renderProductTable(soL,nhsTable);
        soL=bdBUS.countSoldProductByDay(sdate,edate);
        renderProductTable(soL,bhsTable);
    }
    public void renderCustomerTable(ArrayList<statisticalObject> soL,javax.swing.JTable table)
    {
        model = (DefaultTableModel)table.getModel();
        model.setRowCount(0);
        for(statisticalObject so :soL){
            Object[] row = new Object[]{cBUS.GetNameById(so.getId()),so.getValue()};
            model.addRow(row);
        }
    }
    public void renderProductTable(ArrayList<statisticalObject> soL,javax.swing.JTable table){
        model = (DefaultTableModel)table.getModel();
        model.setRowCount(0);
        for(statisticalObject so :soL){
            Object[] row = new Object[]{pBUS.getNameById(so.getId()),so.getDescription(),so.getValue()};
            model.addRow(row);
        }
    }
    public void renderlnTable(){
        Calendar sdate = sCalendar.getCalendar(), edate = eCalendar.getCalendar();
        model = (DefaultTableModel)lnTable.getModel();
        model.setRowCount(0);
        double a,b,c;
         while(sdate.compareTo(edate)<=0){
             date = fmt.format(sdate.getTime());
             a = bBUS.getEarnedValueByDate(date);
             b = rnBUS.getPaidValueByDate(date);
             c = a-b;
             Object[] row = new Object[]{date,format.format(a),format.format(b),format.format(c)};
             model.addRow(row);
            sdate.add(Calendar.DATE, 1);
         }
    }
    
    private void setChart() {
        yearText.setText(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
        monthText.setText(String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1));
        LineChart(String.valueOf(calendar.getCalendar().get(Calendar.YEAR)));
        pieChart(String.valueOf(calendar.getCalendar().get(Calendar.MONTH)+1));
    }   
    public void LineChart(String year){
        double[] Earned = bBUS.SumEarnedValuePerMonth(year);
        double[] Paid = rnBUS.SumPaidValuePerMonth(year);
        Profit = new double[12];
        for(int i=0;i<12;i++)
            Profit[i]=Earned[i]-Paid[i];
        myChart1 = new GUI.RevenueChart(Profit);
        myChart1.setTitle("Doanh thu năm "+year);
        roundPanel13.add(myChart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 931, 370));
    }
    
    
    
    
    
   public void pieChart(String month) {
       ArrayList<statisticalObject> cL = bBUS.countCustomerByMonth(month);
       ArrayList<statisticalObject> spL = bdBUS.CountSoldProductByMonth(month);
       ArrayList<statisticalObject> rpL = rndBUS.CountReceivedProductByMonth(month);
       if(cL.isEmpty()) WarningC.setVisible(true);else WarningC.setVisible(false);
       if(spL.isEmpty()) WarningS.setVisible(true);else WarningS.setVisible(false);
       if(rpL.isEmpty()) WarningR.setVisible(true);else WarningR.setVisible(false);
       customerChart = new GUI.PieChart(cL,"customer");
       roundPanel14.add(customerChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 210, 220));
       soldProductChart = new GUI.PieChart(spL,"");
       roundPanel14.add(soldProductChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 210, 220));
       receivedProductChart = new GUI.PieChart(rpL,"");
       roundPanel14.add(receivedProductChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 210, 220));
       customerChart.setTitle("Khách hàng");
       soldProductChart.setTitle("Sản phẩm bán");
       receivedProductChart.setTitle("Sản phẩm nhập");
   }
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        calendar = new de.wannawork.jcalendar.JCalendarComboBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        roundPanel1 = new Custom.RoundPanel();
        jPanel3 = new javax.swing.JPanel();
        imageAvatar9 = new Custom.ImageAvatar();
        customerCount = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        roundPanel3 = new Custom.RoundPanel();
        jPanel4 = new javax.swing.JPanel();
        imageAvatar11 = new Custom.ImageAvatar();
        rnCount = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        roundPanel4 = new Custom.RoundPanel();
        jPanel5 = new javax.swing.JPanel();
        imageAvatar10 = new Custom.ImageAvatar();
        bCount = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        earnedValue = new javax.swing.JLabel();
        payValue = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        totalValue = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        roundPanel2 = new Custom.RoundPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        CustomerCount1 = new javax.swing.JLabel();
        imageAvatar12 = new Custom.ImageAvatar();
        jScrollPane1 = new javax.swing.JScrollPane();
        khTable = new javax.swing.JTable();
        roundPanel5 = new Custom.RoundPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        rnpCount = new javax.swing.JLabel();
        imageAvatar13 = new Custom.ImageAvatar();
        jScrollPane4 = new javax.swing.JScrollPane();
        nhTable = new javax.swing.JTable();
        roundPanel6 = new Custom.RoundPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        bpCount = new javax.swing.JLabel();
        imageAvatar14 = new Custom.ImageAvatar();
        jScrollPane2 = new javax.swing.JScrollPane();
        bhTable = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        roundPanel8 = new Custom.RoundPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        khsTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        roundPanel9 = new Custom.RoundPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        bhsTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        roundPanel10 = new Custom.RoundPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        nhsTable = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        sCalendar = new de.wannawork.jcalendar.JCalendarComboBox();
        eCalendar = new de.wannawork.jcalendar.JCalendarComboBox();
        button12 = new Custom.Button();
        roundPanel11 = new Custom.RoundPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        lnTable = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        roundPanel13 = new Custom.RoundPanel();
        roundPanel14 = new Custom.RoundPanel();
        WarningR = new javax.swing.JLabel();
        WarningC = new javax.swing.JLabel();
        WarningS = new javax.swing.JLabel();
        roundPanel15 = new Custom.RoundPanel();
        monthText = new javax.swing.JTextField();
        button11 = new Custom.Button();
        yearText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1035, 641));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        calendar.setBackground(new java.awt.Color(255, 255, 255));
        calendar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        calendar.setFocusCycleRoot(true);
        calendar.setFocusable(false);
        calendar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        calendar.setInheritsPopupMenu(true);
        calendar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                calendarStateChanged(evt);
            }
        });
        add(calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 190, -1));

        jTabbedPane1.setBackground(new java.awt.Color(255, 204, 153));
        jTabbedPane1.setFocusable(false);
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Down_arrow.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Up_arrow.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 110, 240));

        roundPanel1.setBackground(new java.awt.Color(204, 204, 255));
        roundPanel1.setMaximumSize(new java.awt.Dimension(211, 176));
        roundPanel1.setPreferredSize(new java.awt.Dimension(211, 176));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.setMaximumSize(new java.awt.Dimension(183, 118));
        jPanel3.setPreferredSize(new java.awt.Dimension(183, 118));

        imageAvatar9.setForeground(new java.awt.Color(255, 255, 255));
        imageAvatar9.setBorderSize(2);
        imageAvatar9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Customer.png"))); // NOI18N

        customerCount.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        customerCount.setForeground(new java.awt.Color(255, 255, 255));
        customerCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        customerCount.setText("123");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerCount, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customerCount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
            .addComponent(imageAvatar9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("KHÁCH HÀNG");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel1.add(roundPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, -1, -1));

        roundPanel3.setBackground(new java.awt.Color(204, 204, 255));
        roundPanel3.setMaximumSize(new java.awt.Dimension(211, 176));
        roundPanel3.setRequestFocusEnabled(false);

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel4.setMaximumSize(new java.awt.Dimension(183, 118));

        imageAvatar11.setForeground(new java.awt.Color(255, 255, 255));
        imageAvatar11.setBorderSize(2);
        imageAvatar11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ReceivedNote.png"))); // NOI18N

        rnCount.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        rnCount.setForeground(new java.awt.Color(255, 255, 255));
        rnCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rnCount.setText("20");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar11, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rnCount, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageAvatar11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
            .addComponent(rnCount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("PHIẾU NHẬP HÀNG");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel1.add(roundPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, -1, -1));

        roundPanel4.setBackground(new java.awt.Color(204, 204, 255));
        roundPanel4.setMaximumSize(new java.awt.Dimension(211, 176));

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel5.setMaximumSize(new java.awt.Dimension(183, 118));

        imageAvatar10.setForeground(new java.awt.Color(255, 255, 255));
        imageAvatar10.setBorderSize(2);
        imageAvatar10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Bill.png"))); // NOI18N

        bCount.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        bCount.setForeground(new java.awt.Color(255, 255, 255));
        bCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bCount.setText("11");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar10, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bCount, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bCount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
            .addComponent(imageAvatar10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("HÓA ĐƠN");

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel1.add(roundPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, -1, -1));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/chart.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 503, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Bảng tính lợi nhuận"));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Chi:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setText("Doanh thu");

        earnedValue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        earnedValue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        earnedValue.setText("100000đ");

        payValue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        payValue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        payValue.setText("100000đ");

        jLabel15.setText("---------------------------------------------");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Tổng cộng:");

        totalValue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalValue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalValue.setText("1000000đ");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Thu:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(earnedValue, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(18, 18, 18)
                                    .addComponent(payValue, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalValue, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(earnedValue, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(payValue, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(totalValue))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 260, 230));

        jTabbedPane1.addTab("Tổng quát", jPanel1);

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        roundPanel2.setBackground(new java.awt.Color(255, 255, 204));
        roundPanel2.setMaximumSize(new java.awt.Dimension(211, 176));
        roundPanel2.setPreferredSize(new java.awt.Dimension(211, 176));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("KHÁCH HÀNG");

        jPanel7.setBackground(new java.awt.Color(153, 153, 153));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel7.setMaximumSize(new java.awt.Dimension(183, 118));
        jPanel7.setPreferredSize(new java.awt.Dimension(183, 118));

        CustomerCount1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        CustomerCount1.setForeground(new java.awt.Color(255, 255, 255));
        CustomerCount1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CustomerCount1.setText("12");

        imageAvatar12.setForeground(new java.awt.Color(255, 255, 255));
        imageAvatar12.setBorderSize(2);
        imageAvatar12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Customer.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(imageAvatar12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CustomerCount1, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CustomerCount1, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(imageAvatar12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        khTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tên khách hàng", "Số lần mua"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        khTable.setIntercellSpacing(new java.awt.Dimension(0, 5));
        khTable.setRowHeight(30);
        jScrollPane1.setViewportView(khTable);
        if (khTable.getColumnModel().getColumnCount() > 0) {
            khTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        }

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        roundPanel5.setBackground(new java.awt.Color(255, 255, 204));
        roundPanel5.setMaximumSize(new java.awt.Dimension(211, 176));
        roundPanel5.setPreferredSize(new java.awt.Dimension(211, 176));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("SẢN PHẨM NHẬP VỀ");

        jPanel8.setBackground(new java.awt.Color(153, 153, 153));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel8.setMaximumSize(new java.awt.Dimension(183, 118));
        jPanel8.setPreferredSize(new java.awt.Dimension(183, 118));

        rnpCount.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        rnpCount.setForeground(new java.awt.Color(255, 255, 255));
        rnpCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rnpCount.setText("123");

        imageAvatar13.setForeground(new java.awt.Color(255, 255, 255));
        imageAvatar13.setBorderSize(2);
        imageAvatar13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ReceivedNote.png"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(imageAvatar13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rnpCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rnpCount, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(imageAvatar13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        nhTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên sản phẩm", "Size", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        nhTable.setRowHeight(30);
        jScrollPane4.setViewportView(nhTable);
        if (nhTable.getColumnModel().getColumnCount() > 0) {
            nhTable.getColumnModel().getColumn(1).setPreferredWidth(20);
            nhTable.getColumnModel().getColumn(2).setPreferredWidth(20);
        }

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        roundPanel6.setBackground(new java.awt.Color(255, 255, 204));
        roundPanel6.setMaximumSize(new java.awt.Dimension(211, 176));
        roundPanel6.setPreferredSize(new java.awt.Dimension(211, 176));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("SẢN PHẨM BÁN RA");

        jPanel9.setBackground(new java.awt.Color(153, 153, 153));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel9.setMaximumSize(new java.awt.Dimension(183, 118));
        jPanel9.setPreferredSize(new java.awt.Dimension(183, 118));

        bpCount.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        bpCount.setForeground(new java.awt.Color(255, 255, 255));
        bpCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bpCount.setText("123");

        imageAvatar14.setForeground(new java.awt.Color(255, 255, 255));
        imageAvatar14.setBorderSize(2);
        imageAvatar14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Bill.png"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(imageAvatar14, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bpCount, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bpCount, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(imageAvatar14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bhTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên sản phẩm", "Size", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bhTable.setRowHeight(30);
        jScrollPane2.setViewportView(bhTable);
        if (bhTable.getColumnModel().getColumnCount() > 0) {
            bhTable.getColumnModel().getColumn(1).setPreferredWidth(20);
            bhTable.getColumnModel().getColumn(2).setPreferredWidth(20);
        }

        javax.swing.GroupLayout roundPanel6Layout = new javax.swing.GroupLayout(roundPanel6);
        roundPanel6.setLayout(roundPanel6Layout);
        roundPanel6Layout.setHorizontalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel6Layout.setVerticalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(roundPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(roundPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Chi tiết", jPanel6);

        jPanel11.setBackground(new java.awt.Color(0, 51, 51));

        roundPanel8.setBackground(new java.awt.Color(255, 255, 255));

        khsTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        khsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tên khách hàng", "Số lần mua"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        khsTable.setGridColor(new java.awt.Color(51, 51, 51));
        jScrollPane5.setViewportView(khsTable);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Khách hàng");

        javax.swing.GroupLayout roundPanel8Layout = new javax.swing.GroupLayout(roundPanel8);
        roundPanel8.setLayout(roundPanel8Layout);
        roundPanel8Layout.setHorizontalGroup(
            roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel8Layout.setVerticalGroup(
            roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        roundPanel9.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel9.setPreferredSize(new java.awt.Dimension(480, 264));

        bhsTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        bhsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên sản phẩm", "size", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bhsTable.setGridColor(new java.awt.Color(51, 51, 51));
        jScrollPane6.setViewportView(bhsTable);
        if (bhsTable.getColumnModel().getColumnCount() > 0) {
            bhsTable.getColumnModel().getColumn(1).setPreferredWidth(15);
            bhsTable.getColumnModel().getColumn(2).setPreferredWidth(15);
        }

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Sản phẩm bán");

        javax.swing.GroupLayout roundPanel9Layout = new javax.swing.GroupLayout(roundPanel9);
        roundPanel9.setLayout(roundPanel9Layout);
        roundPanel9Layout.setHorizontalGroup(
            roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel9Layout.setVerticalGroup(
            roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel10.setBackground(new java.awt.Color(255, 255, 255));

        nhsTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nhsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên sản phẩm", "size", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        nhsTable.setGridColor(new java.awt.Color(51, 51, 51));
        jScrollPane7.setViewportView(nhsTable);
        if (nhsTable.getColumnModel().getColumnCount() > 0) {
            nhsTable.getColumnModel().getColumn(1).setPreferredWidth(15);
            nhsTable.getColumnModel().getColumn(2).setPreferredWidth(15);
        }

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Sản phẩm nhập");

        javax.swing.GroupLayout roundPanel10Layout = new javax.swing.GroupLayout(roundPanel10);
        roundPanel10.setLayout(roundPanel10Layout);
        roundPanel10Layout.setHorizontalGroup(
            roundPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel10Layout.setVerticalGroup(
            roundPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        button12.setBackground(new java.awt.Color(240, 240, 240));
        button12.setBorder(null);
        button12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search.png"))); // NOI18N
        button12.setText("Tìm");
        button12.setColor(new java.awt.Color(240, 240, 240));
        button12.setColorClick(new java.awt.Color(255, 255, 255));
        button12.setColorOver(new java.awt.Color(255, 255, 255));
        button12.setFocusable(false);
        button12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        button12.setRadius(10);
        button12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button12ActionPerformed(evt);
            }
        });

        roundPanel11.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel11.setPreferredSize(new java.awt.Dimension(480, 264));

        lnTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lnTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ngày", "Thu", "Chi", "Lợi nhuận"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        lnTable.setGridColor(new java.awt.Color(51, 51, 51));
        jScrollPane8.setViewportView(lnTable);
        if (lnTable.getColumnModel().getColumnCount() > 0) {
            lnTable.getColumnModel().getColumn(1).setPreferredWidth(15);
            lnTable.getColumnModel().getColumn(2).setPreferredWidth(15);
        }

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Doanh thu");

        javax.swing.GroupLayout roundPanel11Layout = new javax.swing.GroupLayout(roundPanel11);
        roundPanel11.setLayout(roundPanel11Layout);
        roundPanel11Layout.setHorizontalGroup(
            roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel11Layout.setVerticalGroup(
            roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(roundPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(roundPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(sCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button12, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(roundPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(roundPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(eCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(sCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(button12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("Theo ngày", jPanel11);

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));

        roundPanel13.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundPanel14.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        WarningR.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        WarningR.setText("Không có thống kê tháng này");
        roundPanel14.add(WarningR, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 190, 90));

        WarningC.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        WarningC.setText("Không có thống kê tháng này");
        roundPanel14.add(WarningC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 190, 90));

        WarningS.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        WarningS.setText("Không có thống kê tháng này");
        roundPanel14.add(WarningS, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 190, 90));

        roundPanel15.setBackground(new java.awt.Color(255, 255, 255));

        monthText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        monthText.setForeground(new java.awt.Color(153, 153, 153));
        monthText.setText("Nhập tháng");

        button11.setBackground(new java.awt.Color(240, 240, 240));
        button11.setBorder(null);
        button11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search.png"))); // NOI18N
        button11.setText("Tìm");
        button11.setColor(new java.awt.Color(240, 240, 240));
        button11.setColorClick(new java.awt.Color(255, 255, 255));
        button11.setColorOver(new java.awt.Color(255, 255, 255));
        button11.setFocusable(false);
        button11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        button11.setRadius(10);
        button11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button11ActionPerformed(evt);
            }
        });

        yearText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        yearText.setForeground(new java.awt.Color(153, 153, 153));
        yearText.setText("Nhập năm");
        yearText.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Số liệu thống kê");

        javax.swing.GroupLayout roundPanel15Layout = new javax.swing.GroupLayout(roundPanel15);
        roundPanel15.setLayout(roundPanel15Layout);
        roundPanel15Layout.setHorizontalGroup(
            roundPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel15Layout.createSequentialGroup()
                        .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel15Layout.createSequentialGroup()
                        .addGroup(roundPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(yearText, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthText, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55))))
        );
        roundPanel15Layout.setVerticalGroup(
            roundPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(yearText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(monthText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(roundPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Biểu đồ", jPanel10);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 650));
    }// </editor-fold>//GEN-END:initComponents

    private void calendarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_calendarStateChanged
        loadData();
    }//GEN-LAST:event_calendarStateChanged

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        if(jPanel10.isVisible() || jPanel7.isVisible())
        calendar.setVisible(false);
        else calendar.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void button11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button11ActionPerformed
        try{
            if(Integer.parseInt(yearText.getText())<0 || Integer.parseInt(monthText.getText())<=0 || Integer.parseInt(monthText.getText())>12)
            JOptionPane.showMessageDialog(this, "Vui lòng nhập chuẩn định dạng", "Warning", JOptionPane.WARNING_MESSAGE);
            else{
                roundPanel13.removeAll();
                LineChart(yearText.getText());
                roundPanel14.remove(customerChart);
                roundPanel14.remove(soldProductChart);
                roundPanel14.remove(receivedProductChart);
                pieChart(monthText.getText());
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_button11ActionPerformed

    private void button12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button12ActionPerformed
        if(sCalendar.getDate().compareTo(eCalendar.getDate())>0)
            JOptionPane.showMessageDialog(this, "bạn vừa nhập ngày bắt đầu > ngày kết thúc", "Warning", JOptionPane.WARNING_MESSAGE);
        else{
            String sdate = fmt.format(sCalendar.getDate());
            String edate = fmt.format(eCalendar.getDate());
            loadTable(sdate,edate);
        }      
    }//GEN-LAST:event_button12ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CustomerCount1;
    private javax.swing.JLabel WarningC;
    private javax.swing.JLabel WarningR;
    private javax.swing.JLabel WarningS;
    private javax.swing.JLabel bCount;
    private javax.swing.JTable bhTable;
    private javax.swing.JTable bhsTable;
    private javax.swing.JLabel bpCount;
    private Custom.Button button11;
    private Custom.Button button12;
    private de.wannawork.jcalendar.JCalendarComboBox calendar;
    private javax.swing.JLabel customerCount;
    private de.wannawork.jcalendar.JCalendarComboBox eCalendar;
    private javax.swing.JLabel earnedValue;
    private Custom.ImageAvatar imageAvatar10;
    private Custom.ImageAvatar imageAvatar11;
    private Custom.ImageAvatar imageAvatar12;
    private Custom.ImageAvatar imageAvatar13;
    private Custom.ImageAvatar imageAvatar14;
    private Custom.ImageAvatar imageAvatar9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable khTable;
    private javax.swing.JTable khsTable;
    private javax.swing.JTable lnTable;
    private javax.swing.JTextField monthText;
    private javax.swing.JTable nhTable;
    private javax.swing.JTable nhsTable;
    private javax.swing.JLabel payValue;
    private javax.swing.JLabel rnCount;
    private javax.swing.JLabel rnpCount;
    private Custom.RoundPanel roundPanel1;
    private Custom.RoundPanel roundPanel10;
    private Custom.RoundPanel roundPanel11;
    private Custom.RoundPanel roundPanel13;
    private Custom.RoundPanel roundPanel14;
    private Custom.RoundPanel roundPanel15;
    private Custom.RoundPanel roundPanel2;
    private Custom.RoundPanel roundPanel3;
    private Custom.RoundPanel roundPanel4;
    private Custom.RoundPanel roundPanel5;
    private Custom.RoundPanel roundPanel6;
    private Custom.RoundPanel roundPanel8;
    private Custom.RoundPanel roundPanel9;
    private de.wannawork.jcalendar.JCalendarComboBox sCalendar;
    private javax.swing.JLabel totalValue;
    private javax.swing.JTextField yearText;
    // End of variables declaration//GEN-END:variables
}
