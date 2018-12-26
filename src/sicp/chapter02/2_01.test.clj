(ns sicp.chapter02.2_1.test
  (:require [sicp.chapter02.2_1 :refer :all]
            [clojure.test :refer [deftest is run-tests]]))

(deftest gcd-test
  (is (= (gcd 3 6) 3)))

(deftest make-rat-test
  (is (= (make-rat 2 3) (seq [2 3])))
  (is (= (make-rat 2 -3) (seq [-2 3])))
  (is (= (make-rat -2 3) (seq [-2 3])))
  (is (= (make-rat -2 -3) (seq [-2 3]))))

(deftest number-test
  (is (= (number (make-rat 2 3)) 2)))

(deftest denom-test
  (is (= (denom (make-rat 2 3)) 3)))

(deftest add-rat-test
  (is (= (add-rat (make-rat 1 2)
                  (make-rat 1 3))
         (seq [5 6])))
  (is (= (add-rat (make-rat 1 2)
                  (make-rat -1 -3))
         (seq [1 6]))))

(deftest sub-rat-test
  (is (= (sub-rat (make-rat 1 2)
                  (make-rat 1 3))
         (seq [1 6])))
  (is (= (sub-rat (make-rat 1 3)
                  (make-rat 1 2))
         (seq [-1 6]))))

(deftest mul-rat-test
  (is (= (mul-rat (make-rat 1 4)
                  (make-rat 1 2))
         (seq [1 8])))
  (is (= (mul-rat (make-rat 1 4)
                  (make-rat 1 -2))
         (seq [-1 8]))))

(deftest div-rat-test
  (is (= (div-rat (make-rat 1 4)
                  (make-rat 1 2))
         (seq [1 2])))
  (is (= (div-rat (make-rat -1 4)
                  (make-rat 1 -2))
         (seq [-1 2]))))

(deftest equal-rat-test
  (is (= (equal-rat (make-rat 1 2)
                    (make-rat 2 4))
         true))
  (is (= (equal-rat (make-rat 1 3)
                    (make-rat 2 4))
         false))
  (is (= (equal-rat (make-rat 1 -2)
                    (make-rat -2 4))
         true)))

(deftest print-rat-test
  (is (print-rat (make-rat 2 3)) "2/3")
  (is (print-rat (make-rat 2 -3)) "-2/3")
  (is (print-rat (make-rat -2 -3)) "-2/3"))

(run-tests)
