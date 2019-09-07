# Considering the sub vector is sorted, insert a new element shifting
# higher elements to the right.
# Ex: [1, 2, 4, 5, 3] and new element is 3
# Shift to right: [1, 2, _, 4, 5]
# Copy new value to open position: [1, 2, 3, 4, 5]
# Start from left to right. Ex: [5, 4, 3, 2, 1]
# Sub: [5] Element: 4
# Sub: [4,5] Element: 3
# Sub: [3,4,5] Element: 2
# Sub: [2,3,4,5] Element: 1
# Execution: O(n^2)
# Move elements: O(n^2) worst case
# In place: yes
def insertion_sort(arr)
    for i in 1..arr.size-1
        chave = arr[i]
        j = i - 1
        while j>=0 && chave < arr[j] do
            arr[j+1] = arr[j]
            j -= 1
        end
        arr[j+1] = chave
    end
end

def print_array(arr)
    p arr
end

arr = [2, 5, 10, 1, 24, 7, 3, 14]
print_array(arr)
insertion_sort(arr)
print_array(arr)
