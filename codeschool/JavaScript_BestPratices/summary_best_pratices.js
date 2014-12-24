=============================================================================
                                  SUMMARRY
=============================================================================

ARRAY:     ["1","two","three + four"]
    * splice(index,nb of entries to remove) : array of removed entries
    * push(new entry)
    * indexOf(query)
  Do NOT use for(x in array) !!! only classic for(var i=0;i < array.length;i++)

  To improve performances: 
    for (var i = 0, arraySize = object.array.length, list = object.array; i < arraySize; i++) {
        ... list[i] ...
    }


-----------------------------------------------


OBJECT:    {one: "1", two: "two", three: "three + four"}

ACCESS / CREATE PROPERTY
  BAD:       this.swords = this.swords ? this.swords : [];
  BETTER:    this.swords = this.swords || [];"



Do NOT add function to the object itself, but to its prototype!
==> Add all common functions to PROTOTYPE

  BAD: 

    function SignalFire(ID, startingLogs) {
      this.fireId = ID;
      this.logsLefs = startingLogs;
      this.addLogs = function() { };
      this.lightFire = function() { };
      this.smokeSignal = function () { };
    }

  BETTER: 
    
    function SignalFire(ID, startingLogs) {
      this.fireId = ID;
      this.logsLefs = startingLogs;
    }
    SignalFire.prototype = {
      addLogs: function() { }
      lightFire: function() { }
      smokeSignal: function () { }
    }


-----------------------------------------------


When you want to update the DOM, only refresh it ONCE.

  HTML file:  ... <ul id="myElement"> </ul>

  BAD:
    // In the following example the DOM is update for each element... :O
    var list = document.getElementById("myElement");
    var arrayList = ["val1","val2","val3","val4","val5"];
    for (var i = 0, x = arrayList.length; i < x; i++) {
      var element = document.createElement("li");
      element.appendChild(document.createTextNode(arrayList[i]));
      list.append(element);
    }

  BETTER: 
    // In the following example the DOM is only update once... :-)
    // That is done through the 'fragment'
    // For performances issues the "element" variable is declared once - outside the loop
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


-----------------------------------------------


String concatenation
  * on array instead of += use: var result = myArray.join(); 
