package mzc.study.blog_be.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mzc.study.blog_be.domain.user.UserEntity;

@Repository
public interface  UserRepository extends JpaRepository<UserEntity, Long>{
    
}
