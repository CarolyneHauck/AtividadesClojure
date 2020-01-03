(ns atividade2.atividade9)

(defn conta
  [total-ate-agora elementos]
  (if (seq elementos)
    (recur (inc total-ate-agora) (next elementos))
    total-ate-agora))

(println (conta 0 ["daniela" "carol" "jonas"]))
(println (conta 0 []))