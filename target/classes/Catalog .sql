--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.5
-- Dumped by pg_dump version 10.0

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

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
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE users (
    name character varying,
    surename character varying,
    phone_number character varying,
    "e-mail" character varying NOT NULL
);


ALTER TABLE users OWNER TO postgres;

--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY users (name, surename, phone_number, "e-mail") FROM stdin;
Konstantin	Kizin	6471934	KostyKizin@gmail.com
Konstantin	Kizin	6471934	Prem@gmail.com
Ivan	Ivanov	3242234	IvanovIvan@gmail.com
Petya	Petrov	3242234	PPetrov@gmail.com
\.


--
-- Name: users mail; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT mail PRIMARY KEY ("e-mail");


--
-- PostgreSQL database dump complete
--

