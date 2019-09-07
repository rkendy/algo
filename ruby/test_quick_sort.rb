require_relative "quick_sort"
require "test/unit"
require 'set'

class TestSimple < Test::Unit::TestCase
    def test_partition
        arr = [2, 5, 10, 1, 24, 7, 3, 14]
        pivot = partition(arr, 0, arr.size-1)
        assert_equal(6, pivot)
    end

    def test_sort
        arr = [2, 5, 10, 1, 24, 7, 3, 14]
        quick_sort(arr, 0, arr.size-1)
        sorted = [1, 2, 3, 5, 7, 10, 14, 24]
        res = true
        for i in 0..arr.size-1
            if arr[i] != sorted[i]
                res = false
                break
            end
        end
        assert_equal(true, res)
    end

end
