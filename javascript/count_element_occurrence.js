/**
 * Given a sorted array of integers, find the frequency of the occurrence
 * of a given target value in the array.
 */
function count_element_occurrence(arr, target) {
  const leftMost = binary(arr, target, true);
  if (leftMost === -1) return 0;
  const rightMost = binary(arr, target, false);

  return rightMost - leftMost + 1;
}

function binary(arr, target, isLeftSearch) {
  let left = 0;
  let right = arr.length - 1;
  let mid;
  let result = -1;
  while (left <= right) {
    mid = Math.floor((left + right) / 2);
    if (arr[mid] === target) {
      result = mid;
      if (isLeftSearch) right = mid - 1;
      else left = mid + 1;
    } else if (arr[mid] > target) right = mid - 1;
    else left = mid + 1;
  }
  return result;
}

console.log(count_element_occurrence([-5, -3, 0, 1, 3, 3, 3, 4, 5], 3));
console.log(count_element_occurrence([-5, -3, 0, 1, 3, 3, 3, 4, 5], 0));
console.log(count_element_occurrence([-5, -3, 0, 1, 3, 3, 3, 4, 5], 5));
console.log(count_element_occurrence([3, 3, 3, 3, 3], 3));
console.log(count_element_occurrence([3, 3, 3, 3, 3], 5));
console.log(count_element_occurrence([3, 3, 3, 3, 3], 1));
