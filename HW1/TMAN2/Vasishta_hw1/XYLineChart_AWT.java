import java.awt.Color; 
import java.awt.BasicStroke; 

import java.io.*;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ChartUtilities; 

public class XYLineChart_AWT extends ApplicationFrame {
      TMAN tman = new TMAN();
      int q = 5;
      int w = 1;
      String fileName;
      JFreeChart xylineChart;
   public XYLineChart_AWT( String applicationTitle, String chartTitle ) {
      super(applicationTitle);
      xylineChart = ChartFactory.createXYLineChart(
         chartTitle ,
         "Category" ,
         "Score" ,
         createDataset() ,
         PlotOrientation.VERTICAL ,
         true , true , false);
         
      ChartPanel chartPanel = new ChartPanel( xylineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      final XYPlot plot = xylineChart.getXYPlot( );
      
      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
      renderer.setSeriesPaint( 0 , Color.RED );
//      renderer.setSeriesPaint( 1 , Color.GREEN );
//      renderer.setSeriesPaint( 2 , Color.YELLOW );
      renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
//      renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
//      renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
      plot.setRenderer( renderer ); 
      setContentPane( chartPanel );
   }
   
   private XYDataset createDataset( ) {
      final XYSeries firefox = new XYSeries( "Nodes interconnect", false, true );
      final XYSeries chrome = new XYSeries( "Nodes interconnect", false, true );
      int ne;
      for(int i =1; i<=tman.N; i++){
         for(int j =0; j<tman.k; j++){
            ne = tman.nodes[i].neighbors[j];
/*            if(i == tman.N){
               if(ne == tman.nodes[N-1].node_id){
                  firefox.add(  tman.nodes[i].x_co , tman.nodes[i].y_co);          
                  firefox.add( tman.nodes[ne].x_co , tman.nodes[ne].y_co);
                  if (j==1)
                  break;                         
               }

            } else if(tman.nodes[ne].node_id == tman.N || tman.nodes[i].node_id == tman.N){

            } else {
            firefox.add( tman.nodes[i].x_co , tman.nodes[i].y_co);          
            firefox.add( tman.nodes[ne].x_co , tman.nodes[ne].y_co);                         
            }

*/
            if(i==tman.N && tman.topology == 'B'){
               System.out.println("done");
//               System.exit(0);
               if (j==0){
               chrome.add( tman.nodes[i].x_co , tman.nodes[i].y_co);          
               chrome.add( tman.nodes[ne].x_co , tman.nodes[ne].y_co);                                        
               } else if(j==1){
               chrome.add( tman.nodes[i].x_co , tman.nodes[i].y_co);          
               chrome.add( tman.nodes[ne].x_co , tman.nodes[ne].y_co);                                        
               break;
               }
            } else {
               firefox.add( tman.nodes[i].x_co , tman.nodes[i].y_co);          
               firefox.add( tman.nodes[ne].x_co , tman.nodes[ne].y_co);                                        
            }


         }
      }

/*      
      final XYSeries chrome = new XYSeries( "Chrome", false, true );          
      chrome.add( 1.0 , 4.0 );          
      chrome.add( 2.0 , 5.0 );          
      chrome.add( 1.0 , 4.0 );          
      chrome.add( 2.5 , 7.0 );          
      chrome.add( 1.0 , 4.0 );          
      chrome.add( 3.0 , 5.0 );          
      chrome.add( 1.0 , 4.0 );          
      chrome.add( 4.5 , 2.0 );          
      chrome.add( 1.0 , 4.0 );          
      chrome.add( 2.5 , 4.4 );          
      chrome.add( 1.0 , 4.0 );          
      chrome.add( 3.5 , 7.0 );          
      chrome.add( 1.0 , 4.0 );          
/*      
      final XYSeries iexplorer = new XYSeries( "InternetExplorer" );          
      iexplorer.add( 3.0 , 4.0 );          
      iexplorer.add( 4.0 , 5.0 );          
      iexplorer.add( 5.0 , 4.0 );          
*/      
      final XYSeriesCollection dataset = new XYSeriesCollection( );          
      dataset.addSeries( firefox );          
      dataset.addSeries( chrome );          
//      dataset.addSeries( iexplorer );
      return dataset;
   }
/*
   public static void main( String[ ] args ) {
      XYLineChart_AWT chart = new XYLineChart_AWT("Browser Usage Statistics",
         "Which Browser are you using?");
      chart.pack( );          
      RefineryUtilities.centerFrameOnScreen( chart );          
      chart.setVisible( true ); 
   }
*/
}