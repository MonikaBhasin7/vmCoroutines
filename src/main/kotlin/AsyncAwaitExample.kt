import kotlinx.coroutines.*

/**
 * @author Monika Bhasin
 * @date 08-02-2020 09:44
 **/

/**
 *  async creates a coroutine and returns the Deferred job object
 *  await is the callback function, it awaits for the completion of the value and await function get called once the async
 *  coroutine completes.
 *
 *  async starts its own new coroutines(you cna check print statement by executing this)
 *
 *  If we want to do the tasks asynchronously, go and use async tasks. After we can wait for the completion of multiple async
 *  tasks for completion by using the callback method 'await'.. Once the await function of all the coroutines get called,
 *  then that particular coroutine get resumes which was suspend previously because we used the await function...
 *
 *  It means the 'await' function suspend the coroutines in which it is written. it will not block the thread in which that coroutine
 *  is working.
 *
 *  So the lines written after the await() function, will not executes until unless the await function get called(once the async
 *  coroutine completes.)
 */
suspend fun main() {
    val job = CoroutineScope(Dispatchers.IO).launch {
        println("Before Async ${Thread.currentThread().name}")
        val job1 = async {
            delay(4000)
            println("Inside 1st async ${Thread.currentThread().name}")
        }
        val job2 = async {
            delay(2000)
            println("Inside 2nd async ${Thread.currentThread().name}")
        }
        println("Before awaiting for completion for both async coroutines ${Thread.currentThread().name}")

        job1.await()
        job2.await()

        println("After awaiting for completion for both async coroutines ${Thread.currentThread().name}")
    }
    job.join()
}
