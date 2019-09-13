**Nouveau système d’information de la bibliothèque d’une grande ville**

Technologies :
•	Apache Maven 3.6
•	Bootstrap 4.0.0
•	JDK8 version 202
•	MySQL 5.1.47
•	Spring Data 2.1.2. RELEASE

*Projet Maven digital-library :*

**Modules :**

- Consumer -> Contient des interfaces des méthodes relatives aux différentes classes définies dans le modèle. Interfaces étendant l’interface CrudRepository.
- Business -> Contient la logique métier : les interfaces et les implémentations des autres méthodes utilisées.
- Webapp -> Contient le site Web (JSP) et les controllers qui appellent les webservices.
- Modèle -> Contient les classes autours desquelles s’articule le projet.
- Webservices -> Contient les services qui à exposer. 
- Client-WS -> Contient les classes auto-générées.



**Procédure de déploiment de la solution (répertoire livrables) :**

1.	Installer et configuer (port : 8082) un serveur Tomcat et y placer le WAR ‘digital-library-webapp’ 
2.	Installer et confugurer (port : 8084) un deuxième serveur Tomcat et y placer le WAR ‘digital-library-webservice’ 
3.	Installer Mysql 
4.	Exécuter le script de création de base et d’utilisateur
5.	Exécuter le script contenant le jeu de données
6.	Effacer les adresses mail definies dans la table 'member' et les remplacer par une adresse ou on veut recevoir les mails de relance. 
7.	Déployer le War contenant ‘digital-library-webservice’ puis celui contenant ‘digital-library-webapp’
8.  L'application web est désormais disponible via l'URL suivante : http://localhost:8082/home
9.	Choisir un utilisateur de test parmi les deux suivant  : 

Utilisateur1 -> Pierre 
Mot de passe -> pierre1

Utilisateur2 -> Stephanie
Mot de passe -> step2
