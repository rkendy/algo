# Divide and conquer.
# Divide array in two, sort each and then merge.
# Execution: O(n*log(n))
# In place: No. O(n)


# Create array from arr, and insert value in the end higher than max_value.
# It will not work if the highest value if also the higher value of type. 
# In this case, it will need a flag to tell if the array was already processed.
def create_array(arr, start, finish, max_value)
    tmp = arr[start..finish]
    tmp << max_value
    return tmp
end


# Merge arrays: [start...middle] and [middle+1...finish]
def merge(arr, start, middle, finish)

    # Create temporary arrays:
    left = create_array(arr, start, middle, arr[finish]+1)
    right = create_array(arr, middle+1, finish, arr[middle]+1)

    # Initial indexes
    left_index = 0
    right_index = 0

    # Merge:
    for i in start..finish
        if left[left_index] < right[right_index]
            arr[i] = left[left_index]
            left_index += 1
        else
            arr[i] = right[right_index]
            right_index += 1
        end
    end
end


# Merge sort algorithm
def merge_sort(arr, start, finish)
    if(start >= finish)
        return
    else
        middle = (start + finish)/2
        merge_sort(arr, start, middle)
        merge_sort(arr, middle+1, finish)
        merge(arr, start, middle, finish)
    end
end


# Print the array
def print_array(arr)
    p arr
end

arr = [2, 5, 10, 1, 24, 7, 3, 14]
print_array(arr)
merge_sort(arr, 0, arr.size-1)
print_array(arr)
