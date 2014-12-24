var imported = document.createElement('script');
imported.src = '/02_performances_extraLongArray.js';
document.head.appendChild(imported);



console.log("\n\n-------------------------- Performances trick ----------------------");


function monitorSingleExecution(logFunction, functionToExecute, testParams) {
  var startTime = +new Date();

  console.time(logFunction);
  var result = functionToExecute(testParams);
  console.timeEnd(logFunction);
  
  var elapsedTime = +new Date() - startTime;
  console.log(logFunction + " ~ Explicit memory access: " + result);
}


function SpeedTest(functionName, functionToTest, testParams, nbOfExecutions) {
  this.functionName = functionName;
  this.functionToTest = functionToTest;
  this.testParams = testParams;
  this.nbOfExecutions = nbOfExecutions || 100;
  // Function average execution time in ms
  this.averageExecuteTimeInMs = 0;
}
SpeedTest.prototype = {
  startTest: function(){
    var beginTime, endTime, sumExecutionsTimes = 0;
    for (var i = 0, nbTimesToRun = this.nbOfExecutions; i < nbTimesToRun; i++){
      beginTime = +new Date();
      // Function to test
      this.functionToTest(this.testParams);
      endTime = +new Date();
      sumExecutionsTimes += endTime - beginTime;
    }
    this.average = sumExecutionsTimes / this.nbOfExecutions;
    return console.log(this.functionName + " ~ Average execution accross " + this.nbOfExecutions + " times: " + this.average + " ms");
  }
}





// ----------------------- Functions to process (declaration) -----------------------

// Standard way. Pb: everytime it needs to extract the length again! (no cache)
var functionStandardWay = function(arrayToTest) {
  var temp = "", memoryAccessCount = 0;
  for (var i = 0; i < arrayToTest.dataContent.length; i++) {
    temp += arrayToTest.dataContent[i];
    memoryAccessCount += 7;
  }
  return memoryAccessCount;
};

// With cache (bad)
var functionWithCacheBad = function(arrayToTest) {
  var temp = "", memoryAccessCount = 3;
  var arraySize = arrayToTest.dataContent.length;
  for (var i = 0; i < arraySize; i++) {
    temp += arrayToTest.dataContent[i];
    memoryAccessCount += 5;
  }
  return memoryAccessCount;
};

// With cache (good!)
var functionWithCacheGood = function(arrayToTest) {
  var temp = "", memoryAccessCount = 3;
  for (var i = 0, arraySize = arrayToTest.dataContent.length; i < arraySize; i++) {
    temp += arrayToTest.dataContent[i];
    memoryAccessCount += 5;
  }
  return memoryAccessCount;
};


// With cache + reference (better than good: we also cache the array reference)
var functionWithCacheAndReference = function(arrayToTest) {
  var temp = "", memoryAccessCount = 5;
  for (var i = 0, arraySize = arrayToTest.dataContent.length, list = arrayToTest.dataContent; i < arraySize; i++) {
    temp += list[i];
    memoryAccessCount += 4;
  }
  return memoryAccessCount;
};



// ----------------------- Functions to process (runtime) -----------------------

// Single execution monitor
monitorSingleExecution("standard way timer", functionStandardWay, extraLongArray);
monitorSingleExecution("with cache (bad)", functionWithCacheBad, extraLongArray);
monitorSingleExecution("with cache (good)", functionWithCacheGood, extraLongArray);
monitorSingleExecution("with cache + reference", functionWithCacheAndReference, extraLongArray);


// Average execution time
var standardCodeSpeed = new SpeedTest("Standard method", functionStandardWay, extraLongArray);
var cacheBadCodeSpeed = new SpeedTest("With cache (bad)", functionWithCacheBad, extraLongArray);
var cacheGoodCodeSpeed = new SpeedTest("With cache (good)", functionWithCacheGood, extraLongArray);
var cacheAndReferenceCodeSpeed = new SpeedTest("With cache + reference", functionWithCacheAndReference, extraLongArray);
standardCodeSpeed.startTest();
cacheBadCodeSpeed.startTest();
cacheGoodCodeSpeed.startTest();
cacheAndReferenceCodeSpeed.startTest();


