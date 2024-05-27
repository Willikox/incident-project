PGDMP  8    +                |            incidents_db    14.11 (Homebrew)    16.1     <           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            =           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            >           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    16509    incidents_db    DATABASE     �   CREATE DATABASE incidents_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LC_COLLATE = 'C' LC_CTYPE = 'UTF-8';
    DROP DATABASE incidents_db;
                postgres    false                        2615    2200    public    SCHEMA     2   -- *not* creating schema, since initdb creates it
 2   -- *not* dropping schema, since initdb creates it
                williamchabla    false            @           0    0    SCHEMA public    ACL     Q   REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;
                   williamchabla    false    4            �            1259    16511    incident    TABLE     
  CREATE TABLE public.incident (
    id integer NOT NULL,
    created_at timestamp(6) without time zone,
    description character varying(255),
    observation character varying(255),
    status character varying(255),
    update_at timestamp(6) without time zone
);
    DROP TABLE public.incident;
       public         heap    postgres    false    4            �            1259    16510    incident_id_seq    SEQUENCE     �   CREATE SEQUENCE public.incident_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.incident_id_seq;
       public          postgres    false    4    210            A           0    0    incident_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.incident_id_seq OWNED BY public.incident.id;
          public          postgres    false    209            �           2604    16514    incident id    DEFAULT     j   ALTER TABLE ONLY public.incident ALTER COLUMN id SET DEFAULT nextval('public.incident_id_seq'::regclass);
 :   ALTER TABLE public.incident ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    210    209    210            9          0    16511    incident 
   TABLE DATA           _   COPY public.incident (id, created_at, description, observation, status, update_at) FROM stdin;
    public          postgres    false    210          B           0    0    incident_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.incident_id_seq', 7, true);
          public          postgres    false    209            �           2606    16518    incident incident_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.incident
    ADD CONSTRAINT incident_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.incident DROP CONSTRAINT incident_pkey;
       public            postgres    false    210            9     x����j�0�g�)��FHW��R(t)�t�"���ܡ�O�G�Ղ&�q-���s�@�A��ށ �;^zJm�Bʁ��!u�|��˕_o����?Nm��J���f��s�t� `������H=��1o>�>�B�sOZjbO?���a��NH��Hk�^�������1��j���,� W,�FЋ������'�1�c|�����e�v �R\Z��U��TN+���B��0�ƓK������@���Op�8LXiL��V�*[Ujy���a� ����     