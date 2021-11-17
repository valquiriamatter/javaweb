   function onLoad(){
          var app = new Vue(
          {
              el: '#ofertas',
              data: {
                 pedidos : []
              },
              mounted(){
                 axios
                    .get('http://localhost:8080/api/pedidos/aguardando')
                    .then(response => {
                     response.data.forEach(pedido => {
                        pedido.ofertaEnviada = false;
                        pedido.erros = {
                            valor: '',
                            dataEntrega: ''
                        }
                     })
                     this.pedidos = response.data
                 })
              },
              methods: {
                  enviarOferta: function(pedido){
                    axios
                      .post('http://localhost:8080/api/ofertas', {
                          pedidoId: pedido.id,
                          valor: pedido.valorNegociado,
                          dataEntrega: pedido.dataEntrega,
                          comentario: pedido.comentario
                      })
                      .then(response => pedido.ofertaEnviada = true)
                      .catch(error => {
                          error.response.data.erros.forEach(error => {
                            this.pedido.erros[error.field] = error.defaultMessage;
                          })
                          }
                  }
              }
          });
        }