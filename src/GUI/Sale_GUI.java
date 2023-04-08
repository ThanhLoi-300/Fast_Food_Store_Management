
package GUI;

import BUS.BillDetail_BUS;
import BUS.Bill_BUS;
import BUS.Category_BUS;
import BUS.Customer_BUS;
import BUS.DecentralizationDetail_BUS;
import BUS.Discount_BUS;
import BUS.Product_BUS;
import Custom.Detail_Bill;
import Custom.Item_Product;
import Custom.Product;
import Custom.RoundPanel;
import DTO.Bill;
import DTO.BillDetail;
import DTO.Category_DTO;
import DTO.Customer;
import DTO.Discount_DTO;
import DTO.Product_DTO;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sale_GUI extends javax.swing.JPanel implements checkPermission{
    
    private ArrayList<Product_DTO> list_Product = new ArrayList<Product_DTO>();
    private ArrayList<Product_DTO> list_Detail_Bill = new ArrayList<Product_DTO>();
    private ArrayList<Integer> list_Quantity_Choice = new ArrayList<Integer>();
    private ArrayList<Category_DTO> list_Category = new ArrayList<Category_DTO>();
    private Customer customer;
    private String StaffID;
    private Product_BUS product_BUS = new Product_BUS();
    private Category_BUS category_BUS = new Category_BUS();
    private Customer_BUS customer_BUS = new Customer_BUS();
    private Bill_BUS bill_BUS = new Bill_BUS();
    private BillDetail_BUS bd_BUS = new BillDetail_BUS();
    private Discount_BUS discount_BUS = new Discount_BUS();
    private DecentralizationDetail_BUS dcdtBUS = new DecentralizationDetail_BUS();
    private ProductDetails_GUI productDetails_GUI;
    private int permissionType;
    String dcdt = "";
    
    public Sale_GUI(String staffID, int permissionType, String dcdt_Id){
        initComponents();
        Auto_Update_Discount();
        productDetails_GUI = new ProductDetails_GUI();
        this.StaffID = staffID;
        this.permissionType = permissionType;
        Detail_Bill_Panel.setLayout( new GridLayout(1,1,0,0));
        
        list_Product = product_BUS.readProductOnBusiness();
        set_Grid_Layout_for_Panel_And_Load_Product(list_Product);
        
        list_Category = category_BUS.load_Data_CategoryObBusiness();
        Vector comboBoxItems=new Vector();
        comboBoxItems.add("Tất cả");
        for(int i = 0; i< list_Category.size();i++)
            comboBoxItems.add(list_Category.get(i).getCategory_Name());
        cbbSearchFilter.setModel(new DefaultComboBoxModel(comboBoxItems));
        this.dcdt = dcdt_Id;
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
    
    public Product_DTO checkOrderExits(Product_DTO product) {
        for(int i=0; i<list_Detail_Bill.size(); i++) {
            if(product.getProductID().equals(list_Detail_Bill.get(i).getProductID()) 
              && product.getSize().equals(list_Detail_Bill.get(i).getSize())) {
                return list_Detail_Bill.get(i);
            }
        }
        return null;
    }
    
    //Mở rộng panel Grid layout dựa trên list_Product.size()
    public void set_Grid_Layout_for_Panel_And_Load_Product( ArrayList<Product_DTO> list_Product ){
        if(list_Product.size() > 1 && list_Product.size()%2 == 1){
            Product_Panel.setLayout( new GridLayout( list_Product.size()/2 +1 ,2,15,15));
            for(int i = 0; i< list_Product.size();i++)
                addItem(list_Product.get(i));
        }else if(list_Product.size() == 0){//list_Product k có dữ liệu set rỗng panel_Product
            Product_Panel.removeAll();
            Product_Panel.repaint();
            Product_Panel.validate();
        }else if(list_Product.size() > 2 && list_Product.size()%2 == 0){
            Product_Panel.setLayout( new GridLayout( list_Product.size()/2 ,2,15,15));
            for(int i = 0; i< list_Product.size();i++)
                addItem(list_Product.get(i));
        }else if(list_Product.size() == 2){
            Product_Panel.setLayout( new GridLayout( list_Product.size()/2 +1  ,2,15,15));
            for(int i = 0; i< list_Product.size();i++)
                addItem(list_Product.get(i));
            for(int i=0; i<2; i++){
                Item_Product pd = new Item_Product();
                pd.setPreferredSize(new java.awt.Dimension(156,189));
                pd.getjButton8().setVisible(false);
                //Dòng này để test kết quả
                //pd.setData(new Product_DTO("1","1","1","1",1,1,"1",true,true));
                Product_Panel.add(pd);
                Product_Panel.repaint();
                Product_Panel.revalidate();
            }
        }
        else{
            //List chỉ có 1 phần tử tạo thêm 2 Item_Product rỗng để tránh lỗi full screen
            Product_Panel.setLayout( new GridLayout(2,2,15,15));
            addItem(list_Product.get(0));
            for(int i=0; i<2; i++){
                Item_Product pd = new Item_Product();
                pd.setPreferredSize(new java.awt.Dimension(156,189));
                pd.getjButton8().setVisible(false);
                //Dòng này để test kết quả
                //pd.setData(new Product_DTO("1","1","1","1",1,1,"1",true,true));
                Product_Panel.add(pd);
                Product_Panel.repaint();
                Product_Panel.revalidate();
            }
        }
    }
    
    public void addItem( Product_DTO data){
        Item_Product pd = new Item_Product();
        pd.setPreferredSize(new java.awt.Dimension(156,189));
        pd.setData(data);
        pd.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                if(permissionType!=2){
                    hienThiErrorMess();
                    return;
                }
                if( checkOrderExits(data) != null){
                    if(!productDetails_GUI.isShowing())
                        productDetails_GUI = new ProductDetails_GUI( checkOrderExits(data), checkOrderExits(data).getSize(), Sale_GUI.this, "Update Detail Product in Bill", pd.getPercent());
                    else {
                        productDetails_GUI.dispose();
                        productDetails_GUI = new ProductDetails_GUI( checkOrderExits(data), checkOrderExits(data).getSize(), Sale_GUI.this, "Update Detail Product in Bill", pd.getPercent());
                    }
                }
                else
                    if(!productDetails_GUI.isShowing())
                        productDetails_GUI= new ProductDetails_GUI( data, data.getSize(), Sale_GUI.this, "Add new Product to Bill", pd.getPercent());
                    else {
                        productDetails_GUI.dispose();
                        productDetails_GUI= new ProductDetails_GUI( data, data.getSize(), Sale_GUI.this, "Add new Product to Bill", pd.getPercent());
                    }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                pd.setBorder( new LineBorder(Color.BLUE).createGrayLineBorder());
                pd.setPreferredSize(new java.awt.Dimension(pd.getWidth()-1, pd.getHeight()-1));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                pd.setBorder(null);
                pd.setPreferredSize(new java.awt.Dimension(pd.getWidth(), pd.getHeight()));
            }      
        });
        Product_Panel.add(pd);
        Product_Panel.repaint();
        Product_Panel.revalidate();
    }
    
    public void addBill( ArrayList<Product_DTO> list_Detail_Bill, ArrayList<Integer> list_Quantity_Choice){
        double totalPrice = 0;
        for(int e = 0; e < list_Detail_Bill.size();e++){
            Detail_Bill detail_Bill = new Detail_Bill();
            detail_Bill.setData( list_Detail_Bill.get(e), list_Quantity_Choice.get(e), e);
            Product_DTO product = list_Detail_Bill.get(e);
            
            int index = e;
            
            detail_Bill.getDetail_Panel().addMouseListener(new MouseAdapter(){
                @Override
                public void mousePressed(MouseEvent e) {
                    new ProductDetails_GUI(product, product.getSize(), Sale_GUI.this, "Update Detail Product in Bill", discount_BUS.check_Product_Discount(product.getProductID()));
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
            totalPrice += product.getPrice()*list_Quantity_Choice.get(e);
            Detail_Bill_Panel.add(detail_Bill);
            Detail_Bill_Panel.repaint();
            Detail_Bill_Panel.revalidate();
        }
        Locale locale = new Locale("vi","VN");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        jLabel7.setText(format.format(totalPrice));
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
        setPreferredSize(new java.awt.Dimension(1031, 654));

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel1.setPreferredSize(new java.awt.Dimension(1033, 654));

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(70, 70, 70));
        jLabel1.setText("Tên khách hàng: ");
        jLabel1.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setOpaque(true);

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
        button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button2MouseClicked(evt);
            }
        });

        Detail_Bill_Panel.setBackground(new java.awt.Color(255, 255, 255));
        Detail_Bill_Panel.setAutoscrolls(true);

        javax.swing.GroupLayout Detail_Bill_PanelLayout = new javax.swing.GroupLayout(Detail_Bill_Panel);
        Detail_Bill_Panel.setLayout(Detail_Bill_PanelLayout);
        Detail_Bill_PanelLayout.setHorizontalGroup(
            Detail_Bill_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );
        Detail_Bill_PanelLayout.setVerticalGroup(
            Detail_Bill_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(Detail_Bill_Panel);

        roundPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Tổng tiền:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Tiền nhận:");

        btnAdd1.setBorder(null);
        btnAdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/plus.png"))); // NOI18N
        btnAdd1.setText("Thanh toán");
        btnAdd1.setFocusPainted(false);
        btnAdd1.setFocusable(false);
        btnAdd1.setRadius(20);
        btnAdd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdd1MouseClicked(evt);
            }
        });

        btnAdd.setBorder(null);
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/remove.png"))); // NOI18N
        btnAdd.setText("Hủy");
        btnAdd.setFocusPainted(false);
        btnAdd.setFocusable(false);
        btnAdd.setRadius(20);
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("0");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Tiền thừa:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("0");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

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
                .addContainerGap(13, Short.MAX_VALUE)
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

        jTextField3.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateFieldState();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateFieldState();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateFieldState();
            }

            protected void updateFieldState() {
                Locale locale = new Locale("vi","VN");
                NumberFormat format = NumberFormat.getCurrencyInstance(locale);
                //format.setRoundingMode(RoundingMode.HALF_UP);
                if(jTextField3.getText().isBlank()|| !(jTextField3.getText().matches("-?\\d+"))) {
                    // do nothing
                    jLabel9.setText(format.format(0));
                }
                else {
                    double totalCash = 0;
                    double receiveCash = Double.parseDouble(jTextField3.getText());
                    try {
                        totalCash = NumberFormat.getCurrencyInstance(locale).parse(jLabel7.getText()).doubleValue();
                    }
                    catch (ParseException ex) {
                        Logger.getLogger(Sale_GUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    double excessCash = totalCash - receiveCash;
                    jLabel9.setText(format.format(excessCash)+"");
                }
            }
        });

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roundPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel3.setAutoscrolls(true);
        roundPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbbSearchFilter.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbbSearchFilter.setMaximumRowCount(100);
        cbbSearchFilter.setBorder(null);
        cbbSearchFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        cbbSearchFilter.setFocusable(false);
        cbbSearchFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSearchFilterActionPerformed(evt);
            }
        });
        roundPanel3.add(cbbSearchFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 134, 35));

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        roundPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 260, 20));
        jTextField1.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateFieldState();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateFieldState();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateFieldState();
            }

            protected void updateFieldState() {
                String searchString = jTextField1.getText();
                Product_Panel.removeAll();
                list_Product = product_BUS.readProductByName(cbbSearchFilter.getSelectedItem().toString(), searchString);
                set_Grid_Layout_for_Panel_And_Load_Product(list_Product);
            }
        });

        jLabel4.setBackground(new java.awt.Color(102, 102, 102));
        jLabel4.setOpaque(true);
        roundPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 300, 1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search.png"))); // NOI18N
        roundPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, 35));

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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanel3.add(roundPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 64, 580, 550));

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1031, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                .addGap(4, 4, 4))
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

    private void button2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button2MouseClicked
        this.permissionType = dcdtBUS.readById(this.dcdt).getIsSale();
        if(this.permissionType!=2) {
            this.hienThiErrorMess();
            return;
        }
        String phoneNum = jTextField2.getText();
        if(phoneNum.isBlank() || phoneNum.equals("Số điện thoại")) {
            // do nothing
        }
        else {
            customer = customer_BUS.findCustomerByPhoneNum(phoneNum);
            if(customer == null) {
                jLabel1.setText("Tên khách hàng:");
                if(JOptionPane.showConfirmDialog(this, "Không tìm thấy dữ liệu khách hàng, thêm mới?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    new AddCustomerOnSale_GUI();
                }
            }
            else
                jLabel1.setText("Tên khách hàng: "+customer.getCustomerName());
        }
    }//GEN-LAST:event_button2MouseClicked

    private void cbbSearchFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSearchFilterActionPerformed
        Product_Panel.removeAll();
        if(cbbSearchFilter.getSelectedItem().toString().equals("Tất cả")) {
            list_Product = product_BUS.readProductOnBusiness();
            set_Grid_Layout_for_Panel_And_Load_Product(list_Product);
        }else {
            String categoryName = cbbSearchFilter.getSelectedItem().toString();
            list_Product = product_BUS.readProductByCategoryName(categoryName);
            set_Grid_Layout_for_Panel_And_Load_Product(list_Product);
        }
    }//GEN-LAST:event_cbbSearchFilterActionPerformed

    public String autoGenerateId() {
        String bill_id = "B";
        bill_id += (Integer.parseInt(bill_BUS.countGenerateId())+1);
        return bill_id;
    }
    
    private void btnAdd1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdd1MouseClicked
        this.permissionType = dcdtBUS.readById(this.dcdt).getIsSale();
        if(this.permissionType!=2){
            this.hienThiErrorMess();
            return;
        }
        Locale locale = new Locale("vi","VN");
        double totalCash = 0;
        double excessCash = 0;
        try {
            totalCash = NumberFormat.getCurrencyInstance(locale).parse(jLabel7.getText()).doubleValue();
            excessCash = NumberFormat.getCurrencyInstance(locale).parse(jLabel9.getText()).doubleValue();
        } catch (ParseException ex) {
            Logger.getLogger(Sale_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(list_Detail_Bill.isEmpty()) {} //do nothing
        else if(jTextField3.getText().isBlank()|| !(jTextField3.getText().matches("-?\\d+")) || Integer.parseInt(jTextField3.getText())<= 0)
                    JOptionPane.showMessageDialog(this, "Vui lòng điền số tiền khách đưa!", "Warning", JOptionPane.WARNING_MESSAGE);
        else if( Double.parseDouble(jTextField3.getText()) < totalCash)
                    JOptionPane.showMessageDialog(this, "Chưa nhận đủ số tiền", "Warning", JOptionPane.WARNING_MESSAGE);
        else {        
            double receiveCash = Double.parseDouble(jTextField3.getText());
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
            Bill b = new Bill();
            b.setBill_ID(autoGenerateId());
            b.setDate(now.format(format));
            b.setTotalValue(totalCash);
            b.setReceivedMoney(receiveCash);
            b.setExcessMoney(excessCash);
            b.setStaffID(this.StaffID);
            if(this.customer == null) 
                b.setCustomerID("C0");
            else
                b.setCustomerID(this.customer.getCustomerId());
            if(bill_BUS.Insert(b)) {                
                if(!b.getCustomerID().equals("C0"))
                    customer_BUS.updatePurchaseTime(this.customer.getCustomerId(), this.customer.getPurchaseTimes()+1);
                for(int i=0; i<list_Detail_Bill.size(); i++) {
                    BillDetail bd = new BillDetail();
                    bd.setBillId(b.getBill_ID());
                    bd.setProductId(list_Detail_Bill.get(i).getProductID());
                    bd.setSize(list_Detail_Bill.get(i).getSize());
                    bd.setQuantity(list_Quantity_Choice.get(i));
                    bd.setTotalValue(list_Detail_Bill.get(i).getPrice()*list_Quantity_Choice.get(i));
                    int percent = discount_BUS.check_Discount_Percent(list_Detail_Bill.get(i).getProductID());
                    bd.setPercent(percent);
                    int newQuantity = list_Detail_Bill.get(i).getQuantity() - list_Quantity_Choice.get(i);
                    bd_BUS.insert(bd);
                    product_BUS.updateProductQuantity(list_Detail_Bill.get(i), newQuantity);
                } 
                try {
                    Export_Excel(b.getBill_ID());
                } catch (IOException ex) {
                    Logger.getLogger(Sale_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(this, "Thanh toán bill thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                refresh();
            }
        }
    }//GEN-LAST:event_btnAdd1MouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        if(JOptionPane.showConfirmDialog(this, "Xóa hóa đơn hiện tại?", "Xác nhận", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            refresh();
        }
    }//GEN-LAST:event_btnAddMouseClicked

    private void refresh(){
        list_Detail_Bill.clear();
        list_Quantity_Choice.clear();
        Detail_Bill_Panel.removeAll();
        Detail_Bill_Panel.repaint();
        Detail_Bill_Panel.revalidate();
        jLabel7.setText("0");
        jLabel9.setText("0");
        jTextField3.setText("");
        jTextField1.setText("");
        jLabel1.setText("Tên khách hàng:");
    }
    
    public void Export_Excel(String bill_Id) throws FileNotFoundException, IOException{
        Bill bill = category_BUS.get_Bill_From_Id(bill_Id);
        
        Locale locale = new Locale("vi","VN");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        format.setRoundingMode(RoundingMode.HALF_UP);
        
        XSSFWorkbook workBook = new XSSFWorkbook();
        XSSFSheet sheet = workBook.createSheet("Hóa đơn");
        
        XSSFRow row = null;
        Cell cell = null;
        
        CellRangeAddress range = new CellRangeAddress(1, 1, 0, 11);
        sheet.addMergedRegion(range);
        
        //cell style
        CellStyle styleId = workBook.createCellStyle();
        styleId.setAlignment(HorizontalAlignment.CENTER);
            
        XSSFFont font1 = workBook.createFont();
        font1.setFontHeight(16);
        font1.setBold(true);
        font1.setColor(IndexedColors.BLACK1.getIndex());
        styleId.setFont(font1);
        
        //Bold
        CellStyle style_Bold = workBook.createCellStyle();
        style_Bold.setAlignment(HorizontalAlignment.CENTER);
            
        XSSFFont font_Bold = workBook.createFont();
        font_Bold.setFontHeight(13);
        font_Bold.setBold(true);
        font_Bold.setColor(IndexedColors.BLACK1.getIndex());
        style_Bold.setFont(font_Bold);
        
        //Strikeout
        CellStyle style_Strikeout = workBook.createCellStyle();
        style_Strikeout.setAlignment(HorizontalAlignment.CENTER);
            
        XSSFFont font_Strikeout = workBook.createFont();
        font_Strikeout.setFontHeight(13);
        font_Strikeout.setStrikeout(true);
        font_Strikeout.setColor(IndexedColors.BLACK1.getIndex());
        style_Strikeout.setFont(font_Strikeout);
        
        //common
        CellStyle style_Common = workBook.createCellStyle();
        style_Common.setAlignment(HorizontalAlignment.CENTER);
            
        XSSFFont font_Common = workBook.createFont();
        font_Common.setFontHeight(12);
        style_Common.setFont(font_Common);
        
        //Title
        row = sheet.createRow(1);
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("HÓA ĐƠN");
        cell.setCellStyle(styleId);
        
        //Bill_Id
        row = sheet.createRow(3);
        
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Mã:");
        cell.setCellStyle(style_Bold);
        
        range = new CellRangeAddress(3, 3, 1, 4);
        sheet.addMergedRegion(range);
        
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue(bill_Id);
        cell.setCellStyle(style_Common);
        
        //Ngày
        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("Ngày:");
        cell.setCellStyle(style_Bold);
        
        range = new CellRangeAddress(3, 3, 8, 11);
        sheet.addMergedRegion(range);
        
        cell = row.createCell(8, CellType.STRING);
        cell.setCellValue(bill.getDate());
        cell.setCellStyle(style_Common);
        
        //Staff
        row = sheet.createRow(4);
        
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Staff:");
        cell.setCellStyle(style_Bold);
        
        range = new CellRangeAddress(4, 4, 1, 4);
        sheet.addMergedRegion(range);
        
        String staff_Name = category_BUS.get_Staff_Name_From_Id(bill.getStaffID());
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue(staff_Name);
        cell.setCellStyle(style_Common);
        
        //Khách hàng    
        if( !bill.getCustomerID().equals("C0") ){
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Khách:");
            cell.setCellStyle(style_Bold);
        
            range = new CellRangeAddress(4, 4, 8, 11);
            sheet.addMergedRegion(range);
            
            String customer_Name = category_BUS.get_Customer_Name_From_Id(bill.getCustomerID());
            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue(customer_Name);
            cell.setCellStyle(style_Common);
        }
        
        range = new CellRangeAddress(6, 6, 1, 10);
        sheet.addMergedRegion(range);
        
        row = sheet.createRow(6);
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("------------------------------------------------------------------------------------------------------------------------------------------------");
        cell.setCellStyle(style_Bold);
            
        //middle
        row = sheet.createRow(8);
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("STT");
        cell.setCellStyle(style_Bold);
        
        range = new CellRangeAddress(8, 8, 1, 4);
        sheet.addMergedRegion(range);
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Sản phẩm");
        cell.setCellStyle(style_Bold);
        
        
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("SL");
        cell.setCellStyle(style_Bold);
        
        range = new CellRangeAddress(8, 8, 6, 7);
        sheet.addMergedRegion(range);
        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("Giá");
        cell.setCellStyle(style_Bold);
        
        range = new CellRangeAddress(8, 8, 8, 9);
        sheet.addMergedRegion(range);
        cell = row.createCell(8, CellType.STRING);
        cell.setCellValue("Giá giảm");
        cell.setCellStyle(style_Bold);
        
        range = new CellRangeAddress(8, 8, 10, 11);
        sheet.addMergedRegion(range);
        cell = row.createCell(10, CellType.STRING);
        cell.setCellValue("Thành tiền");
        cell.setCellStyle(style_Bold);
        
        ArrayList<BillDetail> detail_Bill = bd_BUS.LoadDetail(bill_Id);
        int i = 0;
        if(detail_Bill != null){
            for( i = 0 ; i< detail_Bill.size(); i++){
                BillDetail bd = detail_Bill.get(i);
                Product_DTO product = category_BUS.get_Product_In_Detail_Bill(bd.getProductId(),bd.getSize());
                
                row = sheet.createRow(10+i);
                
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i+1);
                cell.setCellStyle(style_Common);
                   
                range = new CellRangeAddress(10+i, 10+i, 1, 4);
                sheet.addMergedRegion(range);
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(product.getProductName()+ " ("+ product.getSize()+")");
                cell.setCellStyle(style_Common);
                
                cell = row.createCell(5, CellType.NUMERIC);
                cell.setCellValue(bd.getQuantity());
                cell.setCellStyle(style_Common);
                
                int percent =  discount_BUS.check_Discount_Percent(product.getProductID());
                
                if(percent > 0){
                    range = new CellRangeAddress(10+i, 10+i, 6, 7);
                    sheet.addMergedRegion(range);
                    cell = row.createCell(6, CellType.NUMERIC);
                    cell.setCellValue(format.format(product.getPrice()));
                    cell.setCellStyle(style_Strikeout);

                    range = new CellRangeAddress(10+i, 10+i, 8, 9);
                    sheet.addMergedRegion(range);
                    cell = row.createCell(8, CellType.NUMERIC);
                    double price_Discount = product.getPrice() - product.getPrice() * percent / 100;
                    cell.setCellValue(format.format(price_Discount));
                    cell.setCellStyle(style_Common);
                }else{
                    range = new CellRangeAddress(10+i, 10+i, 6, 7);
                    sheet.addMergedRegion(range);
                    cell = row.createCell(6, CellType.NUMERIC);
                    cell.setCellValue(format.format(product.getPrice()));
                    cell.setCellStyle(style_Common);
                    
                    range = new CellRangeAddress(10+i, 10+i, 8, 9);
                    sheet.addMergedRegion(range);
                }

                range = new CellRangeAddress(10+i, 10+i, 10, 11);
                sheet.addMergedRegion(range);
                cell = row.createCell(10, CellType.NUMERIC);
                cell.setCellValue(format.format(bd.getTotalValue()));
                cell.setCellStyle(style_Common);
            }
            
            range = new CellRangeAddress(11+i, 11+i, 1, 10);
            sheet.addMergedRegion(range);
        
            row = sheet.createRow(11+i);
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("------------------------------------------------------------------------------------------------------------------------------------------------");
            cell.setCellStyle(style_Bold);
            //footer
            //Total
            row = sheet.createRow(13+i);
            range = new CellRangeAddress(13+i, 13+i, 6, 7);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Tổng:");
            cell.setCellStyle(style_Bold);
            
            range = new CellRangeAddress(13+i, 13+i, 8, 10);
            sheet.addMergedRegion(range);
            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue(format.format(bill.getTotalValue()));
            cell.setCellStyle(style_Common);
            
            //Recieved
            row = sheet.createRow(14+i);
            range = new CellRangeAddress(14+i, 14+i, 6, 7);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Tiền nhận:");
            cell.setCellStyle(style_Bold);
            
            range = new CellRangeAddress(14+i, 14+i, 8, 10);
            sheet.addMergedRegion(range);
            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue(format.format(bill.getReceivedMoney()));
            cell.setCellStyle(style_Common);
            
            //Excess
            row = sheet.createRow(15+i);
            range = new CellRangeAddress(15+i, 15+i, 6, 7);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Tiền thối:");
            cell.setCellStyle(style_Bold);
            
            range = new CellRangeAddress(15+i, 15+i, 8, 10);
            sheet.addMergedRegion(range);
            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue(format.format(bill.getExcessMoney()));
            cell.setCellStyle(style_Common);
            
            //Border
            CellRangeAddress rangeBig = new CellRangeAddress(0, 16+i, 0, 11);
            RegionUtil.setBorderRight(BorderStyle.THIN, rangeBig, sheet);
            RegionUtil.setBorderLeft(BorderStyle.DOUBLE, rangeBig, sheet);
            RegionUtil.setBorderTop(BorderStyle.DOUBLE, rangeBig, sheet);
            RegionUtil.setBorderBottom(BorderStyle.THIN, rangeBig, sheet);
            
            
            File f = new File("src\\Excel\\Bill_Excel\\"+bill.getBill_ID()+".xlsx");
            FileOutputStream fos = new FileOutputStream(f);
            workBook.write(fos);
            fos.close();
        }
        
        
        
    }
    
    private void Auto_Update_Discount(){
        int day = LocalDateTime.now().getDayOfMonth();
        int month = LocalDateTime.now().getMonthValue();
        int year = LocalDateTime.now().getYear();
        
        String now = day + "-" + month + "-" + year;
        Date date_Now = null;
        try {
            date_Now = new SimpleDateFormat("dd-MM-yyyy").parse(now);
        } catch (ParseException ex) {
            Logger.getLogger(Sale_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ArrayList<Discount_DTO> list_Discount = discount_BUS.get_Discount();
        
        for(Discount_DTO discount : list_Discount){      
            try {
                if( date_Now.compareTo(new SimpleDateFormat("dd-MM-yyyy").parse(discount.getStart_Time())) >= 0 && date_Now.compareTo(new SimpleDateFormat("dd-MM-yyyy").parse(discount.getEnd_Time())) <= 0 && discount.getStatus() == 0 ){
                    discount_BUS.Auto_Update_Discount(discount.getDiscount_Id(),1);
                }
            } catch (ParseException ex) {
                Logger.getLogger(Sale_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                if( date_Now.compareTo(new SimpleDateFormat("dd-MM-yyyy").parse(discount.getStart_Time())) < 0 && discount.getStatus() == 1 || date_Now.compareTo(new SimpleDateFormat("dd-MM-yyyy").parse(discount.getEnd_Time())) > 0 && discount.getStatus() == 1 ){
                    discount_BUS.Auto_Update_Discount(discount.getDiscount_Id(),0);
                }
            } catch (ParseException ex) {
                Logger.getLogger(Sale_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

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
