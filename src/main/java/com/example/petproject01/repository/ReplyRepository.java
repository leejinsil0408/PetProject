package com.example.petproject01.repository;

import com.example.petproject01.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.xml.stream.events.Comment;
import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply,Long> {
    List<Reply> findAllByNotice_seq(Long seq);

}
