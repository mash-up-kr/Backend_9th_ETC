package mashup.backend.etc.our.group.controller;

<<<<<<< HEAD
<<<<<<< HEAD
import mashup.backend.etc.our.group.dto.ReqGroupListDto;
import mashup.backend.etc.our.group.dto.ResGroupListDto;
import mashup.backend.etc.our.group.entity.Group;
import mashup.backend.etc.our.group.repository.GroupRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GroupControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private GroupRepository groupRepository;

    @After
    public void cleanup() throws Exception {
        groupRepository.deleteAll();
    }
=======
public class GroupControllerTest {
>>>>>>> 02a07f3... [#6] Chore : 패키지 구조 설계
=======
public class GroupControllerTest {
>>>>>>> 01d2806... [#6] Chore : 패키지 구조 설계 (#13)
}
