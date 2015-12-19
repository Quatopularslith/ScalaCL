(ns cl.add
  (:gen-class
    :name cl.add
    :methods [
              #^:static [add [int int] int]
              #^:static [fac [int] int]
              ]))
(defn -add [a b]
  (+ a b))
(defn fac [x] (if (= 0 x) 1 (* x (fac (dec x)))))
(defn -fac [x] (fac x))