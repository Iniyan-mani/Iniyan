/*
 * Proprietary and confidential
 * Copyright 2019-2021 Tresata, Inc.
 * The contents of this file are trade secrets that are the property of Tresata, Inc.
 */

package com.tresata.problems

import com.twitter.algebird._

// Algebird is an "abstract algebra" library for Scala
//
// Watch this video for an overview of the architecture
//  - https://www.youtube.com/watch?v=2ndQ6DGRnJA
//
// To complete these exercises, fill in the `???`s and make the tests pass
//
// Homepage: https://twitter.github.io/algebird/
// Documentation: https://twitter.github.io/algebird/api

object AlgebirdExercise {
  private val seed = 1234

  // Only using Algebird Aggregators, you can:

  // Find the maximum
  def max[N : Ordering](seq: Seq[N]): Option[N] = {
    val agg: Aggregator[N, N, N] = new MaxAggregator
    agg.applyOption(seq)
  }

  // Find the minimum
  def min[N : Ordering](seq: Seq[N]): Option[N] = {
    val agg: Aggregator[N, N, N] = ???
    agg.applyOption(seq)
  }

  // Find the first element
  def first[X](seq: Seq[X]): Option[X] = {
    val agg: Aggregator[X, X, X] = ???
    ???
  }

  // Build a bloom filter? (https://en.wikipedia.org/wiki/Bloom_filter)
  def bloomCheck[X: Hash128](seq: Seq[X]): Option[X => Boolean] = {
    val agg = new BloomFilterAggregator(new BloomFilterMonoid[X](numHashes = 3, width = 1024))
    agg.applyOption(seq).map{ bf =>
      x => ??? // Check that x exists in bloom filter
    }
  }
}
