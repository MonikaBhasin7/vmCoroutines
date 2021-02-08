# vmCoroutines

Previously Threads are the only way to do async task. But making a lot of threads, make the work tedious. How?
- Saving the state of the thread before switching.
- Loding the state of new thread.
These work is done by OS itself, but it increases the extra overhead to Schedule the threads.

Coroutines are light weight threads. It means it can be run/ initialized on the thread which is also executing another coroutines.
It means they use predefines thread pools.

If the Thread get blcoked thw we have to wait unitl the thread get unblocked...But in case of Coroutines, if the coroutine suspends the thread will not get blcoked, all
other coroutines running on that thread will keep running...

