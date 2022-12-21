CREATE TABLE IF NOT EXISTS public.irrigation_sensor (
	id int8 NOT NULL,
	date_created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	date_modified timestamp NULL,
	sensor_api_url varchar(2500) NOT NULL,
	serial_version_id int8 NULL,
	index serial NOT NULL UNIQUE,
	CONSTRAINT irrigation_sensor_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS  public.irrigation_sensor_alert (
	id int8 NOT NULL,
	date_created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	date_modified timestamp NULL,
	description varchar(2500) NULL,
	serial_version_id int8 NULL,
	irrigation_sensor_id int8 NULL,
	index serial NOT NULL UNIQUE,
	CONSTRAINT irrigation_sensor_alert_pkey PRIMARY KEY (id),
	CONSTRAINT fkn84pwgcobkm6y2tq6t9wlo0mo FOREIGN KEY (irrigation_sensor_id) REFERENCES public.irrigation_sensor(id)
);

CREATE TABLE IF NOT EXISTS  public.plot (
	id int8 NOT NULL,
	agricultural_crop_type_enum varchar(255) NULL,
	date_created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	date_modified timestamp NULL,
	name varchar(255) NOT NULL,
	irrigation_sensor_id int8 NULL,
	index serial NOT NULL UNIQUE,
	CONSTRAINT plot_pkey PRIMARY KEY (id),
	CONSTRAINT fk407r7hhgmwxk1ydglrlgkt8kx FOREIGN KEY (irrigation_sensor_id) REFERENCES public.irrigation_sensor(id)
);


CREATE TABLE IF NOT EXISTS  public.plot_irrigation_sensor_slot (
	id int8 NOT NULL,
	amount_of_water float8 NULL DEFAULT 1000,
	date_created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	date_modified timestamp NULL,
	index serial NOT NULL UNIQUE,
	slot_end_time timestamp NOT NULL,
	slot_start_time timestamp NOT NULL,
	slot_status_enum varchar(255) NOT NULL DEFAULT 'PENDING'::character varying,
	plot_id int8 NULL,
	CONSTRAINT plot_irrigation_sensor_slot_pkey PRIMARY KEY (id),
	CONSTRAINT fkciw8012shopl3grdi0iufuaxf FOREIGN KEY (plot_id) REFERENCES public.plot(id)
);