package ii_collections

import java.util.Comparator

fun example4() {
  val max = listOf(1, 42, 4).max()
  val longestString = listOf("a", "b").maxBy { it.length }
}

fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? {
  // Return a customer whose order count is the highest among all customers
  return this.customers.maxWith (Comparator { t, t1 -> t.orders.size - t1.orders.size })
}

fun Customer.getMostExpensiveOrderedProduct(): Product? {
  // Return the most expensive product which has been ordered
  //  return this.orderedProducts.maxWith(Comparator { p, p1 -> (p.price - p1.price).toInt()})
  return this.orders.flatMap { it.products }
      .toSet()
      .maxWith(Comparator { p1, p2 -> (p1.price - p2.price).toInt() })
}
