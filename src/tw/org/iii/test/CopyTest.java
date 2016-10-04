package tw.org.iii.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyTest{
	
	public static void main(String[] args) {
		File source = new File("D:\\JavaTest");
		File target = new File("D:\\JavaTest2");
	
		
		if(!source.exists()){
			System.out.println("No such folder,please creating one");
			System.exit(0);
		}else{
			System.out.println("OK, start copying one file...");
			copyFile(source, target);
		}

		
	}
	
		
	static void copyFile(File source, File target){
		if(!source.isDirectory()){
			//copy one file to a new folder
			long flen = source.length();
			try {
				FileInputStream in = new FileInputStream(source);
				FileOutputStream out = new FileOutputStream(target);
				byte[] temp = new byte[(int)flen];
				int len;
				while((len = in.read(temp)) != -1){
					out.write(temp, 0, len);
				}
				in.close();
				out.close();
				System.out.println("Copy one file from"+ source 
						+ "to " + target + " successfully! ");
			} catch (IOException e1) {
				System.out.println("Error in copying one file");
			}						
		}else {
			//create target folder and copy
			if(!target.exists()){
				target.mkdir();
				System.out.println("Create target directory: " + target);
				String folder_contents[] = source.list();
				for(String f1 : folder_contents){
					System.out.println(f1);
					File srcFile = new File(source, f1);
					File tarFile = new File(target, f1);
					copyFile(srcFile, tarFile);
				}
				//copy file to target folder
			}else {
				String folder_contents[] = source.list();
				for(String f1 : folder_contents){
					System.out.println(f1);
					File srcFile = new File(source, f1);
					File tarFile = new File(target, f1);
					copyFile(srcFile, tarFile);
				}
				
			}
			
			
		}
	}
	



}
