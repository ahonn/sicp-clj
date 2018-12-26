(ns sicp.chapter01.1_05)

;; Observe that our model of evaluation allows for combinations whose operators are compound expressions. Use this observation to describe the behavior of the following procedure

(defn p []
  (p))

(defn test-order [x y]
  (if (= x 0)
      0
      y))

(test-order 0 (p))

;; That's applicative-order evaluation

;; Exception in thread "main" java.lang.StackOverflowError, compiling:(/Users/ahonn/Developer/code/sicp/src/sicp/chapter01/1_05.clj:13:1)
        ;; at clojure.lang.Compiler.load(Compiler.java:7526)
        ;; at clojure.lang.Compiler.loadFile(Compiler.java:7452)
        ;; at clojure.main$load_script.invokeStatic(main.clj:278)
        ;; at clojure.main$script_opt.invokeStatic(main.clj:338)
        ;; at clojure.main$script_opt.invoke(main.clj:333)
        ;; at clojure.main$main.invokeStatic(main.clj:424)
        ;; at clojure.main$main.doInvoke(main.clj:387)
        ;; at clojure.lang.RestFn.applyTo(RestFn.java:137)
        ;; at clojure.lang.Var.applyTo(Var.java:702)
        ;; at clojure.main.main(main.java:37)
;; Caused by: java.lang.StackOverflowError
        ;; at sicp.chapter01.1_05$p.invokeStatic(1_05.clj:6)
        ;; at sicp.chapter01.1_05$p.invoke(1_05.clj:5)
        ;; at sicp.chapter01.1_05$p.invokeStatic(1_05.clj:6)
        ;; at sicp.chapter01.1_05$p.invoke(1_05.clj:5)
        ;; at sicp.chapter01.1_05$p.invokeStatic(1_05.clj:6)
        ;; at sicp.chapter01.1_05$p.invoke(1_05.clj:5)
        ;; at sicp.chapter01.1_05$p.invokeStatic(1_05.clj:6)
        ;; at sicp.chapter01.1_05$p.invoke(1_05.clj:5)
        ;; at sicp.chapter01.1_05$p.invokeStatic(1_05.clj:6)
        ;; at sicp.chapter01.1_05$p.invoke(1_05.clj:5)
        ;; at sicp.chapter01.1_05$p.invokeStatic(1_05.clj:6)
        ;; at sicp.chapter01.1_05$p.invoke(1_05.clj:5)
        ;; at sicp.chapter01.1_05$p.invokeStatic(1_05.clj:6)
        ;; at sicp.chapter01.1_05$p.invoke(1_05.clj:5)
