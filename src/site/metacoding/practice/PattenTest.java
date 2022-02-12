package site.metacoding.practice;

interface Knife {
	void attack();

	void cook();
}

abstract class ¿ä¸®»ç¾î´ğÅÍ implements Knife {
	@Override
	public void attack() {
	}
}

abstract class ½Î¿ò²Û¾î´ğÅÍ implements Knife {
	@Override
	public void cook() {
	}
}

class ¹éÁ¾¿ø extends ¿ä¸®»ç¾î´ğÅÍ {

	@Override
	public void cook() {

	}
}

class °ËÅõ»ç extends ½Î¿ò²Û¾î´ğÅÍ {

	@Override
	public void attack() {

	}
}

public class PattenTest {

}
