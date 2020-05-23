package mashup.backend.etc.our.group.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReqMakeGroupDto {
    @NotNull
    private Long userId;

    @NotNull
    private String groupName;
}
