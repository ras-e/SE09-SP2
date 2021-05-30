--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: account_types; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.account_types (
    id integer NOT NULL,
    account_type character varying(50) NOT NULL
);


ALTER TABLE public.account_types OWNER TO postgres;

--
-- Name: account_types_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.account_types_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.account_types_id_seq OWNER TO postgres;

--
-- Name: account_types_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.account_types_id_seq OWNED BY public.account_types.id;


--
-- Name: kredittering; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.kredittering (
    id integer NOT NULL,
    medvirkendeid integer NOT NULL,
    tv_rolleid integer NOT NULL,
    kategoriid integer NOT NULL,
    tv_programid integer NOT NULL
);


ALTER TABLE public.kredittering OWNER TO postgres;

--
-- Name: kredittering_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.kredittering_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.kredittering_id_seq OWNER TO postgres;

--
-- Name: kredittering_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.kredittering_id_seq OWNED BY public.kredittering.id;


--
-- Name: medvirkende; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.medvirkende (
    id integer NOT NULL,
    name character varying NOT NULL,
    email character varying NOT NULL
);


ALTER TABLE public.medvirkende OWNER TO postgres;

--
-- Name: medvirkende_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.medvirkende_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.medvirkende_id_seq OWNER TO postgres;

--
-- Name: medvirkende_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.medvirkende_id_seq OWNED BY public.medvirkende.id;


--
-- Name: prod_selskab; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.prod_selskab (
    id integer NOT NULL,
    prod_selskab character varying NOT NULL
);


ALTER TABLE public.prod_selskab OWNER TO postgres;

--
-- Name: prod_selskab_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.prod_selskab_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.prod_selskab_id_seq OWNER TO postgres;

--
-- Name: prod_selskab_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.prod_selskab_id_seq OWNED BY public.prod_selskab.id;


--
-- Name: prodandselskab; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.prodandselskab (
    id integer NOT NULL,
    prod_selskabid integer NOT NULL,
    producerid integer NOT NULL
);


ALTER TABLE public.prodandselskab OWNER TO postgres;

--
-- Name: prodandselskab_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.prodandselskab_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.prodandselskab_id_seq OWNER TO postgres;

--
-- Name: prodandselskab_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.prodandselskab_id_seq OWNED BY public.prodandselskab.id;


--
-- Name: producers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.producers (
    id integer NOT NULL,
    userid integer NOT NULL
);


ALTER TABLE public.producers OWNER TO postgres;

--
-- Name: producers_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.producers_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.producers_id_seq OWNER TO postgres;

--
-- Name: producers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.producers_id_seq OWNED BY public.producers.id;


--
-- Name: program_kategori; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.program_kategori (
    id integer NOT NULL,
    kategori character varying NOT NULL
);


ALTER TABLE public.program_kategori OWNER TO postgres;

--
-- Name: program_kategori_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.program_kategori_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.program_kategori_id_seq OWNER TO postgres;

--
-- Name: program_kategori_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.program_kategori_id_seq OWNED BY public.program_kategori.id;


--
-- Name: programkategorier; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.programkategorier (
    programid integer NOT NULL,
    program_kategoriid integer NOT NULL,
    tv_programid integer NOT NULL
);


ALTER TABLE public.programkategorier OWNER TO postgres;

--
-- Name: tv_program; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tv_program (
    id integer NOT NULL,
    name character varying NOT NULL,
    dato date NOT NULL,
    producerid integer NOT NULL
);


ALTER TABLE public.tv_program OWNER TO postgres;

--
-- Name: tv_program_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tv_program_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tv_program_id_seq OWNER TO postgres;

--
-- Name: tv_program_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tv_program_id_seq OWNED BY public.tv_program.id;


--
-- Name: tv_rolle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tv_rolle (
    id integer NOT NULL,
    rolle character varying NOT NULL
);


ALTER TABLE public.tv_rolle OWNER TO postgres;

--
-- Name: tv_rolle_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tv_rolle_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tv_rolle_id_seq OWNER TO postgres;

--
-- Name: tv_rolle_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tv_rolle_id_seq OWNED BY public.tv_rolle.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    account_type integer NOT NULL,
    name character varying(50) NOT NULL,
    username character varying(50) NOT NULL,
    email character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    dato date NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: account_types id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account_types ALTER COLUMN id SET DEFAULT nextval('public.account_types_id_seq'::regclass);


--
-- Name: kredittering id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kredittering ALTER COLUMN id SET DEFAULT nextval('public.kredittering_id_seq'::regclass);


--
-- Name: medvirkende id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medvirkende ALTER COLUMN id SET DEFAULT nextval('public.medvirkende_id_seq'::regclass);


--
-- Name: prod_selskab id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prod_selskab ALTER COLUMN id SET DEFAULT nextval('public.prod_selskab_id_seq'::regclass);


--
-- Name: prodandselskab id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prodandselskab ALTER COLUMN id SET DEFAULT nextval('public.prodandselskab_id_seq'::regclass);


--
-- Name: producers id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producers ALTER COLUMN id SET DEFAULT nextval('public.producers_id_seq'::regclass);


--
-- Name: program_kategori id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.program_kategori ALTER COLUMN id SET DEFAULT nextval('public.program_kategori_id_seq'::regclass);


--
-- Name: tv_program id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tv_program ALTER COLUMN id SET DEFAULT nextval('public.tv_program_id_seq'::regclass);


--
-- Name: tv_rolle id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tv_rolle ALTER COLUMN id SET DEFAULT nextval('public.tv_rolle_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Data for Name: account_types; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.account_types (id, account_type) FROM stdin;
1	producent
2	Admin
3	bruger
4	forretningsperson
\.


--
-- Data for Name: kredittering; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.kredittering (id, medvirkendeid, tv_rolleid, kategoriid, tv_programid) FROM stdin;
\.


--
-- Data for Name: medvirkende; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.medvirkende (id, name, email) FROM stdin;
1	Simon	Simon@outlook.com
2	Jens	Jens@outlook.com
3	Rasmus	Rasmus@outlook.com
4	Anders	Anders@outlook.com
5	Christoffer	Christoffer@outlook.com
\.


--
-- Data for Name: prod_selskab; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.prod_selskab (id, prod_selskab) FROM stdin;
1	prod_selskab1
2	prod_selskab2
3	prod_selskab3
4	prod_selskab4
5	prod_selskab5
\.


--
-- Data for Name: prodandselskab; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.prodandselskab (id, prod_selskabid, producerid) FROM stdin;
\.


--
-- Data for Name: producers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.producers (id, userid) FROM stdin;
2	2
3	3
4	4
\.


--
-- Data for Name: program_kategori; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.program_kategori (id, kategori) FROM stdin;
1	Gyser
2	Drama
3	Komedie
4	Thriller
5	Gyser
6	Drama
7	Komedie
8	Thriller
\.


--
-- Data for Name: programkategorier; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.programkategorier (programid, program_kategoriid, tv_programid) FROM stdin;
\.


--
-- Data for Name: tv_program; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tv_program (id, name, dato, producerid) FROM stdin;
3	programname	2021-05-31	4
4	programname	2021-05-31	2
5	programname	2021-05-31	3
\.


--
-- Data for Name: tv_rolle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tv_rolle (id, rolle) FROM stdin;
1	Billedekunstner
2	Billede og lydredigering
3	Casting
4	Color
5	Dirigenter
6	Drone
7	Dukkefører
8	Dukkeskaber
9	fortæller
10	Fotografer
11	Forlæg
12	Grafiskdesigner
13	indtalere
14	kapelmester
15	klipper
16	Koncept/Programkoncept
17	konsulent
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, account_type, name, username, email, password, dato) FROM stdin;
2	2	admin1	admin1	@admin1@	admin1	2021-05-31
3	2	admin2	admin2	@admin2@	admin2	2021-05-31
4	2	admin3	admin3	@admin3@	admin3	2021-05-31
5	1	prod1	prod1	@prod1@	prod1	2021-05-31
6	1	prod2	prod2	@prod2@	prod2	2021-05-31
7	1	prod3	prod3	@prod3@	prod3	2021-05-31
8	3	user1	user1	@user1@	user1	2021-05-31
9	3	user2	user2	@user2@	user2	2021-05-31
10	3	user3	user3	@user3@	user3	2021-05-31
\.


--
-- Name: account_types_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.account_types_id_seq', 4, true);


--
-- Name: kredittering_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.kredittering_id_seq', 1, false);


--
-- Name: medvirkende_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.medvirkende_id_seq', 5, true);


--
-- Name: prod_selskab_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.prod_selskab_id_seq', 5, true);


--
-- Name: prodandselskab_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.prodandselskab_id_seq', 1, false);


--
-- Name: producers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.producers_id_seq', 4, true);


--
-- Name: program_kategori_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.program_kategori_id_seq', 8, true);


--
-- Name: tv_program_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tv_program_id_seq', 5, true);


--
-- Name: tv_rolle_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tv_rolle_id_seq', 17, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 10, true);


--
-- Name: account_types account_types_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account_types
    ADD CONSTRAINT account_types_pkey PRIMARY KEY (id);


--
-- Name: kredittering kredittering_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kredittering
    ADD CONSTRAINT kredittering_pkey PRIMARY KEY (id);


--
-- Name: medvirkende medvirkende_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medvirkende
    ADD CONSTRAINT medvirkende_pkey PRIMARY KEY (id);


--
-- Name: prod_selskab prod_selskab_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prod_selskab
    ADD CONSTRAINT prod_selskab_pkey PRIMARY KEY (id);


--
-- Name: prodandselskab prodandselskab_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prodandselskab
    ADD CONSTRAINT prodandselskab_pkey PRIMARY KEY (id);


--
-- Name: producers producers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producers
    ADD CONSTRAINT producers_pkey PRIMARY KEY (id);


--
-- Name: program_kategori program_kategori_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.program_kategori
    ADD CONSTRAINT program_kategori_pkey PRIMARY KEY (id);


--
-- Name: tv_program tv_program_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tv_program
    ADD CONSTRAINT tv_program_pkey PRIMARY KEY (id);


--
-- Name: tv_rolle tv_rolle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tv_rolle
    ADD CONSTRAINT tv_rolle_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: kredittering kredittering_kategoriid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kredittering
    ADD CONSTRAINT kredittering_kategoriid_fkey FOREIGN KEY (kategoriid) REFERENCES public.program_kategori(id);


--
-- Name: kredittering kredittering_medvirkendeid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kredittering
    ADD CONSTRAINT kredittering_medvirkendeid_fkey FOREIGN KEY (medvirkendeid) REFERENCES public.medvirkende(id);


--
-- Name: kredittering kredittering_tv_programid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kredittering
    ADD CONSTRAINT kredittering_tv_programid_fkey FOREIGN KEY (tv_programid) REFERENCES public.tv_program(id);


--
-- Name: kredittering kredittering_tv_rolleid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kredittering
    ADD CONSTRAINT kredittering_tv_rolleid_fkey FOREIGN KEY (tv_rolleid) REFERENCES public.tv_rolle(id);


--
-- Name: prodandselskab prodandselskab_prod_selskabid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prodandselskab
    ADD CONSTRAINT prodandselskab_prod_selskabid_fkey FOREIGN KEY (prod_selskabid) REFERENCES public.prod_selskab(id);


--
-- Name: prodandselskab prodandselskab_producerid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prodandselskab
    ADD CONSTRAINT prodandselskab_producerid_fkey FOREIGN KEY (producerid) REFERENCES public.producers(id);


--
-- Name: producers producers_userid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producers
    ADD CONSTRAINT producers_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(id);


--
-- Name: programkategorier programkategorier_program_kategoriid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.programkategorier
    ADD CONSTRAINT programkategorier_program_kategoriid_fkey FOREIGN KEY (program_kategoriid) REFERENCES public.program_kategori(id);


--
-- Name: programkategorier programkategorier_programid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.programkategorier
    ADD CONSTRAINT programkategorier_programid_fkey FOREIGN KEY (programid) REFERENCES public.tv_program(id);


--
-- Name: programkategorier programkategorier_tv_programid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.programkategorier
    ADD CONSTRAINT programkategorier_tv_programid_fkey FOREIGN KEY (tv_programid) REFERENCES public.tv_program(id);


--
-- Name: tv_program tv_program_producerid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tv_program
    ADD CONSTRAINT tv_program_producerid_fkey FOREIGN KEY (producerid) REFERENCES public.producers(id);


--
-- Name: users users_account_type_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_account_type_fkey FOREIGN KEY (account_type) REFERENCES public.account_types(id);


--
-- PostgreSQL database dump complete
--

