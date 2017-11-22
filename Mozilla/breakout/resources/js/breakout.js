// Breakout javascript code
// This is based on the Mozilla Gamedev tutorial: https://developer.mozilla.org/fr/docs/Games/Workflows/2D_Breakout_game_pure_JavaScript
// 
// -----------------------------------------------------------------------------
// File's content has been adjusted for training purposes
// @author: Mozilla foundation (v1)
// @author: Guillaume Diaz (v2) - adjustments while doing the tutorial
// @version 2: 2017-11
// -----------------------------------------------------------------------------

// !! IMPORTANT!! 
// To work with a displayed element when the JavaScript is declared on top of the HTML
// you MUST wait for the DOM to be completly loaded. That's why you need to listen for
// 'DOMContentLoaded' event
document.addEventListener('DOMContentLoaded',domLoaded,false);
function domLoaded(){
    // orchestration
    // Retrieve HTML element to work with
    var canvas = document.getElementById("gameCanvas");

    // 2D rendering context
    var ctx = canvas.getContext("2d");

    // Draw things
    drawRectangleFilled(ctx);
    drawCircle(ctx);
    drawRectangleNotFilled(ctx);
}

function drawRectangleFilled(ctx) {
    // open 2D context
    ctx.beginPath();
    // Draw things
    ctx.rect(20, 40, 50, 70);
    ctx.fillStyle = "#FF0000";
    ctx.fill();
    // close 2D context
    ctx.closePath();
}

function drawCircle(ctx) {
    ctx.beginPath();
    ctx.arc(240, 160, 20, 0, Math.PI*2, false);
    ctx.fillStyle = "green";
    ctx.fill();
    ctx.closePath();
}

function drawRectangleNotFilled(ctx) {
    ctx.beginPath();
    ctx.rect(160, 10, 100, 40);
    ctx.strokeStyle = "rgba(0, 0, 255, 0.5)";
    ctx.stroke();
    ctx.closePath();
}

