-- Create User table
-- Note: Using BIGSERIAL for auto-incrementing big integers
-- TIMESTAMPTZ is used instead of DATETIME to handle timezone information
CREATE TABLE app_user (  -- Quoted because user is a reserved word in PostgreSQL
    id BIGSERIAL NOT NULL,
    email TEXT NOT NULL,
    password TEXT NOT NULL,
    created_on TIMESTAMPTZ NOT NULL,
    updated_on TIMESTAMPTZ NOT NULL,
    PRIMARY KEY (id)
);

-- Create Project table
-- The foreign key syntax is similar but doesn't need CONSTRAINT keyword
-- though we keep it for clarity and consistency
CREATE TABLE project (
    id BIGSERIAL NOT NULL,
    name TEXT NOT NULL,
    description TEXT,
    created_on TIMESTAMPTZ NOT NULL,
    updated_on TIMESTAMPTZ NOT NULL,
    user_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_project_user
        FOREIGN KEY (user_id)
        REFERENCES "user"(id)
        ON DELETE CASCADE
);

-- Create Topic table
CREATE TABLE topic (
    id BIGSERIAL NOT NULL,
    name TEXT NOT NULL,
    PRIMARY KEY (id)
);

-- Create join table for Project-Topic many-to-many relationship
-- PostgreSQL handles composite primary keys the same way as MySQL
CREATE TABLE project_topic (
    project_id BIGINT NOT NULL,
    topic_id BIGINT NOT NULL,
    PRIMARY KEY (project_id, topic_id),
    CONSTRAINT fk_pt_project
        FOREIGN KEY (project_id)
        REFERENCES project(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_pt_topic
        FOREIGN KEY (topic_id)
        REFERENCES topic(id)
        ON DELETE CASCADE
);

-- Create indexes for better query performance
-- PostgreSQL automatically creates indexes for primary keys and unique constraints
-- so we only need the additional indexes for foreign keys
CREATE INDEX idx_project_user ON project(user_id);
CREATE INDEX idx_project_topic_project ON project_topic(project_id);
CREATE INDEX idx_project_topic_topic ON project_topic(topic_id);