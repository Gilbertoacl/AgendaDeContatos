ALTER TABLE usuarios ADD COLUMN ativo TINYINT NOT NULL;
UPDATE usuarios SET ativo = 1;