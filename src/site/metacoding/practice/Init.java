package site.metacoding.practice;

/**
 * 
 * @author 구아현
 * 
 *         생성자 실행 순서 ~~~
 * 
 *         initObject 1번 실행
 * 
 *         initObject 2번 실행
 * 
 *         initListener 3번 실행 (default)
 */

public interface Init {
	void initObject();

	void initSetting();

	// 필수 아님.
	default void initListener() {
	};
}
