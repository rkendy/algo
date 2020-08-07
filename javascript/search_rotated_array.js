/**
 * Given a sorted array of n integers that has been rotated
 * an unknown number of times, write code to find an element
 * (index) in the array. You may assume that the array was
 * originally sorted in ascending order.
 */
function search_array(arr, n) {
  let left = 0;
  let right = arr.length - 1;
  while (left <= right) {
    mid = Math.floor((left + right) / 2);
    if (arr[mid] === n) return mid;

    search_left =
      (n < arr[mid] && n >= arr[left]) || (n > arr[mid] && n > arr[right]);

    if (search_left) right = mid - 1;
    else left = mid + 1;

    // if (n < arr[mid]) {
    //   if (n >= arr[left]) {
    //     right = mid - 1;
    //   } else {
    //     left = mid + 1;
    //   }
    // } else {
    //   if (n <= arr[right]) {
    //     left = mid + 1;
    //   } else {
    //     right = mid - 1;
    //   }
    // }
  }
  return -1;
}

result = search_array([6, 7, 8, 9, 0, 1, 2, 3], 1);
console.log(result);
