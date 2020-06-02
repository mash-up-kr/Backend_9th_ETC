package mashup.backend.etc.our.group.service;

import lombok.RequiredArgsConstructor;
import mashup.backend.etc.our.common.util.RandomCode;
import mashup.backend.etc.our.group.dto.ReqMakeGroupDto;
import mashup.backend.etc.our.group.dto.ResGroupDto;
import mashup.backend.etc.our.group.dto.ResGroupListDto;
import mashup.backend.etc.our.group.dto.ResMakeGroupDto;
import mashup.backend.etc.our.group.entity.Group;
import mashup.backend.etc.our.group.entity.UserGroup;
import mashup.backend.etc.our.group.repository.GroupRepository;
import mashup.backend.etc.our.group.repository.UserGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GroupService {
    private GroupRepository groupRepository;
    private UserGroupRepository userGroupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository, UserGroupRepository userGroupRepository) {
        this.groupRepository = groupRepository;
        this.userGroupRepository = userGroupRepository;
    }

    @Transactional(readOnly = true)
    public ResGroupListDto readGroupList(Long userId) {
        List<ResGroupDto> groups = groupRepository.findGroupsByUserId(userId);

        if(groups.isEmpty()) {
            return ResGroupListDto.builder()
                    .groupList(new ArrayList<>())
                    .build();
        }
        List<ResGroupDto> resGroupDtos = groups.stream().collect(Collectors.toList());
        return ResGroupListDto.builder()
                .groupList(resGroupDtos)
                .build();
    }

    @Transactional(readOnly = true)
    public ResMakeGroupDto makeGroup(ReqMakeGroupDto reqMakeGroupDto) {
        String code;
        /* 랜덤 코드 발생 */
        while(true) {
            code = RandomCode.generateRandomCode();
            if(groupRepository.findGroupIdByCode(code)==null) {
                break;
            }
        }

        Group group = Group.builder()
                .name(reqMakeGroupDto.getGroupName())
                .code(code)
                .build();

        group = groupRepository.save(group);

        UserGroup userGroup = UserGroup.builder()
                .userId(reqMakeGroupDto.getUserId())
                .groupId(group.getGroupId())
                .build();

        userGroupRepository.save(userGroup);

        List<ResGroupDto> groups = groupRepository.findGroupsByUserId(reqMakeGroupDto.getUserId());
        return ResMakeGroupDto.builder()
                .message("그룹이 생성되었습니다.")
                .groupList(groups.stream().collect(Collectors.toList()))
                .build();
    }
}
