package com.admin.ctrl;

import com.admin.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    @GetMapping("/member/edit.html")
    public String memberEdit(@RequestParam(value = "memNo", required = false) int memNo, Model m) {
        Member member = new Member();
        m.addAttribute("member", member);
        return "memberUpdate";
    }

}
