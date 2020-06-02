package mashup.backend.etc.our.diary.dto;

import lombok.Getter;
import mashup.backend.etc.our.diary.domain.entity.Diary;

import java.time.LocalDateTime;

@Getter
public class ResSingleDiaryDto {
    private Long diaryId;
    private String writerName;
    private String title;
    private String contents;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;


    public ResSingleDiaryDto(Diary entity, String writerName){
        this.diaryId = entity.getDiaryId();
        this.writerName = writerName;
        this.title = entity.getTitle();
        this.contents=entity.getContents();
        this.createTime=entity.getCreateTime();
        this.updateTime=entity.getUpdateTime();
    }
}
