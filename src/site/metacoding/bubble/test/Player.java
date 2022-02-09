package site.metacoding.bubble.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author gih12
 *
 *         �÷��̾�� �¿� �̵��� �����ϴ�.
 * 
 *         ������ �����ϴ�.
 * 
 *         ��� �߻� (���߿� ��������)
 */

public class Player extends JLabel {
	// ��ġ
	private int x;
	private int y;
	// �÷��̾� �¿� �̹���
	private ImageIcon playerR, playerL;

	private boolean isRight;
	private boolean isLeft;
	private boolean isJump; // ���� ���� (up, down)

	private static final int SPEED = 4; // �÷��̾��� �¿�ӵ� ����
	private static final int JUMPSPEED = 2; // �÷��̾��� �����ӵ� ����

	// getter and setter
	public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public boolean isJump() {
		return isJump;
	}

	public void setJump(boolean isJump) {
		this.isJump = isJump;
	}

	// ������ Player
	public Player() {
		initObject();
		initSetting();
	}

	// new �ϴ� ��
	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	// ���� ��� ����
	private void initSetting() {
		x = 70;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);

		isRight = false;
		isLeft = false;
		isJump = false;
	}

	// ������ �̵�
	public void right() {
		System.out.println("������ �̵�");
		isRight = true;
		setIcon(playerR);

		new Thread(() -> {
			while (isRight) {
				x = x + SPEED;
				setLocation(x, y); // paintComponent �ϴ� ��
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	// ���� �̵�
	public void left() {
		System.out.println("���� �̵�");
		isLeft = true;
		setIcon(playerL);

		new Thread(() -> {
			while (isLeft) {
				x = x - SPEED;
				setLocation(x, y); // paintComponent �ϴ� ��
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	// ���� (Ű���� ������Ű)
	public void jump() {
		System.out.println("����");
		isJump = true;
		// ����ư for���� ������ �Ѵ�. -> 0~130
		// up�� ���� sleep(5) -> for
		// down�� ���� sleep(3) -> for

		new Thread(() -> {
			// up
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y - JUMPSPEED;
				setLocation(x, y); // paintComponent �ϴ� ��
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// down
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y + JUMPSPEED;
				setLocation(x, y); // paintComponent �ϴ� ��
				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			isJump = false;
		}).start();

	} // end of jump

} // end of JLabel
