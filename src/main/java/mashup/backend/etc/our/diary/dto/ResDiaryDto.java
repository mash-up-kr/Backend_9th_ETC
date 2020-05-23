package mashup.backend.etc.our.diary.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class ResDiaryDto {
    private Long diaryId;
    private String title;
    private Long writerId;
    private LocalDateTime createTime;

    public ResDiaryDto(ResDiaryDto resDiaryDto) {
        this.diaryId = resDiaryDto.getDiaryId();
        this.title = resDiaryDto.getTitle();
        this.writerId = resDiaryDto.getWriterId();
        this.createTime = resDiaryDto.getCreateTime();
    }
}
