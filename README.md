# Projet-taa-gli
Dépôt du projet TAA-GLI - Gestion de Week-end

# Context d'utilisation

L'objectif du projet est de réaliser une application de gestion de week-ends. L'utilisateur entre les activités qu'il/elle souhaite réaliser le week-end, et l'application lui envoie une notification hebdomadaire lui indiquant les informations météorologiques relatives à ces activités avec des recommandations.
Un système d'authentification est pourvu afin d'assurer à l'utilisateur que lui seul puisse modifier ses données. 

# Technologies utilisées

Côté backend, l'application est fondée sur le socle Spring boot pour faciliter la construction de notre API Rest. Au delà du coeur de Spring, le projet dispose des modules suivants : 
 - Spring Data Jpa avec Hibernate : Gestion de la persistance des données
 - Spring AOP : Réalisation d'une programmation par Aspect
 - Spring Security : Gestion des authentifications et authorisations
 - Spring Email : Envoie des messages
En parallèle, Junit a été utilisé pour la réalisation des tests et Swagger pour la documentation de l'API Rests. Le backend est associé à MySql comme base de données. 

Côté frontend, c'est le framework React qui est utilisé. Celui-ci est associé à Redux pour la maintenance des données ainsi qu'à React Router pour le routage entre les composants. 

Pour la gestion des dépendances et le packaging, maven est utilisé côté backend et npm côté frontend.

Le déploiement de l'application se fait avec Docker.

# Fonctionnalités supportées

Pour le moment un utilisateur, après s'être authentifié, peut accéder à ses activités, en ajouter ou en supprimer. Il a accès à la liste des sports et localisations disposées dans la base de données. 

L'API côté backend peut recevoir l'ensemble des requêtes nécessaires pour traiter, un ajout/une suppression d'un utilisateur, d'un sport, d'une localisation et d'une activité à condition d'identifier un utilisateur ayant le rôle adéquat (seul le rôle admin peut modifier les sports et localisations).

Les test unitaires permettent d'observer rapidement le statut des réponses données par le serveur pour l'ensemble des services proposés en fonction des URI et arguments donnés. 

Le service de requêtes vers une API météo nous permet bien de recueillir les informations relatives aux activités stockées en base de données. Ce service est implémenté au sein d'une méthode @Scheduled qui permet d'envoyer un mail de notification tous les mercredis avec les recommandations pour le week-end.

# Fonctionnalités à développer
Côté frontend :
 - un service d'inscription : un formulaire à remplir pour envoyer une requête à l'API Rest qui va ajouter un utilisateur dans la base de données.
 - un service d'administration : si l'utilisateur est authentifié avec le role d'admin, il pourra modifier la liste des sports et celles des localisations

Côté backend :
 - améliorer le service du traitement des données météo pour augmenter le panel d'indication à donner aux utilisateurs. Pour le moment, seul la pluie est pris en compte pour indiquer s'il est conseillé ou non de réaliser une activité.

# Installation

Voici les étapes à suivre pour déployer l'application : 

Le déploiement se fait grâce à docker-compose qui va associer 4 containers :
 - Un docker mysql
 - Un docker phpmyadmin
 - Un docker backend
 - Un docker nginx + frontend

N.B. Voir le fichier design.md pour plus d'informations sur l'architecture de l'application.

La commande suivante permet de construire l'image de notre backend dans le repertoire /backend :

```sh
$ mvn install docker:build

// le nom de l'image sera le nom du projet : spring-boot-taa
```

Les commandes suivantes permettent de construire nos fichiers statiques, puis de les disposer sur un serveur nginx dans le repertoire /frontend/React :
```sh
$ npm run-script build // pour construire les fichiers statiques
$ docker build -f Dockerfile -t nginx-react . // Construit une image docker du server nginx avec les fichiers statiques
```

La commande suivante permet d'executer le docker-compose pour déployer l'ensemble de nos serveurs (à exécuter à la racine du projet) :

```sh
$ docker-compose up
```

L'application démarre et est accéssible sur ``` http://localhost/```.

Après le premier lancement, la base de données est vide. Importer le fichier ```sh db-init-test.sql``` pour nourir la base de données et tester l'application. Phpmyadmin est accéssible sur le port 8081. 


Exemple de requête pour ajouter un sport en tant qu'admin :

```sh
$ curl -X POST -H 'Content-Type: application/json' --user admintest:password -i http://localhost:8080/api/admin/addSport --data '{"name":"Belote","environment":"INSIDE"}'
```

Une fois la base de données nourries, il est possible de s'authentifier et gérer nos activités du week-end sur ``` http://localhost/```.





