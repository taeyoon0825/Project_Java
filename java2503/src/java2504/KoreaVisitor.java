package pub2504.exio;

public class KoreaVisitor {
	private String date;
	private String nation;
	private int visitor;
	private double growth;

	public KoreaVisitor(String date, String nation, int visitor, double growth) {
		this.date = date;
		this.nation = nation;
		this.visitor = visitor;
		this.growth = growth;
	}

	public String getDate() {
		return date;
	}

	public String getNation() {
		return nation;
	}

	public int getVisitor() {
		return visitor;
	}

	public double getGrowth() {
		return growth;
	}

	@Override
	public String toString() {
		return "KoreaVisitor [date=" + date + ", nation=" + nation + ", visitor=" + visitor + ", growth=" + growth
				+ "]";
	}

}
