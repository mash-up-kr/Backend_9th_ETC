package mashup.backend.etc.our.group.entity;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> df4cf72... [#9] Feat : Group 리스트 조회 기능 추가
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mashup.backend.etc.our.common.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
<<<<<<< HEAD
<<<<<<< HEAD
@Table(name = "GROUP_TABLE")
=======
>>>>>>> df4cf72... [#9] Feat : Group 리스트 조회 기능 추가
=======
@Table(name = "GROUP_TABLE")
>>>>>>> 4ca5ea6... [#9] Feat : Group 리스트 조회 기능 추가
public class Group extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    @Column(length = 45, nullable = false)
    private String name;

    @Column(length = 45, nullable = false)
    private String code;

    @Builder
<<<<<<< HEAD
<<<<<<< HEAD
    public Group(String name, String code) {
        this.name = name;
        this.code = code;
    }
=======
public class Group {
>>>>>>> 02a07f3... [#6] Chore : 패키지 구조 설계
=======
public class Group {
>>>>>>> 01d2806... [#6] Chore : 패키지 구조 설계 (#13)
=======
    public Group(String name) {
=======
    public Group(String name, String code) {
>>>>>>> 4ca5ea6... [#9] Feat : Group 리스트 조회 기능 추가
        this.name = name;
        this.code = code;
    }
>>>>>>> df4cf72... [#9] Feat : Group 리스트 조회 기능 추가
}
