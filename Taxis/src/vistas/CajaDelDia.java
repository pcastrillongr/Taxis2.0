package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import models.Container;
import models.Trayecto;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.ListIterator;

public class CajaDelDia {

	private JFrame frame3;
	
	

	private JLabel lblcajadeldia;
	private JLabel lblcajadeldia2;
	private JButton btnvolver;
	private JFrame frameaux;
	private JButton btnprev;
	private JLabel lblinicio;
	private JLabel lblinicio2;
	private JLabel lblfinal;
	private JLabel lblfinal2;
	private JLabel lblPago;
	private JLabel lblpago2;
	private ListIterator<Trayecto>it;
	private JButton btnnext;
	
	
	

	public CajaDelDia(JFrame frame) {
		frame3 = new JFrame();
		lblcajadeldia = new JLabel("Caja Del Dia");
		lblcajadeldia2 = new JLabel("");
		btnvolver = new JButton("Volver");
		btnvolver.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 13));
		this.frameaux=frame;
		btnprev = new JButton("Prev");
		
	
		lblinicio = new JLabel("Inicio Trayecto:");
		lblinicio2 = new JLabel("");
		lblfinal = new JLabel("Final Trayecto:");
		lblfinal2 = new JLabel("");
		lblPago = new JLabel("Pago:");
		lblpago2 = new JLabel("");
		btnnext = new JButton("Next");
		

		initialize();
	}

	private void initialize() {
		propiedades();
		eventos();
	}

	public void propiedades()

	{
		frame3 = new JFrame();
		frame3.setBounds(100, 100, 450, 300);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(null);

		lblcajadeldia.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 14));
		lblcajadeldia.setBounds(21, 190, 131, 16);
		frame3.getContentPane().add(lblcajadeldia);

		lblcajadeldia2.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 14));
		lblcajadeldia2.setBounds(176, 190, 137, 16);
		frame3.getContentPane().add(lblcajadeldia2);
		
	
	
		btnvolver.setBounds(327, 226, 117, 46);
		frame3.getContentPane().add(btnvolver);
		
		
		btnprev.setBounds(293, 6, 68, 29);
		frame3.getContentPane().add(btnprev);
		
	
		lblinicio.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 12));
		lblinicio.setBounds(21, 50, 110, 16);
		frame3.getContentPane().add(lblinicio);
		
	
		lblinicio2.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		
		lblinicio2.setBounds(143, 50, 123, 16);
		frame3.getContentPane().add(lblinicio2);
		
		
		lblfinal.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		lblfinal.setBounds(21, 89, 110, 16);
		frame3.getContentPane().add(lblfinal);
		
		
		lblfinal2.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 13));
		
		lblfinal2.setBounds(143, 89, 123, 16);
		frame3.getContentPane().add(lblfinal2);
		
	
		lblPago.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 13));
		lblPago.setBounds(21, 128, 61, 16);
		frame3.getContentPane().add(lblPago);
		
		
		lblpago2.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 13));
		
		lblpago2.setBounds(143, 128, 123, 16);
		frame3.getContentPane().add(lblpago2);
		
	
	
		btnnext.setBounds(360, 6, 68, 29);
		frame3.getContentPane().add(btnnext);

	}

	public void eventos() {
		
		float cajatotal = 0;
		
		
		
	
			
		for(Trayecto x:Container.getTrayectos())
		{
			lblcajadeldia2.setText(String.valueOf(cajatotal+=x.getPago())+"$");
			System.out.println(x.toString());
		}
		
		if(Container.getTrayectos().size()>=1)
		{
			
			
			lblinicio2.setText(String.valueOf(Container.getTrayectos().get(0).getIniciotrayecto()));
			lblfinal2.setText(String.valueOf(Container.getTrayectos().get(0).getFinaltrayecto()));
			lblpago2.setText(String.valueOf(Container.getTrayectos().get(0).getPago()));
			}
			else{
				lblinicio2.setText("");
				lblfinal2.setText("");
				lblpago2.setText("");
			}

		
		
		btnprev.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				it=Container.getTrayectos().listIterator();
				
				if(it.hasPrevious())
				{
					Trayecto z=it.previous();
					
					lblinicio2.setText(String.valueOf(z.getIniciotrayecto()));
					lblfinal2.setText(String.valueOf(z.getFinaltrayecto()));
					lblpago2.setText(String.valueOf(z.getPago()));
					
					
				}
				else{
					JOptionPane.showMessageDialog(frame3, "No hemos hecho mas viajes");
				}
			}
		});
		
		btnnext.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				it=Container.getTrayectos().listIterator();
				System.out.println("TRIVOGAMARICON");
				if(it.hasNext())
				{
					Trayecto z=it.next();
					
					lblinicio2.setText(String.valueOf(z.getIniciotrayecto()));
					lblfinal2.setText(String.valueOf(z.getFinaltrayecto()));
					lblpago2.setText(String.valueOf(z.getPago()));
					
					
				}
				else{
					JOptionPane.showMessageDialog(frame3, "No hemos hecho mas viajes");
				}
			}
		});
		
		
		btnvolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				frameaux.setVisible(true);
				frame3.dispose();
			}
		});
	
	}
	public JFrame getFrame3() {
		return frame3;
	}
}



