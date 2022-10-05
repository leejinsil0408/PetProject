package com.example.petproject01.service;

import com.example.petproject01.entity.Reply;
import com.example.petproject01.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyRepository ReplRepo;

    @Override
    public List<Reply> getReplyList(Reply reply) {
        return ReplRepo.findAll();
    }

    @Override
    public void insertReply(Reply reply) {
        ReplRepo.save(reply);
    }

    @Override
    public void updateReply(Reply reply) {
        Reply findReply = ReplRepo.findById(reply.getR_seq()).get();
        findReply.setR_writer(reply.getR_writer());
        findReply.setReply(reply.getReply());
        findReply.setR_createDate(reply.getR_createDate());
        ReplRepo.save(findReply);
    }

    @Override
    public void deleteReply(Reply reply) {
        ReplRepo.deleteById(reply.getR_seq());

    }
}
