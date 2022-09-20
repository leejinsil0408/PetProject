package com.example.petproject01.service;

import com.example.petproject01.entity.Notice.Notice;
import com.example.petproject01.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeRepository noticeRepo;

    @Override
    public List<Notice> NoticeList(Notice notice) {
        return (List<Notice>) noticeRepo.findAll();
    }

    @Override
    public void insertNotice(Notice notice) {
        noticeRepo.save(notice);
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
}
