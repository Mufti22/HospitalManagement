package Helper;

public class Item {
	private int key;
	private String value;

	public int getKey() {
		return key;
	}

	public Item(int key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override

	public String toString() {

		return this.value;
	}

}
