package org.bookmarknotes.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by zealot on 09.08.18.
 */
@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private String login;
    private String password;
}
