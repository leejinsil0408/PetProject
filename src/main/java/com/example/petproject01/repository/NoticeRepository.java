package com.example.petproject01.repository;

import com.example.petproject01.entity.Notice.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

    @Modifying
    @Query("update Notice n set n.cnt = n.cnt + 1 where n.seq = :seq")
    int updateCnt(Long cnt);
}
