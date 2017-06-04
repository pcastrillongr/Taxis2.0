package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

import org.joda.time.LocalTime;

import models.Tiempo;
import models.Trayecto;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;

public class Principal {

	private JFrame frame;
	JButton btniniciotrayecto = new JButton("INICIO TRAYECTO");
	JButton btncajadeldia = new JButton("CAJA DEL DIA");
	JButton btnfinalizartrayecto = new JButton("FINALIZAR TRAYECTO");
	JLabel lbltiempo = new JLabel("Tiempo:");
	JLabel lbltiempo2 = new JLabel("");
	JLabel lblprecio = new JLabel("Precio:");
	JLabel lblprecio2 = new JLabel("");
	private Trayecto x;
	private Tiempo t;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		propiedades();
		eventos();
		
	}
	
	private void propiedades()
	{
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		btniniciotrayecto.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 10));
		btniniciotrayecto.setBounds(41, 57, 127, 168);
		frame.getContentPane().add(btniniciotrayecto);
		

		btncajadeldia.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 10));
		btncajadeldia.setBounds(293, 57, 127, 169);
		frame.getContentPane().add(btncajadeldia);
		
	
		btnfinalizartrayecto.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 10));
		btnfinalizartrayecto.setBounds(139, 57, 165, 168);
		btnfinalizartrayecto.setVisible(false);
		frame.getContentPane().add(btnfinalizartrayecto);
		lbltiempo.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 11));
		

		lbltiempo.setBounds(107, 244, 61, 16);
		frame.getContentPane().add(lbltiempo);
		lbltiempo.setVisible(false);
		
		
		lbltiempo2.setBounds(179, 244, 69, 16);
		frame.getContentPane().add(lbltiempo2);
		lblprecio.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 11));
		
		
		
		
		lblprecio.setBounds(296, 244, 61, 16);
		frame.getContentPane().add(lblprecio);
		lblprecio.setVisible(false);
		
		
	
		lblprecio2.setBounds(369, 244, 61, 16);
		
		frame.getContentPane().add(lblprecio2);
		
		
		
	}
	private void eventos()
	{
		
		btniniciotrayecto.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				btniniciotrayecto.setVisible(false);
				btncajadeldia.setVisible(false);
				btnfinalizartrayecto.setVisible(true);
				lbltiempo.setVisible(true);
				lbltiempo2.setVisible(true);
				lblprecio.setVisible(true);
				lblprecio2.setVisible(true);
				
				x=new Trayecto();
				x.setIniciotrayecto(new LocalTime());
				
				t=new Tiempo();
				t.Contar(lbltiempo2,lblprecio2);
				
				
			}
		});
		
		btnfinalizartrayecto.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				x.setFinaltrayecto(new LocalTime());
				t.Detener();
				Suplemento window=new Suplemento(x,frame,lblprecio2);
				window.getFrame2().setVisible(true);
				btnfinalizartrayecto.setVisible(false);
				btniniciotrayecto.setVisible(true);
				btncajadeldia.setVisible(true);
				lbltiempo.setVisible(false);
				lbltiempo2.setVisible(false);
				lblprecio.setVisible(false);
				lblprecio2.setVisible(false);
				frame.dispose();
			}
		});
		
		btncajadeldia.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				CajaDelDia window=new CajaDelDia(frame);
				window.getFrame3().setVisible(true);
				frame.dispose();
			}
		});
		
		
		
		
		
	}

}
