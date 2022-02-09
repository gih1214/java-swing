package site.metacoding.bubble.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author gih12
 *
 *         ���� : ���� !!
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap; // ���ȭ��
	private Player player; // ĳ����

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true); // ���ο� paintComponent() ȣ�� �ڵ尡 �ִ�.
	}

	// new �ϴ� ��
	private void initObject() {
		backgroundMap = new JLabel();
		backgroundMap.setIcon(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap); // ��׶��� ȭ�� ����

		player = new Player();
		add(player);
	}

	// ���� ��� ����
	private void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // JFrame�� �⺻ JPanel�� ���̾ƿ� ����
		setLocationRelativeTo(null); // ��� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ�� �� JVM ���� �����ϱ�
	}

	// �̺�Ʈ ó��
	private void initListener() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("Ű���� ������");

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					// isRight�� false
					player.setRight(false);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					// isLeft�� false
					player.setLeft(false);
				}
			}

			// ���̽�ƽ
			@Override
			public void keyPressed(KeyEvent e) {
				// ���� 37, ������ 39, ���� 38, �Ʒ��� 40
				// System.out.println("Ű���� ������ :" + e.getKeyCode());

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					// Ű���带 ������ �ִ� ���� right() �޼��带 �� ���� �����ϰ� �ʹ�.
					if (player.isRight() == false) {
						player.right();
					} // end of right
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (player.isLeft() == false) {
						player.left();
					} // end of left
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (player.isJump() == false) {
						// System.out.println("ī��Ʈ : " + count);
						// count++;
						player.jump(); // �޼��� ���ο��� if �б� ó���� �̺�Ʈ ������ ����� �Ǵµ� ������ �� �Ǵ� ��.
					}
				} // end of jump
			} // end of keyPressed
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
