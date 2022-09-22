package com.example.petproject01.Controller;

import com.example.petproject01.entity.Notice.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.petproject01.service.NoticeService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Date;
import java.util.List;

    @Controller
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
        public String insertNotice(Notice notice) {
            notice.setCreateDate(new Date());
            noticeService.insertNotice(notice);
            return "redirect:/Notice/NoticeList";
        }


        /*-----READ------*/
        //공지사항 상세
        @GetMapping("/getNotice")
        public String getNotice(Notice notice, Model model) {
            model.addAttribute("notice",noticeService.getNotice(notice));
            System.out.println("noticeService.getNotice(notice)");
            return "/Notice/getNotice";
        }


        @PostMapping("/updateNotice")
        public String updateNotice(Notice notice) {
            noticeService.updateNotice(notice);
            return "redirect:/Notice/getNotice?seq="+notice.getSeq();
        }

        @GetMapping ("/updateNotice")
        public String updateNoticeView(Notice notice, Model model) {
            model.addAttribute("notice", noticeService.getNotice(notice));
            return "/Notice/insertNotice";
        }

        @PostMapping("/deleteNotice")
        public String deleteNotice(Notice notice) {
            noticeService.deleteNotice(notice);
            return "redirect:/Notice/NoticeList";
        }
    }
