--TODO: Append primary and foreign keys as necessary.

create sequence client_id_seq;

create table client (
  id integer not null default nextval('client_id_seq'),
  login varchar(255),
  password varchar(255),
  fullname varchar(255),
  sex boolean
);

alter sequence client_id_seq owned by client.id;

create sequence ticket_id_seq;

create table ticket (
  id integer not null default nextval('ticket_id_seq'),
  date timestamp,
  price numeric(10, 2),
  client_id int
);

alter sequence ticket_id_seq owned by ticket.id;