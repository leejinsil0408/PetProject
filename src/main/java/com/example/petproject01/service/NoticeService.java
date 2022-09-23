package com.example.petproject01.service;

import com.example.petproject01.entity.Data.FileUploadEntity;
import com.example.petproject01.entity.Notice.Notice;
import com.example.petproject01.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface NoticeService {

    List<Notice> NoticeList(Notice notice);

    Long insertNotice(Notice notice);

    Notice getNotice(Notice notice);

    void updateNotice(Notice notice);

    void deleteNotice(Notice notice);


    Long insertFileUploadEntity(FileUploadEntity fileUploadEntity);
    List<FileUploadEntity> getFileUploadEntity2(Long notice_seq);
}
