package main

import "fmt"

func main() {
	arr := []int{1, 2, 4, 6, 10}
	k := 8
	fmt.Print(offer6(arr, k))
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
