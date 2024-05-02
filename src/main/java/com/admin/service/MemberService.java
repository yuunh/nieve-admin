package com.admin.service;

import com.admin.entity.MemberEntity;
import com.admin.model.Member;
import com.admin.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getMemberList() {
        List<MemberEntity> memberList = memberRepository.findAll();

        List<Member> members = new ArrayList<>();
        for (MemberEntity me : memberList) {
            Member m = Member.builder()
                    .memNo(me.getMemNo())
                    .memEmail(me.getMemEmail())
                    .memName(me.getMemName())
                    .enrollDate(me.getEnrollDate())
                    .build();
            members.add(m);
        }

        return members;
    }
}
