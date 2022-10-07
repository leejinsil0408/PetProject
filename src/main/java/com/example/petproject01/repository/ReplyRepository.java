package com.example.petproject01.repository;

import com.example.petproject01.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply,Long> {
}
