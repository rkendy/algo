def counting_sort(arr)
  highest = arr.max
  count_arr = Array.new(highest+1,0)

  for i in 0..arr.size-1
    count_arr[arr[i]] += 1
  end

  for i in 1..count_arr.size-1
    count_arr[i] += count_arr[i-1]
  end

  result = Array.new(arr.size)
  for i in 0..arr.size-1
    index = count_arr[arr[i]]
    result[index-1] = arr[i]
    count_arr[arr[i]] -= 1
  end
  return result
end

def print_array(arr)
    p arr
end

arr = [2, 5, 10, 1, 24, 7, 3, 14, 7, 7, 7]
print_array(arr)
arr = counting_sort(arr)
print_array(arr)
