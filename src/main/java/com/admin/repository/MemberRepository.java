package com.admin.repository;

import com.admin.entity.MemberEntity;
import com.admin.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

    @Query("select u from member as u where u.memNo = :mn")
    MemberEntity findMember(@Param("mn") int memberNo);
}
