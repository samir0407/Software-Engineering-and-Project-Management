Expected Result for Thread-safe Experiment

When the program is executed with `true`, the expected results for each test case are shown below.

| Test | Static Count | Non-static Total | Absolute Difference | Difference (%) |
|------|-------------:|-----------------:|--------------------:|---------------:|
| TC1  | 1,000        | 1,000            | 0                   | 0%             |
| TC2  | 20,000       | 20,000           | 0                   | 0%             |
| TC3  | 50,000       | 50,000           | 0                   | 0%             |
| TC4  | 500,000      | 500,000          | 0                   | 0%             |
| TC5  | 1,000,000    | 1,000,000        | 0                   | 0%             |
| TC6  | 2,500,000    | 2,500,000        | 0                   | 0%             |
| TC7  | 5,000,000    | 5,000,000        | 0                   | 0%             |

Observation
In the thread-safe experiment, the static counter and the total of all non-static counters are equal for every test case.

Conclusion
The absolute difference is zero, and the percentage difference is 0% for all test cases. This happens because `AtomicLong` ensures thread-safe updates to the shared static counter.

Result Recording Sheet
The following table presents the average results of five runs
of the unsynchronized (`false`) experiment for each thread count.

| Threads | Expected count | Static count (unsafe) | Non-static total | Absolute difference | Difference (%) |
|---:|---:|---:|---:|---:|---:|
| 1 | 1,000 | 1,000 | 1,000 | 0 | 0.00% |
| 2 | 20,000 | 15,717.40 | 20,000 | 4,282.60 | 21.41% |
| 5 | 50,000 | 18,733.40 | 50,000 | 31,266.60 | 62.53% |
| 10 | 500,000 | 75,281.80 | 500,000 | 424,718.20 | 84.94% |
| 20 | 1,000,000 | 119,597 | 1,000,000 | 880,403 | 88.04% |
| 50 | 2,500,000 | 560,493.80 | 2,500,000 | 1,939,506.20 | 77.58% |
| 100 | 5,000,000 | 1,576,201.60 | 5,000,000 | 3,423,798.40 | 68.48% |

Observation: The unsynchronized static counter loses updates
because multiple threads access and modify the shared variable
concurrently. The percentage difference does not always increase
with the number of threads because thread scheduling and runtime
conditions affect the results.

