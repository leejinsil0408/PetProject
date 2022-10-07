package com.example.petproject01.Controller;

import com.example.petproject01.entity.Reply;
import com.example.petproject01.service.NoticeService;
import com.example.petproject01.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping("/insertReply")
    public String insertReply(@PathVariable Long noticeId, @RequestBody Reply reply) {
        replyService.insertReply(noticeId, reply);
        return "redirect:/Notice/getNotice";
    }

    @GetMapping("/deleteReply")
    public String deleteReply(Reply reply) {
        replyService.deleteReply(reply);
        return "redirect:/Notice/getNotice";
    }


    @PostMapping("/updateReply")
    public String updateReply(Reply reply) {
        replyService.updateReply(reply);

        return "redirect:/Notice/getNotice";
    }
}
