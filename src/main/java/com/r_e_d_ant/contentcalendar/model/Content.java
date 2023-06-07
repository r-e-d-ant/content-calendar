package com.r_e_d_ant.contentcalendar.model;

import java.time.LocalDateTime;

public record Content(
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
