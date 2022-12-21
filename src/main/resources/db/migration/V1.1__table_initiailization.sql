CREATE TABLE IF NOT EXISTS irrigation_sensor (
    id bigint PRIMARY KEY,
    date_created timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    date_modified timestamp without time zone,
    sensor_api_url character varying(2500) NOT NULL,
    serial_version_id bigint,
    index integer NOT NULL,
    plot_id bigint NOT NULL
);
--
CREATE TABLE IF NOT EXISTS irrigation_sensor_alert (
    id bigint PRIMARY KEY,
    date_created timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    date_modified timestamp without time zone,
    description character varying(2500),
    serial_version_id bigint,
    irrigation_sensor_id bigint,
    index integer NOT NULL
);

CREATE TABLE IF NOT EXISTS plot (
    id bigint PRIMARY KEY,
    agricultural_crop_type_enum character varying(255),
    date_created timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    date_modified timestamp without time zone,
    name character varying(255) NOT NULL,
    irrigation_sensor_id bigint,
    index integer NOT NULL
);

CREATE TABLE IF NOT EXISTS plot_irrigation_sensor_slot (
    id bigint PRIMARY KEY,
    amount_of_water double precision DEFAULT 1000,
    date_created timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    date_modified timestamp without time zone,
    index integer NOT NULL,
    slot_end_time timestamp without time zone NOT NULL,
    slot_start_time timestamp without time zone NOT NULL,
    slot_status_enum character varying(255) DEFAULT 'PENDING'::character varying NOT NULL,
    plot_id bigint
);
--

ALTER TABLE irrigation_sensor ADD CONSTRAINT uk_hc9sqfx793ms3vvvloimrm2u3 UNIQUE (plot_id);
ALTER TABLE plot ADD CONSTRAINT fk407r7hhgmwxk1ydglrlgkt8kx FOREIGN KEY (irrigation_sensor_id) REFERENCES irrigation_sensor(id);
ALTER TABLE plot_irrigation_sensor_slot ADD CONSTRAINT fkciw8012shopl3grdi0iufuaxf FOREIGN KEY (plot_id) REFERENCES plot(id);
ALTER TABLE irrigation_sensor_alert ADD CONSTRAINT fkn84pwgcobkm6y2tq6t9wlo0mo FOREIGN KEY (irrigation_sensor_id) REFERENCES irrigation_sensor(id);


CREATE SEQUENCE irrigation_sensor_index_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE SEQUENCE irrigation_sensor_alert_index_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE SEQUENCE plot_index_seq START WITH 5 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE SEQUENCE plot_irrigation_sensor_slot_index_seq START WITH 1 INCREMENT BY 6 NO MINVALUE NO MAXVALUE CACHE 1;
create SEQUENCE HIBERNATE_SEQUENCE START WITH 6;

ALTER TABLE irrigation_sensor ALTER COLUMN index SET DEFAULT nextval('irrigation_sensor_index_seq');
ALTER TABLE irrigation_sensor_alert ALTER COLUMN index SET DEFAULT nextval('irrigation_sensor_alert_index_seq');
ALTER TABLE plot ALTER COLUMN index SET DEFAULT nextval('plot_index_seq');
ALTER TABLE plot_irrigation_sensor_slot ALTER COLUMN index SET DEFAULT nextval('plot_irrigation_sensor_slot_index_seq');


INSERT INTO irrigation_sensor VALUES (26, '2022-12-21 12:29:06.280329', NULL, 'https://googlecloud.test.com', NULL, 1, 24);

INSERT INTO irrigation_sensor_alert VALUES (38, '2022-12-21 14:33:38.105821', NULL, 'Failed to send slot with id 37 to sensor at 2022-12-21T14:33:38.102831800', NULL, 26, 1);

INSERT INTO plot VALUES (20, 'FIBER_CROPS', '2022-12-21 12:23:16.397954', NULL, 'Builder the buils', NULL, 1);
INSERT INTO plot VALUES (21, 'OIL_CROPS', '2022-12-21 12:23:31.096741', NULL, 'Builder the buils', NULL, 2);
INSERT INTO plot VALUES (22, 'OIL_CROPS', '2022-12-21 12:23:45.608346', NULL, 'Familia Land', NULL, 3);
INSERT INTO plot VALUES (23, 'OIL_CROPS', '2022-12-21 12:23:53.709674', NULL, 'Familia Land', NULL, 4);
INSERT INTO plot VALUES (24, 'FORAGE_CROPS', '2022-12-21 12:24:04.182875', '2022-12-21 12:25:38.923976', 'Adeshina Plot', 26, 5);

INSERT INTO plot_irrigation_sensor_slot VALUES (32, 80298304, '2022-12-21 13:05:58.56842', NULL, 1, '1946-03-21 23:10:23.908', '1970-07-11 03:49:08.72', 'PENDING', 24);
INSERT INTO plot_irrigation_sensor_slot VALUES (33, 80298304, '2022-12-21 13:09:53.365847', NULL, 2, '1946-03-21 23:10:23.908', '1970-07-11 03:49:08.72', 'PENDING', 24);
INSERT INTO plot_irrigation_sensor_slot VALUES (34, 80298304, '2022-12-21 13:13:13.192447', NULL, 3, '1946-03-21 23:10:23.908', '1970-07-11 03:49:08.72', 'PENDING', 24);
INSERT INTO plot_irrigation_sensor_slot VALUES (35, 80298304, '2022-12-21 13:14:06.805671', NULL, 4, '1946-03-21 23:10:23.908', '1970-07-11 03:49:08.72', 'PENDING', 24);
INSERT INTO plot_irrigation_sensor_slot VALUES (36, 80298304, '2022-12-21 13:15:35.293803', NULL, 5, '1946-03-21 23:10:23.908', '1970-07-11 03:49:08.72', 'PENDING', 24);
INSERT INTO plot_irrigation_sensor_slot VALUES (37, 80298304, '2022-12-21 14:33:07.547927', NULL, 6, '1946-03-21 23:10:23.908', '1970-07-11 03:49:08.72', 'PENDING', 24);