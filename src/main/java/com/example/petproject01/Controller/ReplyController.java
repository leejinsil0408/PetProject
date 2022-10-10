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

@RequestMapping("/Notice")
@RequiredArgsConstructor
//@RestController
@Controller
public class ReplyController {

//    @Autowired
    private final ReplyService replyService;
    private final NoticeService noticeService;

    @PostMapping("/create/{seq}")
    public String createReply(Model model, @PathVariable("seq") Long seq, @RequestParam String content) {
        Notice notice = this.noticeService.getNotice1(seq);
        this.replyService.create(notice, content);
        return String.format("redirect:/Notice/getNotice/%s", seq);
    }
}
//    @PostMapping("/insertReply")
//    public String insertReply(@PathVariable Long seq, @RequestBody Reply reply) {
//        replyService.insertReply(seq, reply);
//        return "redirect:/Notice/getNotice";
//    }
//
//    @GetMapping("/deleteReply")
//    public String deleteReply(Reply reply) {
//        replyService.deleteReply(reply);
//        return "redirect:/Notice/getNotice";
//    }
//
//
//    @PostMapping("/updateReply")
//    public String updateReply(Reply reply) {
//        replyService.updateReply(reply);
//
//        return "redirect:/Notice/getNotice";
//    }
