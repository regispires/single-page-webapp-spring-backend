--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: atividade; Type: TABLE; Schema: public; Owner: regis; Tablespace: 
--

CREATE TABLE atividade (
    id integer NOT NULL,
    nome character varying(255) NOT NULL,
    qtdvagas integer
);


ALTER TABLE public.atividade OWNER TO regis;

--
-- Name: atividade_id_seq; Type: SEQUENCE; Schema: public; Owner: regis
--

CREATE SEQUENCE atividade_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.atividade_id_seq OWNER TO regis;

--
-- Name: atividade_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: regis
--

ALTER SEQUENCE atividade_id_seq OWNED BY atividade.id;


--
-- Name: fone; Type: TABLE; Schema: public; Owner: regis; Tablespace: 
--

CREATE TABLE fone (
    id integer NOT NULL,
    numero character varying(255) NOT NULL,
    operadora character varying(255),
    participante_id integer
);


ALTER TABLE public.fone OWNER TO regis;

--
-- Name: fone_id_seq; Type: SEQUENCE; Schema: public; Owner: regis
--

CREATE SEQUENCE fone_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.fone_id_seq OWNER TO regis;

--
-- Name: fone_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: regis
--

ALTER SEQUENCE fone_id_seq OWNED BY fone.id;


--
-- Name: instituicao; Type: TABLE; Schema: public; Owner: regis; Tablespace: 
--

CREATE TABLE instituicao (
    id integer NOT NULL,
    nome character varying(255) NOT NULL,
    sigla character varying(255) NOT NULL
);


ALTER TABLE public.instituicao OWNER TO regis;

--
-- Name: instituicao_id_seq; Type: SEQUENCE; Schema: public; Owner: regis
--

CREATE SEQUENCE instituicao_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.instituicao_id_seq OWNER TO regis;

--
-- Name: instituicao_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: regis
--

ALTER SEQUENCE instituicao_id_seq OWNED BY instituicao.id;


--
-- Name: participante; Type: TABLE; Schema: public; Owner: regis; Tablespace: 
--

CREATE TABLE participante (
    id integer NOT NULL,
    datapagamento date,
    email character varying(255) NOT NULL,
    nome character varying(255) NOT NULL,
    valorpago double precision,
    instituicao_id integer
);


ALTER TABLE public.participante OWNER TO regis;

--
-- Name: participante_atividade; Type: TABLE; Schema: public; Owner: regis; Tablespace: 
--

CREATE TABLE participante_atividade (
    participante_id integer NOT NULL,
    atividade_id integer NOT NULL
);


ALTER TABLE public.participante_atividade OWNER TO regis;

--
-- Name: participante_id_seq; Type: SEQUENCE; Schema: public; Owner: regis
--

CREATE SEQUENCE participante_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.participante_id_seq OWNER TO regis;

--
-- Name: participante_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: regis
--

ALTER SEQUENCE participante_id_seq OWNED BY participante.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: regis
--

ALTER TABLE ONLY atividade ALTER COLUMN id SET DEFAULT nextval('atividade_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: regis
--

ALTER TABLE ONLY fone ALTER COLUMN id SET DEFAULT nextval('fone_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: regis
--

ALTER TABLE ONLY instituicao ALTER COLUMN id SET DEFAULT nextval('instituicao_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: regis
--

ALTER TABLE ONLY participante ALTER COLUMN id SET DEFAULT nextval('participante_id_seq'::regclass);


--
-- Data for Name: atividade; Type: TABLE DATA; Schema: public; Owner: regis
--

COPY atividade (id, nome, qtdvagas) FROM stdin;
\.


--
-- Name: atividade_id_seq; Type: SEQUENCE SET; Schema: public; Owner: regis
--

SELECT pg_catalog.setval('atividade_id_seq', 1, false);


--
-- Data for Name: fone; Type: TABLE DATA; Schema: public; Owner: regis
--

COPY fone (id, numero, operadora, participante_id) FROM stdin;
\.


--
-- Name: fone_id_seq; Type: SEQUENCE SET; Schema: public; Owner: regis
--

SELECT pg_catalog.setval('fone_id_seq', 1, false);


--
-- Data for Name: instituicao; Type: TABLE DATA; Schema: public; Owner: regis
--

COPY instituicao (id, nome, sigla) FROM stdin;
\.


--
-- Name: instituicao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: regis
--

SELECT pg_catalog.setval('instituicao_id_seq', 1, false);


--
-- Data for Name: participante; Type: TABLE DATA; Schema: public; Owner: regis
--

COPY participante (id, datapagamento, email, nome, valorpago, instituicao_id) FROM stdin;
\.


--
-- Data for Name: participante_atividade; Type: TABLE DATA; Schema: public; Owner: regis
--

COPY participante_atividade (participante_id, atividade_id) FROM stdin;
\.


--
-- Name: participante_id_seq; Type: SEQUENCE SET; Schema: public; Owner: regis
--

SELECT pg_catalog.setval('participante_id_seq', 1, false);


--
-- Name: atividade_pkey; Type: CONSTRAINT; Schema: public; Owner: regis; Tablespace: 
--

ALTER TABLE ONLY atividade
    ADD CONSTRAINT atividade_pkey PRIMARY KEY (id);


--
-- Name: fone_pkey; Type: CONSTRAINT; Schema: public; Owner: regis; Tablespace: 
--

ALTER TABLE ONLY fone
    ADD CONSTRAINT fone_pkey PRIMARY KEY (id);


--
-- Name: instituicao_pkey; Type: CONSTRAINT; Schema: public; Owner: regis; Tablespace: 
--

ALTER TABLE ONLY instituicao
    ADD CONSTRAINT instituicao_pkey PRIMARY KEY (id);


--
-- Name: participante_pkey; Type: CONSTRAINT; Schema: public; Owner: regis; Tablespace: 
--

ALTER TABLE ONLY participante
    ADD CONSTRAINT participante_pkey PRIMARY KEY (id);


--
-- Name: uk_413cwb9tu2ayk4f0jw7gwhnmj; Type: CONSTRAINT; Schema: public; Owner: regis; Tablespace: 
--

ALTER TABLE ONLY instituicao
    ADD CONSTRAINT uk_413cwb9tu2ayk4f0jw7gwhnmj UNIQUE (sigla);


--
-- Name: uk_bq2etyeua0alvpgnw3wybnahj; Type: CONSTRAINT; Schema: public; Owner: regis; Tablespace: 
--

ALTER TABLE ONLY participante
    ADD CONSTRAINT uk_bq2etyeua0alvpgnw3wybnahj UNIQUE (email);


--
-- Name: uk_h5erjtsyea3fid26pf7t5gp1p; Type: CONSTRAINT; Schema: public; Owner: regis; Tablespace: 
--

ALTER TABLE ONLY atividade
    ADD CONSTRAINT uk_h5erjtsyea3fid26pf7t5gp1p UNIQUE (nome);


--
-- Name: fk_8bdg5w2yxi9i48p4yue19ki4b; Type: FK CONSTRAINT; Schema: public; Owner: regis
--

ALTER TABLE ONLY fone
    ADD CONSTRAINT fk_8bdg5w2yxi9i48p4yue19ki4b FOREIGN KEY (participante_id) REFERENCES participante(id);


--
-- Name: fk_9mcil27dit7iks008o38pua5i; Type: FK CONSTRAINT; Schema: public; Owner: regis
--

ALTER TABLE ONLY participante_atividade
    ADD CONSTRAINT fk_9mcil27dit7iks008o38pua5i FOREIGN KEY (atividade_id) REFERENCES atividade(id);


--
-- Name: fk_dlfv6xh5h06ovkueergxmelgw; Type: FK CONSTRAINT; Schema: public; Owner: regis
--

ALTER TABLE ONLY participante
    ADD CONSTRAINT fk_dlfv6xh5h06ovkueergxmelgw FOREIGN KEY (instituicao_id) REFERENCES instituicao(id);


--
-- Name: fk_qgdyhcciwgbublvr5e3m0xu8i; Type: FK CONSTRAINT; Schema: public; Owner: regis
--

ALTER TABLE ONLY participante_atividade
    ADD CONSTRAINT fk_qgdyhcciwgbublvr5e3m0xu8i FOREIGN KEY (participante_id) REFERENCES participante(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: regis
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM regis;
GRANT ALL ON SCHEMA public TO regis;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

