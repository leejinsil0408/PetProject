package com.example.petproject01.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //댓글번호, 작성자, 내용, 원글
    private Long r_seq;

    @Column(nullable = false)
    private String content;

    @Column(updatable = false)
    private String r_writer;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date r_createDate;

    @ManyToOne
    @JoinColumn(name= "Notice_seq" ) //참조하고자 하는 테이블 entity
    private Notice notice;


    public void save(Notice notice) {
        this.notice = notice;
    }

}
