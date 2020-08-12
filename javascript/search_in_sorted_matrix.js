/**
 * Use binary search in the last element of each rows, to find the correct row.
 * Then use binary search in the row.
 */
function search_in_sorted_matrix(matrix, target) {
  rows = matrix.length;
  cols = matrix[0].length;

  left = 0;
  right = rows - 1;
  row_index = -1;

  // Binary search using last element of row:
  while (left <= right) {
    mid = Math.floor((left + right) / 2);
    if (target === matrix[mid][cols - 1]) return true;
    if (target < matrix[mid][cols - 1]) {
      row_index = mid;
      right = mid - 1;
    } else left = mid + 1;
  }
  if (row_index === -1) return false;

  // Binary search in the selected row:
  left = 0;
  right = cols - 1;
  while (left <= right) {
    mid = Math.floor((left + right) / 2);
    if (target === matrix[row_index][mid]) return true;
    if (target > matrix[row_index][mid]) left = mid + 1;
    else right = mid - 1;
  }

  return false;
}

/**
 * Use binary search considering matrix as one array.
 */
function search_in_sorted_matrix_index_calculation(arr, target) {
  rows = arr.length;
  cols = arr[0].length;
  left = 0;
  right = cols * rows - 1;
  while (left <= right) {
    mid = Math.floor((left + right) / 2);
    value = arr[Math.floor(mid / cols)][mid % cols];
    if (target === value) return true;
    if (target > value) left = mid + 1;
    else right = mid - 1;
  }
  return false;
}

console.log(
  search_in_sorted_matrix_index_calculation(
    [
      [10, 11, 12, 13],
      [14, 15, 16, 17],
      [27, 29, 30, 31],
      [32, 33, 34, 35],
      [42, 43, 44, 45],
    ],
    16
  )
);
