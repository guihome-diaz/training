import random
import time

# ANSI escape codes for colors
GREEN = "\033[92m"
RED = "\033[91m"
YELLOW = "\033[93m"
CYAN = "\033[96m"
BOLD = "\033[1m"
RESET = "\033[0m"


msg = f"""


{CYAN}=============
{BOLD}{RED}|{YELLOW} Jeu Alexis {RED}|
{CYAN}============={RESET}

"""
print(msg)

compteur = 0
bonne_reponse = True

while(bonne_reponse):
    bonne_reponse = False
    print(f"\n{BOLD}{YELLOW} Question numero: {CYAN}{compteur + 1}{RESET}\n")
    try:
        chiffre_1 = int(input("Factor 1 ? "))
        chiffre_2 = random.randint(1, 12)
        print(f"{chiffre_1} x {chiffre_2} = ??")
        debut = time.time()

        resultat_humain = int(input("resultat ? "))
        fin = time.time()
        temps_reponse = fin - debut
        resultat_ordinateur = chiffre_1 * chiffre_2

        if resultat_humain == resultat_ordinateur:
            print(f"{GREEN}ok{RESET} | Temps de réponse: {temps_reponse: .2f} secondes")
            compteur = compteur + 1
            bonne_reponse = True
        else:
            print(f"{RED}ca va pas !?!{RESET} La bonne réponse était {resultat_ordinateur} | Temps de réponse: {temps_reponse: .2f} secondes")
    except ValueError:
        print(f"{RED}stupide! ce n'est pas un nombre!{RESET}")

print(f"nombre de bonnes réponses: {compteur}")