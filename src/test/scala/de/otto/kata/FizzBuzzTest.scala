package de.otto.kata

import org.scalatest.FunSuite

class FizzBuzzTest extends FunSuite {

  test("Should return number") {
    assert(new FizzBuzz().fizzbuzz(1) == "1")
  }

  test("Should return Fizz") {
    assert(new FizzBuzz().fizzbuzz(3) == "Fizz")
  }

  test("Should return Buzz") {
    assert(new FizzBuzz().fizzbuzz(5) == "Buzz")
  }

  test("Should return FizzBuzz") {
    assert(new FizzBuzz().fizzbuzz(15) == "FizzBuzz")
  }
}
