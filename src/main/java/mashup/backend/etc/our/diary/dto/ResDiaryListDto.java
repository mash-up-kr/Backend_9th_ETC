package mashup.backend.etc.our.diary.dto;

import lombok.Builder;
import lombok.Getter;
import mashup.backend.etc.our.diary.domain.entity.Diary;

import java.util.List;

@Getter
public class ResDiaryListDto {
    private String groupCode;
    private List<ResReadDiaryDto> diaries;

    @Builder
    public ResDiaryListDto(String groupCode, List<ResReadDiaryDto> diaries){
        this.diaries=diaries;
        this.groupCode=groupCode;
    }
}
