package mashup.backend.etc.our.group.controller;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 4ca5ea6... [#9] Feat : Group 리스트 조회 기능 추가
=======
>>>>>>> a8f6066... Group 리스트 조회 API (#14)
import mashup.backend.etc.our.group.dto.ReqGroupListDto;
import mashup.backend.etc.our.group.dto.ResGroupListDto;
import mashup.backend.etc.our.group.entity.Group;
=======
>>>>>>> 139e4af... [#10] Group 생성 API 추가
=======
>>>>>>> e3d23f6597d1e76653947e6a256fd58a7c16e4a5
import mashup.backend.etc.our.group.repository.GroupRepository;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
public class GroupControllerTest {
=======
public class GroupControllerTest {
>>>>>>> a8f6066... Group 리스트 조회 API (#14)
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
<<<<<<< HEAD
>>>>>>> 4ca5ea6... [#9] Feat : Group 리스트 조회 기능 추가
=======
>>>>>>> a8f6066... Group 리스트 조회 API (#14)
}
