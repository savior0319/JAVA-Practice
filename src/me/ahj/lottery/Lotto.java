package me.ahj.lottery;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Lotto extends JFrame implements ActionListener {

	private Container ct = getContentPane();
	private String colNames[] = { "Ƚ��", "��ȣ1", "��ȣ2", "��ȣ3", "��ȣ4", "��ȣ5", "��ȣ6", "���ʽ� ��ȣ" };
	private DefaultTableModel model = new DefaultTableModel(colNames, 0);
	private JScrollPane jsp;
	private JTable table;
	private JButton jbt = new JButton("��ȣ���� <5����>");
	private int count, start = 0;

	public Lotto() {
		setTitle("--�ζ� ��ȣ ��÷--");
		setSize(600, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		table = new JTable(model);
		jsp = new JScrollPane(table);
		jbt.setFont(new Font("�������", Font.BOLD, 20));

		ct.setLayout(new BorderLayout());
		ct.add(jsp, BorderLayout.CENTER);
		ct.add(jbt, BorderLayout.SOUTH);

		jbt.addActionListener(this);
	}

	public static void main(String args[]) {
		new Lotto().setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == jbt) {

			while (start < 5) {
				Random ran = new Random();
				int[] rannum = new int[7];

				for (int i = 0; i < rannum.length; i++) {
					rannum[i] = ran.nextInt(45) + 1;
					for (int j = 0; j < i; j++) {
						if (rannum[i] == rannum[j]) {
							i = i - 1;
							break;
						}
					}
				}
				start++;
				count++;
				String ranstr[] = new String[7];
				for (int i = 0; i < ranstr.length; i++) {
					ranstr[i] = String.valueOf(rannum[i]);
				}
				model.addRow(new Object[] { count, ranstr[0], ranstr[1], ranstr[2], ranstr[3], ranstr[4], ranstr[5],
						ranstr[6] });
			}
			start = 0;
		}
	}
}
