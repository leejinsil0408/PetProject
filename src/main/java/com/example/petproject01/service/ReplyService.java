package com.example.petproject01.service;

import com.example.petproject01.entity.Notice;
import com.example.petproject01.entity.Reply;
import com.example.petproject01.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface ReplyService {


    void insertReply(Notice notice, String r_content);

    Reply getReply(Long r_seq);

//    void updateReply(Reply reply);

    void deleteReply(Reply reply);

    void replyModify(Reply reply, String content);

//    Reply getReply(Long r_seq);
//
//void updateReply(Reply reply, String r_content);

}
