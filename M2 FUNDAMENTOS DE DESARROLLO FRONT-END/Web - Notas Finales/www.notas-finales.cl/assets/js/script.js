
let h1 = parseInt(prompt("Ingrese nota 1 [HTML]"));
let h2 = parseInt(prompt("Ingrese nota 2 [HTML]"));
let h3 = parseInt(prompt("Ingrese nota 3 [HTML]"));
let hp = ((h1 + h2 + h3) / 3).toFixed(2);

document.getElementById("n1html").innerHTML = h1;
document.getElementById("n2html").innerHTML = h2;
document.getElementById("n3html").innerHTML = h3;
document.getElementById("nphtml").innerHTML = hp;

let c1 = parseInt(prompt("Ingrese nota 1 [CSS]"));
let c2 = parseInt(prompt("Ingrese nota 2 [CSS]"));
let c3 = parseInt(prompt("Ingrese nota 3 [CSS]"));
let cp = ((c1 + c2 + c3) / 3).toFixed(2);

document.getElementById("n1css").innerHTML = c1;
document.getElementById("n2css").innerHTML = c2;
document.getElementById("n3css").innerHTML = c3;
document.getElementById("npcss").innerHTML = cp;

let j1 = parseInt(prompt("Ingrese nota 1 [JavaScript]"));
let j2 = parseInt(prompt("Ingrese nota 2 [JavaScript]"));
let j3 = parseInt(prompt("Ingrese nota 3 [JavaScript]"));
let jp = ((j1 + j2 + j3) / 3).toFixed(2);

document.getElementById("n1js").innerHTML = j1;
document.getElementById("n2js").innerHTML = j2;
document.getElementById("n3js").innerHTML = j3;
document.getElementById("npjs").innerHTML = jp;








