package main

import (
	"fmt"
	"sort"
)

func main() {
	//arr := []int{1, 2, 4, 6, 10}
	//k := 8
	//fmt.Print(offer6(arr, k))
	arr := []int{-1, -1, 0, 1, 2, 2, -1, -4}
	fmt.Print(offer7(arr))
}

func offer6(arr []int, t int) []int {
	i := 0
	j := len(arr) - 1
	for i < j && arr[i]+arr[j] != t {
		if arr[i]+arr[j] > t {
			j--
		} else {
			i++
		}
	}
	return []int{i, j}
}

func offer7(nums []int) [][]int {
	sort.Ints(nums)
	var res [][]int
	for i := 0; i < len(nums)-2; i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		left := i + 1
		right := len(nums) - 1
		for left < right {
			sum := nums[i] + nums[left] + nums[right]
			if sum == 0 {
				res = append(res, []int{nums[i], nums[left], nums[right]})
				left++
				right--

				for left < right && nums[left] == nums[left-1] {
					left++
				}
				for left < right && nums[right] == nums[right+1] {
					right--
				}
			} else if sum > 0 {
				right--
			} else {
				left++
			}
		}

	}
	return res
}
