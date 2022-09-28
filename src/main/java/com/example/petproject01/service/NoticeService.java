package com.example.petproject01.service;

import com.example.petproject01.entity.Data.FileUploadEntity;
import com.example.petproject01.entity.Notice;
import com.example.petproject01.repository.NoticeRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

public interface NoticeService {

    List<Notice> NoticeList(Notice notice);

    Long insertNotice(Notice notice);

    Notice getNotice(Notice notice);

    void updateNotice(Notice notice);

    void deleteNotice(Notice notice);

    /*  파일 업로드  */

    Long insertFileUploadEntity(FileUploadEntity fileUploadEntity);
    List<FileUploadEntity> getFileUploadEntity2(Long notice_seq);

    /*  검색  */
    List<Notice> searchNotice(String keyword);

    int updateCnt(Long seq);

}
