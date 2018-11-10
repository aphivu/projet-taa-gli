# Architecture générale de l'application

L'application est décomposée en trois partie, chacune déployée individuellement dans un containeur docker :
 - La base de données MySql
 - Le backend API (Spring boot)
 - Le frontend (React)


# Architecture de l'API Rest

Le backend est décomposé en plusieurs couches :
 - La couche DAO : persistance des données
 - La couche Service : traitement et échange des informations entre la couche controller et DAO
 - La couche Controller : point d'arrivée des requêtes provenant du client

Autour de ces couches se trouvent :
 - Les entités : implémentation du modèle métier fournis pas JPA pour le mapping relationnel vers la base de données
 - Les DTO : objets pour structurer les données nécessaires dans les échanges JSON vers le client. Le mapping des DTO et des entités se fait dans la couche service


# Architecture du frontend

Le frontend est structuré avec l'association React-Redux :
 - React assure l'implémentation des composants graphiques avec JSX
 - Redux assure le management et le maintien de l'état de l'application grâce au store et à la connection entre les composants et les actions à dispatcher vers les reducers. 
 - React Router permet le routing entre différentes "pages" de l'application (home et login pour le moment)

# Déploiement

L'ensemble de l'application est déployé avec l'exécution du fichier de configuration docker-compose.yml. Celui-ci gère le démarrage et les connections entre les dockers. Le frontend est déployé sur un serveur nginx qui joue le rôle de reverse proxy pour l'API Rest. La configuration du "proxy-pass" se trouve dans le fichier ``` nginx/conf.d./default.conf ```.
 

