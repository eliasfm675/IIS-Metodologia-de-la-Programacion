package uo.mp.util.check;

public class StateChecks {

	public static void isTrue(boolean condition) {
		if (condition == true) return;
		throwException( "Condition not met" );
	}

	public static void isTrue(boolean condition, String msg) {
		if (condition == true) return;
		throwException(msg);
	}

	private static void throwException(String msg) {
		throw new IllegalStateException( msg );
	}

}
