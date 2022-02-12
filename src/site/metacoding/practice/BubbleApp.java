package site.metacoding.practice;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class BubbleApp extends JFrame implements Init {

	private static final String TAG = "BubbleApp : ";
	private BubbleApp mContext = this;

	private BackgroundMap backgroundMap; // 배경화면
	private Player player; // 플레이어

	public BubbleApp() {
		// System.out.println(TAG+"생성자 실행");
		initObject();
		initSetting();
		initListener();

		setVisible(true);
	}

	public static void main(String[] args) {
		new BubbleApp();
	}

	@Override
	public void initObject() {
		backgroundMap = new BackgroundMap();
		setContentPane(backgroundMap); // DIV박스를 전체 배경화면으로 설정
		player = new Player(backgroundMap); // 맵을 알아야 백그라운드 색깔을 알 수 있으니까
		add(player);
	}

	@Override
	public void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // JFrame의 기본 JPanel의 레이아웃 설정
		setLocationRelativeTo(null); // 가운데 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 JVM 같이 종료하기
	}

	@Override
	public void initListener() {
		mContext.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) { // switch 값!! == case 값
				case KeyEvent.VK_RIGHT:
					if (player.isRight() == false && player.isRightWallCrush() == false) {
						player.right(); // 내부
					}
					break; // switch 종료
				case KeyEvent.VK_LEFT:
					if (!player.isLeft() && !player.isLeftWallCrush())
						player.left(); // 내부
					break;
				case KeyEvent.VK_UP:
					player.up(); // 내부
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
				}
			}

		});
	}
}