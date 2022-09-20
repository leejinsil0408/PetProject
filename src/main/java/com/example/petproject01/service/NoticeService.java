package com.example.petproject01.service;

import com.example.petproject01.entity.Notice.Notice;

import java.util.List;

public interface NoticeService {

    List<Notice> NoticeList(Notice notice);

    void insertNotice(Notice notice);

    Notice getNotice(Notice notice);

    void updateNotice(Notice notice);

    void deleteNotice(Notice notice);



}
