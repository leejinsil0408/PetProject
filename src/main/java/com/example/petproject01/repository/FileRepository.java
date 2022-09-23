package com.example.petproject01.repository;

import com.example.petproject01.entity.Data.FileUploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<FileUploadEntity, Long> {
    List<FileUploadEntity> findByNoticeSeq(Long noticeSeq);
}
