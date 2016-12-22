;; Using the results of exercises 1.16 and 1.17, devise a procedure that generates an iterative process for multiplying two integers in terms of adding, doubling, and halving and uses a logarithmic number of steps.40


(define (even? n)
  (= (remainder n 2) 0))

(define (double n)
  (* n 2))

(define (halve n)
  (/ n 2))

(define (multi a b)
  (multi-iter a b 0))

(define (multi-iter a b s)
  (cond ((= b 0) s)
        ((even? b)
          (multi-iter (double a)
                      (halve b)
                      s))
        (else 
          (multi-iter a
                      (- b 1)
                      (+ s a)))))
