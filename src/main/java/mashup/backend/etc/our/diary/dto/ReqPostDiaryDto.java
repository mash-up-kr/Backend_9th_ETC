package mashup.backend.etc.our.diary.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mashup.backend.etc.our.diary.domain.entity.Diary;

@Getter
@NoArgsConstructor
public class ReqPostDiaryDto {
    private Long userId;
    private Long groupId;
    private String title;
    private String contents;

    @Builder
    public ReqPostDiaryDto(Long groupId, String title, String contents){
        this.groupId = groupId;
        this.title = title;
        this.contents = contents;
    }

    public Diary toEntity(){
        return Diary.builder()
                .groupId(groupId)
                .writerId(userId)
                .title(title)
                .contents(contents)
                .build();
    }
}
