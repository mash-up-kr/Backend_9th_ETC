package mashup.backend.etc.our.group.service;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
import mashup.backend.etc.our.group.dto.ResGroupDto;
=======
import mashup.backend.etc.our.group.dto.ReqGroupListDto;
>>>>>>> 4ca5ea6... [#9] Feat : Group 리스트 조회 기능 추가
import mashup.backend.etc.our.group.dto.ResGroupListDto;
import mashup.backend.etc.our.group.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
=======
import lombok.RequiredArgsConstructor;
import mashup.backend.etc.our.group.dto.ResGroupListDto;
import mashup.backend.etc.our.group.repository.GroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

>>>>>>> df4cf72... [#9] Feat : Group 리스트 조회 기능 추가
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
<<<<<<< HEAD
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
=======
public class GroupService {
>>>>>>> 01d2806... [#6] Chore : 패키지 구조 설계 (#13)
=======
public class GroupService {
    private GroupRepository groupRepository;

    @Transactional(readOnly = true)
    public List<ResGroupListDto> readGroupList(ReqGroupListDto reqGroupListDto) {
        return groupRepository.readGroupList(reqGroupListDto.getUserId()).stream()
                .map(ResGroupListDto::new)
                .collect(Collectors.toList());
    }
>>>>>>> df4cf72... [#9] Feat : Group 리스트 조회 기능 추가
}
