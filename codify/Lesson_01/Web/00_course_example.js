/*
 Aim: You are given an integer N
     Count the total of:  1 + 2 +  ... + N
 */

function countAlgoLoopProcess(limitN) {
    var nbOfOperation = 0;
    var result = 0;
    for (var i = 1; i <= limitN ; i++) {
        result += i;
        nbOfOperation++;
    }
    return [result, nbOfOperation];
}

function countAlgoSingleRun(limitN) {
    var nbOfOperation = 1;
    var result = 0;
    result = (limitN * (limitN + 1)) / 2;
    return [result, nbOfOperation];
}



// jQuery
$(document).ready(function() {

    // ----------------------------------------
    // Functions must be declared first
    // ----------------------------------------
    var adjustValues = function(limitN) {
        var loopResult = countAlgoLoopProcess(+limitN);
        $("#countAlgo").find(".resultAlgo1").text(loopResult[0]);
        $("#countAlgo").find(".nbOfOperationsAlgo1").text(loopResult[1]);

        var mathResult = countAlgoSingleRun(+limitN);
        $("#countAlgo").find(".resultAlgo2").text(mathResult[0]);
        $("#countAlgo").find(".nbOfOperationsAlgo2").text(mathResult[1]);
    };


    // ----------------------------------------
    // Set default values
    // ----------------------------------------
    adjustValues($("#countAlgo").find(".algoLimit").val());


    // ----------------------------------------
    // Adjust values on limit change
    // ----------------------------------------
    $("#countAlgo").on('change', ".algoLimit", function() {
        adjustValues($(this).val());
    });

});
