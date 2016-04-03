package ii_collections

import java.util.Comparator

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
  // Return the set of customers who ordered the specified product
  return this.customers.filter { it.orders.any { it.products.contains(product) } }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
  // Return the most expensive product among all delivered products
  // (use the Order.isDelivered flag)
  return this.orders.filter { it.isDelivered }.flatMap { it.products }.maxWith(
      Comparator { p1, p2 -> (p1.price - p2.price).toInt() })
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
  // Return the number of times the given product was ordered.
  // Note: a customer may order the same product for several times.
  return this.customers.flatMap { it.orders }.flatMap { it.products } .filter { it == product }.count()
}
