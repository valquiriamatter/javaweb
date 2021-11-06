   function onLoad(){
           var app = new Vue(
           {
               el: '#ofertas,
               data: {
                   pedidos : []
                   },
               mounted(){
                   axios
                       .get('http://localhost:8080/api/pedidos/aguardando')
                       .then(response => (this.pedidos = response.data))
               }
           });
       }