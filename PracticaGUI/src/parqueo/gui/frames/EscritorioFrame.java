package parqueo.gui.frames;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import parqueo.backend.modelos.parqueo.Parqueo;
import parqueo.backend.modelos.registros.RegistroVehiculo;
import parqueo.backend.parqueo.ManejadorParqueo;
import parqueo.backend.personas.clientes.ManejadorClientes;
import parqueo.backend.personas.empleados.ManejadorEmpleados;
import parqueo.backend.reportes.Reporteador;
import parqueo.gui.frames.clientes.ListadoClientesInternalFrame;
import parqueo.gui.frames.registros.ListadoRegistrosInternalFrame;
import parqueo.gui.frames.registros.RegistroIngresoDialog;
import parqueo.gui.frames.registros.RegistroSalidaDialog;
import parqueo.gui.frames.reportes.Reporte2InternalFrame;

/**
 *
 * @author jose
 */
public class EscritorioFrame extends javax.swing.JFrame {

	private ManejadorParqueo manejadorParqueo;
	private ManejadorClientes manejadorClientes;
	private ManejadorEmpleados manejadorEmpleados;
	private ListadoClientesInternalFrame listadoClientesFrame;
	private RegistroIngresoDialog registroIngresoDialog;
	private ListadoRegistrosInternalFrame listadoRegistrosFrame;
	private RegistroSalidaDialog registroSalidaDialog;
	private Reporte2InternalFrame reporte2Frame;
	private Reporteador reporteador;

	/**
	 * Creates new form EscritorioFrame
	 *
	 * @param parqueo
	 */
	public EscritorioFrame(Parqueo parqueo) {
		this.manejadorParqueo = new ManejadorParqueo(parqueo);
		this.manejadorClientes = new ManejadorClientes(parqueo);
		this.manejadorEmpleados = new ManejadorEmpleados(parqueo);
		this.reporteador = new Reporteador(parqueo);
		//frames
		listadoClientesFrame = new ListadoClientesInternalFrame(manejadorClientes);
		listadoRegistrosFrame = new ListadoRegistrosInternalFrame(manejadorParqueo);
		//dialogos
		registroIngresoDialog = new RegistroIngresoDialog(this, manejadorParqueo, manejadorClientes);
		registroSalidaDialog = new RegistroSalidaDialog(this, manejadorParqueo);
		//reportes
		reporte2Frame = new Reporte2InternalFrame(reporteador);
		initComponents();
		this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
		this.escritorioPanel.add(listadoClientesFrame);
		this.escritorioPanel.add(listadoRegistrosFrame);
		this.escritorioPanel.add(reporte2Frame);
		cambiarValorMedidor(Parqueo.VEHICULO_MOTO);
		cambiarValorMedidor(Parqueo.VEHICULO_CARRO);
		cambiarValorMedidor(Parqueo.VEHICULO_CAMION);
		setIcon();
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING:
	 * Do NOT modify this code. The content of this method is always regenerated by the
	 * Form Editor.
	 */
	@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          infoPanel = new javax.swing.JPanel();
          estadoLabel = new javax.swing.JLabel();
          espaciosMotosLabel = new javax.swing.JLabel();
          espaciosMotosProgressbar = new javax.swing.JProgressBar();
          espaciosCarrosLAbel = new javax.swing.JLabel();
          espaciosCarrosProgressbar = new javax.swing.JProgressBar();
          espaciosCamionesLabel = new javax.swing.JLabel();
          espaciosCamionesProgressbar = new javax.swing.JProgressBar();
          espaciosMotosInfoLabel = new javax.swing.JLabel();
          espaciosCarrosInfoLabel = new javax.swing.JLabel();
          espaciosCamionesInfoLabel = new javax.swing.JLabel();
          registrarIngresoButton = new javax.swing.JButton();
          registrarSalidaButton = new javax.swing.JButton();
          escritorioPanel = new javax.swing.JDesktopPane();
          jMenuBar1 = new javax.swing.JMenuBar();
          archivoMenu = new javax.swing.JMenu();
          salirMenuItem = new javax.swing.JMenuItem();
          clientesMenu = new javax.swing.JMenu();
          buscarClientesMenuitem = new javax.swing.JMenuItem();
          empleadosMenu = new javax.swing.JMenu();
          registrosMenu = new javax.swing.JMenu();
          VerListadoMenuItem = new javax.swing.JMenuItem();
          reportesMenu = new javax.swing.JMenu();
          reporte2MenuItem = new javax.swing.JMenuItem();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setTitle("Parqueo");

          infoPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

          estadoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
          estadoLabel.setText("Espacios usados en parqueo");

          espaciosMotosLabel.setText("Motos:");

          espaciosMotosProgressbar.setMaximum(Parqueo.CAPACIDAD_MOTOS);

          espaciosCarrosLAbel.setText("Carros:");

          espaciosCarrosProgressbar.setMaximum(Parqueo.CAPACIDAD_CARROS);

          espaciosCamionesLabel.setText("Camiones:");

          espaciosCamionesProgressbar.setMaximum(Parqueo.CAPACIDAD_CAMIONES);

          espaciosMotosInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          espaciosMotosInfoLabel.setText("0 / 0");

          espaciosCarrosInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          espaciosCarrosInfoLabel.setText("0 / 0");

          espaciosCamionesInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          espaciosCamionesInfoLabel.setText("0 / 0");

          registrarIngresoButton.setText("Ingreso");
          registrarIngresoButton.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    registrarIngresoButtonActionPerformed(evt);
               }
          });

          registrarSalidaButton.setText("Salida");
          registrarSalidaButton.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    registrarSalidaButtonActionPerformed(evt);
               }
          });

          javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
          infoPanel.setLayout(infoPanelLayout);
          infoPanelLayout.setHorizontalGroup(
               infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(infoPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(estadoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                         .addComponent(espaciosMotosProgressbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(espaciosCarrosProgressbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(espaciosMotosInfoLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(espaciosCarrosInfoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(espaciosCamionesProgressbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(espaciosCamionesInfoLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addGroup(infoPanelLayout.createSequentialGroup()
                              .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(espaciosMotosLabel)
                                   .addComponent(espaciosCamionesLabel)
                                   .addComponent(espaciosCarrosLAbel))
                              .addGap(0, 0, Short.MAX_VALUE))
                         .addGroup(infoPanelLayout.createSequentialGroup()
                              .addComponent(registrarIngresoButton)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addComponent(registrarSalidaButton)))
                    .addContainerGap())
          );
          infoPanelLayout.setVerticalGroup(
               infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(infoPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(estadoLabel)
                    .addGap(18, 18, 18)
                    .addComponent(espaciosMotosLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(espaciosMotosProgressbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(espaciosMotosInfoLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(espaciosCarrosLAbel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(espaciosCarrosProgressbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(espaciosCarrosInfoLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(espaciosCamionesLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(espaciosCamionesProgressbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(espaciosCamionesInfoLabel)
                    .addGap(69, 69, 69)
                    .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(registrarIngresoButton)
                         .addComponent(registrarSalidaButton))
                    .addContainerGap(142, Short.MAX_VALUE))
          );

          javax.swing.GroupLayout escritorioPanelLayout = new javax.swing.GroupLayout(escritorioPanel);
          escritorioPanel.setLayout(escritorioPanelLayout);
          escritorioPanelLayout.setHorizontalGroup(
               escritorioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 627, Short.MAX_VALUE)
          );
          escritorioPanelLayout.setVerticalGroup(
               escritorioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 0, Short.MAX_VALUE)
          );

          archivoMenu.setText("Archivo");

          salirMenuItem.setText("Salir");
          salirMenuItem.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    salirMenuItemActionPerformed(evt);
               }
          });
          archivoMenu.add(salirMenuItem);

          jMenuBar1.add(archivoMenu);

          clientesMenu.setText("Clientes");

          buscarClientesMenuitem.setText("Buscar clientes");
          buscarClientesMenuitem.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buscarClientesMenuitemActionPerformed(evt);
               }
          });
          clientesMenu.add(buscarClientesMenuitem);

          jMenuBar1.add(clientesMenu);

          empleadosMenu.setText("Empleados");
          jMenuBar1.add(empleadosMenu);

          registrosMenu.setText("Registros");

          VerListadoMenuItem.setText("Ver listado");
          VerListadoMenuItem.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    VerListadoMenuItemActionPerformed(evt);
               }
          });
          registrosMenu.add(VerListadoMenuItem);

          jMenuBar1.add(registrosMenu);

          reportesMenu.setText("Reportes");

          reporte2MenuItem.setText("Ver reporte2");
          reporte2MenuItem.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    reporte2MenuItemActionPerformed(evt);
               }
          });
          reportesMenu.add(reporte2MenuItem);

          jMenuBar1.add(reportesMenu);

          setJMenuBar(jMenuBar1);

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(escritorioPanel)
                    .addContainerGap())
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                         .addComponent(escritorioPanel)
                         .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void buscarClientesMenuitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarClientesMenuitemActionPerformed
		this.listadoClientesFrame.setVisible(true);
     }//GEN-LAST:event_buscarClientesMenuitemActionPerformed

     private void registrarIngresoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarIngresoButtonActionPerformed
		registroIngresoDialog.mostrarDialogo();
		RegistroVehiculo registro = registroIngresoDialog.getRegistro();
		if (registro != null) {
			cambiarValorMedidor(registro.getTipoVehiculo());
			JOptionPane.showMessageDialog(this, "Vehiculo ingresado correctamente", "Info", JOptionPane.INFORMATION_MESSAGE);
		}
     }//GEN-LAST:event_registrarIngresoButtonActionPerformed

     private void VerListadoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerListadoMenuItemActionPerformed
		this.listadoRegistrosFrame.setVisible(true);
     }//GEN-LAST:event_VerListadoMenuItemActionPerformed

     private void registrarSalidaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarSalidaButtonActionPerformed
		this.registroSalidaDialog.mostrarDialogo();
		RegistroVehiculo registro = registroSalidaDialog.getRegistro();
		if (registro != null) {
			cambiarValorMedidor(registro.getTipoVehiculo());
			JOptionPane.showMessageDialog(this, "Vehiculo retirado correctamente", "Info", JOptionPane.INFORMATION_MESSAGE);
		}
     }//GEN-LAST:event_registrarSalidaButtonActionPerformed

     private void salirMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirMenuItemActionPerformed
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
     }//GEN-LAST:event_salirMenuItemActionPerformed

     private void reporte2MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporte2MenuItemActionPerformed
		this.reporte2Frame.setVisible(true);
     }//GEN-LAST:event_reporte2MenuItemActionPerformed

	/**
	 * Cambia el valor de los medidores de acuerdo al estado del parqueo
	 *
	 * @param tipoVehiculo
	 */
	private void cambiarValorMedidor(int tipoVehiculo) {
		int espaciosUsados = manejadorParqueo.obtenerEspaciosUsados(tipoVehiculo);
		switch (tipoVehiculo) {
			case Parqueo.VEHICULO_MOTO:
				this.espaciosMotosProgressbar.setValue(espaciosUsados);
				espaciosMotosInfoLabel.setText(espaciosUsados + " / "
					   + Parqueo.CAPACIDAD_MOTOS);
				break;
			case Parqueo.VEHICULO_CARRO:
				this.espaciosCarrosProgressbar.setValue(espaciosUsados);
				espaciosCarrosInfoLabel.setText(espaciosUsados + " / "
					   + Parqueo.CAPACIDAD_CARROS);
				break;
			case Parqueo.VEHICULO_CAMION:
				this.espaciosCamionesProgressbar.setValue(espaciosUsados);
				espaciosCamionesInfoLabel.setText(espaciosUsados + " / "
					   + Parqueo.CAPACIDAD_CAMIONES);
				break;
			default:
				break;
		}
	}

	private void setIcon() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/parqueo/gui/imagenes/icon.png")));
	}

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JMenuItem VerListadoMenuItem;
     private javax.swing.JMenu archivoMenu;
     private javax.swing.JMenuItem buscarClientesMenuitem;
     private javax.swing.JMenu clientesMenu;
     private javax.swing.JMenu empleadosMenu;
     private javax.swing.JDesktopPane escritorioPanel;
     private javax.swing.JLabel espaciosCamionesInfoLabel;
     private javax.swing.JLabel espaciosCamionesLabel;
     private javax.swing.JProgressBar espaciosCamionesProgressbar;
     private javax.swing.JLabel espaciosCarrosInfoLabel;
     private javax.swing.JLabel espaciosCarrosLAbel;
     private javax.swing.JProgressBar espaciosCarrosProgressbar;
     private javax.swing.JLabel espaciosMotosInfoLabel;
     private javax.swing.JLabel espaciosMotosLabel;
     private javax.swing.JProgressBar espaciosMotosProgressbar;
     private javax.swing.JLabel estadoLabel;
     private javax.swing.JPanel infoPanel;
     private javax.swing.JMenuBar jMenuBar1;
     private javax.swing.JButton registrarIngresoButton;
     private javax.swing.JButton registrarSalidaButton;
     private javax.swing.JMenu registrosMenu;
     private javax.swing.JMenuItem reporte2MenuItem;
     private javax.swing.JMenu reportesMenu;
     private javax.swing.JMenuItem salirMenuItem;
     // End of variables declaration//GEN-END:variables
}