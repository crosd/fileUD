package com.myFile.fileUpDown.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadDownLoadController {

	public static final String FILE_PATH ="d:\\temp\\";
	
	@RequestMapping(value="/upload",method=RequestMethod.GET)
	public String uploadGET(){
		return "redirect:/frontPage";
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String uploadPOST(@RequestParam("file") MultipartFile file, Model model) throws IOException{
		 
		if(!file.isEmpty()){
			// file save in the drive
			FileOutputStream out = new FileOutputStream(FILE_PATH+file.getOriginalFilename());
			out.write(file.getBytes());
			out.close();
			System.out.println("file uploaded successfully:");
			model.addAttribute("successMsg", "uploaded file"+file.getOriginalFilename());	
			model.addAttribute("fileName", URLEncoder.encode(file.getOriginalFilename(),"UTF-8"));
			
		}
		
		return "frontPage";
	}
	@RequestMapping(value="/download",method= RequestMethod.GET)
	public void downloadGET(@RequestParam("file") String fileName , HttpServletResponse response) throws IOException{
		fileName = URLDecoder.decode(fileName,"UTF-8");
		String ext = FilenameUtils.getExtension(fileName);
		System.out.println(ext);
		//String name = FilenameUtils.getBaseName(fileName);
		
		response.setContentType("image/"+ext);
		response.setHeader("Content-Disposition","attachment; filename="+fileName);
		PrintWriter out = response.getWriter();
		FileInputStream in = new FileInputStream(FILE_PATH+fileName);
		int i;
		while((i=in.read())!=-1){
			out.write(i);
		}
		in.close();
		out.close();
		
	}
	
	
}
