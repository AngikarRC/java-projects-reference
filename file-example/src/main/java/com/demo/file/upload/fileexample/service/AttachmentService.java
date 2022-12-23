package com.demo.file.upload.fileexample.service;

import com.demo.file.upload.fileexample.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {

    Attachment saveAttachment(MultipartFile file) throws Exception;

    Attachment getAttachment(String fileId) throws Exception;
}
