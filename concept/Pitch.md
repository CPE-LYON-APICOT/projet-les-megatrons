# Pitch du projet

Notre projet est de créer un jeu Tron.
Le jeu comportera plusieurs véhicules avec des caractéristiques différentes.

Les véhicules :
- Moto : La Moto est très rapide, mais la traînée crée disparais très vite.
- Voiture : La Voiture est moyennement rapide et possède une traînée qui disparaît moins vite que la moto.
- Camion : Le camion est plutôt lent, mais sa traînée disparaît très lentement.

## TODO : Décrivez votre projet
Montrez qu'il mobilise des techniques de POO avancée
Comment allez-vous utiliser les patrons de conception ?
Comment allez-vous utiliser l'architecture MVC ?

On va utiliser l'architecture MVC en ayant :
- un modèle qui va représenter les données de jeu comme les positions, les collisions, etc.
- une vue qui va affiche la page de jeu
- un contrôleur qui va gérer les interactions utilisateurs comme les commandes. Le contrôleur va mettre à jour le modèle et actualiser la vue pour implémenter ses nouvelles données.