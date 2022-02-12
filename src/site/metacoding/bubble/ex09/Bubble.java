package site.metacoding.bubble.ex09;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

// ��, ����1, ����2, �÷��̾�1, �÷��̾�2 = context�� �ѱ��
public class Bubble extends JLabel {

	private BubbleFrame context; // ��������
	private Player player; // ��������

	private int x; // ����� ��ǥ
	private int y;

	private ImageIcon bubble, bomb; // ���, ���� �̹��� �ʿ�

	public Bubble(BubbleFrame context) {
		this.context = context;
		this.player = context.getPlayer();
		initObject();
		initSetting();

		// ����üũ
		if (player.getDirection() == 1) {
			right();
		} else if (player.getDirection() == -1) {
			left();
		}
	}

	private void initObject() {
		bubble = new ImageIcon("image/bubble.png");
		bomb = new ImageIcon("image/bomb.png");
	}

	private void initSetting() {
		x = player.getX();
		y = player.getY();
		setIcon(bubble);
		setSize(50, 50);
		setLocation(x, y);
	}

	private void left() {
		System.out.println("���� ���� �߻�");

		new Thread(() -> {
			try {
				for (int i = 0; i <= 400; i++) {
					x--;
					setLocation(x, y);
					Thread.sleep(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
	}

	private void right() {
		System.out.println("������ ���� �߻�");

		new Thread(() -> {
			try {
				for (int i = 0; i <= 400; i++) {
					x++;
					setLocation(x, y);
					Thread.sleep(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
	}
}
