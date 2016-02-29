Les sources du projets se situent dans le dossier 4JVA_SupFitness
Les documentations associés se situent dans le dossier Documentation

1 : UML
	L'UML représentant la base de données se trouve au format png dans le dossier Documentation nommé "database_model" mais il est également disponible au format MySQL Workbench (mwb).

2 : Base de données
	Un script MySQL permettant de recréer la base de données, les tzbles et le jeu de données minimal est disponibla dans le dossier Documentation nommé "export_database.mysql.sql". 
	Il est nécéssaire de configurer sur le serveur d'application (ici Glasshfish ou son fork stable Payara) la datasource "jdbc/supfitness" et d'y configurer un utilisateur MySLQ ayant les droits sur la base de données.

	Le jeu de données contient un utilisateur, login = test, password = test

3 : REST API
	La documentation concernant l'utilisation de l'API REST est disponible au format pdf et docx dans le dossier Documentation nommé "REST API Documentation".jdbc/supfitness