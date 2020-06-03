package mashup.backend.etc.our.diary.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mashup.backend.etc.our.common.domain.BaseTimeEntity;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@DynamicUpdate
public class Diary extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long diaryId;

    private Long writerId;

    private Long groupId;

    private String title;

    private String contents;

    @Builder
    public Diary (Long diaryId, Long writerId, Long groupId, String title, String contents){
        this.diaryId = diaryId;
        this.writerId = writerId;
        this.groupId = groupId;
        this.title = title;
        this.contents = contents;
    }

    public void update(String title, String contents){
        this.title = title;
        this.contents = contents;
    }
}
