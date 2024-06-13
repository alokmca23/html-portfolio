//detecting button press

var totalDrumItems = document.querySelectorAll(".drum").length;
for(var i=0; i<totalDrumItems; i++){
    document.querySelectorAll("button")[i].addEventListener("click", function(){
       var content = this.innerHTML;
       makeSound(content);
       buttonAnimation(content);
    });

}


//Detecting keyboard press
document.addEventListener("keypress",function(event){
    makeSound(event.key);
    buttonAnimation(event.key);
})

function makeSound(arg){
    var audio;
       switch(arg){
        case "w": audio = new Audio("./sounds/crash.mp3");
            break;
        case "a": audio = new Audio("./sounds/kick-bass.mp3");
            break;
        case "s": audio = new Audio("./sounds/snare.mp3");
            break;
        case "d": audio = new Audio("./sounds/tom-1.mp3");
            break;
        case "j": audio = new Audio("./sounds/tom-2.mp3");
            break;
        case "k": audio = new Audio("./sounds/tom-3.mp3");
            break;
        case "l": audio = new Audio("./sounds/tom-4.mp3");
            break;
        default: alert(arg);
       }
       audio.play();
}

function buttonAnimation(currentKey){

    var activeButton = document.querySelector("."+ currentKey);
    activeButton.classList.add("pressed");
    
    setTimeout (function (){activeButton.classList.remove("pressed");},200);
}