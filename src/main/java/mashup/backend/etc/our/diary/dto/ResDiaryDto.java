package mashup.backend.etc.our.diary.dto;

import lombok.Getter;
import mashup.backend.etc.our.diary.entity.Diary;

import java.time.LocalDateTime;

@Getter
public class ResDiaryDto {
    private Long diaryId;
    private String title;
    private Long writerId;
    private LocalDateTime createTime;

    public ResDiaryDto(Diary entity) {
        this.diaryId = entity.getDiaryId();
        this.title = entity.getTitle();
        this.writerId = entity.getWriterId();
        this.createTime = entity.getCreateTime();
    }
}
