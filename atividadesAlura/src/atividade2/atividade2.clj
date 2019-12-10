(ns atividade2.atividade2)

;˜Atividade 1˜
( defn imprime-mensagem [] (println 'Teste))

(defn valor-descontado1 [valor-bruto]
  (* valor-bruto 0.9))

;˜Atividade 2˜
(defn valor-descontado
  [valor-bruto]
  (* valor-bruto (-1 0.10)))

;˜Atividade 3˜
(defn valor-descontado
  "Retorna o valor com desconto de 10%."
  [valor-bruto]
  (let [desconto 0.10]
    (* valor-bruto (- 1 desconto))))

;˜Atividade 4˜
(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [valor-bruto]
  ( if (> valor-bruto 100)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (println "Calculando desconto de" desconto)
      (- valor-bruto desconto))
    valor-bruto))
