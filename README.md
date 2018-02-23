[![Build Status](https://travis-ci.org/MAMERY-DOUMBIA/Dauphine-Pole-Info.svg?branch=master)](https://travis-ci.org/MAMERY-DOUMBIA/Dauphine-Pole-Info)
# dauphine-pole-info
Projet de Conception Agile d'Application Web en Java  
  
## Installation de poleinfo3
Un serveur PHP et une base mySQL sont nécessaires : vous pouvez installer wamp,xamp ou mamp suivant votre OS.  
La démarche suivante a été réalisée avec wamp.  
  
1. Récupérer le code sur https://github.com/oliviercailloux/poleinfo3  
2. Déplacer le code dans le répertoire <www> de wamp  
3. Créer une base de données mySQL nommée "Master"  
  3.1 Soit en ligne de commande : mysqladmin -u root -p create Master  
  3.2 Soit avec phpMyAdmin  
4. Importer le fichier Schema.sql dans la base de données  
  4.1 ligne de commande : mysql -u root -p Master < Schema.sql
  4.2 ou avec phpMyAdmin
5. Indiquer les identifiants d'accès à la DB dans "DBinfo.php"
6. Activer les *short open tags* dans la configuration PHP
7. Accéder à l'application ! 
8. (Vous pouvez éventuellement réduire le niveau des erreurs rapportées pour ne pas prendre en compte les dépréciations)
