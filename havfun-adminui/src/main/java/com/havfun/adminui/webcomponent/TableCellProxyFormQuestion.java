package com.havfun.adminui.webcomponent;

import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class TableCellProxyFormQuestion {
	

	public static String renderHtml( String key, String valueEn, String valueHk, String valueCn, String origValueEn, String origValueHk, String origValueCn, int webComponentMode, ResourceBundle resourceBundle ){
		
		return renderHtml( -1, key, valueEn, valueHk, valueCn, origValueEn, origValueHk, origValueCn, webComponentMode, resourceBundle );
		
	}
	
	public static String renderHtml( int rowIndex, String key, String valueEn, String valueHk, String valueCn, String origValueEn, String origValueHk, String origValueCn, int webComponentMode, ResourceBundle resourceBundle ){
		
		String valueEnString = WebComponentHelper.objectToString(valueEn);
		String origValueEnString = WebComponentHelper.objectToString(origValueEn);
		String valueHkString = WebComponentHelper.objectToString(valueHk);
		String origValueHkString = WebComponentHelper.objectToString(origValueHk);
		String valueCnString = WebComponentHelper.objectToString(valueCn);
		String origValueCnString = WebComponentHelper.objectToString(origValueCn);

		String keyEn = key + "_en";
		String keyHk = key + "_hk";
		String keyCn = key + "_cn";

		String nameEn = "";
		String nameHk = "";
		String nameCn = "";
		
		if ( rowIndex >= 0 ){
			
			nameEn = keyEn + "_" + rowIndex;
			nameHk = keyHk + "_" + rowIndex;
			nameCn = keyCn + "_" + rowIndex;
			
		}
		
		
		String contentHtml = "";
		
		switch(webComponentMode){
			
			case WebComponent.MODE_EDITABLE:

				contentHtml += "<div class=\"left\" style=\"width:100%;\">";
				contentHtml += "<div class=\"btn_add_sub_row left\" style=\"margin-right:10px;\" data-add-row-html-source=\"proxy_form_question_table_sub_row_template\"><a>" + getDisplay(resourceBundle, "datatable_add_row") + "</a></div>";
				contentHtml += "<div class=\"btn_delete_sub_row left\" ><a>" + getDisplay(resourceBundle, "datatable_delete_row") + "</a></div>";
				contentHtml += "</div>";
				
				contentHtml += "<div><div>" + getDisplay(resourceBundle, "datatable_en") + ": </div><textarea class=\"web_component_input\" data-key=\"" + keyEn + "\" id=\"" + nameEn + "\" name=\"" + nameEn + "\" style=\"width:95%\" >" + valueEnString + "</textarea></div>";
				contentHtml += "<div><div>" + getDisplay(resourceBundle, "datatable_hk") + ": </div><textarea class=\"web_component_input\" data-key=\"" + keyHk + "\" id=\"" + nameHk + "\" name=\"" + nameHk + "\" style=\"width:95%\" >" + valueHkString + "</textarea></div>";
				contentHtml += "<div><div>" + getDisplay(resourceBundle, "datatable_cn") + ": </div><textarea class=\"web_component_input\" data-key=\"" + keyCn + "\" id=\"" + nameCn + "\" name=\"" + nameCn + "\" style=\"width:95%\" >" + valueCnString + "</textarea></div>";
				
				break;

			case WebComponent.MODE_READONLY:
			case WebComponent.MODE_DISABLED:

				contentHtml += "<div><div>" + getDisplay(resourceBundle, "datatable_en") + ": </div><textarea class=\"web_component_input\" data-key=\"" + keyEn + "\" id=\"" + nameEn + "\" name=\"" + nameEn + "\" style=\"width:95%;border: none;\"  readonly>" + valueEnString + "</textarea></div>";
				contentHtml += "<div><div>" + getDisplay(resourceBundle, "datatable_hk") + ": </div><textarea class=\"web_component_input\" data-key=\"" + keyHk + "\" id=\"" + nameHk + "\" name=\"" + nameHk + "\" style=\"width:95%;border: none;\"  readonly>" + valueHkString + "</textarea></div>";
				contentHtml += "<div><div>" + getDisplay(resourceBundle, "datatable_cn") + ": </div><textarea class=\"web_component_input\" data-key=\"" + keyCn + "\" id=\"" + nameCn + "\" name=\"" + nameCn + "\" style=\"width:95%;border: none;\"  readonly>" + valueCnString + "</textarea></div>";
				
				break;
				 
			case WebComponent.MODE_HIDDEN:
				
				contentHtml += "<div>" + getDisplay(resourceBundle, "datatable_en") + ": <textarea class=\"web_component_input hide\" data-key=\"" + keyEn + "\" id=\"" + nameEn + "\" name=\"" + nameEn + "\" style=\"width:95%;border: none;\" readonly>" + valueEnString + "</textarea></div>";
				contentHtml += "<div>" + getDisplay(resourceBundle, "datatable_hk") + ": <textarea class=\"web_component_input hide\" data-key=\"" + keyHk + "\" id=\"" + nameHk + "\" name=\"" + nameHk + "\" style=\"width:95%;border: none;\" readonly>" + valueHkString + "</textarea></div>";
				contentHtml += "<div>" + getDisplay(resourceBundle, "datatable_cn") + ": <textarea class=\"web_component_input hide\" data-key=\"" + keyCn + "\" id=\"" + nameCn + "\" name=\"" + nameCn + "\" style=\"width:95%;border: none;\" readonly>" + valueCnString + "</textarea></div>";
				
				break;
				
			
			case WebComponent.MODE_PENDING_APPROVAL:				
				
				boolean isValueEnChange = WebComponentHelper.isValueChange(valueEnString , origValueEnString);	
				boolean isValueHkChange = WebComponentHelper.isValueChange(valueHkString , origValueHkString);	
				boolean isValueCnChange = WebComponentHelper.isValueChange(valueCnString , origValueCnString);	
				
				String labelEffectHtml = "<span class= \"%s\"> %s </span>";
				
				//En				
				contentHtml += "<div>En:</div>";
				if ( !isValueEnChange ){
					
					contentHtml += valueEnString;
					
				}else{
						if( origValueEnString.equals("")){
				
							contentHtml += String.format(labelEffectHtml, "blueFont", valueEnString);
							
						}else{	
									
							contentHtml += String.format(labelEffectHtml, "grayFont", origValueEnString) + " > " + String.format( labelEffectHtml, "redFont", valueEnString );
					}			
				}	
				
				contentHtml += "<textarea class=\"web_component_input hide\" data-key=\"" + keyEn + "\" id=\"" + nameEn + "\" name=\"" + nameEn + "\" style=\"width:95%\"  readonly>" + valueEnString + "</textarea>";
				
				//Hk				
				contentHtml += "<div>Hk:</div>";
				if ( !isValueHkChange ){
					
					contentHtml += valueHkString;
					
				}else{
						if( origValueHkString.equals("")){
				
							contentHtml += String.format(labelEffectHtml, "blueFont", valueHkString);
							
						}else{	
									
							contentHtml += String.format(labelEffectHtml, "grayFont", origValueHkString) + " > " + String.format( labelEffectHtml, "redFont", valueHkString );
					}			
				}	
				
				contentHtml += "<textarea class=\"web_component_input hide\" data-key=\"" + keyHk + "\" id=\"" + nameHk + "\" name=\"" + nameHk + "\" style=\"width:95%\"  readonly>" + valueHkString + "</textarea>";
				
				//Cn			
				contentHtml += "<div>Cn:</div>";
				if ( !isValueCnChange ){
					
					contentHtml += valueCnString;
					
				}else{
						if( origValueCnString.equals("")){
				
							contentHtml += String.format(labelEffectHtml, "blueFont", valueCnString);
							
						}else{	
									
							contentHtml += String.format(labelEffectHtml, "grayFont", origValueCnString) + " > " + String.format( labelEffectHtml, "redFont", valueCnString );
					}			
				}	
				
				contentHtml += "<textarea class=\"web_component_input hide\" data-key=\"" + keyCn + "\" id=\"" + nameCn + "\" name=\"" + nameCn + "\" style=\"width:95%\"  readonly" + valueCnString + "></textarea>";
				
				
				break;
		
			default:
				break;
		}
		
		
		return "<td>" + contentHtml + "</td>";
		
		
	}
	
	public static String getDisplay(ResourceBundle resourceBundle, String key) {
		try {
			if ( resourceBundle.containsKey( key ) ){
				return resourceBundle.getString(key);
			}
			return key;
		} catch (MissingResourceException e) {
			return key;
		}
	}
	
}
