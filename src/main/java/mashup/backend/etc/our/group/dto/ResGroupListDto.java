package mashup.backend.etc.our.group.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ResGroupListDto {
    private List<ResGroupDto> groupList;

    @Builder
    public ResGroupListDto(List<ResGroupDto> groupList) {
        this.groupList = groupList;
    }
}
