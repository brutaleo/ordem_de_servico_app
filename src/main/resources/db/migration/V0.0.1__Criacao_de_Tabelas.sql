CREATE TABLE public.exame
(
    id        int8 NOT NULL,
    descricao varchar(255) NULL,
    preco     numeric(19, 2) NULL,
    CONSTRAINT exame_pkey PRIMARY KEY (id)
);

CREATE TABLE public.medico
(
    id            int8 NOT NULL,
    especialidade varchar(255) NULL,
    nome          varchar(255) NULL,
    CONSTRAINT medico_pkey PRIMARY KEY (id)
);

CREATE TABLE public.paciente
(
    id             int8 NOT NULL,
    datanascimento date NULL,
    endereco       varchar(255) NULL,
    nome           varchar(255) NULL,
    sexo           varchar(255) NULL,
    CONSTRAINT paciente_pkey PRIMARY KEY (id)
);

CREATE TABLE public.posto_coleta
(
    id        int8 NOT NULL,
    descricao varchar(255) NULL,
    endereco  varchar(255) NULL,
    CONSTRAINT posto_coleta_pkey PRIMARY KEY (id)
);

CREATE TABLE public.ordemdeservico
(
    id              int8 NOT NULL,
    convenio        varchar(255) NULL,
    dataatualizacao date NULL,
    datacadastro    date NULL,
    protocolo       varchar(255) NULL,
    medico_id       int8 NULL,
    paciente_id     int8 NULL,
    posto_coleta_id int8 NULL,
    CONSTRAINT ordemdeservico_pkey PRIMARY KEY (id)
);


ALTER TABLE public.ordemdeservico
    ADD CONSTRAINT fkgw27o16p3v3nauugb8qngxrik FOREIGN KEY (posto_coleta_id) REFERENCES public.posto_coleta (id);
ALTER TABLE public.ordemdeservico
    ADD CONSTRAINT fkpgo2oyd5vsclpb9np0m3b4gdj FOREIGN KEY (medico_id) REFERENCES public.medico (id);
ALTER TABLE public.ordemdeservico
    ADD CONSTRAINT fkt5ikjcjk7i1qn06my5mtolivo FOREIGN KEY (paciente_id) REFERENCES public.paciente (id);

CREATE TABLE public.ordem_de_servico_exame
(
    id                int8 NOT NULL,
    exame_id          int8 NOT NULL,
    ordemdeservico_id int8 NOT NULL,
    CONSTRAINT ordem_de_servico_exame_pkey PRIMARY KEY (id)
);


ALTER TABLE public.ordem_de_servico_exame
    ADD CONSTRAINT fkg1w890alurlbrnf92obeynom3 FOREIGN KEY (exame_id) REFERENCES public.exame (id);
ALTER TABLE public.ordem_de_servico_exame
    ADD CONSTRAINT fkt4xf6idnoepkkk1seh1jvtc4w FOREIGN KEY (ordemdeservico_id) REFERENCES public.ordemdeservico (id);
