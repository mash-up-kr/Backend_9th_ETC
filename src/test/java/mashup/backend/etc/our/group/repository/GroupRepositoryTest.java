package mashup.backend.etc.our.group.repository;

<<<<<<< HEAD
<<<<<<< HEAD
import mashup.backend.etc.our.group.entity.Group;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupRepositoryTest {
    @Autowired
    GroupRepository groupRepository;

    @After
    public void cleanup() {
        groupRepository.deleteAll();
    }
=======
public class GroupRepositoryTest {
>>>>>>> 02a07f3... [#6] Chore : 패키지 구조 설계
=======
public class GroupRepositoryTest {
>>>>>>> 01d2806... [#6] Chore : 패키지 구조 설계 (#13)
}
