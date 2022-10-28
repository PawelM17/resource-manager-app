CREATE TABLE users
(
    id            BIGINT NOT NULL,
    created_date  TIMESTAMP WITHOUT TIME ZONE,
    modified_date TIMESTAMP WITHOUT TIME ZONE,
    name          VARCHAR(255),
    first_name    VARCHAR(255),
    last_name     VARCHAR(255),
    user_type     VARCHAR(255),
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE resources
(
    id            BIGINT NOT NULL,
    created_date  TIMESTAMP WITHOUT TIME ZONE,
    modified_date TIMESTAMP WITHOUT TIME ZONE,
    name          VARCHAR(255),
    resource_type VARCHAR(255),
    user_id       BIGINT,
    json_data     JSONB,
    CONSTRAINT pk_resources PRIMARY KEY (id)
);

ALTER TABLE resources
    ADD CONSTRAINT FK_RESOURCES_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);



