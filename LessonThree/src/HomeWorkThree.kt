import kotlin.reflect.KProperty
import java.lang.ref.WeakReference

fun main() {
    val age: Int? by weakRef(14)
    println(age)
}

fun <T> weakRef(value: T) = WeakRefHolder(WeakReference(value))
class WeakRefHolder<T>(private var _value: WeakReference<T?>) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T? {
        return _value.get()
    }

    operator fun setValue(
        thisRef: Any?, property: KProperty<*>, value: T?
    ) {
        _value = WeakReference(value)
    }
}