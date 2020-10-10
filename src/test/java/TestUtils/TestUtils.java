package TestUtils;

public class TestUtils {

	public static void markAllSlotsOccupied(Integer[] slots) {
		for (int i = 0; i < slots.length; i++) {
			slots[i] = 1;
		}		
	}
}
