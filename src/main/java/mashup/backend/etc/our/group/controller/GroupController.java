package mashup.backend.etc.our.group.controller;

import lombok.RequiredArgsConstructor;
import mashup.backend.etc.our.group.dto.ReqMakeGroupDto;
import mashup.backend.etc.our.group.dto.ResGroupListDto;
import mashup.backend.etc.our.group.dto.ResMakeGroupDto;
import mashup.backend.etc.our.group.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;;

@RequiredArgsConstructor
@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;

    @GetMapping
    public ResponseEntity<ResGroupListDto> readGroupList(@RequestParam Long userId) {
        if(userId==null) /* 인증 관련 코드 추가 해야함 */
            return new ResponseEntity("접근 권한 없음", HttpStatus.UNAUTHORIZED);
        return ResponseEntity.status(HttpStatus.OK).body(groupService.readGroupList(userId));
    }

    @PostMapping("/group")
    public ResponseEntity<ResMakeGroupDto> makeGroup(@RequestBody ReqMakeGroupDto reqMakeGroupDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(groupService.makeGroup(reqMakeGroupDto));
    }
}
