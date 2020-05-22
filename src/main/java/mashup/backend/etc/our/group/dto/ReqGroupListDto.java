package mashup.backend.etc.our.group.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReqGroupListDto {
    private Long userId;

    @Builder
    public ReqGroupListDto(Long userId) {
        this.userId = userId;
    }
}
