var prod1 = {
    descricao:"Produto eAgro 1",
    perecivel: false,
    embalavel:false,
    valorUnidade:3,
    dataValidade: "2018-12-20T30:59:59.000+0000"
};
var prod2 = {
    descricao: "Produto eAgro 2",
    perecivel: false,
    embalavel: false,
    valorUnidade: 3,
    dataValidade: "2018-12-20T30:59:59.000+0000"
};
var prod3 = {
    descricao: "Produto eAgro 3",
    perecivel: false,
    embalavel: false,
    valorUnidade: 3,
    dataValidade:"2018-12-20T30:59:59.000+0000"
};
db.produtos.insert(prod1);
db.produtos.insert(prod2);
db.produtos.insert(prod3);