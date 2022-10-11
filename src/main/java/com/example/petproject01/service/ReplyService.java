package com.example.petproject01.service;

import com.example.petproject01.entity.Notice;
import com.example.petproject01.entity.Reply;
import com.example.petproject01.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ReplyService {


    void create(Notice notice, String r_content);

//List<Reply> getReplyList(Reply reply);
//
//void insertReply(Notice notice, String content);
//
//void updateReply(Reply reply);
//
//void deleteReply(Reply reply);

}
