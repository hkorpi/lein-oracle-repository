(ns leiningen.oam
  (:import (org.apache.maven.wagon.shared.http BasicAuthScope HttpMethodConfiguration HttpConfiguration)
           (org.apache.maven.wagon.providers.oam OAMWagon)))

(defn create-oam11g-wagon []
  (let [authScope (doto (BasicAuthScope.)
                    (.setHost "ANY")
                    (.setPort "ANY")
                    (.setRealm "OAM 11g"))
        httpMethodConfiguration (doto (HttpMethodConfiguration.)
                                  (.addParam "http.protocol.allow-circular-redirects" "%b,true"))
        httpConfiguration (doto (HttpConfiguration.)
                            (.setAll httpMethodConfiguration))]
    (doto (OAMWagon. "oam11g")
      (.setBasicAuthScope authScope)
      (.setHttpConfiguration httpConfiguration))))

