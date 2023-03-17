package com.havfun.appsservice.data;

import java.util.List;

public class ProductAttribute {

	private String attributeKey;
	
	private String nameEn;
	
	private String nameHk;
	
	private String nameCn;
	
	private List<ProductAttributeOption> optionList;

	public String getAttributeKey() {
		return attributeKey;
	}

	public void setAttributeKey(String attributeKey) {
		this.attributeKey = attributeKey;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameHk() {
		return nameHk;
	}

	public void setNameHk(String nameHk) {
		this.nameHk = nameHk;
	}

	public String getNameCn() {
		return nameCn;
	}

	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}

	public List<ProductAttributeOption> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<ProductAttributeOption> optionList) {
		this.optionList = optionList;
	}

	@Override
	public String toString() {
		return "ProductAttribute [attributeKey=" + attributeKey + ", nameEn=" + nameEn + ", nameHk=" + nameHk
				+ ", nameCn=" + nameCn + ", optionList=" + optionList + "]";
	}
	
	
	
}
