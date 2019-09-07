
def partition(arr, start, finish)
    first_index_of_rgroup = start
    pivot_index = finish

    for i in start..finish-1
        if arr[i] < arr[pivot_index]
            tmp = arr[first_index_of_rgroup]
            arr[first_index_of_rgroup] = arr[i]
            arr[i] = tmp
            first_index_of_rgroup += 1
        end
    end
    tmp = arr[first_index_of_rgroup]
    arr[first_index_of_rgroup] = arr[pivot_index]
    arr[pivot_index] = tmp
    return first_index_of_rgroup
end


def quick_sort(arr, start, finish)
    if start >= finish
        return
    else
        pivot = partition(arr, start, finish)
        quick_sort(arr, start, pivot-1)
        quick_sort(arr, pivot+1, finish)
    end
end

def print_array(arr)
    p arr
end

#arr = [2, 5, 10, 1, 24, 7, 3, 14]
#print_array(arr)
#quick_sort(arr, 0, arr.size-1)
#print_array(arr)
