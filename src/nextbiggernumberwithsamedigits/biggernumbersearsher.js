function nextBigger(n){
  var digits = n.toString().split("");
  for(var i = digits.length - 1; i > 0; i--){
     if(digits[i] <= digits[i-1]) continue;
     var inMemory = digits[i-1];
     var changingPart = digits.join("").substring(i).split("");
     digits[i-1] = getMinBiggerThanN(changingPart, inMemory);
     var tail = changingPart.join("").replace(digits[i-1], inMemory).split("").sort();
     return parseInt(digits.join("").substring(0,i) + tail.join(""));
  }
  return -1;
}

function getMinBiggerThanN(source, n){
  var biggerElements = [];
  source.forEach(function(el){
    if (el > n) biggerElements.push(el);
  });
  return Math.min.apply(null, biggerElements);
}