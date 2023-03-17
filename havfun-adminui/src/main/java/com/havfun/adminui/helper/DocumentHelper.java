package com.havfun.adminui.helper;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class DocumentHelper {

	private static final Logger LOGGER = LogManager.getLogger(DocumentHelper.class.getName());
	public static final String DOC_URL_PATH = "/listco/news/";//"/tmp/hklistco/doc";
	public static final String DOC_COVER_URL_PATH = "/home/hklistco/listco/ar/";//"/tmp/hklistco/cover";
	public static final String DOC_WRITE_PATH = "/home/hklistco/listco/news/";	

	public static final String DOC_UPDATE_COVER_POSTFIX = "_update.jpg";	
	public static final String DOC_COVER_POSTFIX = ".jpg";		
	
	
	public static final String FILE_TYPE_PDF = "pdf";
	
	public static boolean isUpdatedFileCoverExist( String originalCoverName ){
		
		String fullUpdatedCoverPath = DOC_COVER_URL_PATH + originalCoverName + DOC_UPDATE_COVER_POSTFIX;
		
		return new File( fullUpdatedCoverPath ).exists();

	}
	
	public static void useUpdatedFileCover( String originalCoverName ){
		
		String fullUpdatedCoverPath = DOC_COVER_URL_PATH + originalCoverName + DOC_UPDATE_COVER_POSTFIX;
		
		String fullCoverPath = DocumentHelper.DOC_COVER_URL_PATH + originalCoverName + DOC_COVER_POSTFIX;
		
		File updatedFile = new File( fullUpdatedCoverPath );
		File originalFile = new File( fullCoverPath );
		
		try {
			FileUtils.copyFile(updatedFile, originalFile);
		    if (!updatedFile.delete()) {
		        throw new IOException("Failed to delete " + updatedFile.getName());
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOGGER.warn("DocumentHelper Exception " + e.getLocalizedMessage() );
		}
	}
	
	public static void removeUpdatedFileCover( String originalCoverName ){
		
		String fullUpdatedCoverPath = DOC_COVER_URL_PATH + originalCoverName + DOC_UPDATE_COVER_POSTFIX;
		
		File updatedFile = new File( fullUpdatedCoverPath );
		
		 if (!updatedFile.delete()) {
			 LOGGER.warn("DocumentHelper Fail to delete updatedFile" );
		 }
	}
	
	public static void saveFileIntoServer( final Part filePart, String fileName, String fileType) throws IOException{
		//Save file into server
		checkDirectoryExist( DOC_WRITE_PATH );
		checkDirectoryExist( DOC_COVER_URL_PATH );
		
	    OutputStream out = null; 
	    InputStream filecontent = null;
	    //final PrintWriter writer = response.getWriter();

	    try {
	        out = new FileOutputStream(new File(DOC_WRITE_PATH + File.separator
	                + fileName));
	        filecontent = filePart.getInputStream();

	        int read = 0;
	        final byte[] bytes = new byte[1024];

	        while ((read = filecontent.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        //writer.println("New file " + fileName + " created at " + path);
	        LOGGER.info("DocumentHelper File{0}being uploaded to {1}", 
	                new Object[]{fileName, DOC_WRITE_PATH});
	        
	        //savePDFCover( path + fileName );
	        if ( fileType.equals(  FILE_TYPE_PDF ) ){
	        	savePDFCover( DOC_WRITE_PATH, DOC_COVER_URL_PATH, fileName );
	        }
	    } catch (FileNotFoundException fne) {

	        LOGGER.warn("DocumentHelper Problems during file upload. Error: {0}", 
	                new Object[]{fne.getMessage()});
	    } finally {
	        if (out != null) {
	            out.close();
	        }
	        if (filecontent != null) {
	            filecontent.close();
	        }
	    }				
	}
	
	public static void saveFileCover( final Part filePart, String fileName) throws IOException{
		//Save file into server
		checkDirectoryExist( DOC_COVER_URL_PATH );
		
	    OutputStream out = null; 
	    InputStream filecontent = null;
	    //final PrintWriter writer = response.getWriter();

	    try {
	    	
	        out = new FileOutputStream(new File(DOC_COVER_URL_PATH + fileName));
	        filecontent = filePart.getInputStream();

	        int read = 0;
	        final byte[] bytes = new byte[1024];

	        while ((read = filecontent.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        //writer.println("New file " + fileName + " created at " + path);
	        LOGGER.info("DocumentHelper File{0}being uploaded to {1}", 
	                new Object[]{fileName, DOC_WRITE_PATH});
	        
	    } catch (FileNotFoundException fne) {

	        LOGGER.warn("DocumentHelper Problems during file upload. Error: {0}", 
	                new Object[]{fne.getMessage()});
	    } finally {
	    	LOGGER.warn("DocumentHelper Problems upload file finish" ); 
	        if (out != null) {
	            out.close();
	        }
	        if (filecontent != null) {
	            filecontent.close();
	        }
	    }				
	}
	
	private static void checkDirectoryExist( String dirPath ){
		File theDir = new File( dirPath );
		if (!theDir.exists()) {
		    try{
		    	LOGGER.info("DocumentHelper dir "+dirPath +" not exist");
		        boolean result = theDir.mkdirs();
		        if ( result ){
		        	LOGGER.info("DocumentHelper directories created success");
		        }else{
		        	LOGGER.info("DocumentHelper directories created fail without exception");
		        }
		     } catch(SecurityException se){
		        //handle it
		    	 LOGGER.warn("DocumentHelper dir "+dirPath +" created fail "+se.getMessage());
		     }        
		  }		
	}
	
	private static void savePDFCover( String source, String distination, String fileName ) throws IOException{
		
        PDDocument document = PDDocument.load( source + fileName );
        List<PDPage> pages = document.getDocumentCatalog().getAllPages();
        PDPage page = pages.get(0); //first one
        BufferedImage bufferedImage = page.convertToImage();
        File outputFile = new File( distination + fileName + ".jpg" );
        ImageIO.write(bufferedImage, "jpg", outputFile);
        
	}
	
	
}
