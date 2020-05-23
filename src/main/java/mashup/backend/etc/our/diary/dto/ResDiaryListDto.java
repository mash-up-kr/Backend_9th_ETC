package mashup.backend.etc.our.diary.dto;

import lombok.Builder;
import lombok.Getter;
import mashup.backend.etc.our.diary.entity.Diary;

import java.util.List;

@Getter
public class ResDiaryListDto {
    private String groupCode;
    private List<ResDiaryDto> diaries;

    @Builder
    private ResDiaryListDto(String groupCode, List<ResDiaryDto> diaries){
        this.diaries=diaries;
        this.groupCode=groupCode;
    }
}
