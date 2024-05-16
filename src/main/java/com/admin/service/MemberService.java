package com.admin.service;

import com.admin.entity.MemberEntity;
import com.admin.entity.ProductEntity;
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


    public Member getMember(int memNo) {
        MemberEntity me = memberRepository.findById(memNo).orElseThrow();
        Member m = Member.builder()
                .memNo(me.getMemNo())
                .memName(me.getMemName())
                .memEmail(me.getMemEmail())
                .phone(me.getPhone())
                .address1(me.getAddress1())
                .build();
        return m;
    }

    public List<Member> getMemberList() {
        List<MemberEntity> memberList = memberRepository.findAll();

        List<Member> members = new ArrayList<>();
        for (MemberEntity me : memberList) {
            Member m = Member.builder()
                    .memNo(me.getMemNo())
                    .memEmail(me.getMemEmail())
                    .memName(me.getMemName())
                    .enrollDate(me.getEnrollDate())
                    .memState(me.getMemState())
                    .build();
            members.add(m);
        }

        return members;
    }

    public void updateMember(Member member) {
        MemberEntity memberEntity = memberRepository.findById(member.getMemNo()).orElseThrow();
        memberEntity.setMemEmail(member.getMemEmail());
        memberEntity.setPhone(member.getPhone());
        memberEntity.setAddress1(member.getAddress1());
        memberRepository.save(memberEntity);
    }

    public void deleteMembers(Integer memberNo) {

        MemberEntity memberEntity = memberRepository.findById(memberNo).orElseThrow();
        memberEntity.setMemState("N");
        memberRepository.save(memberEntity);
    }
}
