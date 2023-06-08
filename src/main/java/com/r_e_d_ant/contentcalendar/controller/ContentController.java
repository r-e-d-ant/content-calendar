package com.r_e_d_ant.contentcalendar.controller;

import com.r_e_d_ant.contentcalendar.model.Content;
import com.r_e_d_ant.contentcalendar.model.Status;
import com.r_e_d_ant.contentcalendar.repository.ContentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {
    private final ContentRepository repository;

    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

    // make a request and find all the  pieces of content in the system
    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    // Create , Read , Update , Delete - filter | paging and sorting
    // Get by a particular content by id
    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) { // @pathVariable will pass the id from the url into this parameter
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found")); // when not found
    }

    // Create
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(/*@Valid ,content need to be valid*/ @RequestBody Content content) { // @RequestBody indicate that it should be bound to the body of the web request.
        repository.save(content);
    }

    // Update
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        repository.save(content);
    }
    // Delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    // -- Filter
    // by Title
    @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword) {
        return repository.findAllByTitleContains(keyword);
    }

    // by Status
    @GetMapping("/filter/status/{status}")
    public List<Content> findByStatus(@PathVariable Status status) {
        return repository.listByStatus(status);
    }
}
