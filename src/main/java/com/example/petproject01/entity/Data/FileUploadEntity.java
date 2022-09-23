package com.example.petproject01.entity.Data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter //객체 정보
@Entity
@AllArgsConstructor //해당 클래스 변수들을 모두 매개변수로 받는 생성자 알아서 생성
@NoArgsConstructor // 아무것도 매개로 받지 않는 생성자 추가
public class FileUploadEntity {

    @Id @GeneratedValue
    private Long id;
    private String uuid;
    private String contentType;
    private String name;
    private String originalFilename;
    private Long noticeSeq;
}
