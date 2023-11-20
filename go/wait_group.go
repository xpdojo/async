package main

import "sync"

func main() {
	itemList := []string{"item1", "item2", "item3"}

	var wg sync.WaitGroup

	for _, item := range itemList {
		// Increment WaitGroup Counter
		wg.Add(1)
		go doOperation(&wg, item)
	}
	// Wait for goroutines to finish
	wg.Wait()

}

func doOperation(wg *sync.WaitGroup, item string) {
	defer wg.Done()
	// do operation on item
	println(item)
}
