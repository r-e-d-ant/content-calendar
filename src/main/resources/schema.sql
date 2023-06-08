CREATE TABLE IF NOT EXISTS Content (
    id INTEGER AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    description TEXT,
    status VARCHAR(20) NOT NULL,
    content_type VARCHAR(50) NOT NULL,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    url VARCHAR(255),
    PRIMARY KEY (id)
);

INSERT INTO Content(title, description, status, content_type, date_created)
VALUES('1st blog post', 'my 1st blog post', 'IDEA', 'ARTICLE', CURRENT_TIMESTAMP);
INSERT INTO Content(title, description, status, content_type, date_created)
VALUES('2nd blog post', 'my 2nd blog post', 'IN_PROGRESS', 'VIDEO', CURRENT_TIMESTAMP);
INSERT INTO Content(title, description, status, content_type, date_created)
VALUES('3rd blog post', 'my 3rd blog post', 'COMPLETED', 'COURSE', CURRENT_TIMESTAMP);
INSERT INTO Content(title, description, status, content_type, date_created)
VALUES('4th blog post', 'my 4th blog post', 'PUBLISHED', 'CONFERENCE_TALK', CURRENT_TIMESTAMP);
INSERT INTO Content(title, description, status, content_type, date_created)
VALUES('5th blog post', 'my 5th blog post', 'IDEA', 'ARTICLE', CURRENT_TIMESTAMP);
