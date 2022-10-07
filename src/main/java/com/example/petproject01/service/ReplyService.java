package com.example.petproject01.service;

import com.example.petproject01.entity.Reply;
import com.example.petproject01.repository.ReplyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReplyService {

List<Reply> getReplyList(Reply reply);

void insertReply(Long noticeId,Reply reply);

void updateReply(Reply reply);

void deleteReply(Reply reply);

}
