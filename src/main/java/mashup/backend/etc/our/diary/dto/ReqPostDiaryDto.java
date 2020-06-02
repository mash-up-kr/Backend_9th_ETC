package mashup.backend.etc.our.diary.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mashup.backend.etc.our.diary.domain.entity.Diary;

@Getter
@NoArgsConstructor
public class ReqPostDiaryDto {
    private long userId;
    private long groupId;
    private String title;
    private String contents;

    @Builder
    public ReqPostDiaryDto(long groupId, String title, String contents){
        this.groupId = groupId;
        this.title = title;
        this.contents = contents;
    }

    public Diary toEntity(){
        return Diary.builder()
                .groupId(groupId)
                .title(title)
                .contents(contents)
                .build();
    }
}
