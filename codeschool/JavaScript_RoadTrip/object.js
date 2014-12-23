

console.log("-------------------------- Object test 2 ----------------------");
var vehicle1 = {type: "Motorboat", capacity: 6, storedAt: "Ammunition Depot"};
var vehicle2 = {type: "Jet Ski", capacity: 1, storedAt: "Reef Dock"};
var vehicle3 = {type: "Submarine", capacity: 8, storedAt: "Underwater Outpost"};
var vehicles = [ vehicle1, vehicle2, vehicle3];

var findVehicle = function(name, list) {
  for (var i = 0; i < list.length; i++) {
    if (list[i].type === name) {
      return list[i];
    }
  }
}

console.log(findVehicle("Jet Ski", vehicles));



console.log("-------------------------- Object test 3 ----------------------");

var superBlinders = [ ["Firestorm", 4000], ["Solar Death Ray", 6000], ["Supernova", 12000] ];
var lighthouseRock = {
  gateClosed: true,
  weaponBulbs: superBlinders,
  capacity: 30,
  secretPassageTo: "Underwater Outpost",
  numRangers: 3,
  ranger1: {name: "Nick Walsh", skillz: "magnification burn", station: 2},
  ranger2: {name: "Drew Barontini", skillz: "uppercut launch", station: 3},
  ranger3: {name: "Christine Wong", skillz: "bomb defusing", station: 1},	
  addRanger: function (name, skillz, station){
    this.numRangers++;
    this["ranger" + this.numRangers] = {
      name: name, 
      skillz: skillz, 
      station: station 
    }; 
  }
};

lighthouseRock.addBulb = function(name, wattage) {
  this.weaponBulbs.push([name, wattage]);
};

lighthouseRock.addBulb("Sun beam", 8000);
console.log(lighthouseRock.weaponBulbs.map(function (item) { return item[0] + ", " + item[1]}));


console.log("-------------------------- Object test 4 ----------------------");

var vehicle3 = {
  type: "Submarine", capacity: 8, storedAt: "Underwater Outpost",
  ranger1: { name: "Gregg Pollack", skillz: "Lasering", dayOff: "Friday"},
  ranger2: { name: "Bijan Boustani", skillz: "Roundhouse Kicks", dayOff: "Tuesday"},
  ranger3: { name: "Ashley Smith", skillz: "Torpedoing", dayOff: "Friday"},
  ranger4: { name: "Mark Krupinski", skillz: "Sniping", dayOff: "Wednesday"},
  numRangers: 4
};

var relieveDuty = function(vehicle, day) {
  var offDuty = [];
  var onDuty = [];
  for (var i = 1; i <= vehicle.numRangers ; i++) {
	  // Get current ranger
    var currentRanger = vehicle["ranger" + i];
    // Check for day off
    if (currentRanger.dayOff === day) {
      offDuty.push(currentRanger);
    } else {
      onDuty.push(currentRanger);
    }
    // Delete ranger object from source
    delete vehicle["ranger" + i];
  }
  
  // Re-add onDuty soldiers
  for(var j = 0; j < onDuty.length; j++) {
    vehicle["ranger" + (j + 1)] = onDuty[j];
  }
  
  // Adjust number of soliers for the day
  vehicle.numRangers -= offDuty.length;
  
  return offDuty;
};



console.log(
    "OffDuty soldiers: \n >>>> " +
	relieveDuty(vehicle3, "Friday").map(
		function (item) {
			return "[ name: " + item.name + ", skillz: " + item.skillz + ", dayOff: " + item.dayOff + " ]"
		}
	)
);

console.log(
    "Available rangers: \n >>>> " + vehicle3
);



console.log("-------------------------- Object test 5 ----------------------");

var rockSpearguns = {
  Sharpshooter: {barbs: 2, weight: 10, heft: "overhand"},
  Pokepistol: {barbs: 4, weight: 8, heft: "shoulder"},
  Javelinjet: {barbs: 4, weight: 12, heft: "waist"},
  Firefork: {barbs: 6, weight: 8, heft: "overhand"},
  "The Impaler": {barbs: 1, weight: 30, heft: "chest"}
};
function listGuns(guns) {
  for (var speargun in guns) {
  	console.log("Behold! " + speargun + 
  				", with " +
  				 guns[speargun].heft +
  				 " heft!");
  }
}
listGuns(rockSpearguns);



console.log("-------------------------- Object test 6 ----------------------");


var rockSpearguns2 = {
  Sharpshooter: {barbs: 2, weight: 10, heft: "overhand"},
  Pokepistol: {barbs: 4, weight: 8, heft: "shoulder"},
  Javelinjet: {barbs: 4, weight: 12, heft: "waist"},
  Firefork: {barbs: 6, weight: 8, heft: "overhand"},
  "The Impaler": {barbs: 1, weight: 30, heft: "chest"},
  
  listGuns: function() {
    for(var property in this){
        if (this[property]["heft"] != undefined) {
          console.log("Behold! " + property + ", with " + this[property]["heft"] + " heft!");
       }
     }
  }

};
rockSpearguns2.listGuns();

