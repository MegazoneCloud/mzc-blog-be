package mzc.study.blog_be.repository.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mzc.study.blog_be.domain.post.AttatchmentEntity;

@Repository
public interface AttachmentRepository extends JpaRepository<AttatchmentEntity, Long>{

}
