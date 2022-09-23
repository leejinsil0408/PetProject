package com.example.petproject01.service;

import com.example.petproject01.entity.Data.FileUploadEntity;
import com.example.petproject01.entity.Notice.Notice;
import com.example.petproject01.repository.FileRepository;
import com.example.petproject01.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import java.io.File;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {


    private NoticeRepository noticeRepo;
    private FileRepository fileRepo;

    @Autowired
    protected NoticeServiceImpl(NoticeRepository noticeRepo, FileRepository fileRepo){
        this.noticeRepo = noticeRepo;
        this.fileRepo = fileRepo;
    }

    @Override
    public List<Notice> NoticeList(Notice notice) {
        return (List<Notice>) noticeRepo.findAll();
    }

    @Override
    public Long insertNotice(Notice notice) {
        return noticeRepo.save(notice).getSeq();
    }

    @Override
    public Notice getNotice(Notice notice) {
        return noticeRepo.findById(notice.getSeq()).get();
    }

    @Override
    public void updateNotice(Notice notice) {
        Notice findNotice = noticeRepo.findById(notice.getSeq()).get();
        findNotice.setTitle(notice.getTitle());
        findNotice.setContent(notice.getContent());
        noticeRepo.save(findNotice);
    }

    @Override
    public void deleteNotice(Notice notice) {
        noticeRepo.deleteById(notice.getSeq());
    }

    @Override
    public Long insertFileUploadEntity(FileUploadEntity fileUploadEntity) {
        return fileRepo.save(fileUploadEntity).getId();
    }

    @Override
    public List<FileUploadEntity> getFileUploadEntity2(Long notice_seq) {
        return fileRepo.findByNoticeSeq(notice_seq);
    }

}
