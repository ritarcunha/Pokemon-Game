document.getElementById("menu_").addEventListener("click", function(event) {  mn_(false); event.stopPropagation();});
document.body.addEventListener("click", function(event) { mn_(true);});
function mn_(fechar){let x = document.getElementById("navigation"); if(x.style.display != "block" && fechar == false) { x.style.display = "block";} else { x.style.display = "none";}}