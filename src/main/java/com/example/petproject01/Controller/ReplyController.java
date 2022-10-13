package com.example.petproject01.Controller;

import com.example.petproject01.entity.Notice;
import com.example.petproject01.entity.Reply;
import com.example.petproject01.service.NoticeService;
import com.example.petproject01.service.ReplyService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/Reply")
@RequiredArgsConstructor
@Controller
@Setter
@Getter
public class ReplyController {

    //    @Autowired
    private final NoticeService noticeService;
    private final ReplyService replyService;


    //댓글 등록
    @PostMapping("/insertReply/{seq}")
    public String insertReply(Model model, @PathVariable("seq") Long seq, @RequestParam String r_content) {
        Notice notice = this.noticeService.getNotice1(seq);
        this.replyService.insertReply(notice, r_content);
        return String.format("redirect:/Notice/getNotice?seq=" + seq);
    }

//    //댓글 수정
//    @PostMapping("/updateReply")
//    public String updateReply(Reply reply) {
//        replyService.updateReply(reply);
//        return "redirect:/Notice/getReply?seq=" + reply.getR_seq();
//    }

    //댓글 수정
//    @GetMapping("/modify/{r_seq}")
//    public String replyModify(Reply reply, Model model) {
//        model.addAttribute("reply", replyService.getReply(reply.getR_seq()));
//        return "Reply/replyForm";
//    }

    @GetMapping("")
    @PostMapping("/modify/{r_seq}")
    public String replyModify(Reply reply) {
        replyService.replyModify(reply, reply.getR_content());
        return String.format("redirect:/Notice/getNotice/%s", reply.getNotice().getSeq());
    }
}
//    @GetMapping("/updateReply/{r_seq}")
//    public String updateReplyView(Reply reply, Model model) {
//        model.addAttribute("reply", replyService.getReply(reply));
//        return "/Notice/getReply";
//    }

//        //댓글 삭제
//        @GetMapping("/deleteReply")
//        public String deleteReply(Reply reply){
//            replyService.deleteReply(reply);
//            return "redirect:/Notice/getNotice";
//        }
//    }

//    @PostMapping ("/updateReply/{r_seq}")
//    public String updateReply(ReplyForm replyForm, @PathVariable("r_seq") Long r_seq) {
//        Reply reply = this.replyService.getReply(r_seq);
//        replyForm.setR_content(reply.getR_content());
//        return  "reply_form";


//    @GetMapping("/deleteReply/{seq}")
//    public String deleteReply(Reply reply) {
//        replyService.deleteReply(reply);
//        return String.format("redirect:/Notice/getNotice", reply.getNotice().getSeq());
//    }

//    @PostMapping("/updateReply/{r_seq}")
//    public String updateReply(ReplyForm replyForm) {
//        Reply reply = this.replyService.getReply(r_seq);
//        this.replyService.updateReply(reply, replyForm.getR_Content);
//        return String.format("redirect:/getNotice",reply.getReply().getR_seq());
//    }

//    @GetMapping("/updateReply/{r_seq}")
//    public String updateReply(@PathVariable("seq") Long seq, Reply reply, @RequestParam String r_content) {
//        Notice notice = this.noticeService.getNotice1(seq);
//        replyService.updateReply(reply, r_content);
//        return "redirect:/Notice/getNotice?=seq" + reply.getR_seq();
//    }

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

