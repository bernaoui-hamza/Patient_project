# patient_project
--------Introduction--------
Notre objectif en choisissant ce projet était de se familiariser avec toute l'architecture J2EE et de découvrir les frameworks
les plus couramment dans le développement web en java. Pour ce faire, nous avons choisi de les mettre en oeuvre dans un site de gestion de Patients. 
Néanmoins, le véritable objectif reste la manipulation de toutes ces technologies en vue de nous futurs stages.

--------L'environnement de développement------------
IntelliJ IDEA également appelé « IntelliJ », « IDEA » ou « IDJ » est un environnement de développement intégré (en anglais Integrated Development Environment - IDE)
destiné au développement de logiciels informatiques reposant sur la technologie Java. Il est développé par JetBrains (anciennement « IntelliJ ») et disponible 
en deux versions, l'une communautaire, open source,
sous licence Apache 2 et l'autre propriétaire, protégée par une licence commerciale. Tous deux supportent les langages de programmation Java, 
Kotlin, Groovy et Scala.!
![intellig_img](https://user-images.githubusercontent.com/89554025/165275257-4daa77ea-d709-4cf6-bafd-e9844edfaf76.png)

---------------Appach Tomcat--------------
Tomcat est un conteneur de Servlet J2EE issu du projet Jakarta, Tomcat et est désormais un projet principal de la fondation Apache. C'est un conteneur de Servlet
J2EE qui implémente la spécification des Servlets et des JSP de Sun Microsystems. Tomcat est en fait chargé de compiler les pages JSP avec Jasper pour 
en faire des Servlets (une servlet étant une application 
Java qui permet de générer dynamiquement des données au sein d'un serveur http). Généralement, ces données sont présentées sous forme de page HTML coté client.

--------------Architecture et mise en place du modèle MVC-----------------
la couche dao s'occupe de l'accès aux données, le plus souvent des données persistantes au sein d'un SGBD.
1 la couche métier implémente les algorithmes " métier " de l'application. Cette couche est indépendante de toute forme d'interface avec l'utilisateur.
Ainsi elle doit être utilisable aussi bien avec une interface console, une interface web, une interface de client riche. Elle doit ainsi pouvoir être testée
en-dehors de l'interface web et notamment avec une interface console. C'est généralement la couche la plus stable 
de l'architecture. Elle ne change pas si on change l'interface utilisateur ou la façon d'accéder aux données nécessaires au fonctionnement de l'application.

la couche interface utilisateur qui est l'interface (graphique souvent) qui permet à l'utilisateur de piloter l'application et d'en recevoir des informations.

Les couches métier et dao sont normalement utilisées via des interfaces Java. Ainsi la couche métier ne connaît de la couche dao que son ou ses interfaces 
et ne connaît pas les classes les implémentant. C'est ce qui assure l'indépendance des couches entre-elles : changer l'implémentation de la couche dao n'a aucune 
incidence sur
la couche métier tant qu'on ne touche pas à la définition de l'interface de la couche dao. Il en est de même entre les couches interface utilisateur et métier.
