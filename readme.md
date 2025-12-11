nayssam.benessalah.etu@univ-lille.fr

Conception rélisé avec Mehdi Rabi en td.

J'ai effectué l'entiereté du tp. Il peut sembler y avoir peu de test car toutes les méthodes qui ont des comportements évidents n'ont pas été téstées. Notamment pour la classe player ou plusieurs classe héritante de cell qui n'ont pas de méthodes compliqués.

## Commandes (se placer dans /tp8 ):

### Compilation :

```javac -sourcepath src src/goosegame/*.java -d classes```

### Execution :

Sans le .jar (mettre les joueurs en argument) :

```java -classpath classes/ goosegame.GameMain```

Création du jar executable :

```jar cvfe game.jar goosegame.GameMain -C classes .```

Execution avec le .jar (mettre les joueurs en arguments):

```java -jar game.jar```

### Compilation des test

```javac -classpath junit-console.jar:classes test/goosegame/*.java```

### Execution des tests

```java -jar junit-console.jar -classpath test:classes -scan-classpath```

### Génération de la documentation

```javadoc -sourcepath src -subpackages goosegame -d docs```
