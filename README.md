# battle-sim-academy-softwareinside

Il programma simula un combattimento a turni tra un cavaliere e un mago contro un orco e un drago
Il combattimento termina quando entrambi i combattenti di una fazione (Eroi o Nemici) muoiono
# Cavaliere:

- Prende di mira il Dragone, una volta ucciso attaccherà l'orco
- Attacco con spada: attacco base (5% di probabilità di mancare il bersaglio)
- Attacco con arco: può scoccare una freccia se la faretra non è vuota (può portarne al massimo 3)
- Attacco a cavallo: se ha un cavallo può eseguire questo attacco che fa più danno dell'attacco base
- Riflessione: non attacca nel turno corrente, ma la sua forza aumenta per il resto del combattimento

# Mago: 
- Prende di mira l'orco, una volta ucciso attaccherà il Dragone;
- Ha a disposizione una borsa di pozioni curative che ne può contenere al massimo 3 
- 1 probabilià su 6 di trovare una pozione mentre combatte (Consuma l'azione del turno) 
- Attacco magico: attacco base, fa poco danno ed è l'attacco più probabile
- Folata magica: fa più danno rispetto all'attacco base, ma le probabilità che lo esegua sono 1 su 5
- Cura: può consumare una pozione per guadagnare punti vita (Consuma l'azione del turno)
- Cura Alleato: quando il cavaliere ha pochi punti vita può usare una pozione per curarlo (Consuma l'azione del turno)
# Orco:
- Prende di mira il mago, una volta ucciso attaccherà il cavaliere
- Attacca ad ogni turno
# Dragone:
- Prende di mira il cavaliere, una volta ucciso attaccherà il mago
- Attacca ad ogni turno

# Modalità:
Al momento ci sono due modalità di simulazione:

1- Tutti e 4 i personaggi attaccano nello stesso turno i loro bersagli

2- Ad ogni turno viene selezionato casualmente il personaggio che dovrà attaccare ed attaccherà il suo bersaglio

![Screenshot 2023-03-30 170001](https://user-images.githubusercontent.com/79428202/229160941-0120f6dc-df93-4fb0-bb0a-0dd5e757a293.png)

