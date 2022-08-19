CREATE TABLE drama(
    id int auto_increment primary key,
        titulo varchar(255) not null,
        ano_lancamento int not null,
        temporadas int not null,
        quantidade_episodios int not null,
        genero_id int not null,
        plataforma_id int not null
        FOREIGN KEY (genero_id) REFERENCES genero(id)
        FOREIGN KEY (plataforma_id) REFERENCES plataforma(id)
);