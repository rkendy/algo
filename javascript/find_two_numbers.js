// Find Two Numbers that Add up to "n"
function findSum(arr, n) {
  let set = new Set();
  arr.forEach((element) => set.add(n - element));

  for (i = 0; i < arr.length; i++) {
    if (set.has(arr[i])) return [arr[i], n - arr[i]];
  }
  return [];
}

result = findSum([1, 21, 3, 14, 5, 60, 7, 6], 81);
console.log(result);
