/*
 * Christian Taborda
 * 1632081-3743
 */

package adivinaColor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Gui extends JFrame {
	
	//Atributos:
	
	private Font fuente;	
	private JLabel titulo, color1, color2;
	private JButton aRojo, dRojo, aVerde, dVerde, aAzul, dAzul;
	private JPanel botones, colores;
	
	//M�todos:
	
	//Retorna un color aleatorio.
	
	public Color colorear(){
		
		Random rojo = new Random();
		Random verde = new Random();
		Random azul = new Random();
		
		int[] valores = {0,15,30,45,60,75,90,105,120,135,150,165,180,195,210,225,240,255};
		
		int R = valores[rojo.nextInt(18)];
		int V = valores[verde.nextInt(18)];
		int A = valores[azul.nextInt(18)];
		
		Color salida = new Color(R,V,A);
				
		return salida;
		
	}
	
	//Constructor.
	
	public Gui(){
		
		super("Juego");
		
		Dimension size = new Dimension(70,70);
		
		fuente = new Font("Arial", Font.BOLD, 31);
		
		Container contenedor = getContentPane();
		contenedor.setLayout(new BorderLayout());
		
		titulo = new JLabel();
		titulo.setOpaque(true);
		titulo.setForeground(Color.WHITE);
		titulo.setBackground(Color.BLACK);
		titulo.setFont(fuente);
		titulo.setText("Adivina el Color");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setVerticalAlignment(SwingConstants.CENTER);	
		
		contenedor.add(BorderLayout.NORTH, titulo);
		
		Escucha escucha = new Escucha();
				
		aRojo = new JButton("+");
		aRojo.setOpaque(true);
		aRojo.setFont(fuente);
		aRojo.setForeground(Color.BLACK);
		aRojo.setBackground(Color.RED);
		aRojo.setPreferredSize(size);
		aRojo.addActionListener(escucha);
		
		dRojo = new JButton("-");
		dRojo.setOpaque(true);
		dRojo.setFont(fuente);
		dRojo.setForeground(Color.BLACK);
		dRojo.setBackground(Color.RED);
		dRojo.setPreferredSize(size);
		dRojo.addActionListener(escucha);
		
		aVerde = new JButton("+");
		aVerde.setOpaque(true);
		aVerde.setFont(fuente);
		aVerde.setForeground(Color.BLACK);
		aVerde.setBackground(Color.GREEN);
		aVerde.setPreferredSize(size);
		aVerde.addActionListener(escucha);
		
		dVerde = new JButton("-");
		dVerde.setOpaque(true);
		dVerde.setFont(fuente);
		dVerde.setForeground(Color.BLACK);
		dVerde.setBackground(Color.GREEN);
		dVerde.setPreferredSize(size);
		dVerde.addActionListener(escucha);
		
		aAzul = new JButton("+");
		aAzul.setOpaque(true);
		aAzul.setFont(fuente);
		aAzul.setForeground(Color.BLACK);
		aAzul.setBackground(Color.BLUE);
		aAzul.setPreferredSize(size);
		aAzul.addActionListener(escucha);
		
		dAzul = new JButton("-");
		dAzul.setOpaque(true);
		dAzul.setFont(fuente);
		dAzul.setForeground(Color.BLACK);
		dAzul.setBackground(Color.BLUE);
		dAzul.setPreferredSize(size);
		dAzul.addActionListener(escucha);
		
		botones = new JPanel();
		botones.setLayout(new FlowLayout());
		botones.setOpaque(true);
		botones.setBackground(Color.BLACK);
		
		botones.add(aRojo);
		botones.add(dRojo);
		botones.add(aVerde);
		botones.add(dVerde);
		botones.add(aAzul);
		botones.add(dAzul);
		
		contenedor.add(BorderLayout.SOUTH, botones);
		
		color1 = new JLabel();
		color1.setOpaque(true);
		color1.setBackground(colorear());
		color1.setPreferredSize(size);
		//color1.setText("       ");
		color1.setFont(fuente);
		
		color2 = new JLabel();
		color2.setOpaque(true);
		color2.setBackground(Color.BLACK);
		color2.setPreferredSize(size);
		//color2.setText("       ");
		color2.setFont(fuente);
		
		colores = new JPanel();
		colores.setLayout(new FlowLayout());
		colores.setOpaque(true);
		colores.setBackground(Color.WHITE);
		
		colores.add(color1);
		colores.add(color2);
		
		contenedor.add(BorderLayout.CENTER, colores);
		
		setSize(500, 230); 
		setResizable(false);
		setVisible(true);	
		setLocationRelativeTo(null);
	}
	
	public void oprimir(JButton boton){
		
		ImageIcon icono;
		
		int R = color2.getBackground().getRed();
		int V = color2.getBackground().getGreen();
		int A = color2.getBackground().getBlue();
		
		if(boton.equals(aRojo)){
			if(R < 255){
				R += 15;
			}
			else{
				icono = new ImageIcon("src/imagenes/error.png");
				JOptionPane.showMessageDialog(null, "No se puede aumentar m�s el rojo.", "Alerta", JOptionPane.DEFAULT_OPTION, icono);
			}
		}
		if(boton.equals(aVerde)){
			if(V < 255){
				V += 15;
			}
			else{
				icono = new ImageIcon("src/imagenes/error.png");
				JOptionPane.showMessageDialog(null, "No se puede aumentar m�s el verde.", "Alerta", JOptionPane.DEFAULT_OPTION, icono);
			}
		}
		if(boton.equals(aAzul)){
			if(A < 255){
				A += 15;
			}
			else{
				icono = new ImageIcon("src/imagenes/error.png");
				JOptionPane.showMessageDialog(null, "No se puede aumentar m�s el azul.", "Alerta", JOptionPane.DEFAULT_OPTION, icono);
			}
		}
		if(boton.equals(dRojo)){
			if(R > 0){
				R -= 15;
			}
			else{
				icono = new ImageIcon("src/imagenes/error.png");
				JOptionPane.showMessageDialog(null, "No se puede disminuir m�s el rojo.", "Alerta", JOptionPane.DEFAULT_OPTION, icono);
			}
		}
		if(boton.equals(dVerde)){
			if(V > 0){
				V -= 15;
			}
			else{
				icono = new ImageIcon("src/imagenes/error.png");
				JOptionPane.showMessageDialog(null, "No se puede disminuir m�s el verde.", "Alerta", JOptionPane.DEFAULT_OPTION, icono);
			}
		}
		if(boton.equals(dAzul)){
			if(A > 0){
				A -= 15;
			}
			else{
				icono = new ImageIcon("src/imagenes/error.png");
				JOptionPane.showMessageDialog(null, "No se puede disminuir m�s el azul.", "Alerta", JOptionPane.DEFAULT_OPTION, icono);
			}
		}
		
		Color pintar = new Color(R,V,A);
		color2.setBackground(pintar);
		if(color1.getBackground().equals(color2.getBackground())){
			icono = new ImageIcon("src/imagenes/bien.png");
			JOptionPane.showMessageDialog(null, "Has adivinado el color.", "Fin", JOptionPane.DEFAULT_OPTION, icono);
			icono = new ImageIcon("src/imagenes/triste.png");
			int decision = JOptionPane.showConfirmDialog(null, "�Quieres jugar otra vez?", "Reinicio", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, icono);
			if(decision == 0){
				color1.setBackground(colorear());
				color2.setBackground(Color.BLACK);
			}
			else{
				System.exit(-1);
			}
		}
	}
	
	private class Escucha implements ActionListener{
		
		public void actionPerformed(ActionEvent evento){
			if(evento.getSource() == aRojo){
				oprimir(aRojo);
			}
			if(evento.getSource() == dRojo){
				oprimir(dRojo);
			}
			if(evento.getSource() == aVerde){
				oprimir(aVerde);
			}
			if(evento.getSource() == dVerde){
				oprimir(dVerde);
			}
			if(evento.getSource() == aAzul){
				oprimir(aAzul);
			}
			if(evento.getSource() == dAzul){
				oprimir(dAzul);
			}
		}
	}
}
