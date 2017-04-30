package parqueo;

import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import parqueo.backend.datos.ManejadorDatosParqueo;
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
		try {
			//usamos el nuevo objeto para cargar los datos desde el archivo
			ManejadorDatosParqueo manejadorDatosParqueo = new ManejadorDatosParqueo();
			Locale.setDefault(new Locale("en", "US"));
			Parqueo parqueo = manejadorDatosParqueo.cargarParqueo();
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
		} catch (IOException ex) {
			Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
}
