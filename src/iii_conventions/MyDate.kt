package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

operator fun MyDate.rangeTo(other: MyDate): DateRange{
    return DateRange(this, other)
}

operator fun DateRange.contains(date: MyDate): Boolean{
    return this.start < date && date < this.endInclusive
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange (val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return DateRangeIterator(start, endInclusive)
    }
}

class DateRangeIterator(var start: MyDate, val endInclusive: MyDate) : Iterator<MyDate>{
    override fun next(): MyDate {
        val temp = start.copy()
        start = start.nextDay()
        return temp
    }

    override fun hasNext(): Boolean {
        return start < endInclusive || start == endInclusive
    }
}

operator fun MyDate.plus(interval: TimeInterval): MyDate {
    return this.addTimeIntervals(interval, 1)
}

operator fun MyDate.plus(interval: RepeatedTimeInterval): MyDate {
    return this.addTimeIntervals(interval.timeInterval, interval.n)
}

class RepeatedTimeInterval(val timeInterval: TimeInterval, val n: Int)

operator fun TimeInterval.times(n: Int) = RepeatedTimeInterval(this, n)

