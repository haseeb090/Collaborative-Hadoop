/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cohap.collaborative.hadoop.form;

import org.springframework.web.multipart.commons.CommonsMultipartFile;
/**
 *
 * @author Haseeb Khizar
 */
public class UploadForm {
    private String description;
    private CommonsMultipartFile[] FileData;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CommonsMultipartFile[] getFileData() {
        return FileData;
    }

    public void setFileData(CommonsMultipartFile[] FileData) {
        this.FileData = FileData;
    }
    
    
    
    
}
