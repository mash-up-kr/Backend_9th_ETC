package mashup.backend.etc.our.diary.dto;

import lombok.Getter;
import mashup.backend.etc.our.diary.domain.entity.Diary;

import java.time.LocalDateTime;

@Getter
public class ResReadDiaryDto {
    private Long diaryId;
    private String title;
    private Long writerId;
    private LocalDateTime createTime;

    public ResReadDiaryDto(Diary entity) {
        this.diaryId = entity.getDiaryId();
        this.title = entity.getTitle();
        this.writerId = entity.getWriterId();
        this.createTime = entity.getCreateTime();
    }
}
