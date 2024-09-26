//CALCULATOR PROGRAM

const display = document.getElementById("display");
const memoryList = document.getElementById("memory-list");
let memoryValues = [];
let memoryHistory = [];

function appendToDisplay(input){
    display.value += input;
}
function clearDisplay(){
    display.value = "";
}
function calculate(){
    try {
        let result = eval(display.value);
        if (result === Infinity || result === -Infinity) {
            throw new Error("Division by zero");
        }
        display.value = result;
        saveToMemory(result);
    } catch (error) {
        display.value = "ERROR";
    }
}

// Calculate square root
function calculateSquareRoot(){
    try {
        if (display.value === "") {
            throw new Error("Empty input");
        }

        let value = eval(display.value);  // Evaluate the current input

        if (isNaN(value)) {
            throw new Error("Invalid input");
        }

        if (value < 0) {
            throw new Error("Square root of negative number");
        }

        let result = Math.sqrt(value);
        // if (Number.isInteger(value)) {
        //     result = Math.round(result);
        // }
        display.value = result;
        saveToMemory(result);
    } catch (error) {
        display.value = "ERROR";
    }
}

// Calculate percentage
function calculatePercentage(){
    try{
        let result = eval(display.value) / 100;
        display.value = result;
        saveToMemory(result);
    }
    catch(error){
        display.value = "ERROR";
    }
}

// Memory Clear
function memoryClear(){
    // memoryValue = 0;
    memoryValues = [];
    memoryHistory = [];
    updateMemoryList();
}

// Memory Recall
function memoryRecall(){
    if (memoryValues.length > 0) {
        display.value = memoryValues[memoryValues.length - 1];
    }
}

// Memory Add
function memoryAdd(){
    if (display.value !== "") {
        let value = parseFloat(display.value);
        memoryValues.push(value);
        updateMemoryList();
        clearDisplay();
    }
}

// Memory Subtract
function memorySubtract(){
    if (display.value !== "") {
        let value = -parseFloat(display.value);
        memoryValues.push(value);
        updateMemoryList();
        clearDisplay();
    }
}

function saveToMemory(value) {
    memoryValues.push(value);
    updateMemoryList();
}

function updateMemoryList() {
    memoryList.innerHTML = "";  // Clear the list
    memoryValues.forEach((item) => {
        const li = document.createElement("li");
        li.textContent = item;
        memoryList.appendChild(li);
    });
}