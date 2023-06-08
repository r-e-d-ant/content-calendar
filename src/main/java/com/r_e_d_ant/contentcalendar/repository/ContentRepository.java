package com.r_e_d_ant.contentcalendar.repository;

import com.r_e_d_ant.contentcalendar.model.Content;
import com.r_e_d_ant.contentcalendar.model.Status;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
    // search by title
    List<Content> findAllByTitleContains(String keyword);
    // search by status
    @Query("""
            SELECT * FROM Content
            WHERE status = :status
            """)
    List<Content> listByStatus(@Param("status") Status status);
}
