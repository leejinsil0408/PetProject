package com.example.petproject01.entity;

/**
 * @package : com.example.petproject01.entity;
 * @name : Notice.java
 * @date : 2022-09-19 오후 5:30
 * @author : Rubisco
 * @version : 1.0.0
 * @modifyed :
 * @description : 공지사항
 **/

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
public class Notice {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    private String title;

    @Column(updatable = false)
    private String writer;

    private String content;

    private Date createDate;

    private long cnt;

}
