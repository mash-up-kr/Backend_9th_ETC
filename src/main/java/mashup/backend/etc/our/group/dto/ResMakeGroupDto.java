package mashup.backend.etc.our.group.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ResMakeGroupDto {
    private String message;
    private List<ResGroupDto> groupList;

    @Builder
    public ResMakeGroupDto(String message, List<ResGroupDto> groupList) {
        this.message = message;
        this.groupList = groupList;
    }
}
