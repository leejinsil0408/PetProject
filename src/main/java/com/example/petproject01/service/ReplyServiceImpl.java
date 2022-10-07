package com.example.petproject01.service;

import com.example.petproject01.entity.Notice;
import com.example.petproject01.entity.Reply;
import com.example.petproject01.repository.FileRepository;
import com.example.petproject01.repository.NoticeRepository;
import com.example.petproject01.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyRepository replRepo;
    private NoticeRepository noticeRepo;

    @Autowired
    protected ReplyServiceImpl(NoticeRepository noticeRepo, ReplyRepository replRepo){
        this.noticeRepo = noticeRepo;
        this.replRepo = replRepo;
    }
    @Override
    public List<Reply> getReplyList(Reply reply) {
        return replRepo.findAll();
    }

    @Override
    public void insertReply(Long noticeId,Reply reply) {
        Notice notice = noticeRepo.findById(noticeId).orElseThrow(() -> new IllegalArgumentException("해당 noticeid가 없습니다. id =" + noticeId));
        reply.save(notice);
        replRepo.save(reply);
    }

    @Override
    public void updateReply(Reply reply) {
        Reply findReply = replRepo.findById(reply.getR_seq()).get();
        findReply.setR_writer(reply.getR_writer());
        findReply.setContent(reply.getContent());
        findReply.setR_createDate(reply.getR_createDate());
        replRepo.save(findReply);
    }

    @Override
    public void deleteReply(Reply reply) {
        replRepo.deleteById(reply.getR_seq());

    }
}
