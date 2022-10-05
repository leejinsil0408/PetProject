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
public class Reply implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Comment")
    private Long r_seq;

    @Column(updatable = false)
    private String r_writer;

//    @Column(nullable = false)
    private String Reply;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date r_createDate;

    @ManyToOne
    @JoinColumn(name = "seq", referencedColumnName = "seq")
    private Notice notice;

    @Column(updatable = false)
    private Long notice_seq;

}
