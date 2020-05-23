package mashup.backend.etc.our.diary.entity;

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

}
