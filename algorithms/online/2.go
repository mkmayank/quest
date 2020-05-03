package main

import "fmt"

func twoSum(nums []int, target int) []int {
	m := map[int]int{}
	for i, v := range nums {
		m[v] = i
		if _, ok := m[target-v]; ok {
			return []int{m[target-v], i}
		}
	}

	return []int{}
}

func main() {
	fmt.Println(twoSum([]int{3, 2, 4}, 6))
}
