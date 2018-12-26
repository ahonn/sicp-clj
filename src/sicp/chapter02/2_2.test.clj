(ns sicp.chapter02.2_2.test
  (:require [sicp.chapter02.2_2 :refer :all]
            [clojure.test :refer [deftest is run-tests]]))

(def test-segment
  (make-segment (make-point 3 3)
                (make-point 0 0)))

(deftest make-segment-test
  (is (= test-segment
         (seq [(seq [3 3]) (seq [0 0])]))))

(deftest start-segment-test
  (is (= (start-segment test-segment)
         (seq [3 3]))))

(deftest end-segment-test
  (is (= (end-segment test-segment)
         (seq [0 0]))))

(def test-point
  (make-point 2 0))

(deftest make-point-test
  (is (= test-point
         (seq [2 0]))))

(deftest x-point-test
  (is (= (x-point test-point)
         2)))

(deftest y-point-test
  (is (= (y-point test-point)
         0)))

(deftest midpoint-segment-test
  (is (= (midpoint-segment
           (make-segment (make-point 0 0)
                         (make-point 4 2)))
         (seq [2 1]))))

(deftest print-point-test
  (is (= (print-point test-point)
         "(2, 0)")))

(run-tests)
