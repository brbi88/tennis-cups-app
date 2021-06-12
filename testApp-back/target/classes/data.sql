INSERT INTO format (id, tip_takmicenja, br_ucesnika) VALUES (1, 'Grand slam', 50);
INSERT INTO format (id, tip_takmicenja, br_ucesnika) VALUES (2, 'Masters 1000', 45);
INSERT INTO format (id, tip_takmicenja, br_ucesnika) VALUES (3, 'Masters 500', 35);
INSERT INTO format (id, tip_takmicenja, br_ucesnika) VALUES (4, 'Masters 250', 25);

INSERT INTO takmicenje (id, naziv, mesto_odrz, dat_pocetka, dat_zavrsetka, format_id) VALUES (1, 'Australian Open', 'Melbourne, Australia', '2021-02-10', '2021-02-25', 1); 
INSERT INTO takmicenje (id, naziv, mesto_odrz, dat_pocetka, dat_zavrsetka, format_id) VALUES (2, 'Rome', 'Rome, Italia', '2021-07-01', '2021-07-11', 2);
INSERT INTO takmicenje (id, naziv, mesto_odrz, dat_pocetka, dat_zavrsetka, format_id) VALUES (3, 'US Open', 'NY, USA', '2021-10-01', '2021-10-15', 1);

INSERT INTO prijava (id, drz_takmicara, e_mail, dat_prijave, takmicenje_id) VALUES (1, 'USA', 'brbi@gmail.com', '2020-12-19', 1);
INSERT INTO prijava (id, drz_takmicara, e_mail, dat_prijave, takmicenje_id) VALUES (2, 'SRB', 'stef@yahoo.com', '2021-05-14', 2);
INSERT INTO prijava (id, drz_takmicara, e_mail, dat_prijave, takmicenje_id) VALUES (3, 'USA', 'nem@gmail.com', '2020-07-23', 3);

INSERT INTO `user` (id, username, password, role)
              VALUES (1,'miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','ADMIN');
INSERT INTO `user` (id, username, password, role)
              VALUES (2,'tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','KORISNIK');
INSERT INTO `user` (id, username, password, role)
              VALUES (3,'petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','KORISNIK');

