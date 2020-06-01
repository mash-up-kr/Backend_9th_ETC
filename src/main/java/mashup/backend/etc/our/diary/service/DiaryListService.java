package mashup.backend.etc.our.diary.service;

import lombok.RequiredArgsConstructor;
import mashup.backend.etc.our.diary.dto.ReqDiaryListDto;
import mashup.backend.etc.our.diary.dto.ResDiaryDto;
import mashup.backend.etc.our.diary.dto.ResDiaryListDto;
import mashup.backend.etc.our.diary.repository.DiaryRepository;
import mashup.backend.etc.our.group.entity.Group;
import mashup.backend.etc.our.group.entity.UserGroup;
import mashup.backend.etc.our.group.repository.GroupRepository;
import mashup.backend.etc.our.group.repository.UserGroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DiaryListService {
    private final DiaryRepository diaryRepository;
    private final GroupRepository groupRepository;
    private final UserGroupRepository userGroupRepository;

    @Transactional(readOnly=true)
    public ResDiaryListDto readDiaryList(ReqDiaryListDto reqDiaryListDto){

        UserGroup userGroup = userGroupRepository.findUserGroupByGroupIdAndUserId(reqDiaryListDto.getGroupId(),reqDiaryListDto.getUserId())
                            .orElseThrow(NoResultException::new); // user가 groupId를 가지고 있지 않는 경우

        Long groupId = userGroup.getGroupId();

        List<ResDiaryDto> diaryList = diaryRepository.findDiariesByGroupId(groupId).stream()
                .map(ResDiaryDto::new)
                .collect(Collectors.toList());

        Group foundGroup = groupRepository.findById(groupId)
                .orElseThrow(()->new IllegalArgumentException("해당 그룹이 없습니다"));

        return ResDiaryListDto.builder()
                .groupCode(foundGroup.getCode())
                .diaries(diaryList)
                .build();
    }
}
