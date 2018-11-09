# Projet-taa-gli
Dépôt du projet TAA-GLI - Gestion de Week-end

# Context d'utilisation
L'objectif du projet est de réaliser une application de gestion de week-ends. L'utilisateur entre les activités qu'il/elle souhaite réaliser le week-end, et l'application lui envoie une notification hebdomadaire lui indiquant les informations météorologiques relatives à ces activités. Des indications sont transmises lorque les conditions météo sont défavorables à une activité de plein aire.
Un système d'authentification est pourvu afin d'assurer à l'utilisateur que seul lui puisse modifier ses données. 

# Technologies utilisées


Côté backend, l'application est fondé sur le socle Spring boot pour faciliter la construction de notre API Rest. Spring boot apporte le framework Spring en compagnie d'un serveur embarqué Tomcat. Au delà du coeur de Spring, le projet dispose des modules suivants : 
 - Spring Data Jpa avec Hibernate : Gestion de la persistance des données
 - Spring AOP : Réalisation d'une programmation par Aspect
 - Spring Security : Gestion des authentifications et authorisations
 - Spring Email : Envoie des messages
En parallèle, Junit a été utilisé pour la réalisation des tests et Swagger pour la documentation de l'API.

# Ce qui est fonctionnel

# Ce qui est à réaliser

# Installation



```sh
$ mvn install docker:build
$ npm run-script build
$ docker-compose up
```

Pour la production : 


Requête :


```sh
$ curl -X POST -H 'Content-Type: application/json' --user admintest:password -i http://localhost:8080/api/admin/addSport --data '{"name":"Belote","environment":"INSIDE"}'
```





