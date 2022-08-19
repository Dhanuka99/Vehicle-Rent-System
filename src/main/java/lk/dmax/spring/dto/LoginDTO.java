package lk.dmax.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginDTO {

    private String usernic;
    private String userName;
    private String password;
    private String userStatus;
}
