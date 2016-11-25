package com.niit.gauresh_emusic.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	public static void upload(String path, MultipartFile file, String fileName) {
		if(!file.isEmpty()){
			try{
				byte[] bytes= file.getBytes();
				
				//creating directory to store files
				File dir= new File(path);
				if(!dir.exists())
					dir.mkdirs();
				
				//create file on server
				File serverFile= new File(dir.getAbsolutePath()+ File.separator+ fileName);
				BufferedOutputStream stream= new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
