package parqueo;

import java.util.Locale;
import parqueo.backend.modelos.parqueo.Parqueo;
import parqueo.gui.frames.EscritorioFrame;

/**
 *
 * @author jose
 */
public class Run {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Locale.setDefault(new Locale("en", "US"));
		Parqueo parqueo = new Parqueo();
		EscritorioFrame escritorio = new EscritorioFrame(parqueo);
		
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(EscritorioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(EscritorioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(EscritorioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(EscritorioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		
		escritorio.setVisible(true);
	}
	
}
