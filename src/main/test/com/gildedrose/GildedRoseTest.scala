package com.gildedrose

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GildedRoseTest extends AnyFlatSpec with Matchers {
  it should "foo" in {
    val items = Array[Item](new Item("foo", 0, 0))
    val app = new GildedRose(items)
    app.updateQuality()
    app.items(0).name should equal ("foo")
  }


  "Conjured items" should "decrease quality and sellin" in {
    val items = Array[Item](new Item("Conjured", 5, 10))
    val app = new GildedRose(items)
    app.updateQuality()
    items(0).name should equal ("Conjured")
    items(0).sellIn should equal (-1)
    items(0).quality should equal (6)
  }

  it should "once the sellin by date passed, Quality decreases twice as fast" in {
    val items = Array[Item](new Item("Conjured", 0, 10))
    val app = new GildedRose(items)
    app.updateQuality()
    items(0).name should equal ("Conjured")
    items(0).sellIn should equal (-1)
    items(0).quality should equal (6)
  }

}
