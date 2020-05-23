package mashup.backend.etc.our.group.service;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
import mashup.backend.etc.our.common.util.RandomCode;
import mashup.backend.etc.our.group.dto.ReqMakeGroupDto;
>>>>>>> 139e4af... [#10] Group 생성 API 추가
import mashup.backend.etc.our.group.dto.ResGroupDto;
=======
import mashup.backend.etc.our.group.dto.ReqGroupListDto;
>>>>>>> 4ca5ea6... [#9] Feat : Group 리스트 조회 기능 추가
=======
import mashup.backend.etc.our.group.dto.ResGroupDto;
>>>>>>> 7095dd2... [#9] Fix : Group 리스트 조회 API 수정
import mashup.backend.etc.our.group.dto.ResGroupListDto;
import mashup.backend.etc.our.group.dto.ResMakeGroupDto;
import mashup.backend.etc.our.group.entity.Group;
import mashup.backend.etc.our.group.entity.UserGroup;
import mashup.backend.etc.our.group.repository.GroupRepository;
import mashup.backend.etc.our.group.repository.UserGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
<<<<<<< HEAD
=======
import lombok.RequiredArgsConstructor;
import mashup.backend.etc.our.group.dto.ResGroupListDto;
import mashup.backend.etc.our.group.repository.GroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

>>>>>>> df4cf72... [#9] Feat : Group 리스트 조회 기능 추가
=======
import lombok.RequiredArgsConstructor;
import mashup.backend.etc.our.group.dto.ReqGroupListDto;
import mashup.backend.etc.our.group.dto.ResGroupListDto;
import mashup.backend.etc.our.group.repository.GroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

>>>>>>> a8f6066... Group 리스트 조회 API (#14)
=======
>>>>>>> 7095dd2... [#9] Fix : Group 리스트 조회 API 수정
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
<<<<<<< HEAD
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
=======
public class GroupService {
>>>>>>> a8f6066... Group 리스트 조회 API (#14)
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
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> df4cf72... [#9] Feat : Group 리스트 조회 기능 추가
=======
>>>>>>> a8f6066... Group 리스트 조회 API (#14)
=======

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
>>>>>>> 139e4af... [#10] Group 생성 API 추가
}
