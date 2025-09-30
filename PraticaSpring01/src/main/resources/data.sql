-- departamentos
INSERT INTO TB_DEPARTMENT (NAME) VALUES ('Gestão');
INSERT INTO TB_DEPARTMENT (NAME) VALUES ('Informática');

-- usuários (buscando o ID do depto pelo nome, para não depender de 1/2)
INSERT INTO TB_USER (DEPARTMENT_ID, NAME, EMAIL)
SELECT d.ID, 'Maria', 'maria@gmail.com' FROM TB_DEPARTMENT d WHERE d.NAME='Gestão';

INSERT INTO TB_USER (DEPARTMENT_ID, NAME, EMAIL)
SELECT d.ID, 'Bob', 'bob@gmail.com' FROM TB_DEPARTMENT d WHERE d.NAME='Gestão';

INSERT INTO TB_USER (DEPARTMENT_ID, NAME, EMAIL)
SELECT d.ID, 'Alex', 'alex@gmail.com' FROM TB_DEPARTMENT d WHERE d.NAME='Informática';

INSERT INTO TB_USER (DEPARTMENT_ID, NAME, EMAIL)
SELECT d.ID, 'Ana', 'ana@gmail.com' FROM TB_DEPARTMENT d WHERE d.NAME='Informática';
