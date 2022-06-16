/*
Write a javascript program to find the unique domain names,
from the given list of email-id's.


Sample Input:
-------------
abc@kmit.in def@gmail.com kfs@kmit.in hello@gmail.com funnyy@yahoo.com                                                  

Sample Output:
--------------                                                  
kmit.in                                                                                                                 
gmail.com                                                                                                               
yahoo.com                                                                        

*/

var readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
});

var emails=[];

let uniqueDomainSet=new Set();

readline.on('line',function(line){
  emails=line.split(' ');
   uniqueDomains(emails);
});

function uniqueDomains(data){
    //implement you are code here.
    mappedData = data.map(function(x){
       var i = x.lastIndexOf("@");
       var s = x.substr(i);
       return s;
    });
    res = new Set(mappedData);
    console.log(res);
}
