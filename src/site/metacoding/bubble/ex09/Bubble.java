package site.metacoding.bubble.ex09;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

// 맵, 적군1, 적군2, 플레이어1, 플레이어2 = context로 넘기기
public class Bubble extends JLabel {

	private BubbleFrame context; // 컴퍼지션
	private Player player; // 컴퍼지션

	private int x; // 방울의 좌표
	private int y;

	private ImageIcon bubble, bomb; // 방울, 터짐 이미지 필요

	public Bubble(BubbleFrame context) {
		this.context = context;
		this.player = context.getPlayer();
		initObject();
		initSetting();

		// 방향체크
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
		System.out.println("왼쪽 방향 발사");

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
		System.out.println("오른쪽 방향 발사");

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
