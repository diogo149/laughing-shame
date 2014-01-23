(ns laughing-shame.test.handler
  (:use clojure.test
        ring.mock.request
        laughing-shame.handler
        midje.sweet))

(deftest test-app
  (testing "main route"
    (let [response (app (request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Lennon"))))

  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= (:status response) 404)))))

(fact 1 => 1)
