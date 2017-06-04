package vistas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JToggleButton;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

import models.Container;
import models.Trayecto;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Suplemento {

	private JFrame frame2;
	private JToggleButton btnaeropuerto;
	private JToggleButton btnnoche;
	private JToggleButton btnsimple;
	private Trayecto aux;
	private JFrame frameaux;
	private JLabel dineroaux;
	private JButton btnprecio;
	private JLabel lblprecio;
	private JLabel lbldinerocliente;
	private JTextField txtdinerocliente;
	private JLabel lblcuelta = new JLabel("");
	private JButton btnvuelta;
	private JLabel lbldevolucion;

	public Suplemento(Trayecto x, JFrame frame, JLabel lblprecio2) {

		frame2 = new JFrame();
		btnaeropuerto = new JToggleButton("Aeropuerto");
		btnnoche = new JToggleButton("++Nocturna");
		btnnoche.setForeground(Color.GREEN);
		btnnoche.setBackground(Color.BLACK);
		btnsimple = new JToggleButton("Simple");
		this.aux = x;
		this.frameaux = frame;
		this.dineroaux = lblprecio2;
		btnprecio = new JButton("Calcular Precio");
		txtdinerocliente = new JTextField();
		lbldinerocliente = new JLabel("Introduzca el dinero");
		lblprecio = new JLabel("");
		btnvuelta = new JButton("Devolucion");
		lbldevolucion = new JLabel("");

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		propiedades();
		eventos();

	}

	public JFrame getFrame2() {
		return frame2;
	}

	private void propiedades() {

		frame2.setBounds(100, 100, 450, 300);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);

		btnaeropuerto.setBounds(65, 74, 127, 98);
		frame2.getContentPane().add(btnaeropuerto);

		btnnoche.setBounds(160, 25, 127, 46);
		btnnoche.setVisible(false);
		
		frame2.getContentPane().add(btnnoche);

		btnsimple.setBounds(258, 74, 127, 98);
		frame2.getContentPane().add(btnsimple);

		btnprecio.setBounds(0, 204, 117, 68);
		btnprecio.setVisible(false);
		frame2.getContentPane().add(btnprecio);

		lblprecio.setBounds(116, 229, 76, 16);
		frame2.getContentPane().add(lblprecio);

		lbldinerocliente.setBounds(247, 187, 138, 16);
		frame2.getContentPane().add(lbldinerocliente);
		lbldinerocliente.setVisible(false);

		txtdinerocliente.setBounds(242, 204, 143, 26);
		frame2.getContentPane().add(txtdinerocliente);
		txtdinerocliente.setVisible(false);
		txtdinerocliente.setColumns(10);

		lblcuelta.setBounds(274, 242, 138, 16);
		frame2.getContentPane().add(lblcuelta);

		

		btnvuelta.setBounds(273, 242, 96, 29);
		btnvuelta.setVisible(false);
		frame2.getContentPane().add(btnvuelta);

		
		lbldevolucion.setBounds(355, 242, 89, 30);
		frame2.getContentPane().add(lbldevolucion);

	}

	private void eventos() {

		btnsimple.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				

				btnaeropuerto.setEnabled(false);
				
				btnprecio.setVisible(true);
				
				if(new LocalTime().getHourOfDay()<21){

				if (new DateTime().getDayOfWeek() == 6 || new DateTime().getDayOfWeek() == 7) {

					aux.setPago(Float.parseFloat(dineroaux.getText()) + 4.55f);
					Container.getTrayectos().Add(aux);

				}

				else {

					aux.setPago(Float.parseFloat(dineroaux.getText()) + 3.65f);
					Container.getTrayectos().Add(aux);
				}
			}else
			{
				
				
				btnaeropuerto.setEnabled(false);
				btnnoche.setVisible(true);
				btnnoche.setEnabled(false);
				btnprecio.setVisible(true);

				if (new DateTime().getDayOfWeek() == 6 || new DateTime().getDayOfWeek() == 7) {

					aux.setPago(Float.parseFloat(dineroaux.getText()) + 4.55f+2);
					Container.getTrayectos().Add(aux);

				}

				else {

					aux.setPago(Float.parseFloat(dineroaux.getText()) + 3.65f+2);
					Container.getTrayectos().Add(aux);
				}
				
			}
				
				
				
			}
		});
		
		btnaeropuerto.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				btnsimple.setSelected(false);
				btnsimple.setEnabled(false);
				btnprecio.setVisible(true);
				
				if(new LocalTime().getHourOfDay()<9)
				{
					

					if (new DateTime().getDayOfWeek() == 6 || new DateTime().getDayOfWeek() == 7) {

						aux.setPago(Float.parseFloat(dineroaux.getText()) + 4.55f+5);
						Container.getTrayectos().Add(aux);

					}

					else {

						aux.setPago(Float.parseFloat(dineroaux.getText()) + 3.65f+5);
						Container.getTrayectos().Add(aux);
					}
					
				}
				else {


					
					
					
					btnnoche.setVisible(true);
					btnnoche.setEnabled(false);
					

					if (new DateTime().getDayOfWeek() == 6 || new DateTime().getDayOfWeek() == 7) {

						aux.setPago(Float.parseFloat(dineroaux.getText()) + 4.55f+2+5);
						Container.getTrayectos().Add(aux);

					}

					else {

						aux.setPago(Float.parseFloat(dineroaux.getText()) + 3.65f+2+5);
						Container.getTrayectos().Add(aux);
					}
				
				
			}
			}
		});

		btnprecio.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				btnsimple.setEnabled(false);
				btnnoche.setEnabled(false);
				btnaeropuerto.setEnabled(false);
				lbldinerocliente.setVisible(true);
				txtdinerocliente.setVisible(true);
				btnvuelta.setVisible(true);

				lblprecio.setText(String.valueOf(aux.getPago())+"$");

			}
		});
		
		btnvuelta.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				float dinero = 0;
				boolean escorrecto=true;
				try{
					 dinero=Float.parseFloat(txtdinerocliente.getText());
				}catch(Exception ee)
				{
					
					JOptionPane.showMessageDialog(frame2, "Debe introducir un importe");
					escorrecto=false;
				}
				
				if(txtdinerocliente.getText().isEmpty())
				{
					
					JOptionPane.showMessageDialog(frame2, "Debe introducir un importe");
					escorrecto=false;
				}
				if(dinero<aux.getPago())
				{
					JOptionPane.showMessageDialog(frame2, "Dinero Insuficiente");
					escorrecto=false;
				}
				
				if(escorrecto)
				{
					
					JOptionPane.showMessageDialog(frame2,"Su vuelta es de "+ String.valueOf(dinero-aux.getPago())+" $ \n Muchas Gracias por utilizar Cabify");
					frameaux.setVisible(true);
					
					frame2.dispose();
				}
			}
		});

	}
}
