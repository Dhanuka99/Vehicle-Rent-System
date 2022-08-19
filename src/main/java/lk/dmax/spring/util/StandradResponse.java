package lk.dmax.spring.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandradResponse {
    private String code;
    private String message;
    private Object data;
}
