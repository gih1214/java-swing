package site.metacoding.ex13;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GridLayoutEx01 extends MyFrame {

	public GridLayoutEx01() {
		// super(500, 300); �� ������� ������ �� �ǳ�..

		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(new GridLayout(0, 4)); // 3���� ���� ������, ���� �߰��Ǵ� ������Ʈ�� ���� ������

		JButton btn1 = new JButton("Button1");
		JButton btn2 = new JButton("Button2");
		JButton btn3 = new JButton("Button3");
		JButton btn4 = new JButton("B4");
		JButton btn5 = new JButton("Long Button5");

		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);

		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new GridLayoutEx01();
	}

}
