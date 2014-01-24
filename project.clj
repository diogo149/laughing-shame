(defproject laughing-shame "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [com.novemberain/monger "1.6.0-beta2"]
                 [compojure "1.1.5"]
                 [http-kit "2.0.1"]]
  :plugins [[lein-ring "0.8.10"]
            [lein-midje "3.1.3"]]
  :main laughing-shame.handler
  :ring {:handler laughing-shame.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]
                        [midje "1.6.0"]]}})
