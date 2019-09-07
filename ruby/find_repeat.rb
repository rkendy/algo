def find_repeat(the_list) 

	floor = 1
	ceiling = the_list.size - 1

	while floor < ceiling
		midpoint = floor  + ((ceiling - floor) / 2)
		lower_range_floor = floor
		lower_range_ceiling = midpoint
		upper_range_floor = midpoint + 1
		upper_range_ceiling = ceiling

		items_in_lower_range = 0
		for item in the_list
			if item >= lower_range_floor && item <= lower_range_ceiling
				items_in_lower_range += 1
			end
		end

		puts "Items in lower range: #{items_in_lower_range}"

		distinct_possible_integers_in_lower_range = lower_range_ceiling - lower_range_floor + 1

		if items_in_lower_range > distinct_possible_integers_in_lower_range
			floor = lower_range_floor
			ceiling = lower_range_ceiling
			puts "First half"
		else
			floor = upper_range_floor
			ceiling = upper_range_ceiling
			puts "Second half"
		end
	end

	return floor
end


arr = [1, 1, 1, 1, 7, 7, 7, 7]
ret = find_repeat(arr)
puts ret
