package site.metacoding.bubble.ex06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author 아현
 *
 *         목적 : 색상 테스트
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap; // 배경화면
	private Player player; // 캐릭터

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		initService();
		setVisible(true); // 내부에 paintComponent() 호출 코드가 있다.

		// 테스트
		// new BackgroundMapService(player);
	}

	private void initService() {
		new Thread(new BackgroundMapService(player)).start();
	}

	// new 하는 것
	private void initObject() {
		backgroundMap = new JLabel();
		backgroundMap.setIcon(new ImageIcon("image/test.png"));
		setContentPane(backgroundMap); // 백그라운드 화면 설정

		player = new Player();
		add(player);
	}

	// 각종 모든 세팅
	private void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // JFrame의 기본 JPanel의 레이아웃 설정
		setLocationRelativeTo(null); // 가운데 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭 시 JVM 같이 종료하기
	}

	// 이벤트 처리
	private void initListener() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("키보드 릴리즈");

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					// isRight를 false
					player.setRight(false);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					// isLeft를 false
					player.setLeft(false);
				}
			}

			// 조이스틱
			@Override
			public void keyPressed(KeyEvent e) {
				// 왼쪽 37, 오른쪽 39, 위쪽 38, 아래쪽 40
				// System.out.println("키보드 프레스 :" + e.getKeyCode());

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					// 키보드를 누르고 있는 동안 right() 메서드를 한 번만 실행하고 싶다.
					if (player.isRight() == false) {
						player.right();
					} // end of right
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (player.isLeft() == false) {
						player.left();
					} // end of left
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (player.isJump() == false) {
						// System.out.println("카운트 : " + count);
						// count++;
						player.jump(); // 메서드 내부에서 if 분기 처리는 이벤트 루프에 등록은 되는데 실행은 안 되는 것.
					}
				} // end of jump
			} // end of keyPressed
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
