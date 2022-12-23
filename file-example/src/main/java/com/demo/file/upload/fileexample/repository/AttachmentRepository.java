package com.demo.file.upload.fileexample.repository;

import com.demo.file.upload.fileexample.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment,String> {

}
