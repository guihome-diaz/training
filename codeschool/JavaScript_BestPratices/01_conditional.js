var isArthur = true;
var isKing = true;

console.log("\n\n-------------------------- Ternary conditional ----------------------");
console.log("               == alternate if(){...} else{...} form")
console.log("---------------------------------------------------------------------");

/* Even though it is possible to have a Ternary conditional on N lines and execute N commands,
   you should use if(){}else{} for that !  */

// Basic Ternary conditional
isArthur ? true : false;

// Ternary conditional on N lines
console.log(">>>>>>>>>> Introduction | immediate functions");
isArthur && isKing ? function() {
                        alert("Hi, king Arthur");
                        console.log("Current weapon: Excalibur");
                      }()
                      : 
                      function() {
                        alert("Hi fellow knight, let's charge for the glory of the king!");
                        console.log("Current weapon: Longsword");
                      }();

// Ternary conditional that execute N actions. 
// Each action is separated by a comma
console.log(">>>>>>>>>> Introduction | many instructions");
isArthur && isKing ? (weapon = "Excalibur", helmet = "Goosewhite", function() {   
                          alert("Hi, king Arthur. You've performed multiple actions!");
                        }()
                      )
                      : 
                      (weapon = "Longsword", helmet = "Iron helm", function() {
                          alert("Hi fellow knight, let's perform multiple actions");
                        }()
                      );
console.log("Current weapon & helmet: " + weapon + ", " + helmet);

// function(){ ... }() ==> immediate execution



console.log(">>>>>>>>>> Alternative to ternary using OR operator");

// 'classic' check 
var armory = { addSword: function(sword) {
                  // Get 'swords' array or create it on 1st run
                  this.swords = this.swords ? this.swords : [];
                  this.swords.push(sword);
                }
              };

// Better check
var armory = { addSword: function(sword) {
                  // Get 'swords' array or create it on 1st run
                  this.swords = this.swords || [];
                  this.swords.push(sword);
                }
              };
armory.addSword("katana");
armory.addSword("sword");
armory.addSword("glaive");
armory.addSword("shield");
console.log("Armory content: " + armory.swords);



console.log(">>>>>>>>>> Complement to ternary using AND operator");

armory.retrieveSword = function(request) {
  return (this.swords.indexOf(request) >= 0) ? 
    // to cast the array into String value we must use the splice's return array index[0]
    this.swords.splice(this.swords.indexOf(request), 1)[0] :
    alert("No " + request + " in armory");
}
var isKnight = true;
var weapon = isKnight && armory.retrieveSword("katana");
console.log("Knight's weapon is: " + weapon);
console.log("Armory contains: " + armory.swords);


