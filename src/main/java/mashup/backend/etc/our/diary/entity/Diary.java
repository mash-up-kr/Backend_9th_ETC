package mashup.backend.etc.our.diary.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long diaryId;

    private long writerId;

    private long groupId;

    private String title;

    private String contents;

}
