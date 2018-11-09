#Ajouter User
INSERT INTO `user` (`username`, `mail`, `password`, `role`) VALUES ('phivu', 'alexandre.vu@etudiant.univ-rennes1.fr', 'password', '0'); #user role
INSERT INTO `user` (`username`, `mail`, `password`, `role`) VALUES ('admintest', 'alexandre.vu@etudiant.univ-rennes1.fr', 'password', '1'); #admin role

#Ajouter Localisation
INSERT INTO `localisation` (`id`, `region`, `ville`) VALUES ('0', 'Fr', 'Rennes');
INSERT INTO `localisation` (`id`, `region`, `ville`) VALUES ('1', 'Fr', 'Brest');
INSERT INTO `localisation` (`id`, `region`, `ville`) VALUES ('2', 'Fr', 'Saint-Malo');
INSERT INTO `localisation` (`id`, `region`, `ville`) VALUES ('3', 'Fr', 'Nantes');
INSERT INTO `localisation` (`id`, `region`, `ville`) VALUES ('4', 'Fr', 'Lorient');



#Ajouter Sport
INSERT INTO `sport` (`id`, `environment`, `name`) VALUES ('0', '0', 'Badminton'); # inside sport
INSERT INTO `sport` (`id`, `environment`, `name`) VALUES ('1', '1', 'Football'); # outside sport
INSERT INTO `sport` (`id`, `environment`, `name`) VALUES ('2', '1', 'Paddle'); # outside sport
INSERT INTO `sport` (`id`, `environment`, `name`) VALUES ('3', '1', 'Tennis'); # outside sport
INSERT INTO `sport` (`id`, `environment`, `name`) VALUES ('4', '1', 'Beach-Volley'); # outside sport
INSERT INTO `sport` (`id`, `environment`, `name`) VALUES ('5', '0', 'Gymnastique'); # inside sport
INSERT INTO `sport` (`id`, `environment`, `name`) VALUES ('6', '0', 'Natation'); # inside sport
INSERT INTO `sport` (`id`, `environment`, `name`) VALUES ('7', '0', 'Bowling'); # inside sport


