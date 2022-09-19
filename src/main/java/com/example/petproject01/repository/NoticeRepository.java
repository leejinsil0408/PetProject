package com.example.petproject01.repository;

import com.example.petproject01.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
