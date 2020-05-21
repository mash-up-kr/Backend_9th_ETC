package mashup.backend.etc.our.group.dto;

import lombok.Getter;
import mashup.backend.etc.our.group.entity.Group;

@Getter
public class ResGroupListDto {
    private Long groupId;
    private String groupName;

    public ResGroupListDto(Group entity) {
        this.groupId = entity.getGroupId();
        this.groupName = entity.getName();
    }
}
