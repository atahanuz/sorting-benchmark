# sorting-benchmark-java
Benchmark Sorting Algorithms in Java

An utility for benchmarking sorting algorithms in Java. You can use it to easily test the speed of your sorting algorithms as well as Java's built-in sorting methods.

## Installation
Add this to your Maven configuration. 
```xml
<dependency>
  <groupId>com.atahanuz</groupId>
  <artifactId>sorting-benchmark</artifactId>
  <version>1.0.0</version>
</dependency>
```
Or you can manually download the source code and add SortingBenchmark.java to your package.

Now you can use the library
```java
import com.atahanuz.SortingBenchmark;

SortingBenchmark.sortingBenchmark(...,...);
```
## Usage

Call the sortingBenchmark method with two arguments.
- 1st argument: Method reference or lambda of the sorting method.
- 2nd argument: You have two options. You can give it either:
  - An integer array to be sorted by the method
  - An integer, an array of this length will be created with random integers to be sorted

The method will measure the time taken by the provided sorting method to sort the array in ascending order, then print it to the console. It also checks if the array is properly sorted, and if not, prints "NOT SORTED".


## Example
```java
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

```java
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


## Customization
- When creating an array with random integers, the same sequence of numbers is always used, ensuring a fair comparison between different iterations.
You can set RANDOMIZE to true for creating new random values on each run. Though note that this can make comparisions unfair as some datasets are easier to sort than the others

```java
SortingBenchmark.setRandomize(true);
```
- After the sorting ends, by default it checks if the array is correctly sorted. To disable this, set CHECK_SORTED to false.
```java
SortingBenchmark.setCheckSorted(false);
```

## Notes
- For your sorting method to work with this tool, it should accept an int[] as its only parameter and return void (sort array in-place).
```java

 public static void bubbleSort(int[] arr) {
      // implement bubble sort here
    }

sortingBenchmark(Main::bubbleSort,10_000_000);
// will print how long it tok to sort an 
// array with 10 milion elements using bubbleSort
```
If your method's structure is different, you can use lambdas to adjust it to this format.

## Planned in future versions
Make the program:
- Accept other primitive data types( double[], long[]...)
- Accept object data types( String[], Integer[]...)
- Accept collection data types( ArrayList, LinkedList, HashSet...)
- Accept custom comparator to modify sorting procedure
- Accept custom randomizer to create random data with a specific pattern

## Contact

For problems or suggestions raise an [Issue](https://github.com/atahanuz/sorting-benchmark/issues/new) in this repo and I'll happily respond. 
You can mail me at atahanuz23@gmail.com too but it'd be better if you raise an Issue so everyone can see and contribute to the discussion. It also sends a notification to my phone so I'll be able to respond faster.




