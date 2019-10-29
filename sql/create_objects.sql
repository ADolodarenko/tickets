create role ticket_admin with login createdb password 'qwerty';

create database tickets owner ticket_admin;
