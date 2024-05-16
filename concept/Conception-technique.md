
# Retro-conception

**Binome 1 : Antoine Chalançon
**Binome 2 : Guillaume Carlin

Complétez ce document pour décrire votre projet, les difficultés rencontrées, les design patterns mis en oeuvre, les améliorations possibles, et en quoi la POO vous a été utile.

> **Faites le avec sérieux, ce document ainsi que votre code seront évalués.**
Si vous considérez que votre code est quasi-parfait, je vais chercher les erreurs et en trouver, et cela vous pénalisera.
Si vous êtes critique envers vous-même et que vous expliquez correctement vos difficultés, vous serez "à moitié" pardonné.

Ce n'est pas grave de ne pas avoir été au bout de ce que vous vouliez faire, comportez vous comme un ingénieur qui doit rendre des comptes à son client, et qui doit expliquer pourquoi il n'a pas pu tout faire.
Pour rappel le client n'est pas un developpeur (sinon il ne vous aurait pas payé une fortune pour le faire à sa place), vous devez lui expliquer de manière simple et claire les problèmes rencontrés, en vous justifiant 
>Imaginez que vous avez codé Mortal Kombat 
Ne dites pas "je n'ai pas eu le temps de tout faire", mais plutôt "j'ai préféré me concentrer sur la création des spectaculaires "Finish Him" des personnages car c'est un élément essentiel du gameplay, cependant la difficulté dynamique en fonction de la maîtrise du joueur n'a pas pu être implémentée à temps, compte tenu que les critères de maîtrises sont difficilement modélisables, toutefois nous pourrions envisager d'implémenter que plus le combat dure longtemps, plus les coups portés sont puissants, ce qui est rapide à implémenter et lors d'une mise à jour, nous pourrions remplacer ce système par quelque chose de plus élaboré"

Aussi, en entreprise, vous serez confronté à des programmes très mal codés, et vous allez galérer à les comprendre, vous risquez d'essayer de les corriger et tomber dans les mêmes ecueils que les développeurs précédents.
Pour cela, il est courrant de tenir un jour un Document d'Architecture Technique (DAT) qui explique comment fonctionne le programme, et comment le reprendre ainsi qu'un document de réversibilité qui explique comment reprendre le code de quelqu'un d'autre.
(C'est obligatoire pour les marchés publics de prévoir une réversibilité, c'est à dire que le client peut vous dégager et une autre entreprise doit pouvoir reprendre votre code sans difficulté)
Dans ces documents, il ne s'agit pas de cacher la poussière sous le tapis, il faut être honnête et proposer une vision d'ensemble de votre code, et expliquer pourquoi vous avez fait des choix, et pourquoi vous n'avez pas fait d'autres choix, il est souvent question de compromis (on fait un truc pas ouf pour gagner du temps, mais la qualité du code en pâtit, etc.)
> Vous pouvez dire : "Pour la gestion des collisions, nous utilisons une librairie tierce, toutefois celle-ci ne gère que les collisions entre des rectangles, au fur et à mesure des itérations, des ennemis de grande taille et de forme complexe sont apparus, toutefois, nous avons conservé une hitbox rectangulaire, en résulte que le joueur peut être touché alors que visuellement, il n'est pas en contact avec l'ennemi ; nous avions également envisagé de créer plusieurs hitbox de tailles différentes sur un même ennemi afin de mieux coller à la forme de celui-ci, toutefois, les performances du jeu ont étés trop dégradées"



---
# Partie "Client" (pas trop technique) :

## Objectif du projet

Nous avons créé un jeu du type Tron. Le jeu se présente sous la forme d'un 1vs1 ou chaque personne contrôle un véhicule.
Le véhicule laisse une traînée derrière lui capable de tuer l'adversaire. Il faut donc éviter de toucher la traînée de l'adversaire pour ne pas perdre.
Le jeu comporte plusieurs véhicules qui possèdent chacune des caractéristiques différentes.
Des objets peuvent également spawn sur la map et octroyer différents bonus/malus aux joueurs.
Il existe differente carte avec des structures pouvant donner des nouvelle oppportunité de gameplay au joueurs

## Résultat

Nous avons préféré nous concentrer sur les véhicules, les objets et les trainés, car ce sont les éléments principaux
du gameplay pour une première partie cepandant, nous n'avons pas pu finaliser les diffèrentes carte du jeu, mais nous
pourront les implémenter dans de future mise à jour.
Nous avons aussi pu réaliser un menu fonctionnel qui permet de choisir le véhicule que le joueur souhaite utiliser,
ainsi que l'ajout d'une musique dans le menu et d'une autre pendant la partie

### Améliorations possibles

Implémenter différents modes de jeu et différents véhicules supplémentaires.
Implémenter de nouveaux bonus
Implementer des structures faisant partie de la carte
Implémenter differentes cartes

---
# Partie "Développeur" (plus technique) :


### Implémentations remarquables

La gestion de la traînée a été longue à faire, il a fallu mettre en place un système qui gère les différents points du trait en supprimant ce qui ne sont plus utilisée, tout en gérant la direction du trait.

### Faiblesses du code

Il y a beaucoup trop de ligne de code dans le menu. Nous n'avons pas eu le temps de divisée notre code en plusieurs pages donc nous avons fait le choix de tous laisser.
Nous aurions pu diviser en plusieurs parties la musique, le menu et la gestion des véhicules.

### Difficultés rencontrées

#### 1. Gestion des mouvements véhicules sur les changements de direction.

Notre véhicule faisait à chaque changement de direction un déplacement du sprite et de la hitbox du véhicule
qui n’était pas cohérent avec le mouvement que nous voulions. 
Nous avons pu contourner ce problème via l’utilisation d’un pane.


### *Design Patterns* mis en oeuvre

#### 1. [Factory]


Une factory a ici été utilisé pour pouvoir créer des vehicule de manière simple 

<pre>
```java
public class VehiculeFactory {
    public VehiculeFactory() {
    }

    public Vehicule CreateVehicule(VehiculeType vehicule) {
        return switch (vehicule) {
            case VehiculeType.MOTO -> new Moto(350, 250, 10, 1, "file:assets/LowShip.png", 6.0,5.0);
            case VehiculeType.VOITURE -> new Voiture(350, 250, 10, 1, "file:assets/MiddleShip.png", 5.0, 3.0);
            case VehiculeType.CAMION -> new Camion(350, 250, 10, 1, "file:assets/BigShip.png", 4.0, 1.0);
            default -> null;
        };
    }
}
```
</pre>

]

---

#### 2. Interface & decorator
Les interfaces nous ont permis de changer les caractéristiques des véhicules lorsqu'ils prennent un objet de manière à pouvoir facilement les empiler ou les retirer.

#### 3. Builder
Les builders nous ont permis de créer des objets pour les bonus en rendant le code pls simple à maintenir et à évoluer.

# Partie pédagogique


### En quoi la POO vous a été utile


La POO nous a permis de regrouper les caractéristiques communes de nos diffèrents véhicules en une classe.
Cette classe nous permet de rapidement concevoir des nouveaux véhicules qui sont facilement intégrable dans notre jeu.
La POO nous a aussi permis d’utiliser des design pattern qui nous ont été utile pour créer et ajouter des effets a nos 
véhicules sans pour autant modifier leur structure sous-jacente.

Pour la gestion des objets, la POO a permis de stocker plus simplement les objets et les informations 
qui nous sont importantes comme leurs effets, les horaires de spawn, etc ...
Sans la POO, toutes ces informations auraient dû être stockées dans des listes de listes 
ce qui aurait grandement complexifié le code et la manière d'accès à ces informations.
Cela nous a aussi permis de définir des attributs et des méthodes spécifiques à chaque type d'objet,
ce qui a facilité la gestion des collisions et des interactions entre les objets et les véhicules.




### Conclusion

Ce projet nous a permis de mieux comprendre comment fonctionnent les design pattern et les interfaces.
