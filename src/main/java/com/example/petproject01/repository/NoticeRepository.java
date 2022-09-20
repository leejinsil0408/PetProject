package com.example.petproject01.repository;

import com.example.petproject01.entity.Notice.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
