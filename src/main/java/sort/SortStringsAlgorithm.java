package sort;

/**
 * 
 * @author alexey
 *
 */
public interface SortStringsAlgorithm {
	public static class Radix {
		final int base;

		public Radix(int base) {
			super();
			this.base = base;
		}

		public int getBase() {
			return base;
		}
	}
	public static final Radix NORADIX = new Radix(0);
	public static final Radix ASCII_RADIX = new Radix(256);
	public static final Radix UTF8_RADIX = new Radix(65536);
	
	void sort(String[] strings, Radix radix);
}
