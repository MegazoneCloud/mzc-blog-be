package mzc.study.blog_be.domain.post;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mzc.study.blog_be.domain.user.UserEntity;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private Long id;
    private String title;
    private String content;
    @ManyToOne( fetch=FetchType.LAZY )
    @JoinColumn( name="writer_id" )
    private UserEntity writer;
    @Column( name="created_at" )
    private LocalDateTime createdAt;

    // 연관 관계 필드
    @OneToMany( fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="post" )
    private List<AttatchmentEntity> attatchments;

    // 연관 관계 메서드

}
