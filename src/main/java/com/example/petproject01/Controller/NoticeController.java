package com.example.petproject01.Controller;

import com.example.petproject01.entity.Data.FileUploadEntity;
import com.example.petproject01.entity.Notice.Notice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import com.example.petproject01.service.NoticeService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;



@Controller
@Slf4j
    @RequestMapping(path = "/Notice")
    public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/NoticeList")
    public String NoticeList(Model model, Notice notice) {
        List<Notice> noticeList = noticeService.NoticeList(notice);

        model.addAttribute("noticeList", noticeList);
        return "/Notice/getNoticeList";
    }

    @GetMapping("/insertNotice")
    public String insertNotice() {
        return "/Notice/insertNotice";
    }

    @PostMapping("/insertNotice")
    public String insertNotice(Notice notice, @Nullable @RequestParam("uploadfile") MultipartFile[] uploadfile) {
//            model.addAttribute("message","글 작성이 완료되었습니다.");
//            model.addAttribute("searchUrl","redirect:/Notice/getNoticeList");
        notice.setCreateDate(new Date());
        try {
            //boardService.insertBoard 메서드에서는 DB에 데이터를 저장하고 저장된 board_seq를 리턴 받음
            Long notice_seq = noticeService.insertNotice(notice);
            List<FileUploadEntity> list = new ArrayList<>();
            for (MultipartFile file : uploadfile) {
                //MultipartFile로 클라이언트에서 온 데이터가
                //무결성 조건에 성립을 안하거나 메타데이터가 없거나
                // 문제가 생길 여지를 if문으로 처리
                if (!file.isEmpty()) {
                    FileUploadEntity entity = new FileUploadEntity(null,
                            UUID.randomUUID().toString(),
                            file.getContentType(),
                            file.getName(), //저장될 때의 이름
                            file.getOriginalFilename(), //원래 이름
                            notice_seq
                    );
                    //fileuploadtable에 데이터 저장
                    noticeService.insertFileUploadEntity(entity);
                    list.add(entity);
                    File newFileName = new File(entity.getUuid() + "_" + entity.getOriginalFilename());
                    //서버에 이미지 파일 업로드(저장)
                    file.transferTo(newFileName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/Notice/NoticeList";
//            return "/message";
    }


    /*-----READ------*/
    //공지사항 상세
    @GetMapping("/getNotice")
    public String getNotice(Notice notice, Model model) {

        List<FileUploadEntity> fileUploadEntity = noticeService.getFileUploadEntity2(notice.getSeq());
        List<String> path = new ArrayList<>();
        for (FileUploadEntity fe : fileUploadEntity) {
            String savePath = "/Notice/upload/" + fe.getUuid() + "_" + fe.getOriginalFilename();
            path.add(savePath);
        }
        model.addAttribute("notice", noticeService.getNotice(notice));
        model.addAttribute("imgLoading", path);
        return "/Notice/getNotice";
    }


    @PostMapping("/updateNotice")
    public String updateNotice(Notice notice) {
        noticeService.updateNotice(notice);
        return "redirect:/Notice/getNotice?seq=" + notice.getSeq();
    }

    @GetMapping("/updateNotice")
    public String updateNoticeView(Notice notice, Model model) {
        model.addAttribute("notice", noticeService.getNotice(notice));
        return "/Notice/insertNotice";
    }

    @GetMapping("/deleteNotice")
    public String deleteNotice(Notice notice) {
        noticeService.deleteNotice(notice);
        return "redirect:/Notice/NoticeList";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("uploadfile") MultipartFile[] uploadfile,
                             @RequestParam("seq") Long input_seq) throws IOException {
        log.info("img load session");
        List<FileUploadEntity> list = new ArrayList<>();
        for (MultipartFile file : uploadfile) {
            if (!file.isEmpty()) {
                FileUploadEntity entity = new FileUploadEntity(null,
                        UUID.randomUUID().toString(),
                        file.getContentType(),
                        file.getName(),
                        file.getOriginalFilename(),
                        input_seq
                );
                Long output = noticeService.insertFileUploadEntity(entity);
                log.info("seq check!");
                log.info(output.toString());
                list.add(entity);
                File newFileName = new File(entity.getUuid() + "_" + entity.getOriginalFilename());
                //file을 서버에 저장하는 스트림행위는 서버가 성공할지 여부를 체크하므로 exception처리 필요
                //메서드에 throws IOException 처리 = try catch처리 필요
                file.transferTo(newFileName);
            }
        }
        return "/Notice/getNoticeList";
    }

    @GetMapping(value = "/image/{imagename}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> imageLoading(@PathVariable("imagename") String imgname) throws IOException {
        String path = "C:/NewFolder/PetProject01/src/main/resources/static/upload/" + imgname;
        FileInputStream fis = new FileInputStream(path);
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] imgByteArr = bis.readAllBytes();
        return new ResponseEntity<byte[]>(imgByteArr, HttpStatus.OK);
    }

    /* 검색 */
    @PostMapping("/list")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("keyword", noticeService.searchNotice(keyword));
        return "/Notice/list";
    }
}

