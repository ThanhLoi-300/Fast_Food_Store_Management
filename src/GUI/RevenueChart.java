package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartTheme;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
public class RevenueChart extends javax.swing.JPanel {

    private String title = "Doanh thu";
    DefaultCategoryDataset dataset;
    JFreeChart chart;
    ChartPanel chartPanel;

    public RevenueChart(double[] arr) {
        initComponents();
        createChart(arr);
    }

    private void createChart(double[] arr) {
        dataset = createDataset(arr);
        chart = createChart(dataset, title);
        chartPanel = new ChartPanel(chart);
        this.add(chartPanel);
    }

public DefaultCategoryDataset createDataset(double[] arr) {  
  
    String series1 = "Doanh Thu";    

  
    dataset = new DefaultCategoryDataset();  
    dataset.addValue(arr[0], series1, "1");
    for(int i=0;i<12;i++)
        dataset.addValue(arr[i], series1,String.valueOf(i+1)); 
    return dataset;  
  }  

    private JFreeChart createChart(DefaultCategoryDataset dataset, String title) {
        chart = ChartFactory.createLineChart(title,"Tháng","Doanh số", dataset,PlotOrientation.VERTICAL, true, true, false);
        chart.getPlot().setBackgroundPaint(ChartColor.WHITE);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.getRenderer().setSeriesStroke(1, new BasicStroke(5.0f));
        plot.getRenderer().setSeriesStroke(0, new BasicStroke(5.0f));
        plot.setOutlinePaint(null);
        plot.setRangeGridlinePaint(Color.BLACK);
        chart.getTitle().setFont(new java.awt.Font("Times New Roman", 0, 18));
        ChartTheme p = StandardChartTheme.createLegacyTheme();
        StandardChartTheme st = new StandardChartTheme("aa");
        st.setRangeGridlinePaint(Color.BLACK);
        p.apply(chart);
//        chart.setBorderVisible(true);
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
