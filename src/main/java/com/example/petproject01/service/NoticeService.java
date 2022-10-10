package com.example.petproject01.service;

import com.example.petproject01.entity.Data.FileUploadEntity;
import com.example.petproject01.entity.Notice;
import com.example.petproject01.entity.Reply;
import com.example.petproject01.repository.NoticeRepository;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


public interface NoticeService {

    List<Notice> NoticeList(Notice notice);
    Page<Notice> NOTICE_PAGE(Pageable pageable);

    Long insertNotice(Notice notice);

    Notice getNotice(Notice notice, Long seq);


    void updateNotice(Notice notice);

    void deleteNotice(Notice notice);


    /*  파일 업로드  */

    Long insertFileUploadEntity(FileUploadEntity fileUploadEntity);

    List<FileUploadEntity> getFileUploadEntity2(Long notice_seq);

    /*  검색  */
    List<Notice> searchNotice(String keyword);

    int updateCnt(Long seq);

//    @Transactional
//    void insertReply(long seq, Reply reply);

    }

