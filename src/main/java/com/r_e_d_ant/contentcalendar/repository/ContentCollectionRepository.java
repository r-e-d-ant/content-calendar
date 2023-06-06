package com.r_e_d_ant.contentcalendar.repository;

import com.r_e_d_ant.contentcalendar.model.Content;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ContentCollectionRepository {
    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return content;
    }

    public Optional<Content> findById(Integer id) {
        return content.stream().filter(c -> c.id().equals(id)).findFirst();
    }
}
