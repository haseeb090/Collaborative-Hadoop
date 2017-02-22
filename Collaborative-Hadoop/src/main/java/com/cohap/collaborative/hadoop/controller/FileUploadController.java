/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cohap.collaborative.hadoop.controller;

import com.cohap.collaborative.hadoop.ssh.SSH;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cohap.collaborative.hadoop.form.UploadForm;
import static org.springframework.http.RequestEntity.method;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

/**
 *
 * @author Haseeb Khizar
 */
@Controller
public class FileUploadController {
    
    @InitBinder
    public void initBind(WebDataBinder dataBind){
        Object target = dataBind.getTarget();
        if (target == null){
            return;
        }
        System.out.println("Target=" + target);
        if (target.getClass() == UploadForm.class){
            //conversion between multipart object and byte array
            dataBind.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
        }
    }
    
    //GET: show one upload form
    @RequestMapping(value="/uploadOneFile", method = RequestMethod.GET)
    public String uploadOneFileHandler(Model m){
        UploadForm uF = new UploadForm();
        m.addAttribute("UploadForm", uF);
        
        //forward
        return "uploadOneFile";
    }
    
    //POST: one upload process
    @RequestMapping(value="/uploadOneFile", method = RequestMethod.POST)
    public String uploadOneFileHandlerPOST(HttpServletRequest r, Model m, 
            @ModelAttribute("UploadForm") UploadForm uF){
        return this.Upload(r, m, uF);
        
    }
    
    //Get:Show multiple upload form
    @RequestMapping(value="/uploadMultiFile", method = RequestMethod.GET)
    public String uploadMultiFileHandler(Model m){
        UploadForm uF = new UploadForm();
        m.addAttribute("UploadForm", uF);
        
        return "uploadMultiFile";
    }
    
    //Post: Upload multiple 
    @RequestMapping(value="/uploadMultiFile", method=RequestMethod.POST)
    public String uploadMultiFileHandlerPOST(HttpServletRequest r, Model m,
            @ModelAttribute("UploadForm") UploadForm uF){
        return this.Upload(r, m, uF);        
    }
    private String Upload(HttpServletRequest r, Model m, UploadForm uF)
    {
        String description = uF.getDescription();
        System.out.println("Description: "+ description);
        
        String uploadPath = r.getServletContext().getRealPath("upload");
        System.out.println("Upload Path=" + uploadPath);
        File uploadDir = new File("/upload");
        if (!uploadDir.exists()){
            uploadDir.mkdirs();
        }
        
        CommonsMultipartFile[] fData = uF.getFileData();
        
        List<File> uploadedFiles = new ArrayList<File>();
        for(CommonsMultipartFile f : fData){
            
            String name = f.getOriginalFilename();
            System.out.println("Client File Name: " + name);
            
            if(name!= null && name.length()>0){
               try{
                   //creating file
                   File serverFile = new File(uploadDir.getAbsolutePath() + File.separator + name);
                   
                   //write stream
                   BufferedOutputStream s = new BufferedOutputStream(new FileOutputStream(serverFile));
                   s.write(f.getBytes());
                   s.close();
                   
                   uploadedFiles.add(serverFile);
                   System.out.println("File write successful: " + serverFile);
               } catch (Exception e){
                   System.out.println("Error Writing File: " + name);
               }
            }
        }
        m.addAttribute("description", description);
        m.addAttribute("uploadedFiles", uploadedFiles);
        //executeMR();
        return "uploadResult";
    }  
    
    @RequestMapping(value="/sshmr", method = RequestMethod.GET)
    public String exectureMRHandlerGET(Model m){
        UploadForm uF = new UploadForm();
        m.addAttribute("UploadForm", uF);
        
        //forward
        return "sshmr";
    }
    
    @RequestMapping(value="/sshmr" ,method=RequestMethod.POST)
    public String executeMRHandlerPOST (){
                System.out.println("Program starts");

		//SSH test = new SSH("192.168.56.101", "hduser1", "cs354");
		//test.makeConnection();
		
		//test.executeCommand(Commands.makeDirectory("/apple"));
		//test.executeCommand(Commands.removeDirectory("/apple"));
		
		//test.executeCommand(Commands.uploadFile("apple.txt","/"));
		//test.executeCommand(Commands.downloadFile("/apple.txt","~/"));
		//test.executeCommand(Commands.removeDirectory("/apple.txt"));
		
		
		//test.executeCommand(Commands.moveFile("/apple.txt","/input"));
		
		//test.executeCommand(Commands.copyFile("/apple.txt","/input"));


		//test.close();
		//test = null;
		System.out.println("Program ends successfully");
                return "success";       

            } 
    
}
