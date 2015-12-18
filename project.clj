(defproject cl "cl"
  :description "CL Lib jar"
  :url "http://quatopularslith.me"
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :aot [cl.hello]
  :main cl.hello
  :source-paths ["src/main/clojure"]
  :resource-paths ["src/main/resources"]
  :target-path "lib"
  :compile-path "cl-classes"
  :jar-name "cl.jar"
  :uberjar-name "cl.jar")
