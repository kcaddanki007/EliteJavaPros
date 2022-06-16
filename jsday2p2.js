/*
You are given the deatils of the participants of the ideathon competition,
There are two rounds in the competition, one is Coding round, and the second
is Quiz round. Based on the scores, the participants will be decided either 
'pass' or 'fail', [i.e., isSucceed : true or false].

The details of each participant are given as follows:

    {
        id: 1,
        name: "Sri Charan",
        codingScore: 98,
        quizScore: 56,
        isSucceed: true,
    }

Your task is to write a JavaScript program to find the avarage score of 
all the participants, who have succeeded in ideathon competition.

Input: A JSON file.
Output: Print the avergae score.

*/

// input JSON file
const ideathon = require('./file.json');

let ideathonpassed = ideathon.filter((ob)=>{
    return ob.isSucceed;
})

let arr = ideathonpassed.map((x)=>{
    return x.quizScore + x.codingScore;
})

let total = arr.reduce((x,y)=>{
    return x+y;
})

let avg = total/ideathonpassed.length;
console.log(avg);
//implement your code here
