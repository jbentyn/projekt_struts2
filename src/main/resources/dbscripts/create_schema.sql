CREATE TABLE users
(
  id serial NOT NULL,
  login text NOT NULL,
  name text NOT NULL,
  last_name text NOT NULL,
  email text NOT NULL,
  mobile text,
  password text NOT NULL,
  CONSTRAINT users_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE users
  OWNER TO postgres;
GRANT ALL ON TABLE users TO postgres;
GRANT ALL ON TABLE users TO struts;
GRANT ALL ON SEQUENCE users_id_seq to postgres;
GRANT ALL ON SEQUENCE users_id_seq to struts;

CREATE TABLE doctor
(
  id serial NOT NULL,
  name text NOT NULL,
  last_name text NOT NULL,
  CONSTRAINT doctor_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE doctor
  OWNER TO postgres;
GRANT ALL ON TABLE doctor TO postgres;
GRANT ALL ON TABLE doctor TO struts;
GRANT ALL ON SEQUENCE doctor_id_seq to postgres;
GRANT ALL ON SEQUENCE doctor_id_seq to struts;

CREATE TABLE appointment
(
  id serial NOT NULL,
  user_id bigint NOT NULL references users(id),
  doctor_id bigint NOT NULL references doctor(id),
  app_date timestamp NOT NULL,
  CONSTRAINT appointment_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE appointment
  OWNER TO postgres;
GRANT ALL ON TABLE appointment TO postgres;
GRANT ALL ON TABLE appointment TO struts;
GRANT ALL ON SEQUENCE appointment_id_seq to postgres;
GRANT ALL ON SEQUENCE appointment_id_seq to struts;