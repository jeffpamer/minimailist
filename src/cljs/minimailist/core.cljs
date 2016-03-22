(ns minimailist.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [minimailist.handlers]
              [minimailist.subs]
              [minimailist.views :as views]
              [minimailist.config :as config]))

(when config/debug?
  (println "dev mode"))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init [] 
  (re-frame/dispatch-sync [:initialize-db])
  (mount-root))
