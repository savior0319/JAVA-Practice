package me.ahj.lottery;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Lotto extends JFrame implements ActionListener {

	private Container ct = getContentPane();
	private String colNames[] = { "횟수", "번호1", "번호2", "번호3", "번호4", "번호5", "번호6", "보너스 번호" };
	private DefaultTableModel model = new DefaultTableModel(colNames, 0);
	private JScrollPane jsp;
	private JTable table;
	private JButton jbt = new JButton("번호생성 <5개씩>");
	private int count, start = 0;

	public Lotto() {
		setTitle("--로또 번호 추첨--");
		setSize(600, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		table = new JTable(model);
		jsp = new JScrollPane(table);
		jbt.setFont(new Font("맑은고딕", Font.BOLD, 20));

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
