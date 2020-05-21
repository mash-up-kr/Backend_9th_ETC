package mashup.backend.etc.our.group.entity;

<<<<<<< HEAD
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mashup.backend.etc.our.common.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "GROUP_TABLE")
public class Group extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    @Column(length = 45, nullable = false)
    private String name;

    @Column(length = 45, nullable = false)
    private String code;

    @Builder
    public Group(String name, String code) {
        this.name = name;
        this.code = code;
    }
=======
public class Group {
>>>>>>> 02a07f3... [#6] Chore : 패키지 구조 설계
}
