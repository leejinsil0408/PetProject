package com.example.petproject01.service;

import com.example.petproject01.entity.Notice;
import com.example.petproject01.entity.Reply;
import com.example.petproject01.exception.DataNotFoundException;
import com.example.petproject01.repository.NoticeRepository;
import com.example.petproject01.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;


@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyRepository replRepo;
    private NoticeRepository noticeRepo;

    @Override
    public void insertReply(Notice notice, String r_content) {
        Reply reply = new Reply();
        reply.setR_content(r_content);
        reply.setR_createDate(new Date());
        reply.setNotice(notice);
        this.replRepo.save(reply);
    }

    @Override
    public Reply getReply(Long r_seq) {
        Optional<Reply> reply = this.replRepo.findById(r_seq);
        if (reply.isPresent()) {
            return reply.get();
        }else {
            throw new DataNotFoundException("reply not found");
        }
    }

    @Override
    public void replyModify(Reply reply, String r_content) {
//        Reply findReply = replRepo.findById(reply.getR_seq()).get();
//        findReply.setR_seq(reply.getR_seq());
//        findReply.setR_content(reply.getR_content());
//        findReply.setNotice(findReply.getNotice());
        reply.setR_content(r_content);
        this.replRepo.save(reply);
    }

    @Override
    public void deleteReply(Reply reply) {
        this.replRepo.delete(reply);
    }
}
//    @Transactional
//    public void updateReply(Long r_seq, String r_content);

//    @Override
//    public Reply getReply(Long r_seq) {
//        Optional<Reply> reply = this.replRepo.findById(r_seq);
//        if (reply.isPresent()) {
//            return reply.get();
//        } else {
//            throw new DataNotFoundException("reply not found");
//        }
//    }
//    @Override
//    public void updateReply(Reply reply, String r_content) {
//        reply.setR_content(r_content);
//        this.replRepo.save(reply);
//    }
//
//    @Autowired
//    protected ReplyServiceImpl(NoticeRepository noticeRepo, ReplyRepository replRepo){
//        this.noticeRepo = noticeRepo;
//        this.replRepo = replRepo;
//    }
//    @Override
//    public List<Reply> getReplyList(Reply reply) {
//        return replRepo.findAll();
//    }
//
//    @Override
//    public void insertReply(Notice notice, String content){
//        Reply reply = new Reply();
//        reply.setContent(content);
//        reply.setR_createDate(new Date());
//        reply.setNotice(notice);
//
//        replRepo.save(reply);
//
//        //        Notice notice = noticeRepo.findById(noticeId).orElseThrow(() -> new IllegalArgumentException("해당 noticeid가 없습니다. id =" + noticeId));
////        reply.save(notice);
////        replRepo.save(reply);
//    }
//
//    @Override
//    public void updateReply(Reply reply) {
//        Reply findReply = replRepo.findById(reply.getR_seq()).get();
//        findReply.setContent(reply.getContent());
//        findReply.setR_createDate(reply.getR_createDate());
//        replRepo.save(findReply);
//    }
//
//    @Override
//    public void deleteReply(Reply reply) {
//        replRepo.deleteById(reply.getR_seq());

