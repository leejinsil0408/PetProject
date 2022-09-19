package com.example.petproject01.service;

import com.example.petproject01.entity.Notice;

import java.util.List;

public interface NoticeService {

    List<Notice> NoticeList();

    void insertNotice(Notice notice);

    Notice getNotice(Notice notice);

    void updateNotice(Notice notice);

    void deleteNotice(Notice notice);



}
