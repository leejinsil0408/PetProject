package com.example.petproject01.Controller;

import com.example.petproject01.entity.Notice;
import com.example.petproject01.entity.Reply;
import com.example.petproject01.service.NoticeService;
import com.example.petproject01.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequestMapping("/reply")
@RequiredArgsConstructor
@Controller
public class ReplyController {

    //    @Autowired
    private final NoticeService noticeService;
    private final ReplyService replyService;

    @PostMapping("/insertReply/{seq}")
    public String insertReply(Model model, @PathVariable("seq") Long seq, @RequestParam String r_content) {
        System.out.println("seq= " + seq + "string= " + r_content);
        Notice notice = this.noticeService.getNotice1(seq);
        this.replyService.insertReply(notice, r_content);
        return String.format("redirect:/Notice/getNotice?seq=" + seq);
    }

    @GetMapping("/updateReply/{seq}")
    public String updateReply(@PathVariable("seq") Long seq, Reply reply, @RequestParam String r_content) {
        Notice notice = this.noticeService.getNotice1(seq);
        replyService.updateReply(reply, r_content);
        return "redirect:/Notice/getNotice?=seq" + reply.getR_seq();
    }

//    @GetMapping("/deleteReply")
//    public String deleteReply(Reply reply) {
//        replyService.deleteReply(reply);
//        return "redirect:/Notice/getNotice";
//    }

//    @PostMapping("/updateReply")
//    public String updateReply(Reply reply) {
//        replyService.updateReply(reply);
//
//        return "redirect:/Notice/getNotice";
//    }

}
