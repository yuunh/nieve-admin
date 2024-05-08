package com.admin.ctrl;

import com.admin.model.Member;
import com.admin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/member/edit.html")
    public String memberEdit(@RequestParam("memNo") int memNo, Model model) {
        Member member = memberService.getMember(memNo);
        model.addAttribute("member", member);
        return "memberUpdate";
    }

    @GetMapping("/memberList")
    public String memberList(Model model) {
        List<Member> memberList = memberService.getMemberList();
        model.addAttribute("memberList", memberList);
        return "memberList";
    }

    @PostMapping("/updateMember")
    public String updateMember(@ModelAttribute Member member) {
        memberService.updateMember(member);
        return "redirect:/memberList";
    }
}
