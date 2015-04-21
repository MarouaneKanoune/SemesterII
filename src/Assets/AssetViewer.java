package Assets;
import AccountManager.*;

import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AssetViewer extends JFrame {
	/**
	 * shows playerstats on a GUI
	 */
	private AccountManager accManag;
    private AssetTask task = new AssetTask();
    private JLabel assetInformation;
    
    private class AssetTask extends TimerTask {
        public void run() {
        	accManag.updatePlayers();
            String output = createText();
            assetInformation.setText(output);
            assetInformation.repaint();           
        }
        private String createText() {             	
            StringBuilder sBuilder = new StringBuilder();
            sBuilder.append("<html><body>"+AssetViewer.this.accManag.toString()+"<br>");
            Player[] players = accManag.getPlayers();
            for(int i=0;i<players.length;i++){
            	sBuilder.append(accManag.shareDepositAccountToString(players[i].getName())+"<br>");               
            	}
            sBuilder.append("</body></html>");
            return sBuilder.toString();
        }
    }

    public AssetViewer(AccountManager accManag) {
    	this.accManag = accManag;
        assetInformation = new JLabel("AssetViewer");
        add("Center", assetInformation);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(640,0,640,200);
        setVisible(true);       
    }

    public void process() {
    	this.task.run();
    }
}