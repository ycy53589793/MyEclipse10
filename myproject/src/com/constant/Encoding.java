package com.constant;

public enum Encoding {
	
	UTF_8("UTF-8"),GBK("GBK");
	
	private String encoding;
	
	private Encoding(String v) {
		encoding=v;
	}
	
	public String getEncoding() {
		return encoding;
	}

	@Override
	public String toString() {
		return encoding;
	}
	
	
	
}
