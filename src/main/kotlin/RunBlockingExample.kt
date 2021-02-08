import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * @author Monika Bhasin
 * @date 08-02-2020 09:35
 **/

/**
 * runBlocking is a coroutine, runs on a main thread. It blocks the whole thread on which it is running until its completion.
 * The print statement outside the runBlocking{} will not execute because the runBlocking execution blocks the whole thread,
 * and the thread comes in resume state only when the runBlocking completes its work.
 */
fun main() {
    println("outside the runBlocking Before - ${Thread.currentThread().name}")
    val job = runBlocking {
        println("inside the runBlocking - ${Thread.currentThread().name}")
        delay(2000)
    }
    println("outside the runBlocking After - ${Thread.currentThread().name}")
}