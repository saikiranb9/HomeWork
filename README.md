Movie Theatre Seating

Language:  Java

Description:

The program is written using an algorithm to allocate tickets in a Movie Theatre in efficient way. Input to the program is given in a file which is read by the program using path given as command input and writes the output to a file and prints the path to output file on to console.

Algorithm is as follows:

a. If enough seats are available, algorithm assigns seats to customers consecutively as much as possible. 
b. If the customers size is more than seats in a row, then entire row is allocated to some customers and remaining seats will be allocated in some other row.
c. If group of customers cannot be seated consecutively or there is no row that can accomodate a group of customers, then algorithm assigns seats wherever they are available randomly.
Time Complexity to allocate each reservation is O(rows).

Assumptions:

a. Seats are allocated always from left to write and also contiguously so that holes or fragments in between can be avoided.
b. Seats allocation is prioritised towards middle rows as middle rows have best viewing angle anf audio quality. Therefore, first customers will be assigned middle rows and then move on to end rows.

Priorities:

Customer Satisfaction:

a. Customers always prefer to be seated together or in consecutive seats. Algorithm always find best way to place group of customers in same row. If the group is larger than seats in row, then it will split the group and fin next best row nearer to middle row.

Maximum seats allocation:

a. Algorithm is prioritized to assign as many seats as possible such that it will assign continuously without leaving any fragments of seats in between.

Steps to Execute
a. download Asssignment folder.
b. Using JAVAC command in Assignment folder, compile the Homework file, MovieTheatre file. (javac Driver/HomeWork.java MovieTheatre/MovieTheatre.java)
c. Next give command => java Driver/HomeWork input.txt 
