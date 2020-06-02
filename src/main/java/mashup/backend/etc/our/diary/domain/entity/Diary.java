package mashup.backend.etc.our.diary.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mashup.backend.etc.our.common.domain.BaseTimeEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Diary extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long diaryId;

    private long writerId;

    private long groupId;

    private String title;

    private String contents;

    @Builder
    public Diary (long diaryId, long groupId, String title, String contents){
        this.diaryId = diaryId;
        this.groupId = groupId;
        this.title = title;
        this.contents = contents;
    }

}
