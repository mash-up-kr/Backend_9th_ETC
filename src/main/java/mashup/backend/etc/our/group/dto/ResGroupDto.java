package mashup.backend.etc.our.group.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mashup.backend.etc.our.group.entity.Group;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResGroupDto {
    private Long groupId;
    private String groupName;

    public ResGroupDto(Group entity) {
        this.groupId = entity.getGroupId();
        this.groupName = entity.getName();
    }
}
