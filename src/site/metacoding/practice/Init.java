package site.metacoding.practice;

/**
 * 
 * @author ������
 * 
 *         ������ ���� ���� ~~~
 * 
 *         initObject 1�� ����
 * 
 *         initObject 2�� ����
 * 
 *         initListener 3�� ���� (default)
 */

public interface Init {
	void initObject();

	void initSetting();

	// �ʼ� �ƴ�.
	default void initListener() {
	};
}
