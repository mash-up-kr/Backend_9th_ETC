package mashup.backend.etc.our.group.service;

import lombok.RequiredArgsConstructor;
import mashup.backend.etc.our.group.dto.ResGroupListDto;
import mashup.backend.etc.our.group.repository.GroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GroupService {
    private GroupRepository groupRepository;

    @Transactional(readOnly = true)
    public List<ResGroupListDto> readGroupList() {
        return groupRepository.readGroupList().stream()
                .map(ResGroupListDto::new)
                .collect(Collectors.toList());
    }
}
