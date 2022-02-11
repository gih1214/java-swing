package site.metacoding.bubble.ex06;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

// ��׶��� ���� (�������� ������� ������ �Ѵ�.)
public class BackgroundMapService implements Runnable {

	// ��������
	private Player player;
	private BufferedImage image;

	// ���������� ���� ��� => ������ ����(�����ڸ� ���ؼ� ����) = DI (Dependency Injection)
	public BackgroundMapService(Player player) {
		this.player = player;
		try {
			// raw �ϰ� �д´ٴ� �� : ���� �״�� �д� ��
			image = ImageIO.read(new File("image/test.png"));
			// System.out.println(image);
			// System.out.println(image.getRGB(10, 10));
			// System.out.println("�÷��̾� ��ġ : " + player.getX());
			// System.out.println("�÷��̾� ��ġ : " + player.getY());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// ���� ��� (while)
		while (true) {
			Color color = new Color(image.getRGB(player.getX() + 50, player.getY()));
			System.out.println(color.getRed());
			System.out.println(color.getGreen());
			System.out.println(color.getBlue());
			System.out.println("====================");
			try {
				Thread.sleep(10); // �浹������ �̼��ϰ� �ϴ� ������
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
