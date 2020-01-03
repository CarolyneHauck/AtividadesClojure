(ns loja.aula2
  (:require [loja.db :as loja.db]
            [loja.logic :as loja.logic]))

(defn gastou-bastante? [info-do-usuario]
  (> (:preco-total info-do-usuario) 500))

(let [pedidos (loja.db/todos-os-pedidos)
      resumo (loja.logic/resumo-por-usuario pedidos)]
  (println "keep" (keep gastou-bastante? resumo))
  (println "filter" (filter gastou-bastante? resumo)))

