(ns atividade2.atividade10
  (:require [atividade2.atividade11 :as atividade2.atividade11]))

(println (atividade2.atividade11/todos-os-pedidos))

(println (group-by :usuario (atividade2.atividade11/todos-os-pedidos)))

(println (group-by minha-funcao-de-agrupamento (atividade2.atividade11/todos-os-pedidos)))

(defn minha-funcao-de-agrupamento
  [elemento]
  (println "elemento" elemento)
  (:usuario elemento))

(println (group-by minha-funcao-de-agrupamento (atividade2.atividade11/todos-os-pedidos)))

(println (count (vals (group-by :usuario (atividade2.atividade11/todos-os-pedidos)))))

(println (map count (vals (group-by :usuario (atividade2.atividade11/todos-os-pedidos)))))

(->> (atividade2.atividade11/todos-os-pedidos)
     (group-by :usuario)
     vals
     (map count)
     println)

(defn conta-total-por-usuario
  [[usuario pedidos]]
  {:usuario-id usuario
   :total-de-pedidos (count pedidos)})

(->> (atividade2.atividade11/todos-os-pedidos)
     (group-by :usuario)
     (map conta-total-por-usuario)
     println)

(defn total-dos-pedidos
  [pedidos]
  (->> pedidos
       (map :itens)
       (map total-do-pedido)
       (reduce +)))

(defn quantidade-de-pedidos-e-gasto-total-por-usuario
  [[usuario pedidos]]
  {:usuario-id usuario
   :total-de-pedidos (count pedidos)
   :preco-total (total-dos-pedidos pedidos)})

(->> (atividade2.atividade11/todos-os-pedidos)
     (group-by :usuario)
     (map quantidade-de-pedidos-e-gasto-total-por-usuario)
     println)


