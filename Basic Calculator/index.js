//CALCULATOR PROGRAM

const display = document.getElementById("display");

function appendToDisplay(input){
    display.value += input;
}
function clearDisplay(){
    display.value = "";
}
function calculate(){
    try{
        display.value = eval(display.value);
    }
    catch(error){
        display.value = "ERROR";
    }
}
let memoryValue = 0;

// Calculate square root
function calculateSquareRoot(){
    try{
        display.value = Math.sqrt(eval(display.value));
    }
    catch(error){
        display.value = "ERROR";
    }
}

// Calculate percentage
function calculatePercentage(){
    try{
        display.value = eval(display.value) / 100;
    }
    catch(error){
        display.value = "ERROR";
    }
}

// Memory Clear
function memoryClear(){
    memoryValue = 0;
}

// Memory Recall
function memoryRecall(){
    display.value += memoryValue;
}

// Memory Add
function memoryAdd(){
    memoryValue += parseFloat(display.value);
    clearDisplay();
}

// Memory Subtract
function memorySubtract(){
    memoryValue -= parseFloat(display.value);
    clearDisplay();
}

//Error Handling Enhancements
function calculate(){
    try{
        let result = eval(display.value);
        if(result === Infinity || result === -Infinity){
            throw new Error("Division by zero");
        }
        display.value = result;
    }
    catch(error){
        display.value = "ERROR";
    }
}
