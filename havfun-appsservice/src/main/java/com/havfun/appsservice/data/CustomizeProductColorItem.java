package com.havfun.appsservice.data;

import java.util.List;

public class CustomizeProductColorItem {

	private int colorId;
	
	private int baseId;
	
	private String layerName;
	
	private List<CustomizeProductColorItemLayer> lowerLayer;
	
	private List<CustomizeProductColorItemLayer> topLayer;

	public int getColorId() {
		return colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	public int getBaseId() {
		return baseId;
	}

	public void setBaseId(int baseId) {
		this.baseId = baseId;
	}

	public String getLayerName() {
		return layerName;
	}

	public void setLayerName(String layerName) {
		this.layerName = layerName;
	}

	public List<CustomizeProductColorItemLayer> getLowerLayer() {
		return lowerLayer;
	}

	public void setLowerLayer(List<CustomizeProductColorItemLayer> lowerLayer) {
		this.lowerLayer = lowerLayer;
	}

	public List<CustomizeProductColorItemLayer> getTopLayer() {
		return topLayer;
	}

	public void setTopLayer(List<CustomizeProductColorItemLayer> topLayer) {
		this.topLayer = topLayer;
	}

	@Override
	public String toString() {
		return "CustomizeProductColorItem [colorId=" + colorId + ", baseId=" + baseId + ", layerName=" + layerName
				+ ", lowerLayer=" + lowerLayer + ", topLayer=" + topLayer + "]";
	}


	
}
