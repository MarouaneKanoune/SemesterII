package Stockmarket;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StockPriceViewer extends JFrame {
	/**
	 * shows stocks on a GUI
	 */
	private StockPriceInfo stockPriceInfo;
    private JLabel stockMarketInformation;
    private TickerTask task;
    
    private class TickerTask extends TimerTask {
        public void run() {
            String output = createText();
            stockMarketInformation.setText(output);
            stockMarketInformation.repaint();           
        }

        private String createText() {             	
            String output = "<html><body>Shares: "; 
            output +=  StockPriceViewer.this.stockPriceInfo.sharesToString();
            output += "</body></html>";
            return output;
        }
    }

    public StockPriceViewer(StockPriceInfo stockPriceProvider) {
    	this.stockPriceInfo = stockPriceProvider;
    	this.task = new TickerTask();
    	stockMarketInformation = new JLabel("StockPriceViewer");
        add("Center", stockMarketInformation);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640, 200);
        setVisible(true);
        this.task.run();
    } 

    public void process() {
    	this.task.run();
    }
}