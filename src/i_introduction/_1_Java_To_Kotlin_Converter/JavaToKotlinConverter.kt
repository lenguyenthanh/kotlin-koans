package i_introduction._1_Java_To_Kotlin_Converter

import util.TODO

fun todoTask1(collection: Collection<Int>): Nothing = TODO(
    """
        Task 1.
        Rewrite JavaCode1.task1 in Kotlin.
        In IntelliJ IDEA, you can just copy-paste the code and agree to automatically convert it to Kotlin,
        but only for this task!
    """,
    references = { JavaCode1().task1(collection) })

fun <T> Collection<T>.tail(): Collection<T> {
  return this.drop(1)
}

fun task1(collection: Collection<Int>): String {
  val sb = StringBuilder()
  sb.append("{")
  if (collection.size > 0) {
    sb.append(collection.first())
    collection.tail().fold(sb, { sb, i -> sb.append(", ").append(i) })
  }
  sb.append("}")
  return sb.toString()
}
