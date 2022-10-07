package com.example.petproject01.entity;

/*
 * @package : com.example.petproject01.entity;
 * @name : Notice.java
 * @date : 2022-09-19 오후 5:30
 * @author : Rubisco
 * @version : 1.0.0
 * @modifyed :
 * @description : 공지사항
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@DynamicInsert
@DynamicUpdate

@Getter
@Setter
@ToString
@Entity
public class Notice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long seq;

    @Column(length = 40, nullable = false)
    private String title;

    @Column(updatable = false)
    private String writer;

    @Column(nullable = false)
    private String content;

    private String category;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    @ColumnDefault("0")
    private long cnt;

    private String keyword;

    // Notice 테이블에 댓글리스트를 추가 DB에는 하나의 raw 데이터에 하나의 값만 들어감
    // 만약 여러 개의 데이터가 들어간다면 원자성이 깨지므로
    // replyList는 DB에 FK로 생성되면 안되기 때문에 mappedBy를 사용
    // mappedBy : 연관관계의 주인이 아니므로 DB의 FK가 아니다
    // @OneToMany default fetch Lazy -> Eager 변경
    // 무한 참조 발생 조치 , 최근순 설정
    @OrderBy("id asc")
    @JsonIgnoreProperties({"notice"})
    @OneToMany(mappedBy = "notice", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Reply> replyList = new ArrayList<>();

}

