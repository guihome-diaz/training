// =============================================================================
//                     JavaScript Best Pratices summary
//==============================================================================


// =========== ARRAY ===========     
["1","two","three + four"]

// Key methods
    splice(index,nb of entries to remove) : array of removed entries
    push(new entry)
    indexOf(query)


//  Do NOT use:
    for(x in array) 
//  Only classic 
    for(var i=0;i < array.length;i++)


//  To improve performances: 
    for (var i = 0, x = object.array.length, list = object.array; i < x; i++) {
        ... list[i] ...
    }




// =========== OBJECT ===========
{one: "1", two: "two", three: "three + four"}

// Access / create property
//  BAD:       
              this.swords = this.swords ? this.swords : [];
//  BETTER:    
              this.swords = this.swords || [];


// Function scope
// Do NOT add function to the object itself, but to its prototype!
// ==> Add all common functions to PROTOTYPE

//  BAD: 
    function SignalFire(ID, startingLogs) {
      this.fireId = ID;
      this.logsLefs = startingLogs;
      this.addLogs = function() { };
      this.lightFire = function() { };
      this.smokeSignal = function () { };
    }

//  BETTER: 
    function SignalFire(ID, startingLogs) {
      this.fireId = ID;
      this.logsLefs = startingLogs;
    }
    SignalFire.prototype = {
      addLogs: function() { }
      lightFire: function() { }
      smokeSignal: function () { }
    }


// To check Objects type | usage: 
   if (x instanceof MyObject) { }




// =========== DOM update (= HTML page update) ===========

// When you want to update the DOM, only refresh it ONCE.

//  HTML file:  
    ... <ul id="myElement"> </ul>

//  BAD:
//  In the following example the DOM is update for each element...
    var list = document.getElementById("myElement");
    var arrayList = ["val1","val2","val3","val4","val5"];
    for (var i = 0, x = arrayList.length; i < x; i++) {
      var element = document.createElement("li");
      element.appendChild(document.createTextNode(arrayList[i]));
      list.append(element);
    }

// BETTER: 
// In the following example the DOM is only update once :-)
// That is done through the 'fragment'
// For performances issues the "element" variable is declared outside the loop
    var list = document.getElementById("myElement"),
        arrayList = ["val1","val2","val3","val4","val5"],
        fragment = document.createDocumentFragment(),
        element;
    for (var i = 0, x = arrayList.length; i < x; i++) {
      element = document.createElement("li");
      element.appendChild(document.createTextNode(arrayList[i]));
      fragment.appendChild(element);
    }
    list.appendChild(fragment);




// =========== Strings ===========

// String concatenation on array
//  BAD: 
      var result;
      for (var i = 0; i < array.length; i++) {}
          results += array[i] + " ";
      }

// BETTER:  
      var result = myArray.join(" "); 




// =========== Comparisons ===========

// OPERATORS
//  == ensure content                    === strict comparison
//     it helps with type coercion           ensure similar type and content


  '4' == 4          true               '4' === 4            false 
  true == 1         true                true === 1          false
  false == 0        true                false === 0         false

//CAREFUL:
  "\n \n \t" == 0   true                "\n \n \t" === 0    false 


//RULE: always use strict comparison: 
        === 




// =========== Inheritance ===========
// Ex: ChainMail is a child of Armor

function Armor(location) { ... }
Armor.prototype = { ... }

function ChainMail(metal, weight) { ... }
ChainMail.prototype = Object.create(Armor.prototype);




// =========== Exception handling ===========

try {

} catch(error) {

} finally {

}




// =========== Things to avoid ===========

// Do NOT use: 
      with(){} 
// Use a cache variable instead like:
      var ref = myObject.myInnerClass


// Do NOT use:
      eval("javascript code");
// It's better to write code than creating runtime code dynamically


// For JSON data, use:
JSON.parse()




// =========== Numbers limits ===========

// BUG:
console.log(0.1 + 0.2)    >>>   0.300000000004

// Solution: you must use the following combination
//    * toFixed(num of decimal to display)   >> round value as String
//    * parseFloat()                         >> cast String into a Float
var num = 0.1 + 0.2;
var result = parseFloat(num.toFixed(1));
console.log(result);    >>> 0.3


// Use parseInt() to cast String into a Integer:  parseInt(value, radius);
// ex: Cast '21' into value in base 10 system. You can use base 2 || 16
parseInt(021, 10);      


// Never use NaN [Not a Number] only. You must peer it with 'typeof'
if (typeof data is "number" && !isNaN(data)) { ... }




// =========== Namespace ===========

// You should always set a namespace for all your JavaScript files.
// That will avoid overwrite of global variables on runtime


// BAD:
var list = ["one", "two", "three"];
var hof = document.getElementById("hof");
var displayHof = function() { ... }


// BETTER:
var MYFILENAMESPACE = {
  list: ["one", "two", "three"],
  hof: document.getElementById("hof"),
  displayHof: function() {
    ...
  }
};

// You can have nested namespaces
var MYFILENAMESPACE = {
  list: ["one", "two", "three"],
  hof: document.getElementById("hof"),
  displayHof: function() {
    ...
  },
  BIOGRAPHIES: {
    list: "some data",
    untoldBio: function() {
      ...
    }
  }
};

// Reminder:
MYFILENAMESPACE.list  !=  MYFILENAMESPACE.BIOGRAPHIES.list




// =========== Object attributes and methods scope ===========
//          private | public elements within namespace
// ===========================================================

// You can have the same notion as JAVA in JS:
//     ==> you can create public | private attributes and methods using closure

// 1. the namespace should be an immediate function
var ARMORY = (function(){ ... })();

// 2. Each "private" attribute or method will be bound to the function scope
//    using the 'var' keyword.
//    All "private" elements should be at the top.

// 3. Everything that is "public" must be in the return{ ... } element

// NOTE: private elements ==> var ... ;
//       public elements  ==> object style notation


var ARMORY = (function(){

  // private attributes
  var weaponList = ["excalibur", "sword", "claymore"];
  var armorList = ["helmet", "chain mail", "leather", "plate"];

  // private methods
  var removeWeapon = function(){...};
  var replaceWeapon = function(){...};
  var removeArmor = function(){...};
  var replaceArmor = function(){...};

  // public elements
  return {
      makeWeaponRequest: function(){...},
      markeArmorRequest: function(){...}
  };

})();


// RULE:
// Private properties are created in the local scope of the function expression.
// Public properties are built within the object which is then returned to 
// become the namespace. Access to private data is thus possible only because
// of closure within the larger module.




// You can also add some imports

var wartime = false;
var ARMORY = (function(war){

  // private attributes
  var weaponList = ["excalibur", "sword", "claymore"];
  var armorList = ["helmet", "chain mail", "leather", "plate"];

  // private methods
  var removeWeapon = function(){...};
  var replaceWeapon = function(){...};
  var removeArmor = function(){...};
  var replaceArmor = function(){...};

  // public elements
  return {
      makeWeaponRequest: function(){
        if(war) {
          // allow citizens to be armed 
        }
        ...
      },
      markeArmorRequest: function(){...}
  };

})(wartime);

// Your namespace ensures clarity of globals within a file.
// By using a parameter, you protect the imported data that might have been
// inaccessible. All imported data becomes immediately scoped to the closure,
// to be used in private data. Thus, when compared with importing the entire 
// application, declared variables are both clearer and faster.


