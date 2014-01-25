(ns laughing-shame.handler
  (:use compojure.core
        [monger.core :only [connect! connect set-db! get-db]]
        [monger.collection :only [insert insert-batch]]
        [org.httpkit.server :only [run-server]])
  (:import [org.bson.types ObjectId]
           [com.mongodb DB WriteConcern])
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [monger.collection :as mc])
  (:gen-class))

(connect!)
(set-db! (monger.core/get-db "monger-test"))

(defroutes app-routes
  (GET "/" [] (let [id (ObjectId.)
                    _ (insert "documents"
                              {:_id (ObjectId.)
                               :first_name "John"
                               :last_name "Lennon"})]
                (-> (mc/find-maps "documents")
                    first
                    :last_name)))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(defn -main [] (run-server app {}))
