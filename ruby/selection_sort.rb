# Similar to buble sort, but exchange element only in the end of each iteration.
# Execution complecity: O(n^2)
#   = (n-1) + (n-2) + (n-3) + ... + 2 + 1
#   = (n-1)*n/2 = (n^2 - n)/2
# Move elements: O(n) since it moves only one time per iteration (ext loop)
# In place: yes
def selection_sort(arr)
    for i in 0..arr.size-1
        lowest = i
        for j in i+1..arr.size-1
            if(arr[j] < arr[lowest])
               lowest = j
            end
        end
        tmp = arr[lowest]
        arr[lowest] = arr[i]
        arr[i] = tmp
    end
end

def print_array(arr)
    p arr
end

arr = [2, 5, 10, 1, 24, 7, 3, 14]
print_array(arr)
selection_sort(arr)
print_array(arr)
