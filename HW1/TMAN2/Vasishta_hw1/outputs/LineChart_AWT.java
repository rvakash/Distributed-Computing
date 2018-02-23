import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart_AWT extends ApplicationFrame {

   public LineChart_AWT( String applicationTitle , String chartTitle ) {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Cycles","Sum of Distances",
         createDataset(),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
   }

   private DefaultCategoryDataset createDataset( ) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      TMAN tman = new TMAN();
      for(int i =0; i<40; i++){
         dataset.addValue( tman.dis[i] , "distance" , String.valueOf(i) );         
      }
/*      dataset.addValue( tman.dis[0] , "distance" , "1980" );
      dataset.addValue( tman.dis[0] , "distance" ,  "1990" );
      dataset.addValue( tman.dis[0] , "distance" , "2000" );
      dataset.addValue( tman.dis[0] , "schools" , "2010" );
      dataset.addValue( tman.dis[0] , "schools" , "2014" );
*/
      return dataset;
   }
/*   
   public static void main( String[ ] args ) {
      LineChart_AWT chart = new LineChart_AWT(
         "School Vs Years" ,
         "Numer of Schools vs years");

      chart.pack( );
      RefineryUtilities.centerFrameOnScreen( chart );
      chart.setVisible( true );
   }

*/
}
