# java-data-analysis-library
TP 6 de DevOps, l'objectif ce TP est  la mise en oeuvre d'une bibliothèque de manipulation et d'analyse de données.

Nous avons utilisé la branche Master comme branche principale.

# Java Data Analysis Library

## Description

La bibliothèque Java Data Analysis (JADA) est un outil open-source conçu pour faciliter l'analyse de données en Java. Elle offre des fonctionnalités pour la manipulation de données tabulaires, le calcul de statistiques et la visualisation des données.

## Fonctionnalités

- **Création de DataFrames :** La bibliothèque permet de créer des DataFrames, des structures de données tabulaires similaires à des tableaux ou des feuilles de calcul.
  
- **Manipulation de données :** Elle offre des fonctionnalités pour sélectionner, filtrer et manipuler les données à l'intérieur des DataFrames.
  
- **Calcul de statistiques :** JADA permet de calculer diverses statistiques sur les données, telles que la moyenne, l'écart-type, le minimum, le maximum, etc.
  
- **Lecture de fichiers CSV :** La bibliothèque prend en charge la lecture de fichiers au format CSV pour créer des DataFrames à partir de données externes.

## Choix d'outils

Pour le développement de JADA, nous avons choisi les outils suivants :

- **Java :** Nous avons utilisé le langage de programmation Java pour le développement de la bibliothèque en raison de sa popularité et de sa polyvalence.

- **Maven :** Nous avons utilisé Maven comme outil de gestion de dépendances et de construction de projet Java. Maven simplifie la gestion des dépendances et la construction du projet.

- **Git :** Nous avons utilisé Git comme système de contrôle de version pour gérer le code source de manière collaborative.

## Workflow Git

Nous avons adopté le flux de travail Git suivant pour notre projet :

1. **Création de branches :** Chaque nouvelle fonctionnalité ou correctif de bug est développé dans la branche Master.

2. **Validation des Pull Requests :** Avant de fusionner une branche dans la branche principale (main), une Pull Request est créée et examinée par au moins un autre membre de l'équipe.

3. **Tests automatisés :** Avant la fusion, les tests automatisés doivent passer avec succès.

## Feedback

- **Java :** Java s'est avéré être un choix solide pour le développement de notre bibliothèque en raison de sa robustesse et de sa portabilité.

- **Maven :** Maven nous a permis de gérer efficacement les dépendances et de construire notre projet de manière cohérente.

- **Git :** Git a été indispensable pour la gestion du code source et le travail collaboratif sur le projet. Cependant, nous avons rencontré quelques difficultés avec les conflits de fusion.


[![codecov](https://codecov.io/gh/Lucixxe/java-data-analysis-library/branch/main/graph/badge.svg)](https://codecov.io/gh/Lucixxe/java-data-analysis-library)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Lucixxe_java-data-analysis-library&metric=alert_status)](https://sonarcloud.io/dashboard?id=votre-Lucixxe_java-data-analysis-library)
