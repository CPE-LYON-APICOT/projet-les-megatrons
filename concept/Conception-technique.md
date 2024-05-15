
# Retro-conception

**Binome 1 : [Nom Prénom]**
**Binome 2 : [Nom Prénom]**

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

[Décrivez ici l'objectif initial du projet, ne cherchez pas à le minorer si vous n'avez pas tout fini, décrivez ce que vous avez voulu faire]
Nous avons créé un jeu du type Tron. Le jeu se présente sous la forme d'un 1vs1 ou chaque personne contrôle un véhicule.
Le véhicule laisse une traînée derrière lui capable de tuer l'adversaire. Il faut donc éviter de toucher la traînée de l'adversaire pour ne pas perdre.
Le jeu comporte plusieurs véhicules qui possèdent chacune des caractéristiques différentes.
Des objets peuvent également spawn sur la map et octroyer différents bonus/malus aux joueurs.

## Résultat
[Avez vous atteint votre objectif ?]
Nous n'avons pas réussi à implémenter tous les objectifs. Les objets ne sont pas finis. Les véhicules sont finis, mais il n'y a pas de menu pour sélectionner sa voiture, il faut directement modifier le jeu.

### Améliorations possibles

[Décrivez ici les améliorations que vous auriez pu apporter si vous aviez eu plus de temps]
Implémenter différents modes de jeu et différents véhicules supplémentaires.

---
# Partie "Développeur" (plus technique) :


### Implémentations remarquables

[Si pendant votre implémentation, vous trouvez que vous pouvez être particulièrment fiers d'une partie de votre code, décrivez là ici ; par exemple si vous avez généré une carte de manière procédurale, ou à l'aide d'un fichier]
La gestion de la traînée a été longue à faire, il a fallu mettre en place un système qui gère les différents points du trait en supprimant ce qui ne sont plus utilisée, tous en gérant la direction du trait.

### Faiblesses du code

[C'est ici que vous me dites ce que vous savez que vous avez mal fait, expliquez pourquoi vous avez fait ce choix (manque de temps, manque de compétence, trop pénible à faire, etc.)]

### Difficultés rencontrées

#### 1. [Génération dynamique des ... pour ...]

[Expliquez ici la difficulté rencontrée et comment vous l'avez contournée]

#### 2. [Gestion des collisions]

[Exemple : Nous n'avons pas réussi à gérer les collisions, PARCE QUE, mes objets n'héritaient pas d'une classe commune, car nos objets héirtaient de ... et nos personnages de ...]


### *Design Patterns* mis en oeuvre

#### 1. [Factory]
[Décrivez ici brièvement le design pattern utilisé et pourquoi]
[Ajouter éventuellement des exemples de code pour montrer l'élégence de votre solution, pour cela vous pouvez écrire en Markdown votre code ainsi :

<pre>
```java
public class Factory {
    public static Object createObject(String type) {
        if (type.equals("type1")) {
            return new Type1();
        } else if (type.equals("type2")) {
            return new Type2();
        }
        return null;
    }
}
```
</pre>

]


Nous avons utilisée des Fabricators pour simplifier la création des véhicules et des objets.

---
# Partie pédagogique


### En quoi la POO vous a été utile

[Par exemple, expliquez que vous auriez éprouvé des difficultés à gérer les collisions si vous n'aviez pas utilisé la POO, ou que vous avez pu facilement ajouter des fonctionnalités à votre jeu grâce à la POO
Minimum 10 lignes (personnalisé en fonction de votre projet)]

La POO nous à été utile pour les véhicules car ils possèdent des statistiques variables et des fonctionnalités différentes mais ils possèdent tous la même base.
La POO à permis de simplifier grandement la création des véhicules. 

### Conclusion

[Décrivez ici si vous avez compris un concept particulier que vous n'aviez pas compris en cours, inversement si vous pensiez qu'il était possible de faire qqchose mais que cela ne s'est pas passé comme prévu]
