package site.metacoding.ex13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EventEx01 extends JFrame {

	JPanel myPanel;
	JButton btn1, btn2; // ctrl + shift + o
	JCheckBox checkBox1;
	JLabel labelText, labelImg; // div

	public EventEx01() {
		initSetting();
		initObject();
		initAssign();
		initListener();

		setVisible(true);
	}

	// �⺻����
	private void initSetting() {
		setSize(300, 300);
		setLocationRelativeTo(null); // ������ ȭ�� �߾� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ�� �� main ����
	}

	// new�� �͵�
	private void initObject() {
		myPanel = new JPanel();
		btn1 = new JButton("��ư1");
		btn2 = new JButton("��ư2");
		checkBox1 = new JCheckBox();
		labelText = new JLabel("���̺�1");

		// �� ������Ʈ ��ġ���� ����ΰ� �����Ǿ� �ִ�.
		labelImg = new JLabel(new ImageIcon("image/dog.jpg"));
	}

	// ��ġ
	private void initAssign() {
		add(myPanel); // panel�� �����ϴ� ���
		myPanel.add(btn1);
		myPanel.add(btn2);
		myPanel.add(checkBox1);
		myPanel.add(labelText);
		myPanel.add(labelImg); // �̹��� ������ ������ ã�Ƽ� ����ϸ� ��
	}

	// ������ ����
	private void initListener() {
		checkBox1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println(e.toString());
				System.out.println(e.getStateChange());

				if (e.getStateChange() == 1) {
					System.out.println("üũ�Ǿ����ϴ�.");
				} else {
					System.out.println("üũ ���� �Ǿ����ϴ�.");
				}
			}
		}); // end of checkBox1

		// ������� ���Ѻ���!! �� ��ư��!!
		btn1.addActionListener(new ActionListener() {
			// ��¼���? �� �޼��带 ��������!
			// ��ư�� Ŭ���Ǹ� �����찡 �ش� �޼��带 �ݹ����ش�.
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("��ư1�� Ŭ���Ǿ����ϴ�.");
			}
		}); // end of btn1

		// ������� ���Ѻ���!! �� ��ư��!!
		// ��ư�� Ŭ���Ǹ� �����찡 �ش� �޼��带 �ݹ����ش�.
		btn2.addActionListener((ActionEvent e) -> {
			System.out.println("��ư2�� Ŭ���Ǿ����ϴ�.");
		}); // end of btn2

	} // end of initListener

	public static void main(String[] args) {
		new EventEx01();
	}

}
