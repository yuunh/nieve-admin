package com.admin.repository;

import com.admin.entity.MemberEntity;
import com.admin.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {
    @Query("select u from review as u where u.reviewNo = :rn")
    ReviewEntity findReview(@Param("rn") int reviewNo);

    @Query("select u from review as u where u.reviewState = 'Y'")
    List<ReviewEntity> findAllNotDeleted();
}
