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
        saveToMemory(result);
    }
    catch(error){
        display.value = "ERROR";
    }
}

// Calculate square root
function calculateSquareRoot(){
    try{
        display.value = Math.sqrt(eval(display.value));
        display.value = result;
        saveToMemory(result);
    }
    catch(error){
        display.value = "ERROR";
    }
}

// Calculate percentage
function calculatePercentage(){
    try{
        display.value = eval(display.value) / 100;
        display.value = result;
        saveToMemory(result);
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
    if (memoryValues.length > 0) {
        display.value = memoryValues[memoryValues.length - 1]; // Recall last saved value
    }
}

// Memory Add
function memoryAdd(){
    if (display.value !== "") {
        let value = parseFloat(display.value);
        memoryValues.push(value);
        updateMemoryList(); // Update memory display
        clearDisplay();
    }
}

// Memory Subtract
function memorySubtract(){
    if (display.value !== "") {
        let value = -parseFloat(display.value);  // Store the negative value
        memoryValues.push(value);
        updateMemoryList(); // Update memory display
        clearDisplay();
    }
}

function saveToMemory(value) {
    memoryValues.push(value);
    updateMemoryList();
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
    memoryValues.forEach((item) => {
        const li = document.createElement("li");
        li.textContent = item;
        memoryList.appendChild(li);
    });
}