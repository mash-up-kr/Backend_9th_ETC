package mashup.backend.etc.our.group.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mashup.backend.etc.our.common.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Group extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    @Column(length = 45, nullable = false)
    private String name;

    @Column(length = 45, nullable = false)
    private String code;

    @Builder
    public Group(String name) {
        this.name = name;
    }
}
