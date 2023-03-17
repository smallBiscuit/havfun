package com.havfun.adminui.webcomponent;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileInput extends WebComponent {

	private static final Logger LOGGER = LogManager.getLogger(FileInput.class.getName());

	public FileInput(Map<String, Object> valueMap ) {
		
		super( valueMap );

	}
	

	@Override
	public String getWebComponentHtml(ResourceBundle resourceBundle, int pageMode, List<String> choiceList, Object value, Object origValue) {
	
		int webComponentMode = getComponentMode(pageMode);
		String valueString = objectToString(value).trim();
		String origValueString = objectToString(origValue).trim();

		String finalHtml = "";
		
		boolean isValueChange = isValueChange(valueString, origValueString);

		String inputHtmlFormat = "<input type=\"file\" id=\"%s\" name=\"%s\" >";
		
		String hiddenPreviewHtmlFormat = "<img class=\"file_input_preview left\" src=\"#\" alt=\"your image\" height=\"50px\" style=\"display:none;\"/>";
		
		String previewHtmlFormat = "<img class=\"file_input_preview left\" src=\"%s\" alt=\"your image\" height=\"50px\" style=\"\"/>";
		
		String origPreviewHtmlFormat = "<img class=\"file_input_preview left\" src=\"%s\" alt=\"your image\" height=\"50px\" style=\"\"/>";
		
		switch(webComponentMode){
			
			case MODE_EDITABLE: 
				
				finalHtml = String.format(inputHtmlFormat, key, key );
//				finalHtml += previewHtmlFormat;
				break;
				
			case MODE_READONLY:
			case MODE_DISABLED:
			case MODE_HIDDEN:
			case MODE_PENDING_APPROVAL:
					
				break;					
				
			default:
				break;
		}			


		
		//label part html code
	
		switch(webComponentMode){
		
			
			case MODE_HIDDEN:
				break;
				
			case MODE_EDITABLE: 					
			case MODE_READONLY:				
			case MODE_DISABLED:				

				if ( value != null && !value.equals( "" ) ){
					
					finalHtml+= String.format( previewHtmlFormat, value);
					
				}else{

					finalHtml+= hiddenPreviewHtmlFormat;					
					
				}
	
				break;
				
			case MODE_PENDING_APPROVAL:
			
				if ( !isValueChange ){
					
					if ( value != null && !value.equals( "" ) ){
					
						finalHtml+= String.format( previewHtmlFormat, value);
						
					}
					
					
				}else{
					
						if( origValueString.equals("") ){
							
							if ( value != null && !value.equals( "" ) ){
							
								finalHtml+= String.format( previewHtmlFormat, value);
							
							}
							
						}else{	
									
							finalHtml+= String.format( origPreviewHtmlFormat, origValue) + "<div style=\"float:left;margin:20px;\"> > </div>";
							
							if ( value != null && !value.equals( "" ) ){
								
								finalHtml+= String.format( previewHtmlFormat, value);
							
							}
							
					}			
				}									
								
				break;					
				
				default:
				break;
		}			
		
//		LOGGER.debug(finalHtml);
		return finalHtml;
	}
	
	
}