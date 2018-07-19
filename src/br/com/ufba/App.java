package br.com.ufba;

import java.awt.EventQueue;

import javax.swing.JFrame;

import br.com.ufba.atendimento.AtendimentoContext;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.Dimension;

public class App {

	private JFrame frame;
	private final AtendimentoContext atendimento;
	private JButton btnSenhaNormal;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
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
	public App() {
		initialize();
		this.atendimento = new AtendimentoContext();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnSenhaNormal = new JButton("Normal");
		btnSenhaNormal.setForeground(Color.WHITE);
		btnSenhaNormal.setBackground(new Color(0, 51, 255));
		
		btnSenhaNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atendimento.gerarSenhaNormal();
			}
		});
		
		JButton btnSenhaPreferencial = new JButton("Preferencial");
		btnSenhaPreferencial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atendimento.gerarSenhaPreferencial();
			}
		});
		
		table = new JTable();
		table.setSize(new Dimension(100, 100));
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		frame.getContentPane().add(table);
		frame.getContentPane().add(btnSenhaNormal);
		frame.getContentPane().add(btnSenhaPreferencial);
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atendimento.atender();
			}
		});
		frame.getContentPane().add(btnNewButton);
	}
}
