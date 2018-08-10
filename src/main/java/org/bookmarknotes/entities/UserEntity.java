package org.bookmarknotes.entities;

import lombok.*;

import javax.persistence.*;

/**
 * Created by zealot on 08.08.18.
 */
@Entity(name = "Customer")
@Table(name = "user_t")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "user_Sequence")
    @SequenceGenerator(name = "user_Sequence", sequenceName = "USER_SEQ")
    private Long id;
    @Column
    private String login;
    @Column
    private String password;

}
