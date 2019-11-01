create sequence client_id_seq;

create table client (
  id integer not null default nextval('client_id_seq'),
  login varchar(255) not null,
  password varchar(255) not null,
  fullname varchar(255) not null,
  sex boolean not null,
  constraint pk_client primary key (id)
);

alter sequence client_id_seq owned by client.id;

create sequence ticket_id_seq;

create table ticket (
  id integer not null default nextval('ticket_id_seq'),
  date date not null,
  price double precision not null,
  client_id int not null,
  constraint pk_ticket primary key (id),
  constraint fk_ticket_client foreign key (client_id) references client (id)
    on update cascade on delete cascade
);

alter sequence ticket_id_seq owned by ticket.id;
