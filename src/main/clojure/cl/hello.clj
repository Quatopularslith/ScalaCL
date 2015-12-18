(ns cl.hello
  (:gen-class :methods [^:static [printhello [] void]])
  )

(defn -printhello []
  (println "Hello from clojure!"))

(defn printhi []
  (println "Hi from clojure!"))

(printhi)