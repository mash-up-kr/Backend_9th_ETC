package mashup.backend.etc.our.diary.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReqDeleteDiaryDto {
    private Long userId;
    private Long groupId;
}
