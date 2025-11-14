package mzc.study.blog_be.repository.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mzc.study.blog_be.domain.post.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long>{

}
