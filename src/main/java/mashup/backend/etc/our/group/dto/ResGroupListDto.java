package mashup.backend.etc.our.group.dto;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
public class ResGroupListDto {
>>>>>>> 02a07f3... [#6] Chore : 패키지 구조 설계
=======
public class ResGroupListDto {
>>>>>>> 01d2806... [#6] Chore : 패키지 구조 설계 (#13)
=======
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
>>>>>>> df4cf72... [#9] Feat : Group 리스트 조회 기능 추가
}
