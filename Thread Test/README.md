# Lab: Static and Non-Static Variables in Multithreading

## 1. Objective
To compare static and non-static counters in Java multithreading and observe race conditions.

## 2. Experimental Setup
Two experiments are performed:
- `true`: Uses `AtomicLong` for thread-safe counting.
- `false`: Uses a normal `long` to observe race conditions.

Each thread has its own non-static counter.

## 3. Test Cases

| Threads | Increments per Thread | Expected Count |
|--------:|----------------------:|---------------:|
| 1 | 1,000 | 1,000 |
| 2 | 10,000 | 20,000 |
| 5 | 10,000 | 50,000 |
| 10 | 50,000 | 500,000 |
| 20 | 50,000 | 1,000,000 |
| 50 | 50,000 | 2,500,000 |
| 100 | 50,000 | 5,000,000 |

## 4. Expected Results (Thread-safe)

In thread-safe mode, both counters should be equal.

| Threads | Static Count | Non-static Total | Difference |
|--------:|-------------:|-----------------:|-----------:|
| 1 | 1,000 | 1,000 | 0 |
| 2 | 20,000 | 20,000 | 0 |
| 5 | 50,000 | 50,000 | 0 |
| 10 | 500,000 | 500,000 | 0 |
| 20 | 1,000,000 | 1,000,000 | 0 |
| 50 | 2,500,000 | 2,500,000 | 0 |
| 100 | 5,000,000 | 5,000,000 | 0 |

## 5. Result Analysis

Absolute Difference = |Static Count - Non-static Total|

Percentage Difference = (Absolute Difference / Non-static Total) × 100%

Record the actual results of the unsynchronized experiment in a table. Run it at least five times for each thread count.

## 6. Observation

In thread-safe mode, both counter totals should be equal. In unsynchronized mode, some increments may be lost due to race conditions. Results may vary between runs.

## 7. Conclusion

Static variables are shared among objects, while non-static variables belong to individual objects. Static variables are not automatically thread-safe. Atomic operations help prevent lost updates.

## 8. Files

- Java Code 
- Handwritten Java code
- Test inputs
- Output screenshots
- Result analysis
