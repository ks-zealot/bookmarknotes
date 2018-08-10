package org.bookmarknotes.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by zealot on 08.08.18.
 */
@Getter
@Setter
@NoArgsConstructor
public class NoteDTO {
    public Long id;
    public String note;
}
