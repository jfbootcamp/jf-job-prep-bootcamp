// if문 (Conditional Statement)

// 1. 기본 if문
console.log("[1. 기본 if문]")

let num1 = 5;
console.log("num1 =", num1);

if(num1 < 10) {
    console.log("-> num1은 10보다 작습니다.");
}

// 2. if-else문
console.log("[2. if-else문]")

let num2 = 50;
console.log("num2 =", num2);

if(num2 < 10) {
    console.log("-> num2는 10보다 작습니다.");
} else {
    console.log("-> num2는 10보다 크거나 같습니다.");
} 

// 3. 중첩 if문
console.log("[3. 중첩 if문]");

let num3 = 10;
console.log("num3 =", num3);

if(num3 < 10) {
    console.log("-> num3은 10보다 작습니다.");
} else {
    if(num3 > 10) {
        console.log("-> num3은 10보다 큽니다.");
    } else {
        console.log("num3은 10입니다.")
    }
} 

// 4. else if문 (다중 조건)
console.log("[4. else if문]");

let num4 = 10;
console.log("num4 =", num4);

if(num4 < 10) {
    console.log("-> num4는 10보다 작습니다.");
} else if(num4 > 10) {
    console.log("-> num4는 10보다 큽니다.");
} else {
    console.log("num4는 10입니다.")
}

// 5. 조건문 활용
console.log("\n[5. 조건문 활용 - 성적 등급]");

let score = 95;
console.log("점수 =", score);

if(score >= 90) {
    console.log("-> 등급: A");
} else if(score >= 80) {
    console.log("-> 등급: B");
} else if(score >= 70) {
    console.log("-> 등급: C");
} else if(score >= 60) {
    console.log("-> 등급: D");
} else {
    console.log("-> 등급: F");
}