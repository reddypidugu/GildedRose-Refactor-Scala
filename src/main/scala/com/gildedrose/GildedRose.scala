package com.gildedrose

class GildedRose(val items: Array[Item]) {

  import GildedRose._

  def updateQuality(): Unit = {
    items.foreach { item =>

      item.name match {
        case TYPE_AGEDBRIE =>
          item.sellIn = item.sellIn - 1
          increaseQuality(item)
          //if sellin is reached
          if (item.sellIn < 0) {
            increaseQuality(item)
          }

        case TYPE_BACKSTAGE =>
          item.sellIn = item.sellIn - 1
          increaseQuality(item)

          if (item.sellIn < 11) {
            increaseQuality(item)
          }

          if (item.sellIn < 6) {
            increaseQuality(item)
          }

          if (item.sellIn < 0) {
            item.quality = 0
          }

        case TYPE_SULFURAS =>

        case TYPE_CONJURED =>

          if(item.sellIn < 1 ){
            item.sellIn = item.sellIn - 1
            decreaseQualityTwice(item)
          } else {
            item.sellIn = item.sellIn - 1
            decreaseQuality(item)
          }

        case _ =>
          item.sellIn = item.sellIn - 1
          decreaseQuality(item)

          if (item.sellIn < 0) {
            decreaseQuality(item)
          }
      }
    }
  }

  private def decreaseQuality(item: Item) = {
    if (item.quality > 0) {
      item.quality = item.quality - 2
    }
  }

  private def decreaseQualityTwice(item: Item) = {
    if (item.quality > 0) {
      item.quality = item.quality - 4
    }
  }

  private def increaseQuality(item: Item) = {
    if (item.quality < 50) {
      item.quality = item.quality + 1
    }
  }
}

object GildedRose {
  val TYPE_SULFURAS = "Sulfuras, Hand of Ragnaros"
  val TYPE_AGEDBRIE = "Aged Brie"
  val TYPE_BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert"
  val TYPE_CONJURED = "Conjured"
}