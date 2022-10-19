INSERT INTO users (id, created_date, modified_date, name, first_name, last_name, user_type)
VALUES ('1', NOW(), NOW(), 'User1', 'Lincoln', 'Linc', 'DEFAULT');

INSERT INTO users (id, created_date, modified_date, name, first_name, last_name, user_type)
VALUES ('2', NOW(), NOW(), 'User2', 'Laura', 'Lau', 'SUPER_USER');

INSERT INTO users (id, created_date, modified_date, name, first_name, last_name, user_type)
VALUES ('3', NOW(), NOW(), 'User3', 'Carla', 'Car', 'DEFAULT');

INSERT INTO resources (id, created_date, modified_date, name, resource_type, user_id, json_data)
VALUES ('1', NOW(), NOW(), 'File1', 'FILE', 1, '{"information": "File 1"}');

INSERT INTO resources (id, created_date, modified_date, name, resource_type, user_id, json_data)
VALUES ('2', NOW(), NOW(), 'File2', 'FILE', 2, '{"information": "File 2"}');

INSERT INTO resources (id, created_date, modified_date, name, resource_type, user_id, json_data)
VALUES ('3', NOW(), NOW(), 'Research1', 'RESEARCH', 2, '{"information": "Research 1"}');

INSERT INTO resources (id, created_date, modified_date, name, resource_type, user_id, json_data)
VALUES ('4', NOW(), NOW(), 'Map1', 'MAP', 3, '{"information": "Map 1"}');

