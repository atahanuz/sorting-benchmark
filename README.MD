# sorting-benchmark-java
Benchmark Sorting Algorithms in Java

An utility for benchmarking sorting algorithms in Java. You can use it to easily test the speed of your sorting algorithms as well as Java's built in sorting methods.

## Requirements
None, only Java's built in libraries are used. You can download the SortingBenchmark.java (or simply view it from browser and copy the code) to use in your project.

## Usage

Call the sortingBenchmark method with two arguments.
- 1st argument: Method reference or lambda of the sorting method.
- 2nd argument: You have two options. You can give it either:
  - An array to be sorted by the method
  - An integer, an array of this length will be created with random integers to be sorted

The method will measure the time taken by the provided sorting method to sort the array, then print it to the console. It also checks if the array is properly sorted, and if not, prints "NOT SORTED".


## Example
```
sortingBenchmark(Arrays::sort,100_000_000);
sortingBenchmark(Arrays::parallelSort,100_000_000);
```
Output:
```
Time= 6.809765250 seconds
Time= 1.398866792 seconds
```
In this example, we tested Java's sort and parallelSort methods with 100 million random integers. As expected, parallelSort was about 5 times faster.


### Example with predefined array

```
int[] array= new int[]{4,2,6,3,9};
sortingBenchmark(Arrays::sort,array);
sortingBenchmark(Arrays::parallelSort,array);
```

Output:
```
Time= 0.000143708 seconds
Time= 0.000700709 seconds
```
This time we tested them with an array. Now parallelSort ended up slower, which is alo excepted because for small arrays the overhead of parallelism will make it slower.

# Notes
- When creating an array with random integers, the same sequence of numbers is always used, ensuring a fair comparison between different iterations.
- For your sorting method to work with this tool, it should accept an int[] as its only parameter and return void (hence sort array in-place).If your method's logic is different you can use lambdas to workaround this.😀

  





