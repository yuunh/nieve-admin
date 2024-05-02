package com.admin.repository;

import com.admin.entity.MemberEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberRepositoryTest {

    @Autowired private MemberRepository memberRepository;

    @Test
    public void testFindAll() {

        List<MemberEntity> memberList = memberRepository.findAll();

        System.out.println(memberList);
    }

    @Test
    public void testSave() {
        MemberEntity me = MemberEntity.builder()
                .memEmail("djfd@com").memName("홍길동").phone("010-4565-8522")
                .build();
        memberRepository.save(me);
    }

    @Test
    public void testFindMember(){
        MemberEntity e = memberRepository.findMember(5);
        System.out.println(e);
    }

}