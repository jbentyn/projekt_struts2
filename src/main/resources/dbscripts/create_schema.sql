CREATE TABLE users
(
  id serial NOT NULL,
  login text NOT NULL ,
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
  CONSTRAINT appointment_pkey PRIMARY KEY (id),
  CONSTRAINT fk_app_doctor_id FOREIGN KEY (doctor_id)
      REFERENCES doctor (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE,
  CONSTRAINT fk_app_user_id FOREIGN KEY (user_id)
      REFERENCES users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
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

CREATE TABLE role
(
  id serial NOT NULL,
  name text NOT NULL,
  CONSTRAINT role_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE role
  OWNER TO postgres;
GRANT ALL ON TABLE role TO postgres;
GRANT ALL ON TABLE role TO struts;
GRANT ALL ON SEQUENCE role_id_seq to postgres;
GRANT ALL ON SEQUENCE role_id_seq to struts;

CREATE TABLE user_role
(
  role_id bigint NOT NULL,
  user_id bigint NOT NULL,
  CONSTRAINT user_role_pkey PRIMARY KEY (role_id, user_id),
  CONSTRAINT fk_user_role_role FOREIGN KEY (role_id)
      REFERENCES role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE,
  CONSTRAINT fk_user_role_user FOREIGN KEY (user_id)
      REFERENCES users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);

ALTER TABLE user_role
  OWNER TO postgres;
GRANT ALL ON TABLE user_role TO postgres;
GRANT ALL ON TABLE user_role TO struts;
