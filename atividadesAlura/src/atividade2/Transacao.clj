(ns atividade2.Transacao)

;funcao select-key permite q peguemos só alguns valores de um mapa.
(defn resumo [transacao]
  (select-keys transacao [:valor :tipo :data]))

(def transacoes
  [{:valor 33.0 :tipo "despesa" :comentario "Almoco" :data "19/11/2016" :moeda "R$"}
   {:valor 2700.0 :tipo "receita" :comentario "Bico" :data "01/12/2016" :moeda "R$"}
   {:valor 29.0 :tipo "despesa" :comentario "Livro" :data "03/12/2016" :moeda "R$"}])

(defn despesa? [transacao]
  (= (:tipo transacao) "despesa"))

(defn receita? [transacao]
  (= (:tipo transacao) "receita"))

; filter separou somente a que queremos
(filter despesa? transacoes)
(filter receita? transacoes)

;funcao q pega o valor da transacao
(defn so-valor [transacao]
  (:valor transacao))

;pegamos apenas os valores de cada transacao do tipo despesa
(map so-valor (filter despesa? transacoes))

;agora iremos somar todos os valores retornados
(reduce + (map so-valor (filter despesa? transacoes)))

;no caso acima podemos usar thread-last
(->> (filter despesa? transacoes)
     (map so-valor)
     (reduce +))

;;def é usado para dar nome a algum dado e defn para alguma funcao
(defn valores-grandes? [transacao]
  ( > (:valor transacao) 100))

(filter valores-grandes? transacoes)

;;criando funcao anonima sem o valores-grandes?
(filter (fn [transacao]
          (> (:valor transacao) 100))
        transacoes)

;funcao anonima simplificada
(filter #(> (:valor %) 100) transacoes)
;outro exemplo de funcao anonima
(filter #(= (:tipo %) "despesa") transacoes)

;macro ->
(-> (first transacoes)
    (so-valor))



;;;;;; Capitulo 6
;;Adicionado a moeda e o valor de cada transacao
(defn valor-sinalizado [transacao]
  (if (= (:tipo transacao) "despesa")
    (str (:moeda transacao) " -" (:valor transacao))
    (str (:moeda transacao) " +" (:valor transacao))))

(valor-sinalizado (first transacoes))
(valor-sinalizado (second transacoes))


;;podemos utilizar o let para evitar repeticoes a funcao valor-sinalizado ficaria assim
(defn valor-sinalizado [transacao]
  (let [moeda (:moeda transacao "R$") ;se no mapa nao tiver o valor de moeda sera adicionado por defaulf "R$"
        valor (:valor transacao)]
  (if (= (:tipo transacao) "despesa")
    (str moeda " -" valor)
    (str moeda " +" valor))))

(def transacao-aleatoria {:valor 9.0})
(valor-sinalizado transacao-aleatoria)

(defn data-valor [transacao]
  (str (:data transacao) " => " (valor-sinalizado transacao)))

(data-valor (first transacoes))

(defn transacao-em-yuan [transacao]
  (assoc transacao :valor (* 2.50 (:valor transacao))
                   :moeda "&"))

(transacao-em-yuan (first transacoes))

;4.1

(defn transacao-aleatoria []
  {:valor (* (rand-int 100001) 0.01M) ;bigdecimal
   :tipo (rand-nth ["despesa" "receita"])})

(transacao-aleatoria)
(repeatedly 3 transacao-aleatoria)