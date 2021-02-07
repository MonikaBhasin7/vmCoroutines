import kotlinx.coroutines.*
import java.util.logging.Logger

/**
 * @author Monika Bhasin
 * @date 07-02-2020 20:11
 **/
/**
 * GlobalScope -> in the context of whole application
 *                This coroutine will be active until the application ends.
 *                It is a coroutine Scope.
 * launch -> It is the coroutine builder. Used to launch the coroutine.
 *
 *
 * The coroutine returns the job. If I don't use the job.join(), then the main() function finishes before the coroutine completes.
 * To make the main function waits for the coroutine to finish. I have used job.join(). job.join() suspend the coroutine or blocks
 * the thread in which its is called. When the coroutine finish, the lines after the job.join() executes.
 *
 *
 * we should not use the GlobalScope in our project, because the coroutine remains active throughout the app and cause the
 * memory leaks.
 */
suspend fun main() {
    println(Thread.currentThread().name)
    val job = GlobalScope.launch {
        withContext(Dispatchers.IO) {
            println(Thread.currentThread().name)
        }
    }
    job.join()
    println(Thread.currentThread().name)
}