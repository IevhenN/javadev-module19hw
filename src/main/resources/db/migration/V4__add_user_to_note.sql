ALTER TABLE note
ADD COLUMN user_id BIGINT;

UPDATE note
SET user_id = 1;

ALTER TABLE note
ADD CONSTRAINT fk_user
    FOREIGN KEY (user_id) REFERENCES users(id);