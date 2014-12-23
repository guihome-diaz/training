console.log("-------------------------- Exercise 1 ----------------------");

function theBridgeOfHoistingDoomE1Source() {
    function balrog(){
        return "fire";
    }
    var ring;
    function elf(){
        return "pointy ears";
    }
    ring = wizard;
    wizard = balrog;
    return wizard();
    function balrog(){
        return "whip";
    }
    function wizard(){
        return "white";
    }
    var power = ring();
    return elf();
    function elf(){
        return "immortal";
    }
}

console.log("CodeSchool version: " + theBridgeOfHoistingDoomE1Source());


function theBridgeOfHoistingDoomE1Student() {
  var ring = undefined;
  var power = undefined;
  
  function wizard(){
    return "white";
  }
  
  function balrog(){
    return "whip";
  }
    
  function elf(){
    return "immortal";
  }
  
  ring = wizard;
  wizard = balrog;
  
  return wizard();
}

console.log("Guillaume result: " + theBridgeOfHoistingDoomE1Student());


console.log("-------------------------- Exercise 2 ----------------------");
function theBridgeOfHoistingDoomE2Source( ){
  function fellowship(){
    return "friends";
  }
  var sword = "sting";
  var dwarf = function(){ 
    return "axe";
  };
  var fall = "Fly you fools!";
  fellowship = function(){
    return "broken";
  };
  // ring();
  return sword;
  fellowship = function(){
    return "mines";
  };
  sword = function(){
    return "glamdring";
  };
  var ring = function(){
      return "precious";
  };
  
}

console.log("CodeSchool version: " + theBridgeOfHoistingDoomE2Source());

function theBridgeOfHoistingDoomE2Student( ){
  var sword = undefined;
  var dwarf = undefined;
  var fall = undefined;
  var ring = undefined;
  
  function fellowship(){
    return "friends";
  }
  
  dwarf = function(){ 
    return "axe";
  };
  ring = function(){
      return "precious";
  };
  
  sword = "sting";
  fall = "Fly you fools!";
  
  ring();
  
  return sword;
  
}

console.log("Guillaume result: " + theBridgeOfHoistingDoomE2Student());

