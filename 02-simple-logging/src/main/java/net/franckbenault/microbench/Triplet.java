package net.franckbenault.microbench;

class Triplet {
	@Override
	public String toString() {
		return "Triplet [a=" + a + ", b=" + b + ", c=" + c + "]";
	}

	private String a;
	private String b;
	private String c;

	public Triplet(int i) {
		this.a = "a" + i;
		this.b = "b" + i;
		this.c = "c" + i;
	}

	public String getA() {
		return a;
	}

	public String getB() {
		return b;
	}

	public String getC() {
		return c;
	}
}