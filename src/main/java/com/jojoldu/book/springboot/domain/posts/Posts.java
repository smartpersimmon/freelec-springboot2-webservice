package com.jojoldu.book.springboot.domain.posts;

// 서비스 초기 구축 단계에선 테이블 설계(Entity)가 빈번하게 변경되는데, 이 때 롬복의 어노테이션들은 코드 변경량을 최소화시켜 주기 때문에 적극적으로 사용
import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter // 클래스 내 모든 필드의 Getter 메소드를 자동생성
@NoArgsConstructor //기본 생성자 자동추가
@Entity // 테이블과 링크될 클래스임을 나타냄
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IENTITY 옵션을 추가해야 auto_increment가 가능
    private Long id;

    @Column(length = 500, nullable = false) //굳이 선언 안해도 Column으로 처리되는데 옵션을 지정할 경우 선언함. String 기본 크기는 255
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
