PGDMP     1    %                y            g191210385_db    13.2    13.2 	    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    16405    g191210385_db    DATABASE     j   CREATE DATABASE g191210385_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1254';
    DROP DATABASE g191210385_db;
                postgres    false            ?            1259    16417    rooms    TABLE     T   CREATE TABLE public.rooms (
    id integer NOT NULL,
    degree integer NOT NULL
);
    DROP TABLE public.rooms;
       public         heap    postgres    false            ?            1259    16414    users    TABLE     `   CREATE TABLE public.users (
    id character varying(20),
    password character varying(20)
);
    DROP TABLE public.users;
       public         heap    postgres    false            ?          0    16417    rooms 
   TABLE DATA           +   COPY public.rooms (id, degree) FROM stdin;
    public          postgres    false    201   ?       ?          0    16414    users 
   TABLE DATA           -   COPY public.users (id, password) FROM stdin;
    public          postgres    false    200   ?       %           2606    16421    rooms rooms_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.rooms
    ADD CONSTRAINT rooms_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.rooms DROP CONSTRAINT rooms_pkey;
       public            postgres    false    201            ?      x?3?46?21z\\\ ??      ?       x???L?,)????1???*?$???? T??     