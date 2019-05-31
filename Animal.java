package meins;

public enum Animal {
	
	CAT("Miaou"),
	DOG("Wooff"),
	CATTLE("Muuuhhh"),
	HORSE("Whiiieeeahhh"),
	DUCK("Quack"),
	PIG("Oink");
	
	private final String spruch;

	private Animal(String spruch) {
		this.spruch = spruch;
	}

	public String getSpruch() {
		return spruch;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.name());
		sb.append(":");
		sb.append(getSpruch());
		return sb.toString();
	}
	 

}
