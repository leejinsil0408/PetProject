package com.example.petproject01.entity.Notice;

/*
 * @package : com.example.petproject01.entity;
 * @name : Notice.java
 * @date : 2022-09-19 오후 5:30
 * @author : Rubisco
 * @version : 1.0.0
 * @modifyed :
 * @description : 공지사항
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@ToString
@Entity
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(length = 40, nullable = false)
    private String title;

    @Column(updatable = false)
    private String writer;

    @Column(nullable = false)
    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    @ColumnDefault("0")
    private long cnt;

}

