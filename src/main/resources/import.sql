-- Insert 1
INSERT INTO "user" (username, password, name, role) VALUES ('user1', '$2a$10$LI1KWWyuG2pmQFmnZjM3vurg0lVoeWsUqkQoCTk1Yj342DNSw6Ad6', 'John Doe', 'CUSTOMER');

-- Insert 2
INSERT INTO "user" (username, password, name, role) VALUES ('user2', '$2a$10$61itDbUx5eulFsXL.QnXwuPRwHlZ8Y4hZ84du8kO29OuoH4P/7.OC', 'Jane Smith', 'ADMINISTRATOR');



INSERT INTO category (name, description) VALUES ('Atención Cliente','Atención consultas de clientes');

INSERT INTO category (name, description) VALUES ('Contabilidad','Tareas contables y financieras');

INSERT INTO category (name, description) VALUES ('Sistemas','Soporte técnico y desarrollo');

INSERT INTO category (name, description) VALUES ('Administración','Tareas administrativas');