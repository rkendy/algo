function find_duplicates(arr) {
  map = new Map();
  result = new Array();
  arr.forEach((element) => {
    count = (map.get(element) || 0) + 1;
    if (count === 2) {
      result.push(element);
    }
    map.set(element, count);
  });
  return result;
}

console.log(find_duplicates([1, 3, 4, 3, 5, 4, 100, 100]));
console.log(find_duplicates([7, 5, 4, 3, 5, 11, 7, 11, 9, 3]));
console.log(find_duplicates([6, 5, 7]));
