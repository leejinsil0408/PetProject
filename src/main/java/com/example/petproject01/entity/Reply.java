package com.example.petproject01.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Notice_seq")
    //댓글번호, 작성자, 내용, 원글
    private Long r_seq;

    @Column(nullable = false)
    private String r_content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date r_createDate;

    @ManyToOne
    @JoinColumn
    private Notice notice;

    public void save(Notice notice) {
        this.notice = notice;
    }

}
