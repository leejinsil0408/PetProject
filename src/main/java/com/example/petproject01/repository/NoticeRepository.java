package com.example.petproject01.repository;

import com.example.petproject01.entity.Notice.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

  @Query(value = "SELECT n FROM Notice n WHERE n.title LIKE %:keyword OR n.content LIKE %:keyword% OR n.writer LIKE %:keyword%")
  List<Notice> findAllSearch(String keyword);
}
