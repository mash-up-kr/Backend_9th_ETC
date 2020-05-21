package mashup.backend.etc.our.group.controller;

import lombok.RequiredArgsConstructor;
import mashup.backend.etc.our.group.dto.ResGroupListDto;
import mashup.backend.etc.our.group.service.GroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GroupController {
    private final GroupService groupService;

    @GetMapping("/group")
    public List<ResGroupListDto> readGroupList() {
        return groupService.readGroupList();
    }
}
