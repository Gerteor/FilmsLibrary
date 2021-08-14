
CREATE TABLE director
(
    id SERIAL  NOT NULL ,
    first_name varchar (255) COLLATE pg_catalog."default",
    last_name varchar (255) COLLATE pg_catalog."default",
    birth_date date,
    CONSTRAINT director_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE director
    OWNER to postgres;

   CREATE TABLE film
(
    id BIGSERIAL  NOT NULL,
    director_id integer NOT NULL,
    name varchar(255) COLLATE pg_catalog."default" NOT NULL,
    release_date date NOT NULL,
    genre varchar(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT film_pkey PRIMARY KEY (id),
    CONSTRAINT fk_director FOREIGN KEY (director_id)
        REFERENCES director (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE film
    OWNER to postgres;

create unique index if not exists director_id_uindex
    on director (id);

create unique index if not exists film_id_uindex
    on film (id);
