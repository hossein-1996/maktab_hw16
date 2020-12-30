a=0
function print(){
    a+=1;
    var div = document.createElement("div");
    div.innerHTML = a;
    div.style.backgroundColor = getRandomColor();
    document.getElementById("card").appendChild(div);

    
}
function getRandomColor() {
    var letters = '0123456789ABCDEF';
    var color = '#';
    for(var i =0; i<6 ;i++) {
        color += letters[Math.floor(Math.random()*16)];
    }
    return color;
}