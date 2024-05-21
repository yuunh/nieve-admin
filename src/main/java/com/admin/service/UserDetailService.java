package com.admin.service;

import com.admin.config.CustomUser;
import com.admin.entity.MemberEntity;
import com.admin.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Example<? extends MemberEntity> example = Example.of(MemberEntity.builder().memEmail(username).build());
        MemberEntity entity = memberRepository.findBy(example, FluentQuery.FetchableFluentQuery::first).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        return toUserDetails(entity);
    }

    private UserDetails toUserDetails(MemberEntity entity) {
        List<GrantedAuthority> auths = new ArrayList<>();
        auths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        auths.add(new SimpleGrantedAuthority("ROLL_USER"));
        return new CustomUser(entity.getMemEmail(), entity.getMemPwd(), entity.getMemNo(), auths);
    }

}
