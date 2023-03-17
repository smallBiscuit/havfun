package com.havfun.adminui.data;

public class Parameter {
	private String name;
	private String value;
	
	public Parameter() {
		
	}
	
	public Parameter(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Parameter [name=" + name + ", value=" + value + "]";
	}
}

