

console.log("-------------------------- prototype test 1 ----------------------");


Array.prototype.countCattle = function(cattleType) {
  var cattleFound = 0;
  for (var cattle in this) {
    if (this[cattle].type === cattleType) {
      cattleFound++;
    }
  }
  return cattleFound;
};


console.log("-------------------------- prototype test 2 ----------------------");

// Source dataset
var forestCows = [
  {name: "Legolas", type: "calf", hadCalf: null},
  {name: "Gimli", type: "bull", hadCalf: null},
  {name: "Arwen", type: "cow", hadCalf: null},
  {name: "Galadriel", type: "cow", hadCalf: null},
  {name: "Eowyn", type: "cow", hadCalf: "Legolas"}
];


// Exercice
Object.prototype.noCalvesYet = function() {
  if (this.type === "cow" && this.hadCalf === null) {
    return true;
  } else {
    return false;
  }
};

Array.prototype.countForBreeding = function() {
  var numToBreed = 0;
  for (var index = 0; index < this.length; index++) {
    if (this[index].noCalvesYet()) {
      numToBreed++;
    }
  }
  return numToBreed;
};

console.log("Number of cows that are ready to breed: " + forestCows.countForBreeding());


console.log("-------------------------- prototype test 8 ----------------------");


var genericPost = {
  x: 0, 
  y: 0, 
  postNum: undefined, 
  connectionsTo: undefined,
  sendRopeTo: function ( connectedPost ) {
    if(this.connectionsTo == undefined){
      var postArray = [ ];
      postArray.push(connectedPost);
      this.connectionsTo = postArray;
    } else {
      this.connectionsTo.push(connectedPost);
    }
  },
  setY: function(newY) {
    this.y = newY;
    if (newY % 2 === 0) {
      this.numBirds = 0;
    }
  },
  setPostNum: function(newPostNum) {
    this.postNum = newPostNum;
    if (newPostNum % 2 === 0) {
      this.lightsOn = false;
    }
  }
};
// Create posts
var post8 = Object.create(genericPost);
post8.setPostNum(8);
post8.x = 0;
post8.setY(-3);
var post9 = Object.create(genericPost);
post9.setPostNum(9);
post9.x = 6;
post9.setY(8);
var post10 = Object.create(genericPost);
post10.setPostNum(10);
post10.x = -2;
post10.setY(3);
// Connect posts
post8.sendRopeTo(post10);
post9.sendRopeTo(post10);
// Manual assignment
post10.weathervane = "N";

console.log(post8);
console.log(post9);
console.log(post10);


console.log("-------------------------- prototype test 10 ----------------------");


function Fencepost (x, y, postNum){
  this.x = x;
  this.y = y;
  this.postNum = postNum;
  this.connectionsTo = [];
  this.sendRopeTo = function ( connectedPost ){
    this.connectionsTo.push(connectedPost);
  };
}
var post18 = new Fencepost(-3,4,18);
var post19 = new Fencepost(5,-1,19);
var post20 = new Fencepost(-2,10,20);

//post18.sendRopeTo(post20);
//post19.sendRopeTo(post18);

console.log(post18);
console.log(post19);
console.log(post20);


console.log("-------------------------- prototype test 13 ----------------------");


function Fencepost (x, y, postNum){
  this.x = x;
  this.y = y;
  this.postNum = postNum;
  this.connectionsTo = [];
  this.sendRopeTo = function ( connectedPost ){
    this.connectionsTo.push(connectedPost);
  };
}
var post25 = new Fencepost(-3,4,18);

Fencepost.prototype.valueOf = function() {
  var distance = Math.pow(this.x,2) + Math.pow(this.y,2);
  distance = Math.sqrt(distance);
  return distance;
};


console.log("distance to root ranch = " + post25.valueOf());


console.log("-------------------------- prototype test 14 ----------------------");


function Fencepost (x, y, postNum){
  this.x = x;
  this.y = y;
  this.postNum = postNum;
  this.connectionsTo = [];
}
Fencepost.prototype = {
  sendRopeTo: function ( connectedPost ){
    this.connectionsTo.push(connectedPost);
  },
  removeRope: function ( removeTo ){
    var temp = [];
    for(var i = 0; i<this.connectionsTo.length; i++){
      if(this.connectionsTo[i].postNum != removeTo){
        temp.push(this.connectionsTo[i]);
      }
    }
    this.connectionsTo = temp;
  },
  movePost: function (x, y){
    this.x = x;
    this.y = y;
  },
  valueOf: function (){
    return Math.sqrt( this.x*this.x + this.y*this.y );
  },
  toString: function() {
    var log = "Fence post #" + this.postNum + ":\n";
    log += "Connected to posts:\n";
    for(var i = 0; i < this.connectionsTo.length; i++) {
      log += this.connectionsTo[i].postNum + "\n";
    }
    log += "Distance from ranch: " + this.valueOf() + " yards";
    return log;
  }
};

var post30 = new Fencepost(-3,4,30);
var post31 = new Fencepost(9,1,31);
var post32 = new Fencepost(2,5,32);
var post33 = new Fencepost(1,2,33);

post30.sendRopeTo(post33);
post30.sendRopeTo(post31);
post31.sendRopeTo(post33);
post32.sendRopeTo(post33);

console.log(post30.toString());


/*
!!! CAREFUL !!! 
for ... in  ==> BAD in JavaScript
See:  http://stackoverflow.com/questions/500504/why-is-using-for-in-with-array-iteration-such-a-bad-idea
*/
