# Quicksort-Variations
WPI Algorithms (CS 2223) Final Project - Analysis of different quicksort algorithms

# How to run the project
* Clone the project to your computer
* Add the 'stdlib.jar' file as a library
* Alter parameters such as T (for trials), and change output options
* Run QuicksortVariations.main()
* Note: This will take a long time! (~30 Minutes on a slow computer)

# Report
[Read our Report here!](Report.docx)  
Or by downloading the `Report.docx` file.

# Presentation
<a href="http://www.youtube.com/watch?feature=player_embedded&v=9lMkeN_o7LU
" target="_blank"><img src="http://img.youtube.com/vi/9lMkeN_o7LU/0.jpg" 
alt="Presentation" width="240" height="180" border="10" /></a>

# Explore our Data!
https://docs.google.com/spreadsheets/d/1a_cVJwWMOKsLbLEcUgur9qgg4Iwui_vL9-Apm9ZpurY/edit?usp=sharing

-----
# Description #
This project creates numerous datasets and performs analysis of various quicksort algorithm implementations
Algorithms (from Sedgewick book):
- Cutoff to Insertion Sort (p. 296)
- Median-of-three partitioning -- sample a[lo], a[hi] and a[mid] and choose middle as pivot
- Three-way partitioning (p. 299)

Datasets:
- N uniformly random doubles -- use StdRandom.double() for this [a sedgewick class]
- N strings from the English dictionary. 
- N integers from StdRandom.uniform(N/k) for k in 2,3,4, ... 16. The invocation to uniform(p) returns a uniformly distributed random integer from 0 up to p-1.

 These three data sets approximate (1) true randomness; (2) arbitrarily structured data; (3) data with lots of duplicate keys.

# Objectives:
- Pull together the necessary code to have three separate Quicksort implementations; be sure to instrument your code to count the number of exchanges and the number of compares
- Create code that can generate the different data sets. 
- For N = 2^(14) (that is, 16384) doubling to 2^(18) (that is, 262144), evaluate the performance of the three variations of quicksort on the different data sets.
- For each Dataset-i and variation Q-j on problem size N, you should count the # of comparisons and the # of exchanges. Also use Stopwatch to compute execution time. 
- When empirically evaluating randomized runs, it is common to run T independent runs (where T = 100 or something) and then report the ranges for each value as [low, average, high] scores. I recommend following this approach; if the 100 is too low (because the runs complete too quickly) then increase T
