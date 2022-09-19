package com.example.petproject01.Controller;

import com.example.petproject01.entity.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.petproject01.service.NoticeService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/NoticeList")
    public String NoticeList(Model model, Notice notice) {
        List<Notice> noticeList = noticeService.NoticeList();

        model.addAttribute("noticeList", noticeList);
        return "NoticeList";
    }


}
