package com.demo.file.upload.fileexample.controller;

import com.demo.file.upload.fileexample.entity.Attachment;
import com.demo.file.upload.fileexample.model.ResponseData;
import com.demo.file.upload.fileexample.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class AttachmentCotroller {

    @Autowired
    private AttachmentService attachmentService;

    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file")MultipartFile file) throws Exception {
        Attachment attachment = attachmentService.saveAttachment(file);

        //have to return responsedata as the response , we can use the attachment object and create
        //separate download url
        String downloadURL;
        downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath().
                path("/download/").
                path(attachment.getId()).toUriString();

        return new ResponseData(attachment.getFileName(),
                downloadURL,
                file.getContentType(),
                file.getSize());


    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("fileId")String fileId) throws Exception {
        Attachment attachment = null;
        attachment = attachmentService.getAttachment(fileId);

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(attachment.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\""+attachment.getFileName()
                +"\"")
                .body(new ByteArrayResource(attachment.getData()));

    }
}
