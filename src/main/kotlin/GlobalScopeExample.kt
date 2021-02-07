import kotlinx.coroutines.*
import java.util.logging.Logger

/**
 * @author Monika Bhasin
 * @date 07-02-2020 20:11
**/

suspend fun main() {
    println(Thread.currentThread().name)
    val job = GlobalScope.launch {
        println(Thread.currentThread().name)
    }
    job.join()
    println(Thread.currentThread().name)
}