(ns atividade2.atividade4)

(println (filte even? (range 10)))

(defn minha-soma
  [valor-1 valor-2]
  (println "somando" valor-1 valor-2)
  (+ valor-1 valor-2))

(println (reduce minha-soma (range 10)))
(println (reduce minha-soma [15]))