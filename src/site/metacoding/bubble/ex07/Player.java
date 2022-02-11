package site.metacoding.bubble.ex07;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author 아현
 * 
 *         플레이어는 좌우 이동이 가능하다. 점프가 가능하다. 방울 발사 (나중에 생각하자)
 */

public class Player extends JLabel {
	private int x;
	private int y;
	private ImageIcon playerR, playerL;

	private boolean isRight;
	private boolean isLeft;
	private boolean up; // 점프 상태 (up, down)
	private boolean down;

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

	public Player() {
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
	}

	public void left() {
		isLeft = true;
		setIcon(playerL);
		System.out.println("왼쪽 이동");

		new Thread(() -> {
			while (isLeft) {
				x = x - SPEED;
				setLocation(x, y); // paintComponent 하는 중
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

	public void right() {
		isRight = true;
		setIcon(playerR);
		System.out.println("오른쪽 이동");

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

	// 키보드 윗방향키
	public void up() {
		System.out.println("업");
		up = true;
		// 점프는 for문을 돌려야 한다. -> 0~130
		// up 일 때는 sleep(5) -> for
		// down 일 때는 sleep(3) -> for

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

			up = false; // 새로운 스레드가 상태를 변경해야 한다.
			down(); // 업하고 다운시키려고 메서드 호출
		}).start(); // end of Thread

	} // end of up

	public void down() {
		System.out.println("다운");
		down = true;
		// 점프는 for문을 돌려야 한다. -> 0~130
		// up 일 때는 sleep(5) -> for
		// down 일 때는 sleep(3) -> for

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
