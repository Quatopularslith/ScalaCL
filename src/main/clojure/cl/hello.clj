(ns cl.hello
  (:gen-class :methods [#^{:static true} [printhello [] void]])
  )

(defn -printhello []
  (println "Hello from sbt clojure!!!"))