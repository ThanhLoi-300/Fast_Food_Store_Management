package GUI;

import BUS.Customer_BUS;
import BUS.Product_BUS;
import DTO.statisticalObject;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class PieChart extends javax.swing.JPanel {

    private String title = "My chart";
    DefaultPieDataset dataset;
    JFreeChart chart;
    ChartPanel chartPanel;
    private Product_BUS pBUS = new Product_BUS();
    private Customer_BUS cBUS = new Customer_BUS();

    public PieChart(ArrayList<statisticalObject> soL,String type) {
        initComponents();
        createChart(soL,type);
    }

    private void createChart(ArrayList<statisticalObject> soL,String type) {
        dataset = createDataset(soL,type);
        chart = createChart(dataset, title);
        chartPanel = new ChartPanel(chart);
        this.add(chartPanel);
    }

    private DefaultPieDataset createDataset(ArrayList<statisticalObject> soL,String type) {
        DefaultPieDataset result = new DefaultPieDataset();
        if(!soL.isEmpty()){
            if(type.equalsIgnoreCase("customer"))
                for (statisticalObject soL1 : soL) 
                result.setValue(cBUS.GetNameById(soL1.getId()), soL1.getValue());
            else
                for (statisticalObject soL1 : soL) 
                result.setValue(pBUS.getNameById(soL1.getId())+"["+soL1.getDescription()+"]", soL1.getValue());
        }
        return result;
    }

    private JFreeChart createChart(PieDataset dataset, String title) {
        chart = ChartFactory.createPieChart(title, dataset, false, true, false);
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelLinksVisible(false);
        plot.setLabelGenerator(null);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);
//        plot.setBaseSectionOutlinePaint(Color.black);
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.8f);
        return chart;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        chart.getTitle().setText(title);
    }

    public void setValues(String name, int values) {
        dataset.setValue(name, values);
    }

    public void setValues(String name, double values) {
        dataset.setValue(name, values);
    }

    public void setBackgroundImage(Icon image) {
        ImageIcon icon = (ImageIcon) image;
        chart.setBackgroundImage(icon.getImage());
    }

    public void setBackgroundColor(Color color) {
        chart.setBackgroundPaint(color);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
