package mashup.backend.etc.our.group.controller;

import lombok.RequiredArgsConstructor;
import mashup.backend.etc.our.group.dto.ReqGroupListDto;
import mashup.backend.etc.our.group.dto.ResGroupListDto;
import mashup.backend.etc.our.group.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ResGroupListDto> readGroupList(@RequestBody ReqGroupListDto reqGroupListDto) {
        return groupService.readGroupList(reqGroupListDto);
    }
}
