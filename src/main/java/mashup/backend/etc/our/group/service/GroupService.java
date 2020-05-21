package mashup.backend.etc.our.group.service;

<<<<<<< HEAD
import lombok.RequiredArgsConstructor;
import mashup.backend.etc.our.group.dto.ResGroupDto;
import mashup.backend.etc.our.group.dto.ResGroupListDto;
import mashup.backend.etc.our.group.repository.GroupRepository;
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

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
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
=======
public class GroupService {
>>>>>>> 02a07f3... [#6] Chore : 패키지 구조 설계
}
