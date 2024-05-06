package com.admin.service;

import com.admin.entity.MemberEntity;
import com.admin.model.Member;
import com.admin.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Member getMember(int memNo) {
        MemberEntity me = memberRepository.findById(memNo).orElseThrow();
        Member m = Member.builder()
                .memName(me.getMemName())
                .memEmail(me.getMemEmail())
                .phone(me.getPhone())
                .address1(me.getAddress1())
                .build();
        return m;
    }

    public void updateMember(Member member) {

        Optional<MemberEntity> updateMember = memberRepository.findById(member.getMemNo());

        updateMember.ifPresent(memberUpdate -> {
            memberUpdate.setMemName(member.getMemName());
            memberUpdate.setMemEmail(member.getMemEmail());
            memberUpdate.setPhone(member.getPhone());
            memberUpdate.setAddress1(member.getAddress1());

            memberRepository.save(memberUpdate);
        });
    }
}
