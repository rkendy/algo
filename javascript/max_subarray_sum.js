/**
 * The maximum sum subarray problem consists in finding the maximum sum of a
 * contiguous subsequence in an array or list of integers:
 * Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
 * should be 6: {4, -1, 2, 1}
 **/

function max_subarray_sum(arr) {
  var max = 0;
  var curr_max = 0;
  arr.forEach((element) => {
    curr_max = element > curr_max ? element : curr_max + element;
    max = Math.max(max, curr_max);
  });
  return max;
}

console.log(max_subarray_sum([-2, 1, -3, 4, -1, 2, 1, -5, 4]));
