package com.r_e_d_ant.contentcalendar.model;
import java.time.LocalDateTime;

//@Table(value="tbl_content")
public record Content(
//        @Id
        Integer id,
//        @NotBlank
        String title,
        String desc,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {
}
