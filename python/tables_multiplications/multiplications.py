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
{CYAN}==========================
{BOLD}{RED}|{YELLOW} MULTIPLICATIONS TABLES {RED}|
{CYAN}=========================={RESET}
"""
print(msg)


# Choose 2 random number between 1 and 12
factor1 = random.randint(1, 12)
factor2 = random.randint(1, 12)

# Question to solve
print(YELLOW + f"{factor1} x {factor2} = ?" + RESET)

# Counters
trial = 0
max_retries = 3
expected_answer = factor1 * factor2
success = False

while trial < max_retries:
    start_time = time.time()
    try:
        user_answer = int(input(f"[trial {trial + 1}/{max_retries}] Response: "))
        response_time = time.time() - start_time
        if user_answer == expected_answer:
            print(GREEN + f"OK ({response_time: .2f} seconds)" + RESET)
            success = True
            break
        else:
            trial += 1
            print(RED + f"WRONG! Try again. ({response_time: .2f} seconds)" + RESET)
    except ValueError:
        print(RED + "Invalid response. You must type a number." + RESET)
        trial += 1
        continue

if not success:
    print(RED + "PERDU !!! Trop d'erreurs" + RESET)