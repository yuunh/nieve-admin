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

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/member/edit.html")
    public String memberEdit(@RequestParam(value = "memNo", required = false) int memNo, Model m) {

        Member member = memberService.getMember(memNo);

        m.addAttribute("member", member);

        return "memberUpdate";
    }

    @GetMapping("/memberList")
    public String memberUpdate(@ModelAttribute Member member) {

        memberService.getMemberList();

        return "redirect:/memberList.html";
    }

    @PostMapping("/member")
    public String updateMember(@ModelAttribute Member member) {

        memberService.updateMember(member);

        return "redirect:/memberList.html";
    }
}
