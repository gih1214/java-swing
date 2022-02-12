package site.metacoding.practice;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

	private static final String TAG = "Player : ";

	// 컴포지션
	private BackgroundMap backgroundMap;

	private ImageIcon playerR, playerL;
	private int x, y;

	private static final int SPEED = 4;
	private static final int JUMPSPEED = 2;

	private boolean isLeft, isRight, isUp, isDown;

	private boolean leftWallCrush, rightWallCrush;

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public boolean isUp() {
		return isUp;
	}

	public void setUp(boolean isUp) {
		this.isUp = isUp;
	}

	public boolean isDown() {
		return isDown;
	}

	public void setDown(boolean isDown) {
		this.isDown = isDown;
	}

	public boolean isLeftWallCrush() {
		return leftWallCrush;
	}

	public void setLeftWallCrush(boolean leftWallCrush) {
		this.leftWallCrush = leftWallCrush;
	}

	public boolean isRightWallCrush() {
		return rightWallCrush;
	}

	public void setRightWallCrush(boolean rightWallCrush) {
		this.rightWallCrush = rightWallCrush;
	}

	public Player(BackgroundMap backgroundMap) {
		this.backgroundMap = backgroundMap;
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");

		x = 70;
		y = 535;
		// y = 180;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // JLabel의 위치

		isLeft = false;
		isRight = false;
		isUp = false;
		isDown = false;
	}

	private void 왼쪽벽충돌감지() {
		// System.out.println(TAG + "왼쪽 충돌 계산 중");
		Color leftColor = new Color(backgroundMap.getImage().getRGB(getX() - 10, getY() + 25));

		if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
			System.out.println(TAG + "왼쪽 벽에 충돌했어요!");
			// leftWallCrush 상태 true 변경
			leftWallCrush = true;
			// left 상태 false 변경
			isLeft = false;
		}
	}

	private void 오른쪽벽충돌감지() {
		// System.out.println(TAG + "오른쪽 충돌 계산 중");
		Color rightColor = new Color(backgroundMap.getImage().getRGB(getX() + 50 + 15, getY() + 25));

		if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
			System.out.println(TAG + "오른쪽 벽에 충돌했어요!");
			// leftWallCrush 상태 true 변경
			rightWallCrush = true;
			// left 상태 false 변경
			isRight = false;
		}
	}

	// left(), right(), down()
	private void 바닥충돌감지() {
		// System.out.println(TAG + "바닥충돌 감지 중");
		int bottomColor = backgroundMap.getImage().getRGB(getX() + 10, getY() + 50 + 5) // -1
				+ backgroundMap.getImage().getRGB(getX() + 50 - 10, getY() + 50 + 5); // -1

		if (bottomColor == -2) { // 바닥이 흰색
			System.out.println("바닥이 흰색이에요");
			if (!isUp() && !isDown())
				down();
		} else if (bottomColor != -2) { // 바닥에 장애물이 있다는 것
			System.out.println("바닥에 장애물이 있어요");
			isDown = false; // 연산 낭비?
		}
	}

	@Override
	public void left() {
		System.out.println(TAG + "left()");
		isLeft = true;
		setIcon(playerL);
		rightWallCrush = false;

		new Thread(() -> {
			try {
				while (isLeft) {
					x = x - SPEED;
					setLocation(x, y); // paintComponent()를 자동 호출해준다. 내부적으로 repaint가 된다.
					Thread.sleep(10);

					왼쪽벽충돌감지(); // 왼쪽벽 충돌감지
					바닥충돌감지();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}).start();
	}

	@Override
	public void right() {
		System.out.println(TAG + "right()");
		isRight = true;
		setIcon(playerR);
		leftWallCrush = false;

		new Thread(() -> {
			try {
				while (isRight) {
					x = x + SPEED;
					setLocation(x, y); // paintComponent()를 자동 호출해준다. 내부적으로 repaint가 된다.
					Thread.sleep(10);

					오른쪽벽충돌감지(); // 오른쪽벽 충돌감지
					바닥충돌감지();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}).start();

	} // 이게 종료될 때 paintComponent() -> repaint() 호출됨.

	@Override
	public void up() {
		System.out.println(TAG + "up()");
		isUp = true;

		new Thread(() -> {
			try {
				for (int i = 0; i < 130 / JUMPSPEED; i++) {
					y = y - JUMPSPEED;
					setLocation(x, y);
					Thread.sleep(5);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			isUp = false;
			down();
		}).start();
	}

	@Override
	public void down() {
		System.out.println(TAG + "down()");
		isDown = true;

		new Thread(() -> {
			try {
				while (isDown) {
					y = y + JUMPSPEED;
					setLocation(x, y);
					Thread.sleep(3);
					바닥충돌감지();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			isDown = false;
		}).start();
	}
}
