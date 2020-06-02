package mashup.backend.etc.our.diary.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ReqDiaryListDto {
    private Long userId;
    private Long groupId;

    @Builder
    public ReqDiaryListDto(Long userId, Long groupId){
        this.userId = userId;
        this.groupId = groupId;
    }
}
