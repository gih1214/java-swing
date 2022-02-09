package site.metacoding.bubble.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author gih12
 *
 *         플레이어는 좌우 이동이 가능하다.
 * 
 *         점프가 가능하다.
 * 
 *         방울 발사 (나중에 생각하자)
 */

public class Player extends JLabel {
	// 위치
	private int x;
	private int y;
	// 플레이어 좌우 이미지
	private ImageIcon playerR, playerL;

	private boolean isRight;
	private boolean isLeft;
	private boolean isJump; // 점프 상태 (up, down)

	private static final int SPEED = 4; // 플레이어의 좌우속도 고정
	private static final int JUMPSPEED = 2; // 플레이어의 점프속도 고정

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

	// 생성자 Player
	public Player() {
		initObject();
		initSetting();
	}

	// new 하는 것
	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	// 각종 모든 세팅
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

	// 오른쪽 이동
	public void right() {
		System.out.println("오른쪽 이동");
		isRight = true;
		setIcon(playerR);

		new Thread(() -> {
			while (isRight) {
				x = x + SPEED;
				setLocation(x, y); // paintComponent 하는 중
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	// 왼쪽 이동
	public void left() {
		System.out.println("왼쪽 이동");
		isLeft = true;
		setIcon(playerL);

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

	// 점프 (키보드 윗방향키)
	public void jump() {
		System.out.println("점프");
		isJump = true;
		// 점프튼 for문을 돌려야 한다. -> 0~130
		// up일 때는 sleep(5) -> for
		// down일 때는 sleep(3) -> for

		new Thread(() -> {
			// up
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y - JUMPSPEED;
				setLocation(x, y); // paintComponent 하는 중
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// down
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y + JUMPSPEED;
				setLocation(x, y); // paintComponent 하는 중
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
