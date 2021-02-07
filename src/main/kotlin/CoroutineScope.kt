import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author Monika Bhasin
 * @date 07-02-2020 21:30
 **/
suspend fun main() {
    println("In main thread - ${Thread.currentThread().name}")
    val jobIO = CoroutineScope(Dispatchers.IO).launch {
        println("In Coroutine which is launched in background thread - ${Thread.currentThread().name}")
    }
    jobIO.join()


    val jobDefault = CoroutineScope(Dispatchers.Default).launch {
        println("In Coroutine which is launched in main thread - ${Thread.currentThread().name}")
    }

    jobDefault.join()
    println("In main thread after join - ${Thread.currentThread().name}")
}