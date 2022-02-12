package site.metacoding.bubble.ex09;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author ����
 * 
 *         �÷��̾�� �¿� �̵��� �����ϴ�. ������ �����ϴ�. ��� �߻� (���߿� ��������)
 */

public class Player extends JLabel {

	private BubbleFrame context; // ��������
	private int x;
	private int y;
	private ImageIcon playerR, playerL;

	private boolean isRight;
	private boolean isLeft;
	private boolean up; // ���� ���� (up, down)
	private boolean down;

	private int direction; // -1�� ���� ����, 1�� ������ ����, 0�� ���� ����

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	private boolean leftWallCrash;
	private boolean rightWallCrash;

	private static final int JUMPSPEED = 2;
	private static final int SPEED = 4;

	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}

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

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public Player(BubbleFrame context) {
		this.context = context; // ��������
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	private void initSetting() {
		x = 90;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);

		isRight = false;
		isLeft = false;
		up = false;
		down = false;

		leftWallCrash = false;
		rightWallCrash = false;

		direction = 0; // ���� ����
	}

	public void attack() {
		// 1. ���� new
		Bubble bubble = new Bubble(context); // �����ڸ� ���� �����ϴ� �͵��� �ѱ� -> ������ ����
		// 2. ȭ�鿡 �پ�� �� ? JFrame�� add �ؾ� �Ǵµ� ���⼭ ��� ? context
		context.add(bubble);
		// 3. �����̵� (�÷��̾� ����) -> ���� ���°� ���� ����
		if (direction == 0) {
			// bubble.left();
		} else if (direction == 1) {
			// bubble.right();
		}
	}

	public void left() {
		direction = -1; // ���⿡ ���� ����
		isLeft = true;
		setIcon(playerL);
		System.out.println("���� �̵�");

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

	public void right() {
		direction = 1; // ���⿡ ���� ����
		isRight = true;
		setIcon(playerR);
		System.out.println("������ �̵�");

		new Thread(() -> {
			while (isRight) {
				x = x + SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void up() {
		System.out.println("��");
		up = true;
		// ������ for���� ������ �Ѵ�. -> 0~130
		// up �� ���� sleep(5) -> for
		// down �� ���� sleep(3) -> for

		new Thread(() -> {
			// up
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y - JUMPSPEED;
				setLocation(x, y);

				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			up = false; // ���ο� �����尡 ���¸� �����ؾ� �Ѵ�.
			down(); // ���ϰ� �ٿ��Ű���� �޼��� ȣ��
		}).start(); // end of Thread

	} // end of up

	public void down() {
		System.out.println("�ٿ�");
		down = true;
		// ������ for���� ������ �Ѵ�. -> 0~130
		// up �� ���� sleep(5) -> for
		// down �� ���� sleep(3) -> for

		new Thread(() -> {
			// down
			while (down) {
				y = y + JUMPSPEED;
				setLocation(x, y);

				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			down = false;
		}).start(); // end of Thread
	} // end of down

}
