//CALCULATOR PROGRAM

const display = document.getElementById("display");
const memoryList = document.getElementById("memory-list");
let memoryValue = 0;
let memoryHistory = [];

function appendToDisplay(input){
    display.value += input;
}
function clearDisplay(){
    display.value = "";
}
function calculate(){
    try{
        let result = eval(display.value);
        if (result === Infinity || result === -Infinity) {
            throw new Error("Division by zero");
        }
        display.value = result;
    }
    catch(error){
        display.value = "ERROR";
    }
}

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
    memoryHistory = [];
    updateMemoryList();
}

// Memory Recall
function memoryRecall(){
    display.value += memoryValue;
}

// Memory Add
function memoryAdd(){
    if (display.value !== "") {
        memoryValue += parseFloat(display.value);
        memoryHistory.push(`M+ : ${parseFloat(display.value)}`);
        updateMemoryList();
        clearDisplay();
    }
}

// Memory Subtract
function memorySubtract(){
    if (display.value !== "") {
        memoryValue -= parseFloat(display.value);
        memoryHistory.push(`M- : ${parseFloat(display.value)}`);
        updateMemoryList();
        clearDisplay();
    }
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

function updateMemoryList() {
    memoryList.innerHTML = "";  // Clear the list
    memoryHistory.forEach((item) => {
        const li = document.createElement("li");
        li.textContent = item;
        memoryList.appendChild(li);
    });
}