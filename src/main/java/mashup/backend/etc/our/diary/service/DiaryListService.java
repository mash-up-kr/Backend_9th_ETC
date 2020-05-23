package mashup.backend.etc.our.diary.service;

import lombok.RequiredArgsConstructor;
import mashup.backend.etc.our.diary.dto.ReqDiaryListDto;
import mashup.backend.etc.our.diary.dto.ResDiaryDto;
import mashup.backend.etc.our.diary.dto.ResDiaryListDto;
import mashup.backend.etc.our.diary.entity.Diary;
import mashup.backend.etc.our.diary.repository.DiaryRepository;
import mashup.backend.etc.our.group.entity.Group;
import mashup.backend.etc.our.group.repository.GroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DiaryListService {
    private final DiaryRepository diaryRepository;
    private final GroupRepository groupRepository;

    @Transactional(readOnly=true)
    public ResDiaryListDto readDiaryList(ReqDiaryListDto reqDiaryListDto){

        Long groupId = reqDiaryListDto.getGroupId();
        Long userId = reqDiaryListDto.getUserId();

        List<ResDiaryDto> diaryList = diaryRepository.findDiariesByGroupId(groupId,userId).stream()
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
