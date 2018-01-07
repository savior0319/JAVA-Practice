package me.ahj.test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Vend extends JFrame implements ActionListener{

	private JTextArea ja = new JTextArea("�ݾ��� ���� ��, ������� ����");
	private JButton jb1 = new JButton("�ݶ�(1000)");
	private JButton jb2 = new JButton("���̴�(800)");
	private JButton jb3 = new JButton("ȯŸ(700)");
	private JButton jb4 = new JButton("����");
	private JTextField jf1 = new JTextField();
	private JTextField jf2 = new JTextField("�ܵ�");

	private Container ct = getContentPane();
	private JPanel jp1 = new JPanel(); // JTextArea �г�
	private JPanel jp2 = new JPanel(); // JTextField �г�
	private int input = 0; // ���Աݾ�
	private int output = 0; // �ܵ�
	private int price = 0; // �� �ݾ�
	private int coke = 0; // �ݶ� ī��Ʈ
	private int cider = 0; // ���̴� ī��Ʈ
	private int fanta = 0; // ȯŸ ī��Ʈ

	/*���̾ƿ�*/
	public Vend() {
		setTitle("������ ���Ǳ�");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		ct.setLayout(new BorderLayout()); // ��ġ -BorderLayout
		
		jp1.setLayout(new GridLayout(2,2,0,0)); // JTextArea �г�
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp1.add(jb4);
		
		jp2.setLayout(new GridLayout(2,1,0,0)); // JTextField �г�
		jp2.add(jf1); 
		jp2.add(jf2);
		
		ct.add(ja, BorderLayout.NORTH);
		ct.add(jp1, BorderLayout.CENTER);
		ct.add(jp2, BorderLayout.SOUTH);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new Vend().setVisible(true);
	}

	/*�׼�*/
	@Override
	public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource()==jb1) {  // �ݶ� ��ư
			price += 1000;
			coke++;
			} else if(arg0.getSource()==jb2) { // ���̴� ��ư
			price += 800;
			cider++;
		    } else if(arg0.getSource()==jb3) { // ȯŸ ��ư
			price += 700;
			fanta++;
			} else if(arg0.getSource()==jb4) { // ���� ��ư
				input = Integer.parseInt(jf1.getText());
				output = input - price;
			if(output>=0) { // �ܾ� ���� ��
			ja.setText("�ݶ� : " + (coke) + "�� " + " / " + 
				"���̴� : " + (cider) + "�� " + " / " +
				"ȯŸ : " + (fanta) + "�� " + " / " + "�� �ݾ� : " + price);
			jf2.setText("�ܵ� : " + String.valueOf(output));
			} else if(output<0) { // �ܾ� ������ ��
			ja.setText("�ܾ��� �����մϴ�.");
			}
		}
	}
}